package web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.SeansKlientDAO;
import model.Seans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Servlet implementation class SeansKlientServlet
 */
@WebServlet("/Guest/repertuar")
public class SeansGuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeansKlientDAO seansDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeansGuestServlet() {
        super();
        this.seansDAO=new SeansKlientDAO();
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
   				listSeanse(request, response);
   			}
   		catch (SQLException ex) {
   			throw new ServletException(ex);
   		}
   	}

	private void listSeanse(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException{
		List <Seans> listSeanse= seansDAO.selectAllSeanse();
		request.setAttribute("listSeanse", listSeanse);
		RequestDispatcher dispatcher = request.getRequestDispatcher("guestRepertuar.jsp");
		dispatcher.forward(request, response);
	}

}
