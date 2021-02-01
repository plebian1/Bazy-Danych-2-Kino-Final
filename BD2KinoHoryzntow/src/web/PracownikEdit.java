package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pracownik;
import dao.PracownikDAO;

/**
 * Servlet implementation class PracownikEdit
 */
@WebServlet("/Manager/PracownikEdit")
public class PracownikEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PracownikDAO pracownikDAO = new PracownikDAO();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PracownikEdit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Ids = request.getParameter("Id_pracownika");
		int Id = Integer.parseInt(Ids);  
		

		Pracownik pracownik = new Pracownik();
		pracownik = pracownikDAO.getPracownik(Id);
		
	
		request.setAttribute("pracownik", pracownik);
		RequestDispatcher dispatcher = request.getRequestDispatcher("pracownicyManagementModify.jsp");
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
