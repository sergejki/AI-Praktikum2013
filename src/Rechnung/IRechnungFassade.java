
package Rechnung;

import Datentypen.AuftragTyp;
import Datentypen.RechnungTyp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author NED
 */
public interface IRechnungFassade {
    public RechnungTyp erstelleRechnung(double betrag, String auftragNr, Date date, String KundenNr) throws Exception;

    public List<RechnungTyp> getRechnungenPerKunde(String kundenNr);

    public RechnungTyp getRechnungPerID(String rechnungsNr)throws Exception;
    
    public RechnungTyp getRechnungPerAuftragNr(String auftragNr)throws Exception;
    
}
