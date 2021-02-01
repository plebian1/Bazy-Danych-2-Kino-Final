package model;

public class Film {

	private int id;
	private String tytul;
	private String rezyser;
	private String gatunek;
	private String pegi;
	private String obsada;
	private String dlugosc;
	
	
	
	public Film() {
		super();
	}

	
	

	public Film(String tytul, String rezyser, String gatunek, String pegi, String obsada, String dlugosc) {
		super();
		this.tytul = tytul;
		this.rezyser = rezyser;
		this.gatunek = gatunek;
		this.pegi = pegi;
		this.obsada = obsada;
		this.dlugosc = dlugosc;
	}




	public Film(int id,String tytul, String rezyser, String gatunek, String pegi, String obsada, String dlugosc) {
		super();
		this.id = id;
		this.tytul = tytul;
		this.rezyser = rezyser;
		this.gatunek = gatunek;
		this.pegi = pegi;
		this.obsada = obsada;
		this.dlugosc = dlugosc;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTytul() {
		return tytul;
	}


	public void setTytul(String tytul) {
		this.tytul = tytul;
	}


	public String getRezyser() {
		return rezyser;
	}


	public void setRezyser(String rezyser) {
		this.rezyser = rezyser;
	}


	public String getGatunek() {
		return gatunek;
	}


	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}


	public String getPegi() {
		return pegi;
	}


	public void setPegi(String pegi) {
		this.pegi = pegi;
	}


	public String getObsada() {
		return obsada;
	}


	public void setObsada(String obsada) {
		this.obsada = obsada;
	}


	public String getDlugosc() {
		return dlugosc;
	}


	public void setDlugosc(String dlugosc) {
		this.dlugosc = dlugosc;
	}


	
	
}
