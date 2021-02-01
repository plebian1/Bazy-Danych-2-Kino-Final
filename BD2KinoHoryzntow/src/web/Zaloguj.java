package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDB;
import model.Uzytkownik;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Guest/Zaloguj")
public class Zaloguj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Zaloguj() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	
		 
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		
		UserDB ud = new UserDB();
		
		Uzytkownik user = new Uzytkownik();
		user.setEmail(email);
		user.setPassword(password);
		
		user = ud.getUser(user);
		
		Integer s1 = user.getPoziomDostepu();
		//request.setAttribute("user", user);
		
		
		
		HttpSession session = request.getSession(false);
		if (session != null) {
            session.removeAttribute("user");
		  }
		
		 session = request.getSession();
	
	

		
		if(s1==3)
		{
			
		    session.setAttribute("user", user);
	        //Uzytkownik user2 = (Uzytkownik) session.getAttribute("user");

			RequestDispatcher dispatcher = request.getRequestDispatcher("..\\User\\landingPage.jsp");
			dispatcher.forward(request, response);
			//response.sendRedirect("..\\User\\userPanel.jsp");
			
		}
		else if(s1==2)
		{
			
	        session.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("..\\Employee\\landingPage.jsp");
			dispatcher.forward(request, response);

		}
		else if(s1==1)
		{
			
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("../Manager/managerPanel.jsp");
			//dispatcher.forward(request, response);
			
			response.sendRedirect("..\\Manager\\managerPanel.jsp");
		}
		else if(s1==0) 
		{
			//System.out.print("HERE");
			
			String message = "Invalid email/password";
		    request.setAttribute("message", message);
			//RequestDispatcher dispatcher = request.getRequestDispatcher("../index.jsp");
			//response.sendRedirect("..\\Guest\\login.jsp");
			//dispatcher.forward(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher("..\\Guest\\login.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		
	}

}
