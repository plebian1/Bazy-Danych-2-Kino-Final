package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDAO;
import model.Film;

/**
 * Servlet implementation class FilmEdit
 */
@WebServlet("/Manager/FilmEdit")
public class FilmEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmDAO filmDAO= new FilmDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String Ids = request.getParameter("Id_filmu");
		int Id = Integer.parseInt(Ids);  
		

		Film film = new Film();
		film = filmDAO.getFilm(Id);
		
		
		
		request.setAttribute("film", film);
		RequestDispatcher dispatcher = request.getRequestDispatcher("filmyManagementModify.jsp");
		dispatcher.forward(request, response);

		
	}
	
	
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

			doGet(request, response);
		
	}

}
