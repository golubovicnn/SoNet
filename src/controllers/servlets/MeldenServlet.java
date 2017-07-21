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
 * Servlet implementation class MeldenServlet
 */
@WebServlet("/MeldenServlet")
public class MeldenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MeldenServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Management manage = new Management();
		HttpSession session = request.getSession();
		int	angemeldetePerson = (int) session.getAttribute("personID");
		int besitzer = (int) session.getAttribute("besitzerID");
		
		
		if(manage.getPersonByID(angemeldetePerson).isAdmin()) {
			manage.personSperren(manage.getPersonByID(angemeldetePerson), manage.getPersonByID(besitzer));
		}	
			response.sendRedirect("FremdPinnwand.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Management manage = new Management();
		HttpSession session = request.getSession();
		int	angemeldetePerson = (int) session.getAttribute("personID");
		int besitzer = (int) session.getAttribute("besitzerID");
		
		
		if(manage.getPersonByID(angemeldetePerson).isAdmin()) {
			manage.personEntsperren(manage.getPersonByID(angemeldetePerson), manage.getPersonByID(besitzer));
		}	

			response.sendRedirect("FremdPinnwand.jsp");
	}

}
