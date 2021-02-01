package model;

public class Seans {
	
	private int id;
	private String data;
	private String godzina;
	private String nazwa_filmu;
	private int id_sali;
	private String napisy;
	private String jezyk;
	private String czas_trwania;
	private String imie;
	private String nazwisko;
	
	
	
	
	public Seans() {
		super();
	}

	public Seans(int id, String data, String godzina, String nazwa_filmu, int id_sali, int napisy, String jezyk,
			String czas_trwania, String imie, String nazwisko) {
		super();
		this.id = id;
		this.data = data;
		this.godzina = godzina;
		this.nazwa_filmu = nazwa_filmu;
		this.id_sali = id_sali;
		if(napisy==1) this.napisy="TAK";
		else this.napisy="NIE";
		this.jezyk = jezyk;
		this.czas_trwania = czas_trwania;
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	
	
	
	public Seans(String data, String godzina, String nazwa_filmu, int id_sali,int napisy, String jezyk, String czas_trwania) {
		this.data=data;
		this.godzina=godzina;
		this.nazwa_filmu=nazwa_filmu;
		this.id_sali=id_sali;
		if(napisy==1) this.napisy="TAK";
		else this.napisy="NIE";
		this.jezyk=jezyk;
		this.czas_trwania=czas_trwania;
	}
	
	
		
	public Seans(int id,String data, String godzina, String nazwa_filmu, int id_sali,int napisy, String jezyk, String czas_trwania) {
		this.id=id;
		this.data=data;
		this.godzina=godzina;
		this.nazwa_filmu=nazwa_filmu;
		this.id_sali=id_sali;
		if(napisy==1) this.napisy="TAK";
		else this.napisy="NIE";
		this.jezyk=jezyk;
		this.czas_trwania=czas_trwania;
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
	public String getNazwa_filmu() {
		return nazwa_filmu;
	}
	public void setNazwa_filmu(String nazwa_filmu) {
		this.nazwa_filmu = nazwa_filmu;
	}
	public int getId_sali() {
		return id_sali;
	}
	public void setId_sali(int id_sali) {
		this.id_sali = id_sali;
	}
	public String getNapisy() {
		return napisy;
	}
	public void setNapisy(String napisy) {
		this.napisy = napisy;
	}
	public String getJezyk() {
		return jezyk;
	}
	public void setJezyk(String jezyk) {
		this.jezyk = jezyk;
	}
	public String getCzas_trwania() {
		return czas_trwania;
	}
	public void setCzas_trwania(String czas_trwania) {
		this.czas_trwania = czas_trwania;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public String getImieNazwisko() {
		return imie+" "+nazwisko;
	}
}
