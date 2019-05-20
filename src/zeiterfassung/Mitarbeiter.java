package zeiterfassung;

public class Mitarbeiter {
	
	private String mitarbeiter_vn;
	private String mitarbeiter_nn;
	
	public Mitarbeiter(String mitarbeiter_vn, String mitarbeiter_nn) {

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

	
}
