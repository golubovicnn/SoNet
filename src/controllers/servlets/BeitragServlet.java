package controllers.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soNet.Beitrag;
import soNet.Management;
import soNet.Person;

/**
 * Servlet implementation class BeitragServlet
 */
@WebServlet("/BeitragServlet")
public class BeitragServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Person currentUser = null;
	Management manage = new Management();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeitragServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();
		int besitzerID = (int) session.getAttribute("besitzerID");
		int personID= (int) session.getAttribute("personID");
		
		String beitragZuLoschenID = request.getParameter("idBeitrag");
			if(beitragZuLoschenID==null) {
				
				System.out.println("beitragZuLoschenID==null");
				response.sendRedirect("Pinnwand.jsp");
			}
			else {
				
				int beitragZuEntfernenID = Integer.parseInt(beitragZuLoschenID);
				if(manage.getPersonByID(personID).isAdmin() || personID == manage.getBeitragbyID(beitragZuEntfernenID).getBesitzerID()) {
					if(manage.getBeitragbyID(beitragZuEntfernenID) != null)
						manage.beitragEntfernen(manage.getPersonByID(besitzerID), manage.getBeitragbyID(beitragZuEntfernenID));
				}
					response.sendRedirect("Pinnwand.jsp");

				
			}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session = request.getSession();
		
		String post = request.getParameter("post");
		int besitzerID = (int) session.getAttribute("personID");
		
		//Beitrag beitrag = new Beitrag (1, post, besitzerID);
		manage.beitragHinzufugen(manage.getPersonByID(besitzerID), post);
		
        response.sendRedirect("PublicPinnwand.jsp");

	}

}
