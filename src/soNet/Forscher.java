package soNet;

import java.io.Serializable;

/**
 * Die Klasse Forscher definiert Instanzvariablen für den/die ForscherIn.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */
@SuppressWarnings("serial")
public class Forscher implements Serializable {
	
	private int forscherID;
	private String vorname;
	private String nachname;
	private String email;
	private String passwort;
	
	/**
	 * Der Konstruktor Forscher  weist folgende als Parameter
	 * mitgegebene Variablen den Instanzvariablen zu. 
	 * 
	 * @param forscherID - ID des/der FroscherIn
	 * @param vorname - Vorname des/der ForscherIn 
	 * @param nachname - Nachname des/der ForscherIn
	 * @param email - E-Mail des/der ForscherIn
	 * @param passwort - Passwort für Anmeldung ins soziale Netzwerk
	 */
	public Forscher(int forscherID, String vorname, String nachname, String email, String passwort) {
		this.forscherID = forscherID;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.passwort = passwort;
	}
	
	/**
	 * Get und Set Methoden für jeweilige Instanzvariablen
	 * @return liefert Wert der jeweiligen Instanzvariable zurück
	 */
	
	
	public int getForscherID() {
		return forscherID;
	}

	public void setForscherID(int forscherID) {
		this.forscherID = forscherID;
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

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@Override
	public String toString() {
		return "Forscher [ForscherID=" + forscherID + ", Vorname=" + vorname + ", Nachname=" + nachname + ", Email="
				+ email + ", Passwort=" + passwort + "]";
	}
}