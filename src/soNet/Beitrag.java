package soNet;

import java.util.ArrayList;
import java.io.Serializable;

/**
 * Die Klasse Beitrag definiert Instanzvariablen für ein Beitrag, d.h. 
 * sie representiert Beiträge die eine Person teilt.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */

@SuppressWarnings("serial")
public class Beitrag implements Serializable {
	
	
	private int beitragID;
	private String inhalt;
	private int geffaltMirAngaben;
	ArrayList<String> kommentare;
	private int besitzerID;
	ArrayList<Integer> personLikedID;
	
	/**
	 * Der Konstruktor speichert Werte der Instanzvariablen eines Beitrags
	 * (beitragID, inhalt, besitzerID). Die anderen Instanzvariablen haben
	 * für den Anfang den Default Wert. 
	 * 
	 * @param beitragID - ID des Beitrags
	 * @param inhalt - Inhalt des Beitrags
	 * @param besitzerID - ID der Person die den Beitrag besitzt bzw.teilt
	 */
	
	public Beitrag(int beitragID, String inhalt, int besitzerID) {
		super();
		this.beitragID = beitragID;
		this.besitzerID = besitzerID;
		this.inhalt = inhalt;
		
		this.geffaltMirAngaben = 0;
		this.kommentare = new ArrayList<String>();
		this.personLikedID = new ArrayList<Integer>();
	}
	
	/**
	 * Get und Set Methoden für jeweilige Instanzvariablen der Klasse Beitrag
	 * @return liefert den Wert der jeweiligen Instanzvariable zurück
	 */
	public int getBeitragID() {
		return beitragID;
	}


	public void setBeitragID(int beitragID) {
		this.beitragID = beitragID;
	}


	public String getInhalt() {
		return inhalt;
	}


	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}


	public int getGeffaltMirAngaben() {
		return geffaltMirAngaben;
	}


	public void setGeffaltMirAngaben(int geffaltMirAngaben) {
		this.geffaltMirAngaben = geffaltMirAngaben;
	}


	public ArrayList<String> getKommentare() {
		return kommentare;
	}


	public void setKommentare(ArrayList<String> kommentare) {
		this.kommentare = kommentare;
	}


	public int getBesitzerID() {
		return besitzerID;
	}


	public void setBesitzerID(int besitzerID) {
		this.besitzerID = besitzerID;
	}


	public ArrayList<Integer> getPersonLikedID() {
		return personLikedID;
	}


	public void setPersonLikedID(ArrayList<Integer> personLikedID) {
		this.personLikedID = personLikedID;
	}
	
	/**
	 * 
	 * Es wird überprüft ob der Beitrag mit Gefällt mir schon markiert wurde.
	 * Falls nicht, wird die Anzahl der Gefällt mir Angaben erhöht.
	 * Falls ja, wird eine Benachrichtigung, dass der Beitrag schon markiert
	 * wurde, angezeigt.
	 * 
	 * @param personLiked - Person die einen Beitrag mit Gefällt mir markiert
	 * @param beitragID 
	 */

	public void like(int personLiked, int beitragID){
		geffaltMirAngaben++;
	}
	
	@Override
	public String toString(){
		return "\n" + beitragID + " BeitragID\n" + inhalt + "\n geffaltMirAngaben: " + geffaltMirAngaben + "\nKommentare: " + kommentare + "\n";
	}

	
}















