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


	public int getProjekt_id() {
		return projekt_id;
	}

	public void setProjekt_id(int projekt_id) {
		this.projekt_id = projekt_id;
	}

	@Override
	public String toString() {
		return projekt_bezeichnung;
	}
	
	
}
