package controllers.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import soNet.Forscher;
import soNet.Management;
import soNet.Person;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        Management manage =new Management();
        Person person = (Person) request.getAttribute("person");
        Forscher forscher = (Forscher) request.getAttribute("forscher");
        /*if(email.equals("admin") && password.equals("admin"))
        {
            response.sendRedirect("Pinnwand.jsp");
        }
        else response.sendRedirect("Anmelden.jsp");*/
 
	        if(manage.anmeldenUberprufenPerson(email, password) == true) {
		            HttpSession session = request.getSession();
		            session.setAttribute("person", manage.getPersonByEmail(email));
		            if(!manage.getPersonByEmail(email).isGesperrt())
		            	response.sendRedirect("Pinnwand.jsp");
		            else
		            	response.sendRedirect("FailAnmelden.jsp");
	        	
	        }
 
	        else if(manage.anmeldenUberprufenForscher(email, password) == true) {
        		
        			HttpSession session = request.getSession();
        			session.setAttribute("forscher", manage.getForscherByEmail(email));
        			response.sendRedirect("ForscherPinnwand.jsp");
        	}
        	else response.sendRedirect("FailAnmelden.jsp");	
	}

}
