package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import dao.SeansManagerDAO;
import model.Film;
import model.Pracownik;
import model.Seans;

/**
 * Servlet implementation class SeansEdit
 */
@WebServlet("/Manager/SeansEdit")
public class SeansEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDAO filmDAO;
	private PracownikDAO pracownikDAO;  
    private SeansManagerDAO seansManagerDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeansEdit() {
        super();
        this.filmDAO = new FilmDAO();
    	this.pracownikDAO = new PracownikDAO();
    	this.seansManagerDAO = new SeansManagerDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		
		String Ids = request.getParameter("Id_seansu");
		int Id = Integer.parseInt(Ids);  
		
		Statement stmt ;
		ResultSet rs;
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		
		
		int Idfilmu =0;
		
		try{
			stmt =  connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM bdkino.seanse where Id_seansu = '"+Id+"' ;");
			rs.next();
			Idfilmu = rs.getInt("Id_filmu");
			
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Film film = new Film();
		film = filmDAO.getFilm(Idfilmu);
		request.setAttribute("film", film);
		
		try
		{
				listPracownik(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
		
		
		int sala = 0;
		try{
			stmt =  connection.createStatement();
			
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.seanse where Id_seansu = '"+Id+"';");
			while(rs.next()) {
				sala = rs.getInt("Id_sali");
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	
		
		request.setAttribute("sala", sala);
	
		
		//wysy³aæ seans
		Seans seans = new Seans();
		seans = seansManagerDAO.getSeans(Id);
		request.setAttribute("seans", seans);
		
		
		// aktywny opiekun
		int opiekun =0;
		try{
			stmt =  connection.createStatement();
			
			
			rs = stmt.executeQuery("SELECT * FROM bdkino.seanse where Id_seansu = '"+Id+"';");
			while(rs.next()) {
				opiekun = rs.getInt("Id_pracownika");
			}
			
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("aktualnyOpiekun", opiekun);
		
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("seansManagementModify.jsp");
		dispatcher.forward(request, response);
		
		
	}
	
	
	
	private void listPracownik(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Pracownik> pracownicy=pracownikDAO.selectAllPracownik();
		
		request.setAttribute("listOpiekun", pracownicy);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
