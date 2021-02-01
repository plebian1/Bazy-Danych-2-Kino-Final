package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RezerwacjaDAO;
import dao.UserDB;
import model.Rezerwacja;
import model.Uzytkownik;

/**
 * Servlet implementation class KlientRezerwacje
 */
@WebServlet("/User/userRezerwacje")
public class KlientRezerwacje extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RezerwacjaDAO rezerwacjaDAO;   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KlientRezerwacje() {
        super();
        this.rezerwacjaDAO=new RezerwacjaDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int IdUzytkownika =1;
		HttpSession session = request.getSession(false);
		
		Uzytkownik user =  (Uzytkownik) session.getAttribute("user");
		UserDB userdb = new UserDB();
		IdUzytkownika = userdb.getUserID(user);
		
		
		List <Rezerwacja> listRezerwacje= rezerwacjaDAO.selectRezerwacjeKlienta(IdUzytkownika);
		request.setAttribute("listRezerwacje", listRezerwacje);
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("userRezerwacje.jsp");
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
