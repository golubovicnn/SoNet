package controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import soNet.*;
	
	/**
	 * Die Klasse Authentifikation dient zur
	 * Authentifizierung.
	 * 
	 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
	 *
	 */
	public class Authentifikation {
	
		private static enum Rechte {
			Person, Admin, Forscher
		}
		
		private static Authentifikation instanz;

		/**
		 * Dieser Konstruktor schützt damit die Variable instanz
		 * nicht instanziiert wird.
		 */
		private Authentifikation() {
			
		}
		
		/**
		 * 
		 * @return liefert die Instanzvariable instanz dieser Klasse.
		 */
		public static Authentifikation getInstanz() {
			if (instanz != null) {
				return instanz;
			} else {
				return instanz = new Authentifikation();
			}
		}
		
		/**
		 * Liefert etwas zurück, wenn eine Aktion für
		 * jeweilige Person erlaubt ist.
		 * 
		 * @param request HttpRequest
		 * @param action Aktion welche angefordert wurde.
		 * @return
		 */
		public boolean hatRechte(HttpServletRequest request, String action) {
			
			HttpSession session = request.getSession();
			Object personIDObject = session.getAttribute("personID");
			Person person;
			int personID;
			Management management = Management.getInstanz();
			
			if(personIDObject == null) {
				String email = request.getParameter("email");
				String passwort = request.getParameter("passwort");

				person = management.getPersonByEmail(email);
				
				if(email == null || person == null || passwort == null || !passwort.equals(person.getPasswort())) {
					return false;
				}
				
				else {
					session.setAttribute("personID", person.getPersonID());
				}
			} 
			
			else {
				personID = (int)personIDObject;
				person = management.getPersonByID(personID);
				if (person == null) {
					return false;
				}
			}

			if(person.isGesperrt()||!person.isAdmin()) {
				return false;
			}
			
			Rechte rechte = getDieRechte(action);
			return rechte == Rechte.Person || 
					(rechte == Rechte.Admin && person instanceof Admin);
		
		
		}
		
		/**
		 * 
		 * @param action - Aktion 
		 * @return liefert Rechte für gewünschte Aktion zurück
		 */
		private Rechte getDieRechte(String action) {
			switch (action) {
	
			case "beitragTeilen":
				return Rechte.Person;
			case "abmelden":
				return Rechte.Person;
			case "suchen":
				return Rechte.Person;
			case "nachricht":
				return Rechte.Person;
			case "sperren":
				return Rechte.Admin;
			case "adminStellen":
				return Rechte.Admin;
			default:
				return Rechte.Person;
			}
		}
		
		/**
		 * 
		 * @param request HttpRequest
		 * @return liefert aktuel angemeldete Person
		 */
		public Person getAngemeldetPerson(HttpServletRequest request) {
			
			System.out.println("getAngemeldetPerson");
			HttpSession session = request.getSession();
			Object personID = session.getAttribute("personID");
			//System.out.println((int)personID);
			if(personID != null) {
				System.out.println("persoonID != null");
				return Management.getInstanz().getPersonByID((int)personID);
			}
			System.out.println("persoonID == null");
			return null;
		}

		/**
		 * Meldet Person ab
		 * @param request HttpRequest
		 */
		public void abmelden(HttpServletRequest request) {
			HttpSession session = request.getSession();
			session.removeAttribute("personID");
			session.invalidate();

		}
}