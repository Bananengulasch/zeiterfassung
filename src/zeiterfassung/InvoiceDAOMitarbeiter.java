package zeiterfassung;

import java.util.List;

public interface InvoiceDAOMitarbeiter {

	public List<Invoice> getAllInvoices();
	public void addInvoice(String mitarbeiter_vn, String mitarbeiter_nn);
	public void updateInvoice(int mitarbeiter_id, String mitarbeiter_vn, String mitarbeiter_nn);
}
