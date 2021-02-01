package model;

public class Rezerwacja {
	private int id;
	private int id_bilet;
	private String data;
	private String godzina;
	private String nazwa;
	private int rzad;
	private int kolumna;
	private int sala;
	
	
	
	
	
	public Rezerwacja(int id, String data, String godzina, String nazwa, int rzad, int kolumna, int sala) {
		super();
		this.id = id;
		this.data = data;
		this.godzina = godzina;
		this.nazwa = nazwa;
		this.rzad = rzad;
		this.kolumna = kolumna;
		this.sala = sala;
	}

	public Rezerwacja(int id, int id_bilet, String data, String godzina, String nazwa, int rzad, int kolumna,
			int sala) {
		super();
		this.id = id;
		this.id_bilet = id_bilet;
		this.data = data;
		this.godzina = godzina;
		this.nazwa = nazwa;
		this.rzad = rzad;
		this.kolumna = kolumna;
		this.sala = sala;
	}

	public Rezerwacja(int id, String data, String godzina, String nazwa, int rzad, int kolumna) {
		super();
		this.id = id;
		this.data = data;
		this.godzina = godzina;
		this.nazwa = nazwa;
		this.rzad = rzad;
		this.kolumna = kolumna;
	}
	
	public Rezerwacja(int id_bilet) {
		super();
		this.id_bilet = id_bilet;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getGodzina() {
		return godzina;
	}
	public void setGodzina(String godzina) {
		this.godzina = godzina;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public int getRzad() {
		return rzad;
	}
	public void setRzad(int rzad) {
		this.rzad = rzad;
	}
	public int getKolumna() {
		return kolumna;
	}
	public void setKolumna(int kolumna) {
		this.kolumna = kolumna;
	}
	public int getId_bilet() {
		return id_bilet;
	}
	public void setId_bilet(int id_bilet) {
		this.id_bilet = id_bilet;
	}

	public int getSala() {
		return sala;
	}

	public void setSala(int sala) {
		this.sala = sala;
	}
}
