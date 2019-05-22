package zeiterfassung;

public class Projekt {

	private String projekt_bezeichnung;
	private int projekt_id;
	
	public Projekt(int id, String projekt_bezeichnung) {
		this.projekt_bezeichnung = projekt_bezeichnung;
		this.projekt_id = id;
	}

	public String getProjekt_bezeichnung() {
		return projekt_bezeichnung;
	}

	public void setProjekt_bezeichnung(String projekt_bezeichnung) {
		this.projekt_bezeichnung = projekt_bezeichnung;
	}

	public int getId() {
		return projekt_id;
	}

	public void setId(int id) {
		this.projekt_id = id;
	}
	
	
}
