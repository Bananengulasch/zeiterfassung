package zeiterfassung;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	public List<Mitarbeiter> getAllMitarbeiter();
	public List<Projekt> getAllProjekte();
	public String getSpecificId();
	public void addInvoice(int mitarbeiter_mitarbeiter_id, int projekt_projekt_id, String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer);
	public void updateInvoice(int projektposition_id, int mitarbeiter_mitarbeiter_id, int projekt_projekt_id, String projektposition_bezeichnung, Date projektposition_datum, String projektposition_dauer);
	public void addMitarbeiter(String mitarbeiter_vn, String mitarbeiter_nn);
	public void updateMitarbeiter(int mitarbeiter_id, String mitarbeiter_vn, String mitarbeiter_nn);
	public void addProjekt(String projekt_bezeichnung);
	public void updateProjekt(int projekt_id, String projekt_bezeichnung);
}
