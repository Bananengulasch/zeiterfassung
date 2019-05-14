package zeiterfassung;

import java.sql.Date;

public class Invoice {
	
	private int id;
	private String marke;
	private String modell;
	private String aufbau;
	private int jahr;
	private int kilometer;
	private int ps;
	private int tueren;
	private String farbe;
	private String nwgw;
	private String getriebe;
	private int preis;
	private String verkauft;
	

	public Invoice(int id, String marke, String modell, String aufbau, int jahr, int kilometer, int ps, 
			String nwgw, int tueren, String farbe,  String getriebe, int preis, String verkauft) {
		super();
		this.id = id;
		this.marke = marke;
		this.modell = modell;
		this.aufbau = aufbau;
		this.jahr = jahr;
		this.kilometer = kilometer;
		this.ps = ps;
		this.tueren = tueren;
		this.farbe = farbe;
		this.nwgw = nwgw;
		this.getriebe = getriebe;
		this.preis = preis;
		this.verkauft = verkauft;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

	public String getModell() {
		return modell;
	}

	public void setModell(String modell) {
		this.modell = modell;
	}

	public String getAufbau() {
		return aufbau;
	}

	public void setAufbau(String aufbau) {
		this.aufbau = aufbau;
	}

	public int getJahr() {
		return jahr;
	}

	public void setJahr(int jahr) {
		this.jahr = jahr;
	}

	public int getKilometer() {
		return kilometer;
	}

	public String getFarbe() {
		return farbe;
	}

	public void setFarbe(String farbe) {
		this.farbe = farbe;
	}

	public String getNwgw() {
		return nwgw;
	}
	
	public void setNwgw(String nwgw) {
		this.nwgw = nwgw;
	}

	public String getGetriebe() {
		return getriebe;
	}
	
	public void setGetriebe(String getriebe) {
		this.getriebe = getriebe;
	}
	
	public void setKilometer(int kilometer) {
		this.kilometer = kilometer;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public int getTueren() {
		return tueren;
	}

	public void setTueren(int tueren) {
		this.tueren = tueren;
	}

	

	

	public String getVerkauft() {
		return verkauft;
	}

	public void setVerkauft(String verkauft) {
		this.verkauft = verkauft;
	}

	public int getPreis() {
		return preis;
	}

	
	@Override
	public String toString() {
		return "Invoice [id=" + id + ", marke=" + marke + ", modell=" + modell + ", aufbau=" + aufbau + ", jahr=" + jahr
				+ ", kilometer=" + kilometer + ", ps=" + ps + ", tueren=" + tueren + ", farbe=" + farbe + ", nwgw="
				+ nwgw + ", getriebe=" + getriebe + ", preis=" + preis + "]";
	}


	

	public void setPreis(int preis) {
		this.preis = preis;
	}

	
	
	
}