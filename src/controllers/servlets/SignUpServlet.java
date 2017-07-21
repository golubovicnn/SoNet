package controllers.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import soNet.*;
/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Management manage = Management.getInstanz();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		// TODO Auto-generated method stub
		
		String vorname = request.getParameter("vorname");
		String nachname = request.getParameter("nachname");
		String email = request.getParameter("email");
		String geburtstag = request.getParameter("geburtstag");
		String geburtsmonat = request.getParameter("geburtsmonat");
		String geburtsjahr = request.getParameter("geburtsjahr");
		String pass = request.getParameter("passwort");
		String wiederpass = request.getParameter("passwort2");
		String geschlecht = request.getParameter("geschlecht");
		String angemeldetAls = request.getParameter("angemeldetAls");

		//System.out.println("1 doPost");

		String geburtsdatumString = geburtstag + "-" + geburtsmonat + "-" + geburtsjahr;
		
		Person person = null;
		Forscher forscher = null;

		Management manage = new Management();
		
		if (angemeldetAls.equals("person") && pass.equals(wiederpass)) {
			person = new Person(1, vorname, nachname, email, geburtsdatumString, pass, geschlecht, false, false);
			manage.personHinzufugen(person);
		}
		
		else if (angemeldetAls.equals("admin")) {
			person = new Person(1, vorname, nachname, email, geburtsdatumString, pass, geschlecht, true, false);
			manage.personHinzufugen(person);
		}
		else if(angemeldetAls.equals("forscher")) {
			forscher = new Forscher(1, vorname, nachname, email, pass);
			manage.forscherHinzufugen(forscher);
		}
			
		request.setAttribute("person", person);
		request.setAttribute("forscher", forscher);

		request.setAttribute("angemeldetAls", angemeldetAls);

		response.sendRedirect("Anmelden.jsp");
		
	}
}