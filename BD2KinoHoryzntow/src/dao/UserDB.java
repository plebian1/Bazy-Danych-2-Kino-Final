package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Uzytkownik;

public class UserDB {
	
	public void insertUser(Uzytkownik dane)
	{
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try {
			Statement stmt =  con.createStatement();
			String imie = dane.getImie();
			String nazwisko = dane.getNazwisko();
			String telefon = dane.getNumerTel();
			String email = dane.getEmail();
			String haslo = dane.getPassword();
			Integer typ = 3;
			stmt.executeUpdate("insert into login(Mail,Haslo,Id_typu) VALUES ('"+email+"','"+haslo+"','"+typ+"')");
			stmt.executeUpdate("insert into uzytkownik(Imie,Nazwisko,Numer_telefonu,Mail) VALUES ('"+imie+"','"+nazwisko+"','"+telefon+"','"+email+"')");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public	Uzytkownik getUser(Uzytkownik user)
	{
		Uzytkownik uzytkownik = new Uzytkownik();
		String mail = user.getEmail();
		String haslo = user.getPassword();
		MyDb db = new MyDb();
		ResultSet rs;
		Connection con = db.getCon();
		uzytkownik.setPoziomDostepu(0);
		uzytkownik.setEmail(mail);

		try {
			Statement stmt =  con.createStatement();
		
			rs = stmt.executeQuery("SELECT Id_typu FROM bdkino.login where Mail ='"+mail+"' and Haslo ='"+haslo+"' ");
			//rs.next();
			
			Integer token = 0;
			String imie = "Gal";
			String nazwisko = "Anonim";
			if(rs.next())
			{
				token = rs.getInt("Id_typu");
				uzytkownik.setPoziomDostepu(token);
			}
			
			
			if(token == 3)
			{
				rs = stmt.executeQuery("SELECT Imie, Nazwisko FROM bdkino.uzytkownik where Mail ='"+mail+"'; ");
				
				if(rs.next())
				{
					imie = rs.getString("Imie");
					nazwisko = rs.getString("Nazwisko");
					
				}
				
				
			
			}
			else if (token == 2)
			{
				
				
				rs = stmt.executeQuery("SELECT Imie, Nazwisko FROM bdkino.pracownik where Mail ='"+mail+"'; ");
				if(rs.next())
				{
					imie = rs.getString("Imie");
					nazwisko = rs.getString("Nazwisko");
					
				}
				
				
			}
			else if (token == 1)
			{
				imie = "Bo¿ydar";
				nazwisko = "Enigmatyczny";
				
			}
			
			uzytkownik.setImie(imie);
			uzytkownik.setNazwisko(nazwisko);
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uzytkownik;
	
	}
	
	
	public	int getUserID(Uzytkownik user)
	{
		Uzytkownik uzytkownik = new Uzytkownik();
		String mail = user.getEmail();
		
		MyDb db = new MyDb();
		ResultSet rs;
		Connection con = db.getCon();
		uzytkownik.setEmail(mail);
		int id_uzytkownika = 1;

		try {
			Statement stmt =  con.createStatement();
		
			rs = stmt.executeQuery("SELECT Id_uzytkownika FROM bdkino.uzytkownik where Mail ='"+mail+"'; ");
			
			if(rs.next())
			{
				id_uzytkownika = rs.getInt("Id_uzytkownika");
			}
			
			
				
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id_uzytkownika;
	
	}

}
