/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lager;

import Datentypen.AngebotTyp;
import Datentypen.AuftragTyp;
import Datentypen.BestellungTyp;
import Datentypen.ProduktTyp;
import Datentypen.WarenAusgangMeldungTyp;
import Datentypen.WarenEingangMeldungTyp;
import java.util.List;

/**
 *
 * @author Barzgun
 */
public class LagerFassade implements ILagerFassade {

    @Override
    public ProduktTyp erstelleProdukt(String name, String produktNr, int lagerBestand, double preis) {
        ProduktTyp produkt = ProduktRepository.erstelleProdukt(name, produktNr, lagerBestand, preis).getTyp();
        return produkt;
    }

    @Override
    public List<ProduktTyp> getProduktList() {
        return ProduktRepository.getProduktList();
    }

    @Override
    public ProduktTyp fordereProduktInformationen(int produktNummer) {

        return null;
    }

    @Override
    public boolean isLagerbestandAusreichend(AngebotTyp angebot) {
        return LagerLogic.isLagerbestandAusreichend(angebot);
    }

    @Override
    public void triggerWareneingang(ProduktTyp produkt, int produktMenge) {
        LagerRepository.triggerWareneingang(produkt, produktMenge);
    }

    @Override
    public void triggerWarenAusgang(ProduktTyp produkt, int produktMenge) {
        LagerRepository.triggerWarenAusgang(produkt, produktMenge);
    }

    @Override
    public WarenAusgangMeldungTyp triggerWarenAusgangMeldung(AuftragTyp angebot) {
        return LagerRepository.triggerWarenAusgangMeldung(angebot).getTyp();
    }

    @Override
    public WarenEingangMeldungTyp triggerWarenEingangMeldung(BestellungTyp bestellung) {
        return LagerRepository.triggerWarenEingangMeldung(bestellung).getTyp();
    }

    @Override
    public List<ProduktTyp> produktReservieren(AngebotTyp angebot) {
        return ProduktLogic.produktReservieren(angebot);
    }
}
