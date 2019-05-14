package zeiterfassung;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAOKunde {

	public List<InvoiceKunde> getAllInvoices();
	public void deleteInvoice(int id);
	public void addInvoice(String vname, String nname, Date birthdate, String adress, String email, String number, int cars, String besitz);
	public void updateInvoice(int id, String vname, String nname, Date birthdate, String adress, String email, String number, int cars, String besitz);
}
