package dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Rezerwacja;
//Operacje na bazie danych
import model.Seans;

public class RezerwacjaDAO {
	Statement stmt ;
	Statement stmt2 ;
	
	int id;
	String data;
	String godzina;
	String nazwa;
	int rzad;
	int kolumna;
	int sala;
	
	ResultSet rs;
	ResultSet rs2;
	
	public List<Rezerwacja> selectAllRezerwacja(){
		List<Rezerwacja> rezerwacje = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.rezerwacje_view;");
			while(rs.next()) {
				id=rs.getInt("Id_rezerwacji");
				data = rs.getString("Data");
				godzina = rs.getString("Godzina");
				nazwa = rs.getString("Nazwa");
				rzad = rs.getInt("rzad");
				kolumna = rs.getInt("kolumna");
				rezerwacje.add(new Rezerwacja(id,data,godzina,nazwa,rzad,kolumna));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rezerwacje;
	}
	public List<Rezerwacja> selectAllRezerwacjaSeans(int id){
		List<Rezerwacja> rezerwacje = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT rezerwacja.id_biletu FROM bdkino.rezerwacja JOIN bdkino.bilet ON (rezerwacja.id_biletu=bilet.id_biletu) WHERE bilet.id_seansu='"+id+"' ;");
			while(rs.next()) {
				id=rs.getInt("Id_biletu");
				rezerwacje.add(new Rezerwacja(id));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rezerwacje;
	}
	public void aproveRezerwacja(int id_biletu) {
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try {
			Statement stmt =  con.createStatement();
			stmt.executeUpdate("DELETE FROM rezerwacja WHERE  Id_biletu = '"+id_biletu+"'; ");
			stmt.executeUpdate("update bilet set id_statusu=3 WHERE id_biletu = '"+id_biletu+"' ;");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public List<Rezerwacja> selectRezerwacjeKlienta(int idUzytkownika){
		List<Rezerwacja> rezerwacje = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			
			
			rs2 = stmt2.executeQuery("SELECT Id_rezerwacji FROM bdkino.rezerwacja where Id_uzytkownika = '"+idUzytkownika+"'; ");
			
			while(rs2.next())
			{	
			int id_rezerwacji = rs2.getInt("Id_rezerwacji");
			rs = stmt.executeQuery("SELECT * FROM bdkino.rezerwacje_view where Id_rezerwacji ='"+id_rezerwacji+"';");
			while(rs.next()) {
				id=rs.getInt("Id_rezerwacji");
				data = rs.getString("Data");
				godzina = rs.getString("Godzina");
				nazwa = rs.getString("Nazwa");
				rzad = rs.getInt("rzad");
				kolumna = rs.getInt("kolumna");
				sala = rs.getInt("Id_sali");
				rezerwacje.add(new Rezerwacja(id,data,godzina,nazwa,rzad,kolumna,sala));
			}
			
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rezerwacje;
	}
}
