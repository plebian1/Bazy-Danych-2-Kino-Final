package model;

public class Rachunek {
	private int id;
	private String data;
	private int kwota;
	private int NIP;
	
	public Rachunek(int id, String data, int kwota, int NIP) {
		this.id = id;
		this.data=data;
		this.kwota=kwota;
		this.setNIP(NIP);
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
	public double getKwota() {
		return kwota;
	}
	public void setKwota(int kwota) {
		this.kwota = kwota;
	}

	public int getNIP() {
		return NIP;
	}

	public void setNIP(int nIP) {
		NIP = nIP;
	}
	
	
}
