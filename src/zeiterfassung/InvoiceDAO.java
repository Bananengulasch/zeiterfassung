package zeiterfassung;

import java.sql.Date;
import java.util.List;

public interface InvoiceDAO {

	public List<Invoice> getAllInvoices();
	public void deleteInvoice(int id);
	public void addInvoice(String marke, String modell, String aufbau, int jahr, int kilometer, int ps,  String nwgw, int tueren, String farbe,  String getriebe, int preis, String verkauft);
	public void updateInvoice(int id, String marke, String modell, String aufbau, int jahr, int kilometer, int ps,  String nwgw, int tueren, String farbe, String getriebe, int preis, String verkauft);
}
