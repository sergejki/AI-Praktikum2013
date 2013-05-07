package Kunde;

import Datentypen.AdresseTyp;
import Datentypen.KundenTyp;
import Datentypen.TelefonNrTyp;

/**
 *
 * @author NED
 */
public interface IKundeFassade {

    public KundenTyp erstelleKunde(String vorName, String nachName, AdresseTyp adresse, TelefonNrTyp telefon);

    public KundenTyp getKunde(String kundeNr);

    public KundenTyp getKunde(TelefonNrTyp tel);

    public KundenTyp getKunde(String vorname, String nachname, AdresseTyp adresse);
}