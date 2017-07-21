package soNet;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Die Klasse Person definiert Instanzvariablen der Objekte und deren
 * Methoden.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */

@SuppressWarnings("serial")
public class Person implements Serializable {
	
	private int personID;
	private String vorname;
	private String nachname;
	private String email;
	private String geburtsdatum;
	private String passwort;
	private String geschlecht;
	private boolean admin;
	private boolean gesperrt;
	private ArrayList<Person> freundlist = new ArrayList<Person>();

	/**
	 * Dieser Konstruktor der Klasse Person weist folgende als Parameter
	 * mitgegebene Variablen den Instanzvariablen zu.
	 * 
	 * @param vorname - Vorname der Person
	 * @param nachname - Nachname der Person
	 * @param email - E-Mail der Person
	 * @param geburtsdatum - Geburtsdatum der Person
	 * @param passwort - Passwort für Anmeldung ins soziale Netzwerk
	 * @param geschlecht - Geschlecht der Person
	 * @param admin - Wert der zeigt ob die Person AdministratorIn ist
	 * @param gesperrt - Wert der zeigt ob Person gesperrt ist
	 */
	
	public Person(int personID, String vorname, String nachname, String email, String geburtsdatum, String passwort, String geschlecht, boolean admin, boolean gesperrt) {
		this.personID = personID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.geburtsdatum = geburtsdatum;
		this.passwort = passwort;
		this.geschlecht = geschlecht;
		this.admin = admin;
		this.gesperrt = gesperrt;
	}
	
	/**
	 * Get und Set Methoden für jeweilige Instanzvariablen.
	 * @return liefert Wert der jeweiligen Instanzvariable zurück
	 */
	
	public int getPersonID() {
		return personID;
	}


	public void setPersonID(int personID) {
		this.personID = personID;
	}



	public String getVorname() {
		return vorname;
	}



	public void setVorname(String vorname) {
		this.vorname = vorname;
	}



	public String getNachname() {
		return nachname;
	}



	public void setNachname(String nachname) {
		this.nachname = nachname;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getGeburtsdatum() {
		return geburtsdatum;
	}



	public void setGeburtsdatum(String geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}



	public String getPasswort() {
		return passwort;
	}



	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}



	public String getGeschlecht() {
		return geschlecht;
	}



	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}



	public boolean isAdmin() {
		return admin;
	}



	public void setAdmin(boolean admin) {
		this.admin = admin;
	}



	public boolean isGesperrt() {
		return gesperrt;
	}



	public void setGesperrt(boolean gesperrt) {
		this.gesperrt = gesperrt;
	}



	public ArrayList<Person> getFreundlist() {
		return freundlist;
	}



	public void setFreundlist(ArrayList<Person> freundlist) {
		this.freundlist = freundlist;
	}

	@Override
	public String toString() {
		return "\nPerson\n[UserID=" + getPersonID() + "\nVorname=" + vorname + "\nNachname=" + nachname + "\nEmail=" + email
				+ "\nGeburtsdatum=" + geburtsdatum + "\nPasswort=" + passwort + "\nGeschlecht=" + geschlecht
				+ "\nAdmin=" + admin + "\nGesperrt=" + gesperrt + "]\n";
	}
	
	
}