package model;

public class Uzytkownik {
	
	private String imie;
	private String nazwisko;
	private String email;
	private String numerTel;
	private int poziomDostepu;
	private String password;
	

	public Uzytkownik() {
		super();
	}

	public Uzytkownik(String imie, String nazwisko, String email, String numerTel, String password) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		this.numerTel = numerTel;
		this.password = password;
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

	public String getNumerTel() {
		return numerTel;
	}

	public void setNumerTel(String numerTel) {
		this.numerTel = numerTel;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getPoziomDostepu() {
		return poziomDostepu;
	}

	public void setPoziomDostepu(int poziomDostepu) {
		this.poziomDostepu = poziomDostepu;
	}
	
}
