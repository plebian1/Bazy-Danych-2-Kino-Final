package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Film;
import model.Seans;

public class SeansManagerDAO {
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
	String imie;
	String nazwisko;
	
	ResultSet rs;
	ResultSet rs2;
	
	
	
	public List<Seans> selectAllSeanse(){
		List <Seans> seanse = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.seans_pracownik_view;");
			while(rs.next()) {
				id=rs.getInt("Id_seansu");
				data = rs.getString("Data");
				godzina = rs.getString("Godzina");
				nazwa_filmu = rs.getString("Nazwa");
				id_sali = rs.getInt("Id_sali");
				napisy = rs.getInt("Napisy");
				jezyk = rs.getString("Jezyk");
				czas_trwania = rs.getString("Czas_trwania");
				imie =rs.getString("Imie");
				nazwisko =rs.getString("Nazwisko");
				seanse.add(new Seans(id,data,godzina,nazwa_filmu,id_sali,napisy,jezyk,czas_trwania,imie,nazwisko));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seanse;
	}
	
	
	public Seans getSeans(int id){

		Seans seans = new Seans();;
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.seanse where Id_seansu = '"+id+"';");
			while(rs.next()) {
				//id=rs.getInt("Id_seansu");
				data = rs.getString("Data");
				godzina = rs.getString("Godzina");
				//nazwa_filmu = rs.getString("Nazwa");
				id_sali = rs.getInt("Id_sali");
				napisy = rs.getInt("Napisy");
				jezyk = rs.getString("Jezyk");
				czas_trwania = rs.getString("Czas_trwania");
				//imie =rs.getString("Imie");
				//nazwisko =rs.getString("Nazwisko");
				
				String napisys;
				if(napisy ==1)
				{
					napisys = "tak";
				}
				else
				{
					napisys = "nie";
				}
				
				
				seans.setId(id);
				seans.setCzas_trwania(czas_trwania);
				seans.setData(data);
				seans.setGodzina(godzina);
				seans.setId_sali(id_sali);
				seans.setJezyk(jezyk);
				seans.setNapisy(napisys);
				//seans.setNazwa_filmu(nazwa_filmu);
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seans;
	}
	
	
	
	
	
	
	
	
public void insertSeans(String godzina, String data, int film, int sala, int napisy, String jezyk, int pracownik, String dlugosc) throws SQLException {
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{		
					stmt =  connection.createStatement();
					
				
					
					
					stmt.executeUpdate("insert into seanse(Godzina,Data, Id_filmu, Id_sali, Napisy, Jezyk,Id_pracownika, Czas_trwania) VALUES ('"+godzina+"','"+data+"',"
							+ " '"+film+"', '"+sala+"', '"+napisy+"', '"+jezyk+"' , '"+pracownik+"', '"+dlugosc+"'   ) ");
					
					
					
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

public void deleteSeans(int id) throws SQLException {
	
	MyDb db = new MyDb();
	Connection connection2 = db.getCon();
	ResultSet rshere;
	try{		
				stmt =  connection2.createStatement();
				stmt2 =  connection2.createStatement();
				
				rshere = stmt.executeQuery("SELECT * FROM bdkino.bilet where Id_seansu ='"+id+"';");

				while(rshere.next())
				{
					
					int idbiletu = rshere.getInt("Id_biletu");
					stmt2.executeUpdate("DELETE FROM rezerwacja WHERE  Id_biletu = '"+idbiletu+"'; ");					
					
					
				}
				stmt.executeUpdate("DELETE FROM bilet WHERE  Id_seansu = '"+id+"'; ");
				
				stmt.executeUpdate("DELETE FROM seanse WHERE  Id_seansu = '"+id+"'; ");
				
				
				
				
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}


public void updateSeans(int seans,String godzina, String data, int film, int sala, int napisy, String jezyk, int pracownik, String dlugosc) throws SQLException {
	
	MyDb db = new MyDb();
	Connection connection = db.getCon();
	try{		
				stmt =  connection.createStatement();
				
				
				
				stmt.executeUpdate("update seanse set Godzina = '"+godzina+"' ,Data ='"+data+"' , Id_filmu='"+film+"' , Id_sali = '"+sala+"',"
						+ " Napisy = '"+napisy+"', Jezyk = '"+jezyk+"' ,Id_pracownika = '"+pracownik+"', Czas_trwania = '"+dlugosc+"' where Id_seansu = '"+seans+"' ;");

				
				
				
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}




}
