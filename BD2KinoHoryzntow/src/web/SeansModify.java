package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDb;
import dao.SeansManagerDAO;

/**
 * Servlet implementation class SeansModify
 */
@WebServlet("/Manager/SeansModify")
public class SeansModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeansModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Statement stmt ;
		ResultSet rs;
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		
		
		
		String godzina = request.getParameter("godzina");
		String data = request.getParameter("data");
		String id_filmu = request.getParameter("Id_filmu");
		//String id_sali = request.getParameter("Id_sali");
		String napisy = request.getParameter("napisy");		
		String jezyk = request.getParameter("jezyk");
		String id_pracownika = request.getParameter("opiekunName");
		String dlugosc = request.getParameter("duration");
		String id_seansu = request.getParameter("Id_seansu");
		
		int  napisybool = 1;
		int filmint,pracownikint,salaint = 0, seansint;
		
		if(napisy.equals("tak") )
		{
			napisybool = 1;
		}
		else 
		{
			napisybool = 0;
		}
		
		filmint  = Integer.parseInt(id_filmu); 
		pracownikint = Integer.parseInt(id_pracownika); 
		seansint = Integer.parseInt(id_seansu);
		
		try{
			stmt =  connection.createStatement();
			
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.seanse where Id_seansu = '"+seansint+"';");
			while(rs.next()) {
				salaint = rs.getInt("Id_sali");
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		SeansManagerDAO seans = new SeansManagerDAO();
		try {
			seans.updateSeans(seansint,godzina, data, filmint,salaint,napisybool,jezyk,pracownikint,dlugosc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		response.sendRedirect("seansManagement");
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
