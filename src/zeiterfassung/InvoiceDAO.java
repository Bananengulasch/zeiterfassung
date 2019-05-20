package zeiterfassung;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	public void addInvoice(String mitarbeiter_id, String projekt_id, String taetigkeit, Date timestamp);
	public void updateInvoice(int id, String mitarbeiter_id, String projekt_id, String taetigkeit, Date timestamp);
}
