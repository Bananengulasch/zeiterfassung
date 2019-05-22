package zeiterfassung;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	public void addInvoice(int mitarbeiter_mitarbeiter_id, int projekt_projekt_id, String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer);
	public void updateInvoice(int projektposition_id, int mitarbeiter_mitarbeiter_id, int projekt_projekt_id, String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer);
}
