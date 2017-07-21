package soNet;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Die Klasse Management repräsentiert die ganze Logik des sozialen Netzwerks.
 * Es definiert eine Instanzvariable von Typ PersonDAO damit es alle Funktionen
 * von PersonDAO aufrufen kann.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */
public class Management {
	
	/**
	 * personDAO ist eine Varible von PersonDAO mit welcher auf
	 * Funktionen in PersonDAO zugegrifen wird.
	 */
	private PersonDAO personDAO;
	
	/**
	 * Das ist der Konstruktor welcher serializedDAO einbringt
	 */
	public Management(){
		//System.out.println(" 2 konst manage");

		personDAO = new SerializedDAO();
	}
	
	/**
	 * instanz ist eine Instanzvariable der Klasse Management.
	 * Die Methode getInstanz liefert den Wert dieser Variable
	 * zurück.
	 */
	private static Management instanz = null;
	
	
	public static Management getInstanz() {
		if(instanz != null)
			return instanz;
		else
			return instanz = new Management();
	}

	
	public ArrayList<Person> getPersonenList(){
		return personDAO.getPersonenList();
	}
	
	public Person getPersonByID(int personID){
		return personDAO.getPersonByID(personID);
	}
	
	/**
	 * Findet Person über die E-Mail.
	 * @param email - eingegebene E-Mail
	 * @return liefert Person zurück zur welcher die E-Mail gehört
	 */
	public Person getPersonByEmail(String email){
		
		for(Person person : getPersonenList()) {
			if(person.getEmail().equals(email))
				return person;
		}
		return null;
	}
	
	public void personHinzufugen(Person personHinzuzufugen) throws IOException{
		//System.out.println(" 7 management");
		personDAO.personHinzufugen(personHinzuzufugen);
	}
	
	public ArrayList<Person> personSuchen(String text){
		return personDAO.getPersonbyName(text);
	}
	
	public void personSperren(Person admin, Person person) throws IOException {
		personDAO.personSperren(admin, person);
	}

	public void personEntsperren(Person admin, Person person) throws IOException {
		personDAO.personEntsperren(admin, person);
	}
	public void adminStellen(Person admin, Person user) throws IOException {
		personDAO.adminStellen(admin, user);	
	}
	public void freundHinzufuegen(Person anforderer, Person freundHinzufuegen) throws IOException {
		personDAO.freundHinzufuegen(anforderer, freundHinzufuegen);
	}
	
	public void freundEntfernen(Person anforderer, Person freundEntfernen) throws IOException {
		personDAO.freundEntfernen(anforderer, freundEntfernen);
	}
	public Forscher getForscherByID(int id) {
		return personDAO.getForscherByID(id);
	}
	public ArrayList<Beitrag> getAlleBeitraege() {
		return personDAO.getAlleBeitraege();
	}
	public ArrayList<Beitrag> getBeitragList(Person person){
		return personDAO.getBeitragList(person);
	}
	
	public Beitrag getBeitragbyID(int beitragID){
		return personDAO.getBeitragbyID(beitragID);
	}
	
	public void beitragHinzufugen(Person person, String inhalt) {
		
		ArrayList<Beitrag> beitraege = personDAO.getAlleBeitraege();
		if(beitraege.size() > 0) {
			int neuBeitragID = beitraege.size() + 1;
			Beitrag neuerBeitrag = new Beitrag (neuBeitragID, inhalt, person.getPersonID());
			personDAO.beitragHinzufugen(person, neuerBeitrag);
			}
		else {
			int neuBeitragID = 1;
			Beitrag neuerBeitrag = new Beitrag (neuBeitragID, inhalt, person.getPersonID());
			personDAO.beitragHinzufugen(person, neuerBeitrag);
		}
	}
	
	
	public void beitragEntfernen(Person besitzer, Beitrag beitragZuEntfernen){
		personDAO.beitragLoschen(besitzer, beitragZuEntfernen);
	}
	
	/**
	 * Eine Person markiert einen Beitrag eine anderen Person
	 * mit Gefällt mir.
	 * 
	 */
	public void like(int personID, int beitragID) {
		
		ArrayList<Beitrag> alleBeitrage = personDAO.getAlleBeitraege();
		for(Beitrag beitrag : alleBeitrage) {
			if(beitrag.getBeitragID() == beitragID) {
				beitrag.like(personID, beitragID);
				break;
			}
		}
		personDAO.beitragListeZuAktualisieren(alleBeitrage);
	}

	public boolean anmeldenUberprufenPerson(String email, String password) {
		
		ArrayList<Person> personenListe = getPersonenList();
		boolean check = false;
		for (Person person : personenListe) {
			if(person.getEmail().equals(email) && person.getPasswort().equals(password)){
				check = true;
			}
		}
		return check;
	}
	
public boolean anmeldenUberprufenForscher(String email, String password) {
		
		ArrayList<Forscher> forscherListe = getForscherList();
		boolean check = false;
		for (Forscher forscher : forscherListe) {
			if(forscher.getEmail().equals(email) && forscher.getPasswort().equals(password)){
				check = true;
			}
		}
		return check;
	}


	public void kommentieren(int beitragZuKommentID, String kommentar) {
		ArrayList<Beitrag> alleBeitrage = personDAO.getAlleBeitraege();
		for(Beitrag beitrag : alleBeitrage) {
			if(beitrag.getBeitragID() == beitragZuKommentID) {
				personDAO.kommentieren(beitragZuKommentID, kommentar);
				break;
			}
		}
		personDAO.beitragListeZuAktualisieren(alleBeitrage);
	}


	public void forscherHinzufugen(Forscher forscher) {
		personDAO.forscherHinzufugen(forscher);
		
	}


	public Forscher getForscherByEmail(String email) {
		for(Forscher forscher : getForscherList()) {
			if(forscher.getEmail().equals(email))
				return forscher;
		}
		return null;
	}
	
	public ArrayList<Forscher> getForscherList(){
		return personDAO.getForscherList();
	}

	public ArrayList<Statistik> getStatistikList(){
		return personDAO.getStatistikList();
	}
	public void statistikErstellen(int forscherID) {
		personDAO.statistikErstellen(forscherID);
	}
	
	public ArrayList<Nachricht> getNachrichtList(){
		return personDAO.getNachrichtList();
	}
	
	public ArrayList<Nachricht> konversationFinden(int id1, int id2) {
		return personDAO.konversationFinden(id1,id2);
	}


	public void nachrichtHinzufugen(int personID, int personID2, String nachricht) throws IOException {
		personDAO.nachrichtHinzufugen(personID,personID2, nachricht);
		
	}
	
	
}








