package soNet;

import java.io.Serializable;

/**
 * Die Klasse Admin ist eine Unterklasse der Klasse Person, d.h.
 * sie erbt die Instanzvariablen und Methoden ihrer Oberklasse.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */

@SuppressWarnings("serial")
public class Admin extends Person implements Serializable {

	/**
	 * Der Konstruktor Admin gibt Werte an den Konstruktor der Oberklasse Person weiter.
	 * 
	* @param vorname - Vorname der Person
	 * @param nachname - Nachname der Person
	 * @param email - E-Mail der Person
	 * @param geburtsdatum - Geburtsdatum der Person
	 * @param passwort - Passwort für Anmeldung ins soziale Netzwerk
	 * @param geschlecht - Geschlecht der Person
	 * @param admin - Wert der zeigt ob die Person AdministratorIn ist
	 * @param gesperrt - Wert der zeigt ob Person gesperrt ist
	 * @param freundlist - Liste aller anderen Personen mit welchen eine Person
	 * befreundet ist
	 */

	public Admin(int adminid, String vorname, String nachname, String email, String geburtsdatum, String passwort, String geschlecht, boolean admin, boolean gesperrt) {
		super(adminid, vorname, nachname, email, geburtsdatum, passwort, geschlecht, admin, gesperrt);
		
	}

}