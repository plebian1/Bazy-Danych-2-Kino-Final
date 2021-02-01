package web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDAO;
import model.Film;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
/**
 * Servlet implementation class FilmServlet
 */
@WebServlet("/Manager/FilmManagement")
public class FilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private FilmDAO filmDAO;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmServlet() {
    	this.filmDAO = new FilmDAO();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		//System.out.println(action);
		request.setCharacterEncoding("UTF-8");
		try {
			
				listFilm(request, response);
				
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	
	private void listFilm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Film> listFilm = filmDAO.selectAllFilms();
		request.setAttribute("listFilm", listFilm);
		RequestDispatcher dispatcher = request.getRequestDispatcher("filmyManagement.jsp");
		dispatcher.forward(request, response);
	}



}
