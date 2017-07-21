package controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import soNet.Management;
import soNet.Person;

/**
 * Servlet implementation class NachrichtServlet
 */
@WebServlet("/NachrichtServlet")
public class NachrichtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NachrichtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Nachricht.jsp");
		
		/*HttpSession session = request.getSession();
		Person angemeldetePerson = (Person)session.getAttribute("person");
		Person besitzer = (Person)session.getAttribute("person2");
		Management manage = new Management();
		
		manage.getNachrichtList(angemeldetePerson.getPersonID(), besitzer.getPersonID());*/
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Person angemeldetePerson = (Person)session.getAttribute("person");
		Person besitzer = (Person)session.getAttribute("person2");
		Management manage = new Management();
		
		String nachricht = request.getParameter("nachricht");

		manage.nachrichtHinzufugen(angemeldetePerson.getPersonID(), besitzer.getPersonID(), nachricht);
		response.sendRedirect("Nachricht.jsp");

	}

}
