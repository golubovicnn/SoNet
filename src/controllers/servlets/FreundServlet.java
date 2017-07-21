package controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soNet.Management;

/**
 * Servlet implementation class FreundServlet
 */
@WebServlet("/FreundServlet")
public class FreundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FreundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Management manage = new Management();
		
		String friendID = request.getParameter("friendID");
		int angemeldetePersonID = (int) session.getAttribute("personID");
		int freundID = Integer.parseInt(friendID);
		
		manage.freundEntfernen(manage.getPersonByID(angemeldetePersonID), manage.getPersonByID(freundID));
		response.sendRedirect("Pinnwand.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Management manage = new Management();
		
		int besitzerID = (int) session.getAttribute("besitzerID");
		int angemeldetePersonID = (int) session.getAttribute("personID");
		
		if(!manage.getPersonByID(besitzerID).isGesperrt()) {
			System.out.println("doPost");
			manage.freundHinzufuegen(manage.getPersonByID(angemeldetePersonID), manage.getPersonByID(besitzerID));
		}
		response.sendRedirect("FremdPinnwand.jsp");
	}

}
