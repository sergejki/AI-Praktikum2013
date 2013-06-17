/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Datentypen.AdresseTyp;
import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;
import Exceptions.KundeException;
import HESServer.RmiServerInterface;
import HESDispatcher.Dispatcher;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author sk
 */
public class KundeView extends javax.swing.JFrame {

    private Dispatcher dispatcher;
    private RmiServerInterface onlineServer;

    /**
     * Creates new form KundeView
     */
    public KundeView(Dispatcher dispatcher) {
        initComponents();
        this.setTitle("erstelle Kundne");
        this.dispatcher = dispatcher;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        EdtErstelleTelNr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        EdtErstelleVorwahl = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        EdtErstelleNachname = new javax.swing.JTextField();
        EdtErstelleVorname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EdtErstelleStrasse = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        EdtErstelleHausnummer = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        EdtErstellePLZ = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        EdtErstelleStadt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        EdtErstelleLand = new javax.swing.JTextField();
        BtnKundenErstellt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setText("TelefonNr.:");

        jLabel5.setText("Vorwahl:");

        jLabel3.setText("Nachname:");

        jLabel2.setText("Vorname:");

        jLabel6.setText("Straße:");

        jLabel1.setText("Nr.:");

        jLabel7.setText("PLZ:");

        jLabel8.setText("Stadt:");

        jLabel9.setText("Land:");

        BtnKundenErstellt.setText("erstellen");
        BtnKundenErstellt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BtnKundenErstelltMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(EdtErstelleVorname, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(EdtErstelleVorwahl, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(EdtErstelleTelNr))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(EdtErstelleNachname, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                    .addComponent(EdtErstelleStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(jLabel1)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(EdtErstelleHausnummer))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addComponent(EdtErstellePLZ)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(jLabel8)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(EdtErstelleStadt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(EdtErstelleLand, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnKundenErstellt)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EdtErstelleVorname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(EdtErstelleNachname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(EdtErstelleStrasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(EdtErstelleHausnummer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(EdtErstellePLZ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(EdtErstelleStadt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(EdtErstelleLand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EdtErstelleTelNr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EdtErstelleVorwahl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnKundenErstellt)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Kunde erstellen", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKundenErstelltMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnKundenErstelltMouseClicked
        this.onlineServer = dispatcher.liefereServer();
        if (onlineServer == null) {
            JOptionPane.showMessageDialog(rootPane, "Keine Server Online!", "Error !", JOptionPane.ERROR_MESSAGE);

        } else {
            String vorname = EdtErstelleVorname.getText();
            String nachname = EdtErstelleNachname.getText();
            String strasse = EdtErstelleStrasse.getText();
            String hausNr_ = EdtErstelleHausnummer.getText();
            String plz_ = EdtErstellePLZ.getText();
            String stadt = EdtErstelleStadt.getText();
            String land = EdtErstelleLand.getText();
            String vorwahl = EdtErstelleVorwahl.getText();
            String tel_ = EdtErstelleTelNr.getText();

            try {
                int hausNr = Integer.valueOf(hausNr_);
                int plz = Integer.valueOf(plz_);
                int tel = Integer.valueOf(tel_);
                AdresseTyp adr = new AdresseTyp(strasse, hausNr, plz, stadt, land);
                TelefonNrTyp telNr = new TelefonNrTyp(vorwahl, tel);
                KundenTyp neuerKunde = onlineServer.erstelleKunde(vorname, nachname, adr, telNr);

                JOptionPane.showMessageDialog(rootPane, "Kunde wurde erfolgreich erstellt!");
                this.setVisible(false);
            } catch (KundeException ex) {
                Logger.getLogger(KundeView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(rootPane, "Felder dürfen nicht leer sein!", "leere Felder", JOptionPane.ERROR_MESSAGE);
            } catch (RemoteException ex) {
                Logger.getLogger(KundeView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_BtnKundenErstelltMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnKundenErstellt;
    private javax.swing.JTextField EdtErstelleHausnummer;
    private javax.swing.JTextField EdtErstelleLand;
    private javax.swing.JTextField EdtErstelleNachname;
    private javax.swing.JTextField EdtErstellePLZ;
    private javax.swing.JTextField EdtErstelleStadt;
    private javax.swing.JTextField EdtErstelleStrasse;
    private javax.swing.JTextField EdtErstelleTelNr;
    private javax.swing.JTextField EdtErstelleVorname;
    private javax.swing.JTextField EdtErstelleVorwahl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
