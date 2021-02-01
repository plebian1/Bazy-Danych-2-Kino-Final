package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDAO;
import dao.MyDb;
import dao.PracownikDAO;
import model.Film;
import model.Pracownik;

/**
 * Servlet implementation class SeansGetdata1
 */
@WebServlet("/Manager/SeansGetdata1")
public class SeansGetdata1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDAO filmDAO;
	private PracownikDAO pracownikDAO;  
	
	
	 public SeansGetdata1() {
	    	this.filmDAO = new FilmDAO();
	    	this.pracownikDAO = new PracownikDAO();
	    }
       
 

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

	
		
		try {
			
				listFilm(request, response);
				
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		try
		{
				listPracownik(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		
		
		List <Integer> sale = new ArrayList<>();
		Statement stmt ;
		ResultSet rs;
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		
		try{
			stmt =  connection.createStatement();
			
			
			rs = stmt.executeQuery("SELECT Id_sali FROM bdkino.sala;");
			while(rs.next()) {
				sale.add(rs.getInt("Id_sali"));
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//List<Film> a = filmDAO.selectAllFilms();
		//a =  (List<Film>) request.getAttribute("listFilm");
		//Film a2 = a.get(1);
		//System.out.print(a2.getTytul());
		
		request.setAttribute("listSale", sale);
		RequestDispatcher dispatcher = request.getRequestDispatcher("seansManagementAdd.jsp");
		dispatcher.forward(request, response);	
		
		
		
	}
	
	
	private void listFilm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Film> listFilm = filmDAO.selectAllFilms();
		request.setAttribute("listFilm", listFilm);

		//RequestDispatcher dispatcher = request.getRequestDispatcher("seansManagementAdd.jsp");
		//dispatcher.forward(request, response);
	}
	
	private void listPracownik(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Pracownik> pracownicy=pracownikDAO.selectAllPracownik();
		
		request.setAttribute("listOpiekun", pracownicy);
		//RequestDispatcher dispatcher = request.getRequestDispatcher("seansManagementAdd.jsp");
		//dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
