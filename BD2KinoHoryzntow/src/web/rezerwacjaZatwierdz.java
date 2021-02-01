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
import javax.servlet.http.HttpSession;

import model.Bilet;
import dao.BiletDAO;
import dao.UserDB;
import model.Seans;
import model.Uzytkownik;

/**
 * Servlet implementation class Rezerwuj
 */
@WebServlet("/User/rezerwacjaZatwierdz")
public class rezerwacjaZatwierdz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BiletDAO biletDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rezerwacjaZatwierdz() {
        super();
        biletDAO=new BiletDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Ids = request.getParameter("biletList");
		int Id = Integer.parseInt(Ids);
		//System.out.println(Id);
		
		int IdUzytkownika =1;
		HttpSession session = request.getSession(false);
		
		Uzytkownik user =  (Uzytkownik) session.getAttribute("user");
		UserDB userdb = new UserDB();
		IdUzytkownika = userdb.getUserID(user);
		
		biletDAO.updateReservation(Id, IdUzytkownika);
		RequestDispatcher dispatcher = request.getRequestDispatcher("..\\User\\landingPage.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}