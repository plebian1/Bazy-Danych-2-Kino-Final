package web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SeansManagerDAO;
import dao.FilmDAO;
import model.Film;

/**
 * Servlet implementation class SeansInsert
 */
@WebServlet("/Manager/SeansInsert")
public class SeansInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SeansInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		
		String godzina = request.getParameter("godzina");
		String data = request.getParameter("data");
		String id_filmu = request.getParameter("filmTitle");
		String id_sali = request.getParameter("saleList");
		String napisy = request.getParameter("napisy");		
		String jezyk = request.getParameter("jezyk");
		String id_pracownika = request.getParameter("opiekunName");
		String dlugosc = request.getParameter("duration");

		
		int  napisybool = 1;
		int filmint,pracownikint,salaint;
		
		if(napisy.equals("tak") )
		{
			napisybool = 1;
		}
		else 
		{
			napisybool = 0;
		}
		
		filmint  = Integer.parseInt(id_filmu); 
		pracownikint = Integer.parseInt(id_pracownika); 
		salaint = Integer.parseInt(id_sali); 
		
		
		
		
		
		
		SeansManagerDAO seans = new SeansManagerDAO();
		try {
			seans.insertSeans(godzina, data, filmint,salaint,napisybool,jezyk,pracownikint,dlugosc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("seansManagement");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
