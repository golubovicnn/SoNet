package controllers.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.Authentifikation;
import soNet.Management;
import soNet.Person;

/**
 * Servlet implementation class PinnwandServlet
 */
@WebServlet("/PinnwandServlet")
public class PinnwandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	Management manage = Management.getInstanz();
	Person currentUser = null;
	Person differentUser = null;
	int beitragID=0;
	int geffaltMirAngaben;
	HttpSession session;
	
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PinnwandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Authentifikation c = Authentifikation.getInstanz();
		currentUser = c.getAngemeldetPerson(request);
		
		session = request.getSession(true);

		int besitzerID = currentUser.getPersonID();

		Person besitzer = manage.getPersonByID(besitzerID);
		if (besitzer == null)
			throw new IllegalArgumentException("Person gibts nicht.");
	
		
		request.setAttribute("besitzer", besitzer);
		
		String url = "Pinnwand.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request,response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		Authentifikation c = Authentifikation.getInstanz();
		currentUser = c.getAngemeldetPerson(request);
		
		session = request.getSession(true);

		int besitzerID = currentUser.getPersonID();
		
		
	}

}
