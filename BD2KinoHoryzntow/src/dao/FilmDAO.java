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
//Operacje na bazie danych
public class FilmDAO {
	
	Statement stmt ;
	Statement stmt2 ;
	int id;
	String tytul ;
	String rezyser;
	String gatunek ;
	String pegi ;
	String obsada ;
	String dlugosc ;
	Integer gatId ;
	Integer pegiId ;
	Integer rezId;
	ResultSet rs;
	ResultSet rs2;
	
	public FilmDAO() {
		
	}
	

	
	
	//insert film
	public void insertFilm(Film film) throws SQLException {
		
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{		
					stmt =  connection.createStatement();
					tytul = film.getTytul();
					rezyser= film.getRezyser();
					gatunek = film.getGatunek();
					pegi = film.getPegi();
					obsada = film.getObsada();
					dlugosc = film.getDlugosc();
					gatId =2;
					pegiId =1;
					
					String[] rezysertab = rezyser.split(" ");
					
					
					rs = stmt.executeQuery("SELECT Id_rezysera from  bdkino.rezyser where imie ='"+rezysertab[0]+"'and nazwisko ='"+rezysertab[1]+"' ");
					if(rs.next())
					{
						 rezId = rs.getInt("Id_rezysera");
					}
					else
					{
						stmt.executeUpdate(" insert into rezyser(Imie,Nazwisko) Values ( '"+rezysertab[0]+"','"+rezysertab[1]+"' )   ");
						rs = stmt.executeQuery("SELECT Id_rezysera from  bdkino.rezyser where imie ='"+rezysertab[0]+"'and nazwisko ='"+rezysertab[1]+"' ");
						rs.next();
						rezId = rs.getInt("Id_rezysera");
						
					}
					
					rs = stmt.executeQuery("SELECT Id_gatunku from  bdkino.gatunektab where Nazwa_gatunku ='"+gatunek+"' ");
					rs.next();
					gatId = rs.getInt("Id_gatunku");
					
					rs = stmt.executeQuery("SELECT Id_PEGI from  bdkino.pegitab where Nazwa_PEGI ='"+pegi+"' ");
					rs.next();
					pegiId = rs.getInt("Id_PEGI");
					
					stmt.executeUpdate("insert into film(Nazwa,Id_gatunku, Id_rezysera, Id_PEGI, Czas_trwania, Obsada) VALUES ('"+tytul+"','"+gatId+"',"
							+ " '"+rezId+"', '"+pegiId+"', '"+dlugosc+"', '"+obsada+"'    ) ");
					
					
					
					}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
					
	
	//select film by id
	
	//select films
	
	public List<Film> selectAllFilms(){
		
		List <Film> films = new ArrayList<>();
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			Statement stmt =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.film_view;");
			
			while(rs.next())
			{
				
				int id = rs.getInt("Id_filmu");
				String nazwa = rs.getString("Nazwa");
				String imie = rs.getString("Imie");
				String nazwisko = rs.getString("Nazwisko");
				String dlugosc = rs.getString("Czas_trwania");
				String obsada = rs.getString("Obsada");
				String pegi = rs.getString("Nazwa_PEGI");
				String gatunek = rs.getString("Nazwa_gatunku");
				String rezyser = imie +(" ")+ nazwisko;
				Film dane = new Film();
				
				dane.setId(id);
				dane.setTytul(nazwa);
				dane.setRezyser(rezyser);
				dane.setObsada(obsada);
				dane.setDlugosc(dlugosc);
				dane.setPegi(pegi);
				dane.setGatunek(gatunek);
				
				
								

				
				films.add(dane);
			}
				
				
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return films;
	}
	
	
public Film getFilm(int id){
		

		Film film = new Film();
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		
		try{
			Statement stmt =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.film_view where Id_Filmu = '"+id+"';");
			
			rs.next();
			
				String nazwa = rs.getString("Nazwa");
				String imie = rs.getString("Imie");
				String nazwisko = rs.getString("Nazwisko");
				String dlugosc = rs.getString("Czas_trwania");
				String obsada = rs.getString("Obsada");
				String pegi = rs.getString("Nazwa_PEGI");
				String gatunek = rs.getString("Nazwa_gatunku");
				String rezyser = imie +(" ")+ nazwisko;

				
				
				
				film.setId(id);
				film.setTytul(nazwa);
				film.setRezyser(rezyser);
				film.setObsada(obsada);
				film.setDlugosc(dlugosc);
				film.setPegi(pegi);
				film.setGatunek(gatunek);
				

		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return film;
	}
	
	//update film


public void updateFilm(Film film) throws SQLException {
	
	MyDb db = new MyDb();
	Connection connection = db.getCon();
	try{		
				stmt =  connection.createStatement();
				tytul = film.getTytul();
				rezyser= film.getRezyser();
				gatunek = film.getGatunek();
				pegi = film.getPegi();
				obsada = film.getObsada();
				dlugosc = film.getDlugosc();
				id = film.getId();
				gatId =2;
				pegiId =1;
				
				String[] rezysertab = rezyser.split(" ");
				
				
				rs = stmt.executeQuery("SELECT Id_rezysera from  bdkino.rezyser where imie ='"+rezysertab[0]+"'and nazwisko ='"+rezysertab[1]+"' ");
				if(rs.next())
				{
					 rezId = rs.getInt("Id_rezysera");
				}
				else
				{
					stmt.executeUpdate(" insert into rezyser(Imie,Nazwisko) Values ( '"+rezysertab[0]+"','"+rezysertab[1]+"' )   ");
					rs = stmt.executeQuery("SELECT Id_rezysera from  bdkino.rezyser where imie ='"+rezysertab[0]+"'and nazwisko ='"+rezysertab[1]+"' ");
					rs.next();
					rezId = rs.getInt("Id_rezysera");
					
				}
				
				rs = stmt.executeQuery("SELECT Id_gatunku from  bdkino.gatunektab where Nazwa_gatunku ='"+gatunek+"' ");
				rs.next();
				gatId = rs.getInt("Id_gatunku");
				
				rs = stmt.executeQuery("SELECT Id_PEGI from  bdkino.pegitab where Nazwa_PEGI ='"+pegi+"' ");
				rs.next();
				pegiId = rs.getInt("Id_PEGI");
				
				stmt.executeUpdate("update film set Nazwa ='"+tytul+"',Id_gatunku='"+gatId+"', Id_rezysera = '"+rezId+"', Id_PEGI = '"+pegiId+"', Czas_trwania = '"+dlugosc+"' ,"
						+ " Obsada ='"+obsada+"' where  Id_filmu = '"+id+"' ;");


				
				
				
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}

//usuwanie filmu

public void deleteFilm(int id) throws SQLException {
	
	MyDb db = new MyDb();
	Connection connection2 = db.getCon();
	ResultSet rshere;
	SeansManagerDAO seans = new SeansManagerDAO();
	try{		
				stmt =  connection2.createStatement();
				stmt2 =  connection2.createStatement();
				
				rshere = stmt.executeQuery("SELECT * FROM bdkino.seanse where Id_filmu ='"+id+"';");

				
				
				while(rshere.next())
				{
					int idseansu = rshere.getInt("Id_seansu");
					seans.deleteSeans(idseansu);
							
					
					
				}
				stmt.executeUpdate("DELETE FROM film WHERE  Id_filmu = '"+id+"'; ");
				
				
				
				
				
				
				}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}



	
}
