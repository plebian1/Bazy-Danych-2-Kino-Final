package web;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.RachunekDAO;
import model.Rachunek;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/Manager/RachunekView")
public class RachunekServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RachunekDAO rachunekDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RachunekServlet() {
    	this.rachunekDAO=new RachunekDAO();
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
			
				listRachunek(request, response);
				
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}
	private void listRachunek(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Rachunek> listRachunek=rachunekDAO.selectAllRachunki();
		request.setAttribute("listRachunek", listRachunek);
		RequestDispatcher dispatcher = request.getRequestDispatcher("przegladRachunkow.jsp");
		dispatcher.forward(request, response);
		
	}
}
