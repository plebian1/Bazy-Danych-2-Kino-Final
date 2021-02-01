package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PracownikDAO;
import model.Pracownik;

/**
 * Servlet implementation class FilmModify
 */
@WebServlet("/Manager/PracownikModify")
public class PracownikModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PracownikModify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		
		String imie = request.getParameter("firstName");
		String nazwisko = request.getParameter("lastName");
		String stanowisko = request.getParameter("phoneNum");
		String email = request.getParameter("email");
		String haslo = request.getParameter("password");
		String Ids = request.getParameter("Id_pracownika");
		System.out.println(Ids);
		int id = Integer.parseInt(Ids);  
		

		
		
		Pracownik dane = new Pracownik(id,imie,nazwisko,stanowisko,email,haslo);
		PracownikDAO pracownik = new PracownikDAO();
		try {
			pracownik.updatePracownik(dane);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("PracownicyManagement");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
