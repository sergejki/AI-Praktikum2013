package HESDispatcher;

import java.awt.Color;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author NED
 */
public class HESMonitor extends Thread {

    private Map<InetAddress, Long[]> onlineServerListe;
    private JLabel labelAlpha, labelBeta, labelAlphaTime, labelBetaTime, labelAlphaCount, labelBetaCount;
    private InetAddress server1;
    private InetAddress server2;
    Dashboard dashboard;

    public HESMonitor() {
        try {
            this.server1 = InetAddress.getByName("192.168.137.70");
            // this.server2 = InetAddress.getByName("server2");
        } catch (UnknownHostException ex) {
            Logger.getLogger(HESMonitor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Starting Monitor..");
        this.onlineServerListe = new HashMap<>();
        Dashboard dashboard = new Dashboard();
        dashboard.setVisible(true);
        this.labelAlpha = dashboard.getLabelAlpha();
        this.labelBeta = dashboard.getLabelBeta();
        this.labelAlphaTime = dashboard.getLabelAlphaTime();
        this.labelBetaTime = dashboard.getLabelBetaTime();
        this.labelAlphaCount = dashboard.getLabelAlphaCount();
        this.labelBetaCount = dashboard.getLabelBetaCount();
        labelAlphaCount.setText("0 Anfragen");
        labelBetaCount.setText("0 Anfragen");

        //Thread to calculate the lastUpdateTime and remove Server from OnlineServerListe if time difference is more than 2 Seconds
        new Thread() {
            public void run() {

                while (true) {
                    if (!onlineServerListe.isEmpty()) {
                        for (Map.Entry<InetAddress, Long[]> entry : onlineServerListe.entrySet()) {
                            //if lastUpdateTime is longer than 2 Seconds remove Server from the list
                            if ((System.currentTimeMillis() - getlastUpdateTime(entry.getKey())) > 3000) {
                                System.out.println("Removing at: " + (System.currentTimeMillis() - getlastUpdateTime(entry.getKey())));
                                onlineServerListe.remove(entry.getKey());
                                updateMonitor();
                            }
                        }
                    }

                }
            }
        }
                .start();

        ////// end Thread Definition////////

    }

    public void run() {





        ///// Start Thread for listening to Server Broadcast////////
        try {
            int udpPort = 55555;
            DatagramSocket serverSocket = new DatagramSocket(udpPort);
            byte[] receiveData = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Waiting for Server..");
            while (true) {
                serverSocket.receive(receivePacket);
                String sentence = new String(receivePacket.getData());
                System.out.println("RECEIVED: " + sentence);

                if (sentence.indexOf("AM ALIVE") > -1) {

                    updateServerOnlineListe(receivePacket.getAddress());
                }
            }
        } catch (SocketException ex) {
            ex.printStackTrace();


        } catch (IOException ex) {
            Logger.getLogger(HESMonitor.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateMonitor(InetAddress server, Integer anzahl) {
        System.out.println("server to update " + server.getHostAddress());

        if (server.equals(server1)) {
            labelAlphaCount.setText(anzahl + " Anfragen");
        } else if (server.equals(server2)) {
            labelBetaCount.setText(anzahl + " Anfragen");
        }




    }

    private void updateMonitor() {

        if (onlineServerListe.keySet().contains(server1)) {
            labelAlpha.setForeground(Color.green);
            labelAlpha.setText("Online");
            labelAlphaTime.setText(((System.currentTimeMillis() - onlineServerListe.get(server1)[0]) / 1000) + " Seconds");
        } else {
            labelAlpha.setForeground(Color.red);
            labelAlpha.setText("Offline");
            labelAlphaTime.setText("0 Seconds");
        }
        if (onlineServerListe.keySet().contains(server2)) {
            labelBeta.setForeground(Color.green);
            labelBeta.setText("Online");
            labelBetaTime.setText(((System.currentTimeMillis() - onlineServerListe.get(server2)[0]) / 1000) + " Seconds");
        } else {
            labelBeta.setForeground(Color.red);
            labelBeta.setText("Offline");
            labelBetaTime.setText("0 Seconds");
        }

    }

    public long getUpTime(InetAddress serverAdresse) {
        for (Map.Entry<InetAddress, Long[]> entry : onlineServerListe.entrySet()) {

            if (serverAdresse.equals(entry.getKey())) {
                Long currentTime = System.currentTimeMillis();
                return currentTime - getRegisterTime(serverAdresse);
            }
        }

        return Long.MIN_VALUE;
    }

    public List<InetAddress> getOnlineListe() {
        return new ArrayList<InetAddress>(onlineServerListe.keySet());
    }

    public Long getRegisterTime(InetAddress onlineServerAddress) {

        if (onlineServerListe.containsKey(onlineServerAddress)) {
            return onlineServerListe.get(onlineServerAddress)[0];
        } else {
            return Long.MIN_VALUE;
        }
    }

    public Long getlastUpdateTime(InetAddress onlineServerAddress) {
        if (onlineServerListe.containsKey(onlineServerAddress)) {
            return onlineServerListe.get(onlineServerAddress)[1];
        } else {
            return Long.MAX_VALUE;
        }
    }

    private void updateServerOnlineListe(InetAddress serverAdresse) {

        //loop throw onlineServerList to check if server already registered

        if (!onlineServerListe.keySet().contains(serverAdresse)) {
            //new Server
            Long[] serverStartTime = {System.currentTimeMillis(), System.currentTimeMillis()};
            onlineServerListe.put(serverAdresse, serverStartTime);
        } else {
            Long lastUpdateTime = System.currentTimeMillis();
            Long[] serverTimes = {getRegisterTime(serverAdresse), lastUpdateTime};
            onlineServerListe.put(serverAdresse, serverTimes);
        }

        updateMonitor();
    }
}
