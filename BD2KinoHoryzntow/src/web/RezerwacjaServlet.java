package web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.RezerwacjaDAO;
import model.Rezerwacja;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class RezerwacjaServlet
 */
@WebServlet("/Manager/rezerwacjeManagement")
public class RezerwacjaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RezerwacjaDAO rezerwacjaDAO;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezerwacjaServlet() {
        super();
        this.rezerwacjaDAO=new RezerwacjaDAO();
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
   		request.setCharacterEncoding("UTF-8");
   		String action = request.getServletPath();
   		
   		try {
   				listRezerwacje(request, response);
   			}
   		catch (SQLException ex) {
   			throw new ServletException(ex);
   		}
   	}

	private void listRezerwacje(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException{
		List <Rezerwacja> listRezerwacje= rezerwacjaDAO.selectAllRezerwacja();
		request.setAttribute("listRezerwacje", listRezerwacje);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rezerwacjeManagement.jsp");
		dispatcher.forward(request, response);
	}

}
