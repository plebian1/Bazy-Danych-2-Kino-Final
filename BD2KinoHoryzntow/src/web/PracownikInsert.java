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

import model.Pracownik;
import dao.PracownikDAO;
import model.Pracownik;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class PracownikModify
 */
@WebServlet("/Manager/insertuser")
public class PracownikInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	
	
    public PracownikInsert() {
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
		String password = request.getParameter("password");
		String stanowisko = request.getParameter("phoneNum");
		String email = request.getParameter("email");
		
		Pracownik dane = new Pracownik(imie,nazwisko,stanowisko,email,password);
		PracownikDAO ud = new PracownikDAO();
		ud.InsertPracownik(dane);
		
		response.sendRedirect("PracownicyManagement");
		
		
		
		
		
	}
	
	private void listPracownik(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Pracownik> pracownicy = null;
		//System.out.println(pracownicy.get(0).getEmail());
		request.setAttribute("listPracownik", pracownicy);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pracownicyManagement.jsp");
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
