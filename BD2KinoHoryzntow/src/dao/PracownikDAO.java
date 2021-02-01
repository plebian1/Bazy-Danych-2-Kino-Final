package dao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import dao.MyDb;

import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Film;
import model.Pracownik;

public class PracownikDAO {
	private String jdbcURL = "jdbc:Mysql://localhost:3306/bdkino?serverTimezone=UTC";
	private String jdbcUsername = "root";
	private String jdbcPassword = "admin12345";
	
	Statement stmt ;
	Statement stmt2 ;
	
	int id;
	String imie;
	String nazwisko;
	String stanowisko;
	String email;
	String haslo;
	
	ResultSet rs;
	ResultSet rs2;
	
	public PracownikDAO() {
		
	}
	
public void updatePracownik(Pracownik pracownik) throws SQLException {
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{		
					stmt =  connection.createStatement();
					id = pracownik.getId();
					imie = pracownik.getImie();
					nazwisko = pracownik.getNazwisko();
					stanowisko = pracownik.getStanowisko();
					email = pracownik.getEmail();
					haslo = pracownik.getHaslo();
					
					
					
					stmt.executeUpdate("update login set Haslo ='"+haslo+"' where  Mail = '"+email+"' ;");
					
					stmt.executeUpdate("update pracownik set Imie ='"+imie+"',Nazwisko='"+nazwisko+"', Stanowisko = '"+stanowisko+"' where  Id_pracownika = '"+id+"' ;");
					
//					Zapo¿yczone z FilmDAO 
//					rs = stmt.executeQuery("SELECT Id_rezysera from  bdkino.rezyser where imie ='"+rezysertab[0]+"'and nazwisko ='"+rezysertab[1]+"' ");
//					if(rs.next())
//					{
//						 rezId = rs.getInt("Id_rezysera");
//					}
//					else
//					{
//						stmt.executeUpdate(" insert into rezyser(Imie,Nazwisko) Values ( '"+rezysertab[0]+"','"+rezysertab[1]+"' )   ");
//						rs = stmt.executeQuery("SELECT Id_rezysera from  bdkino.rezyser where imie ='"+rezysertab[0]+"'and nazwisko ='"+rezysertab[1]+"' ");
//						rs.next();
//						rezId = rs.getInt("Id_rezysera");
//						
//					}
//					
//					rs = stmt.executeQuery("SELECT Id_gatunku from  bdkino.gatunektab where Nazwa_gatunku ='"+gatunek+"' ");
//					rs.next();
//					gatId = rs.getInt("Id_gatunku");
//					
//					rs = stmt.executeQuery("SELECT Id_PEGI from  bdkino.pegitab where Nazwa_PEGI ='"+pegi+"' ");
//					rs.next();
//					pegiId = rs.getInt("Id_PEGI");
//					
//					stmt.executeUpdate("update film set Nazwa ='"+tytul+"',Id_gatunku='"+gatId+"', Id_rezysera = '"+rezId+"', Id_PEGI = '"+pegiId+"', Czas_trwania = '"+dlugosc+"' ,"
//							+ " Obsada ='"+obsada+"' where  Id_filmu = '"+id+"' ;");


					
					
					
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}	
	//insert pracownik
	
	//select pracownik by id
	
public Pracownik getPracownik(int id){
		

		Pracownik pracownik = new Pracownik();
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		
		try{
			Statement stmt =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.pracownik_view where Id_pracownika = '"+id+"';");
			
			rs.next();
			
				String imie = rs.getString("Imie");
				String nazwisko = rs.getString("Nazwisko");
				String stanowisko = rs.getString("Stanowisko");
				String email = rs.getString("Mail");


				pracownik.setId(id);
				pracownik.setImie(imie);
				pracownik.setNazwisko(nazwisko);
				pracownik.setStanowisko(stanowisko);
				pracownik.setEmail(email);
				
			rs = stmt.executeQuery("SELECT Haslo FROM bdkino.login where Mail = '"+email+"';");
			rs.next();	
			
				String haslo = rs.getString("Haslo");
				pracownik.setHaslo(haslo);
			
				
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pracownik;
	}
	
	//select pracownik
	public List<Pracownik> selectAllPracownik(){
		
		List <Pracownik> pracownicy = new ArrayList<>();
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("select * from pracownik_view");
			while(rs.next()) {
				id = rs.getInt("Id_pracownika");
				imie = rs.getString("Imie");
				nazwisko = rs.getString("Nazwisko");
				email = rs.getString("Mail");
				stanowisko = rs.getString("Stanowisko");
				
				pracownicy.add(new Pracownik(id,imie,nazwisko,stanowisko,email));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pracownicy;
	}
	
	public void InsertPracownik(Pracownik dane)
	{
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try {
			Statement stmt =  con.createStatement();
			String imie = dane.getImie();
			String nazwisko = dane.getNazwisko();
			String stanowisko = dane.getStanowisko();
			String email = dane.getEmail();
			String haslo = dane.getHaslo();
			
			Integer typ = 2;
			stmt.executeUpdate("insert into login(Mail,Haslo,Id_typu) VALUES ('"+email+"','"+haslo+"','"+typ+"')");
			stmt.executeUpdate("insert into pracownik(Imie,Nazwisko,Mail,Stanowisko) VALUES ('"+imie+"','"+nazwisko+"','"+email+"','"+stanowisko+"')");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	//delete pracownik
	
	public void DeletePracownik(int id)
	{
		MyDb db = new MyDb();
		Connection con = db.getCon();
		try {
			Statement stmt =  con.createStatement();
			
			
			PracownikDAO pracownik =  new PracownikDAO();
			Pracownik dane = new Pracownik();
			dane = pracownik.getPracownik(id);
			String mail = dane.getEmail();
			
			if(id == 1)
			{
				int idd = id+1;
				stmt.executeUpdate("update Bilet set Id_pracownika ='"+idd+"' where  Id_pracownika = '"+id+"' ;");
				stmt.executeUpdate("update Rachunek set Id_pracownika ='"+idd+"' where  Id_pracownika = '"+id+"' ;");
				stmt.executeUpdate("update Seanse set Id_pracownika ='"+idd+"' where  Id_pracownika = '"+id+"' ;");
				
				
			}
			else
			{
				int idd = id-1;
				stmt.executeUpdate("update Bilet set Id_pracownika ='"+idd+"' where  Id_pracownika = '"+id+"' ;");
				stmt.executeUpdate("update Rachunek set Id_pracownika ='"+idd+"' where  Id_pracownika = '"+id+"' ;");
				stmt.executeUpdate("update Seanse set Id_pracownika ='"+idd+"' where  Id_pracownika = '"+id+"' ;");
				
				
			}
			
			
			stmt.executeUpdate("DELETE FROM pracownik WHERE  Id_pracownika = '"+id+"'; ");
			stmt.executeUpdate("DELETE FROM Login WHERE  Mail = '"+mail+"'; ");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
