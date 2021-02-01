package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BiletDAO;

/**
 * Servlet implementation class saleZatwierdz
 */
@WebServlet("/Employee/saleZatwierdz")
public class saleZatwierdz extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BiletDAO biletDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saleZatwierdz() {
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
		System.out.println(Id);
		biletDAO.sellTicket(Id);;
		RequestDispatcher dispatcher = request.getRequestDispatcher("..\\Employee\\landingPage.jsp");
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
