package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Rachunek;
import model.Seans;

public class SeansKlientDAO {
	
	
	Statement stmt ;
	Statement stmt2 ;
	
	int id;
	String data;
	String godzina;
	String nazwa_filmu;
	int id_sali;
	int napisy;
	String jezyk;
	String czas_trwania;
	
	ResultSet rs;
	ResultSet rs2;
	
	
	
	public List<Seans> selectAllSeanse(){
		List <Seans> seanse = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.seans_klient_view;");
			while(rs.next()) {
				id=rs.getInt("Id_seansu");
				data = rs.getString("Data");
				godzina = rs.getString("Godzina");
				nazwa_filmu = rs.getString("Nazwa");
				id_sali = rs.getInt("Id_sali");
				napisy = rs.getInt("Napisy");
				jezyk = rs.getString("Jezyk");
				czas_trwania = rs.getString("czas_trwania");
				seanse.add(new Seans(id,data,godzina,nazwa_filmu,id_sali,napisy,jezyk,czas_trwania));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seanse;
	}
	
}
