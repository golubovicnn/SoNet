package soNet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Das Interface PersonDAO enthält Methoden die Person, AdministratorIn
 * oder ForscherIn haben.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */

public interface PersonDAO {
	
	//Person
	/**
	 *
	 * @return liefert Liste alles Personen im Netzwerk zurück
	 */
	public ArrayList<Person> getPersonenList();
	
	/**
	 * Methode um eine bestimmte Person nach Vor- oder Nachnamen,
	 * bzw. Text zu suchen
	 * 
	 * @param text - Suchtext nach dem in Liste gesucht wird
	 * @return liefert Liste mit Personen die gesucht wurde
	 */
	ArrayList<Person> getPersonbyName(String text);
	
	/**
	 * Methode um Person im Netzwerk nach ID zu suchen.
	 * 
	 * @param id - ID der Person
	 * @return 
	 */
	public Person getPersonByID(int id);
	
	/**
	 * 
	 * @param personHinzuzufugen
	 * @throws IOException 
	 */
	public void personHinzufugen(Person personHinzuzufugen) throws IOException;
	
	/**
	 * AdministratorIn gibt Admin-Rechte einer Person
	 * 
	 * @param admin AdministratorIn
	 * @param person Person die zur AdministratorIn wird
	 */
	public void adminStellen(Person admin, Person person) throws IOException;

	
	/**
	 * Eine Person entfernt eine andere Person aus ihren Kontakten
	 * 
	 * @param anforderer - Person die Entfernung anfordert
	 * @param freundEntfernen - Person die entfernt wird
	 */
	public void freundEntfernen(Person anforderer, Person freundEntfernen)throws IOException;
	
	/**
	 * Eine Person fügt eine andere Person zur ihren Kontakten
	 * 
	 * @param anforderer - Person die Hinzufügung anfordert
	 * @param freundHinzufuegen - Person die hinzugefügt wird
	 */
	public void freundHinzufuegen(Person anforderer, Person freundHinzufuegen)throws IOException;
	
	//AdministratorIn
	
	/**
	 * AdministratorIn sperrt eine Person
	 * 
	 * @param admin - AdministratorIn
	 * @param person - Person die gesperrt wird
	 * @throws IOException 
	 */
	public void personSperren(Person admin, Person person) throws IOException;
	
	/**
	 * AdministratorIn entsperrt eine gesperrte Person
	 * 
	 * @param admin - AdministratorIn
	 * @param person - gesperrte Person die entsperrt wird
	 */
	public void personEntsperren(Person admin, Person person) throws IOException;
	
	/**
	 * Beitrag wird von AdministratorIn gesperrt bzw. vom Netzwerk entfernt
	 * 
	 * @param beitrag - Beitrag der entfernt wird
	 */
	public void beitragSperren(Beitrag beitrag);
	
	//ForscherIn	
	//statistik
	
	//Beitrag
	
	/**
	 * Liste aller Beiträge wird aktualisiert.
	 * 
	 * @param listZuAktualisieren
	 */
	public void beitragListeZuAktualisieren(ArrayList<Beitrag> listZuAktualisieren);
	
	/**
	 * Liste aller Beiträge des Netzwerks.
	 * @return liefert Liste aller Beiträge im Netzwerk zurück
	 */
	public ArrayList<Beitrag> getAlleBeitraege();
	
	/**
	 * Liste aller Beiträge einer Person.
	 * 
	 * @param person Person die Besitzer der Beiträge ist
	 * @return liefert Liste mit allen Beiträgen der Person
	 */
	public ArrayList<Beitrag> getBeitragList(Person person);
	
	/**
	 * Person teilt einen Beitrag
	 * 
	 * @param person Person
	 * @param beitragZuErstellen
	 */
	public void beitragHinzufugen(Person person, Beitrag beitragZuErstellen);
	
	/**
	 * Mit dieser Methode wird ein Beitrag über die ID gefunden.
	 * 
	 * @param ID
	 * @return liefert Beitrag zurück (falls gefunden)
	 */
	public Beitrag getBeitragbyID(int beitragID);
	
	/**
	 * Person löscht eigenen Beitrag
	 * 
	 * @param besitzer - Person
	 * @param beitragZuLoschen - Beitrag der gelöscht wird
	 */
	public void beitragLoschen(Person besitzer, Beitrag beitragZuLoschen);

	public void forscherHinzufugen(Forscher forscher);

	public ArrayList<Forscher> getForscherList();
	public Forscher getForscherByID(int id);
	public void statistikErstellen(int forscher);

	public ArrayList<Statistik> getStatistikList();
	
	public ArrayList<Nachricht> getNachrichtList();

	public ArrayList<Nachricht> konversationFinden(int id1, int id2);

	public void nachrichtHinzufugen(int personID, int personID2, String nachricht) throws IOException;


	public void kommentieren(int beitragZuKommentID, String kommentar);

	
	//kommentar	
	//konversation
	//nachricht

	}