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
 * Servlet implementation class Beitrag2Servlet
 */
@WebServlet("/Beitrag2Servlet")
public class Beitrag2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Management manage = new Management();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Beitrag2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int besitzerID = (int) session.getAttribute("besitzerID");
		String zwischen = request.getParameter("idBeitrag");
		String kommentar= request.getParameter("kommentar");
		
		if(zwischen==null) {
			//System.out.println("beitragZuLikenID==null");
			response.sendRedirect("Pinnwand.jsp");
		}
		else {
			int beitragZuKommentID = Integer.parseInt(zwischen);		
			if(manage.getBeitragbyID(beitragZuKommentID) == null)
				System.out.println("manage.getBeitragbyID(beitragZuLikeID) == null");

			else
				manage.kommentieren(beitragZuKommentID, kommentar);
	        response.sendRedirect("Pinnwand.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int besitzerID = (int) session.getAttribute("besitzerID");

		String zwischen = request.getParameter("idBeitrag");
		
		if(zwischen==null) {
			//System.out.println("beitragZuLikenID==null");
			response.sendRedirect("Pinnwand.jsp");
		}
		else {
			int beitragZuLikeID = Integer.parseInt(zwischen);		
			if(manage.getBeitragbyID(beitragZuLikeID) != null)
				manage.like(besitzerID, beitragZuLikeID);
	        response.sendRedirect("Pinnwand.jsp");

				

		}
	}
}
