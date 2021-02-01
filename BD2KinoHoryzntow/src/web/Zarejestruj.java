package web;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDB;
import model.Uzytkownik;


/**
 * Servlet implementation class Zarejestruj
 */
@WebServlet("/Guest/Zarejestruj")
public class Zarejestruj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zarejestruj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		String imie = request.getParameter("firstName");
		String nazwisko = request.getParameter("lastName");
		String password = request.getParameter("password");
		String telefon = request.getParameter("phoneNum");
		String email = request.getParameter("email");
		
			
		Uzytkownik dane = new Uzytkownik(imie,nazwisko,email,telefon,password);
		UserDB ud = new UserDB();
		
		
		ud.insertUser(dane);
		response.sendRedirect("..\\index.jsp");
		//out.print("HERE");
	}

}
