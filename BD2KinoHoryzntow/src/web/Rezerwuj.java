package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bilet;
import dao.BiletDAO;
import model.Seans;

/**
 * Servlet implementation class Rezerwuj
 */
@WebServlet("/User/Rezerwuj")
public class Rezerwuj extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BiletDAO biletDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rezerwuj() {
        super();
        biletDAO=new BiletDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String Ids = request.getParameter("Id_seansu");
		int Id = Integer.parseInt(Ids);
		
		List<Bilet> listBilet= biletDAO.selectAllFreeBiletSeans(Id);
		System.out.println(listBilet.size());
		request.setAttribute("listBilet", listBilet);
		RequestDispatcher dispatcher = request.getRequestDispatcher("rezerwacja2.jsp");
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
