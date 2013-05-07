package Verkauf;

import Datentypen.AngebotTyp;
import Datentypen.KundenTyp;
import Datentypen.ProduktTyp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import Lager.IProduktManager;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author NED
 */
public class AngebotLogic implements IAngebotManager {

    private IProduktManager PM;
    private AngebotRepository AR;

    @Override
    public AngebotTyp erstelleAngebot(KundenTyp kunde, Date gueltigBis, HashMap<ProduktTyp, Integer> produktListe) {
        Double gesamtKosten = 0.0;

        for (Map.Entry<ProduktTyp, Integer> entry : produktListe.entrySet()) {
            gesamtKosten = +entry.getKey().getPreis() * entry.getValue();
        }

        return this.AR.erstelleAngebot(kunde, gueltigBis, produktListe, gesamtKosten).getTyp();

    }

    @Override
    public List<AngebotTyp> sucheAngebote(String kundenName) {
        List<AngebotTyp> angebotListe = new ArrayList<>();
        List<Angebot> aListe = this.AR.getAngebote(kundenName);

        for (int i = 0; i < aListe.size(); i++) {
            angebotListe.add(aListe.get(i).getTyp());
        }

        return angebotListe;
    }

    @Override
    public AngebotTyp sucheAngebotePerNr(String kundenNr) {
        return this.AR.getAngebot(kundenNr).getTyp();
    }
}