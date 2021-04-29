package model;

public class Bestellung {

	// Attribute für die Bestellungsliste
	private int bestellungsId;
	private String vorname;
	private String nachname;
	private String artikel;
	private int anzahl;
	private float preis;
	
	public int getBestellungsId() {
		return bestellungsId;
	}
	public void setBestellungsId(int bestellungsId) {
		this.bestellungsId = bestellungsId;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getArtikel() {
		return artikel;
	}
	public void setArtikel(String artikel) {
		this.artikel = artikel;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	public float getPreis() {
		return preis;
	}
	public void setPreis(float preis) {
		this.preis = preis;
	}
	public Bestellung(int bestellungsId, String vorname, String nachname, String artikel, int anzahl, float preis) {
		super();
		this.bestellungsId = bestellungsId;
		this.vorname = vorname;
		this.nachname = nachname;
		this.artikel = artikel;
		this.anzahl = anzahl;
		this.preis = preis;
	}

	
	
}
