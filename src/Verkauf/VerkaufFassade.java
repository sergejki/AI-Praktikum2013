package Verkauf;

import Datentypen.*;
import Exceptions.KundeException;
import Kunde.IKundeFassade;
import Kunde.KundenLogic;

import Lieferant.ILieferantManager;

import Rechnung.IRechnungFassade;

import Lager.ILagerFassade;
import Lager.LagerFassade;
import Lager.LagerLogic;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author NED
 */
public class VerkaufFassade implements IVerkauf {

    private IKundeFassade KM;
    private ILagerFassade LF;
    private IAuftragManager AufM;
    private IAngebotManager AngM;
    private IRechnungFassade RF;

    public VerkaufFassade() {
        this.KM = new KundenLogic();
        this.LF = new LagerFassade();
        this.AngM = new AngebotLogic();
        this.AufM = new AuftragLogic();
    }

    @Override
    public KundenTyp getKunde(String kundeNr) throws KundeException {

        return KM.getKunde(kundeNr);

    }

    @Override
    public KundenTyp getKunde(TelefonNrTyp tel) throws KundeException {
        return KM.getKunde(tel);
    }

    @Override
    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse) throws KundeException {

        return KM.getKunde(vorname, nachname, adresse);

    }

    @Override
    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon) throws KundeException {

        return KM.erstelleKunde(vorName, nachName, adresse, telefon);

    }

    @Override
    public ProduktTyp fordereProduktInformationen(String produktNummer) {
        return LF.fordereProduktInformationen(produktNummer);
    }

    @Override
    public AngebotTyp erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe) {
        try {
            System.out.println("Angebot wurde erstellet :)");
            return AngM.erstelleAngebot(kunde, gueltigBis, produktListe);
        } catch (Exception ex) {
            Logger.getLogger(VerkaufFassade.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Angebot wurde nicht erstellet :(");
            return null;
        }
    }

    @Override
    public AuftragTyp erstelleAuftrag(AngebotTyp angebot) {
        return AufM.erstelleAuftrag(angebot);
    }

    @Override
    public List<AngebotTyp> getAngebot(String kundenName) {
        return AngM.sucheAngebote(kundenName);
    }

    @Override
    public List<AuftragTyp> getAuftrag(String kundenName) {
        return AufM.sucheAuftrage(kundenName);
    }

    @Override
    public AngebotTyp getAngebotPerAngebotNr(String angebotNr) {
        return AngM.sucheAngebotePerNr(angebotNr);
    }

    @Override
    public AuftragTyp getAuftragPerAuftragNr(String auftragNr) {
        return AufM.sucheAuftragePerNr(auftragNr);
    }
}
