package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.RezerwacjaDAO;
import model.Rezerwacja;

/**
 * Servlet implementation class rezerwacjaAproveServlet
 */
@WebServlet("/Employee/rezerwacjaAprove")
public class rezerwacjaAproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RezerwacjaDAO rezerwacjaDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rezerwacjaAproveServlet() {
        super();
        rezerwacjaDAO=new RezerwacjaDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Ids = request.getParameter("Id_seansu");
		int Id = Integer.parseInt(Ids);
		
		List<Rezerwacja> listRezerwacja= rezerwacjaDAO.selectAllRezerwacjaSeans(Id);
		request.setAttribute("listRezerwacja", listRezerwacja);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rezerwacjaAprove.jsp");
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
