package dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Bilet;
//Operacje na bazie danych

public class BiletDAO {
	Statement stmt ;
	Statement stmt2 ;
	
	int id_biletu;
	int id_seansu;
	int id_miejsca;
	int id_pracownika;
	int id_statusu;
	int cena;
	int rzad;
	int kolumna;
	
	ResultSet rs;
	ResultSet rs2;
	
	public List<Bilet> selectAllFreeBiletSeans(int id){
		List<Bilet> bilety = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			System.out.println(id);
			rs = stmt.executeQuery("SELECT id_biletu,id_seansu,id_pracownika,cena,bilet.id_miejsca,id_statusu, rzad, kolumna FROM bilet JOIN miejsce ON (bilet.id_miejsca=miejsce.id_miejsca) WHERE id_statusu=1 AND id_seansu='"+id+"';");
			while(rs.next()) {
				id_biletu=rs.getInt("id_biletu");
				id_seansu=rs.getInt("id_seansu");
				id_pracownika = rs.getInt("id_pracownika");
				cena = rs.getInt("cena");
				id_miejsca = rs.getInt("id_miejsca");
				id_statusu = rs.getInt("id_statusu");
				rzad = rs.getInt("rzad");
				kolumna = rs.getInt("kolumna");
				bilety.add(new Bilet(id_biletu,id_seansu,id_pracownika,id_miejsca,id_statusu,cena,rzad,kolumna));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bilety;
	}
	public void updateBilet(Bilet bilet) {
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{		
			id_biletu=bilet.getId_biletu();
			id_seansu=bilet.getId_seansu();
			id_pracownika = bilet.getId_pracownika();
			cena = bilet.getCena();
			id_miejsca = bilet.getId_miejsca();
			id_statusu = bilet.getId_statusu();
			rzad = bilet.getRzad();
			kolumna = bilet.getKolumna();
			stmt.executeUpdate("update bilet set id_seansu ='"+id_seansu+"', id_pracownika ='"+id_pracownika+"', cena ='"+cena+"',id_miejsca='"+id_miejsca+"', id_statusu ='"+id_statusu+"' where  id_biletu = '"+id_biletu+"' ;");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateReservation(int id , int idUzytkownika) { //iduzy
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt.executeUpdate("insert into bdkino.rezerwacja(Id_biletu, Id_uzytkownika) VALUES('"+id+"', '"+idUzytkownika+"');");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void sellTicket(int id) {
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt.executeUpdate("update bilet set id_statusu=3 WHERE id_biletu = '"+id+"' ;");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
