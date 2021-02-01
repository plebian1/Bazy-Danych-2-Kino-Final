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

public class RachunekDAO {
	
	
	Statement stmt ;
	Statement stmt2 ;
	
	int id;
	String data;
	int kwota;
	int NIP;
	
	ResultSet rs;
	ResultSet rs2;
	
	public RachunekDAO() {
		
	}
	
	
	
	public List<Rachunek> selectAllRachunki(){
		
		List <Rachunek> rachunki = new ArrayList<>();
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		try{
			stmt =  connection.createStatement();
			stmt2 =  connection.createStatement();
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.rachunek_view;");
			while(rs.next()) {
				id = rs.getInt("Id_zakupu");
				data = rs.getString("Data");
				kwota = rs.getInt("Kwota");
				NIP = rs.getInt("NIP");
				rachunki.add(new Rachunek(id,data,kwota,NIP));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rachunki;
	}
}
