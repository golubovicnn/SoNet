package controllers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soNet.Management;
import soNet.Person;

/**
 * Servlet implementation class PersonSuchenServlet
 */
@WebServlet("/PersonSuchenServlet")
public class PersonSuchenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Management manage = new Management();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonSuchenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String personID = request.getParameter("idPerson");
		
		if(personID==null) {
			response.sendRedirect("PublicPinnwand.jsp");
		}
		else {
			int gefundenID = Integer.parseInt(personID);		
			if(manage.getPersonByID(gefundenID) == null)
				response.sendRedirect("PublicPinnwand.jsp");

			else
				session.setAttribute("person2", manage.getPersonByID(gefundenID));
				response.sendRedirect("FremdPinnwand.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String suchen = request.getParameter("suchen");
		ArrayList<Person> ergebnis = manage.personSuchen(suchen);
		session.setAttribute("ergebnisListe", ergebnis);
		response.sendRedirect("PersonSuchenErgebnis.jsp");
		
	}

}
