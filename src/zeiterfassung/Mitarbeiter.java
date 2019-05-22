package zeiterfassung;

public class Mitarbeiter {
	
	private int mitarbeiter_id;
	private String mitarbeiter_vn;
	private String mitarbeiter_nn;
	
	public Mitarbeiter(int mitarbeiter_id, String mitarbeiter_vn, String mitarbeiter_nn) {

		this.mitarbeiter_vn = mitarbeiter_vn;
		this.mitarbeiter_nn = mitarbeiter_nn;
	}

	public String getMitarbeiter_vn() {
		return mitarbeiter_vn;
	}

	public void setMitarbeiter_vn(String mitarbeiter_vn) {
		this.mitarbeiter_vn = mitarbeiter_vn;
	}

	public String getMitarbeiter_nn() {
		return mitarbeiter_nn;
	}

	public void setMitarbeiter_nn(String mitarbeiter_nn) {
		this.mitarbeiter_nn = mitarbeiter_nn;
	}

	public int getMitarbeiter_id() {
		return mitarbeiter_id;
	}

	public void setMitarbeiter_id(int mitarbeiter_id) {
		this.mitarbeiter_id = mitarbeiter_id;
	}

	
	
}
