package zeiterfassung;

import java.sql.Date;

public class InvoiceKunde {
	
	private int id;
	private String vname;
	private String nname;
	private Date birthdate;
	private String adress;
	private String email;
	private String number;
	private int cars;
	private String besitz;
	
	public InvoiceKunde(int id, String vname, String nname, Date birthdate, String adress, String email, String number,
			int cars, String besitz) {
		super();
		this.id = id;
		this.vname = vname;
		this.nname = nname;
		this.birthdate = birthdate;
		this.adress = adress;
		this.email = email;
		this.number = number;
		this.cars = cars;
		this.besitz = besitz;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVname() {
		return vname;
	}

	public void setVname(String vname) {
		this.vname = vname;
	}

	public String getNname() {
		return nname;
	}

	public void setNname(String nname) {
		this.nname = nname;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getCars() {
		return cars;
	}

	public void setCars(int cars) {
		this.cars = cars;
	}
	
	

	public String getBesitz() {
		return besitz;
	}

	public void setBesitz(String besitz) {
		this.besitz = besitz;
	}

	@Override
	public String toString() {
		return "InvoiceKunde [id=" + id + ", vname=" + vname + ", nname=" + nname + ", birthdate=" + birthdate
				+ ", adress=" + adress + ", email=" + email + ", number=" + number + ", cars=" + cars + "]";
	}
	
	
	
	
}