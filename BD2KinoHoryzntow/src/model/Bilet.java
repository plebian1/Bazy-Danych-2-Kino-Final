package model;

public class Bilet {
	private int id_biletu;
	private int id_seansu;
	private int id_pracownika;
	private int id_miejsca;
	private int id_statusu;
	private int cena;
	private int rzad;
	private int kolumna;
	
	public Bilet(int id_biletu, int id_seansu, int id_pracownika, int id_miejsca, int id_statusu,int cena, int rzad, int kolumna) {
		super();
		this.id_biletu = id_biletu;
		this.id_seansu = id_seansu;
		this.id_pracownika = id_pracownika;
		this.id_miejsca=id_miejsca;
		this.id_statusu=id_statusu;
		this.cena = cena;
		this.rzad = rzad;
		this.setKolumna(kolumna);
	}
	
	public int getId_miejsca() {
		return id_miejsca;
	}

	public void setId_miejsca(int id_miejsca) {
		this.id_miejsca = id_miejsca;
	}

	public int getId_biletu() {
		return id_biletu;
	}
	public void setId_biletu(int id_biletu) {
		this.id_biletu = id_biletu;
	}
	public int getId_seansu() {
		return id_seansu;
	}
	public void setId_seansu(int id_seansu) {
		this.id_seansu = id_seansu;
	}
	public int getId_pracownika() {
		return id_pracownika;
	}
	public void setId_pracownika(int id_pracownika) {
		this.id_pracownika = id_pracownika;
	}
	public int getCena() {
		return cena;
	}
	public void setCena(int cena) {
		this.cena = cena;
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
	public int getId_statusu() {
		return id_statusu;
	}

	public void setId_statusu(int id_statusu) {
		this.id_statusu = id_statusu;
	}
}
