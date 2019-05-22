package zeiterfassung;

import java.sql.Date;

public class Invoice {
	
	private int id;
	private String mitarbeiter_id;
	private String projekt_id;
	private String taetigkeit;
	private Date timestamp;
	private String dauer;
	
	

	public Invoice(int id, String mitarbeiter_id, String projekt_id, String taetigkeit, Date timestamp, String dauer) {
		this.id = id;
		this.mitarbeiter_id = mitarbeiter_id;
		this.projekt_id = projekt_id;
		this.taetigkeit = taetigkeit;
		this.timestamp = timestamp;
		this.dauer = dauer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMitarbeiter_id() {
		return mitarbeiter_id;
	}

	public void setMitarbeiter_id(String mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}

	public String getProjekt_id() {
		return projekt_id;
	}

	public void setProjekt_id(String projekt_id) {
		this.projekt_id = projekt_id;
	}

	public String getTaetigkeit() {
		return taetigkeit;
	}

	public void setTaetigkeit(String taetigkeit) {
		this.taetigkeit = taetigkeit;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getDauer() {
		return dauer;
	}

	public void setDauer(String dauer) {
		this.dauer = dauer;
	}
	

	
	
	
}