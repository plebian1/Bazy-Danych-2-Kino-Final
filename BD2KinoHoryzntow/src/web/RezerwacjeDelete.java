package web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MyDb;

/**
 * Servlet implementation class RezerwacjeDelete
 */
@WebServlet("/User/RezerwacjaDelete")
public class RezerwacjeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RezerwacjeDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id_rezerwacji = request.getParameter("Id_rezerwacji");
		int id_rezerwacjiint = Integer.parseInt(id_rezerwacji); 
		
		Statement stmt ;
		ResultSet rs;
		MyDb db = new MyDb();
		Connection connection = db.getCon();
		

		try {
			stmt =  connection.createStatement();
			stmt.executeUpdate("DELETE FROM rezerwacja WHERE  Id_rezerwacji = '"+id_rezerwacjiint+"'; ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("userRezerwacje");
		dispatcher.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
