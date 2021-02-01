package web;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.PracownikDAO;
import model.Pracownik;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/Manager/PracownicyManagement2")
public class PracownikServlet2 extends HttpServlet{
	private static final long serialVersionUID = 1L;
    private PracownikDAO pracownikDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PracownikServlet2() {
    	this.pracownikDAO=new PracownikDAO();
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
		
		
		try
		{
				listPracownik(request, response);
			
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listPracownik(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException{
		List<Pracownik> pracownicy=pracownikDAO.selectAllPracownik();
		//System.out.println(pracownicy.get(0).getEmail());
		request.setAttribute("listPracownik", pracownicy);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pracownicyManagement2.jsp");
		dispatcher.forward(request, response);	
	}
	
	
	
	
}
