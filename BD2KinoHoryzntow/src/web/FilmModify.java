package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FilmDAO;
import model.Film;

/**
 * Servlet implementation class FilmModify
 */
@WebServlet("/Manager/FilmModify")
public class FilmModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		String tytul = request.getParameter("filmTitle");
		String rezyser = request.getParameter("director");
		String dlugosc = request.getParameter("duration");
		String gatunek = request.getParameter("gatunek");
		String pegi = request.getParameter("pegi");
		String obsada = request.getParameter("cast");
		String Ids = request.getParameter("Id_filmu");
		System.out.println(Ids);
		int id = Integer.parseInt(Ids);  
		

		
		
		Film dane = new Film(id,tytul,rezyser,gatunek,pegi,obsada,dlugosc);
		FilmDAO film = new FilmDAO();
		try {
			film.updateFilm(dane);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("FilmManagement");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
