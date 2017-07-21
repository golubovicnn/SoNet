package soNet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

/**
 * Die Klasse serializedDAO implementiert das Interface PersonDAO und beschreibt
 * dessen Methoden.
 * 
 * @author Golubovic Nikola, Milic Boris, Mirkovic Sara, Salkic Amela
 *
 */

public class SerializedDAO implements PersonDAO {

	/**
	 * Das sind die Instanzvariablen der Klasse serializedDAO.
	 * @param personenList - Liste aller Personen im Netzwerk
	 * @param pfadPersonList - Pfad zum File wo Personen gespeichert werden
	 * @param dateiPerson - Datei in welche Personen gespeichert werden
	 * @param pfadBeitragList - Pfad zum File wo Beiträge gespeichert werden
	 * @param dateiBeitrag - Datei in welche Beiträge gespeichert wird 
	 */
	private ArrayList<Person> personenList;
	String pfadPersonList;
	File dateiPerson;
	
	private ArrayList<Forscher> forscherList;
	String pfadForscherList;
	File dateiForscher;
	
	private ArrayList<Beitrag> beitragList;
	String pfadBeitragList;
	File dateiBeitrag;
	
	private ArrayList<Statistik> statistikList;
	String pfadStatistikList;
	File dateiStatistik;
	
	private ArrayList<Nachricht> nachrichtList;
	String pfadNachrichtList;
	File dateiNachricht;
	/**
	 * Der Konstruktor der Klasse.
	 */
	public SerializedDAO() {

		personenList = new ArrayList<Person>();
		pfadPersonList = "Person";
		dateiPerson = new File(pfadPersonList);
		
		forscherList = new ArrayList<Forscher>();
		pfadForscherList = "Forscher";
		dateiForscher = new File(pfadForscherList);
		
		beitragList = new ArrayList<Beitrag>();
		pfadBeitragList = "Beitrag";
		dateiBeitrag = new File(pfadBeitragList);
		
		statistikList = new ArrayList<Statistik>();
		pfadStatistikList = "Statistik";
		dateiStatistik = new File(pfadStatistikList);
		
		nachrichtList = new ArrayList<Nachricht>();
		pfadNachrichtList = "Nachricht";
		dateiNachricht = new File(pfadNachrichtList);
		
		personfileErstellen(pfadPersonList);
		forscherfileErstellen(pfadForscherList);
		beitragfileErstellen(pfadBeitragList);
		statistikfileErstellen(pfadStatistikList);
		nachrichtfileErstellen(pfadNachrichtList);

	}
	
	
	@SuppressWarnings("unchecked")
	private void nachrichtfileErstellen(String pfadNachrichtList2) {
		
		ArrayList<Nachricht> nachrichtListe = getNachrichtList();
		
		File dateiNachricht = new File(pfadNachrichtList2);
		if (!dateiNachricht.isFile()) {
			try {

				FileOutputStream fos = new FileOutputStream(pfadNachrichtList2);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(nachrichtListe);
				oos.flush();
				
				fos.close();
				oos.close();
				
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		} else {

			try {
				FileInputStream fis=new FileInputStream(pfadNachrichtList2);
				ObjectInputStream ois=new ObjectInputStream(fis);
				
				nachrichtListe = (ArrayList<Nachricht>) ois.readObject();
				
				fis.close();
				ois.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}			
	}

	
	@SuppressWarnings("unchecked")
	private void statistikfileErstellen(String pfadStatistikList2) {
		
		ArrayList<Statistik> statistikListe = getStatistikList();
		
		File dateiStatistik = new File(pfadStatistikList2);
		if (!dateiStatistik.isFile()) {
			try {

				FileOutputStream fos = new FileOutputStream(pfadStatistikList2);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(statistikListe);
				oos.flush();
				
				fos.close();
				oos.close();
				
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		} else {

			try {
				FileInputStream fis=new FileInputStream(pfadStatistikList2);
				ObjectInputStream ois=new ObjectInputStream(fis);
				
				statistikListe = (ArrayList<Statistik>) ois.readObject();
				
				fis.close();
				ois.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}			
	}


	


	@SuppressWarnings("unchecked")
	private void forscherfileErstellen(String pfadForscherList2) {
			
		ArrayList<Forscher> forscherListe = getForscherList();
		
		File dateiForscher = new File(pfadForscherList2);
		if (!dateiForscher.isFile()) {
			try {

				FileOutputStream fos = new FileOutputStream(pfadForscherList2);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(forscherListe);
				oos.flush();
				
				fos.close();
				oos.close();
				
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		} else {

			try {
				FileInputStream fis=new FileInputStream(pfadForscherList2);
				ObjectInputStream ois=new ObjectInputStream(fis);
				
				forscherListe = (ArrayList<Forscher>) ois.readObject();
				
				fis.close();
				ois.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}		
	}


	@SuppressWarnings("unchecked")
	private void beitragfileErstellen(String path) {
        ArrayList<Beitrag> beitragListe = getAlleBeitraege();
		
		if (!dateiBeitrag.isFile()) {
			try {

				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(beitragListe);
				oos.flush();
				
				fos.close();
				oos.close();
				
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		}
		
		else {

			try {
				FileInputStream fis=new FileInputStream(path);
				ObjectInputStream ois=new ObjectInputStream(fis);
				
				beitragListe = (ArrayList<Beitrag>) ois.readObject();
				
				fis.close();
				ois.close();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}


	@SuppressWarnings("unchecked")
	public void personfileErstellen(String path) {

		ArrayList<Person> personenListe = getPersonenList();
		
		File dateiPerson = new File(path);
		if (!dateiPerson.isFile()) {
			try {

				FileOutputStream fos = new FileOutputStream(path);
				ObjectOutputStream oos = new ObjectOutputStream(fos);

				oos.writeObject(personenListe);
				oos.flush();
				
				fos.close();
				oos.close();
				
			} 
			catch (Exception e) {
				System.out.println(e);
			}
		} else {

			try {
				FileInputStream fis=new FileInputStream(path);
				ObjectInputStream ois=new ObjectInputStream(fis);
				
				personenListe = (ArrayList<Person>) ois.readObject();
				
				fis.close();
				ois.close();
			} catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
	
	
	
	/**
	 * 
	 * @param listeZuAktualisieren Liste die übergeben wird
	 * @throws IOException 
	 */
	public void personenListAktualisieren(ArrayList<Person> listeZuAktualisieren) throws IOException {

		FileOutputStream fos = new FileOutputStream(pfadPersonList);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(listeZuAktualisieren);
		oos.flush();
		
		fos.close();
		oos.close();
		
	}
	
	/**
	 * Ruft Methode zur Aktualisierung der Liste auf
	 * @throws IOException 
	 */
	public void aktualisieren() throws IOException {
		personenListAktualisieren(personenList);
	}
	
	/**
	 * @return liefert Liste mit allen Personen zurück
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Person> getPersonenList() {
		try {
			InputStream inp=new FileInputStream(pfadPersonList);
			try {
				ObjectInputStream oinp=new ObjectInputStream(inp);
				try {
					personenList=(ArrayList<Person>)oinp.readObject();
					inp.close();			
				
				}
				
				catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		    }
			
			catch (IOException e) {
			e.printStackTrace();
		    }
	    }
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
		
		return personenList;
	}


	public void setPersonenList(ArrayList<Person> personenList) {
		this.personenList = personenList;
	}

	/**
	 * Liefert Liste mit gesuchten Personen (nach Namen)
	 */
	@Override
	public ArrayList<Person> getPersonbyName(String text) {
		
		String[] input = text.split(" ");
		System.out.println("input=" + input);
		ArrayList<Person> personenList = getPersonenList();
		int loop = input.length;
		System.out.println(loop);
		ArrayList<Person> ergebnis = new ArrayList<Person>();
		
		for(Person person : personenList) {
			
			for(int count=0; count<loop; count++) {
				
				if(input[count].toLowerCase().equals(person.getVorname().toLowerCase()) ||
						input[count].toLowerCase().equals(person.getNachname().toLowerCase())) {
					
//					if(anforderer.getPersonID()!=person.getPersonID()) {
						ergebnis.add(person);
					
					break;
				}
			}
		}
		
		return ergebnis;
	}
	
	public Person getPersonByID(int id) {
		
		try {
			personenList = getPersonenList();
			for(Person person : personenList) {
					if(id==person.getPersonID()) {
						return person;
					}
			}
				throw new IllegalArgumentException("Person wurde nicht gefunden!");
		}
		
		catch(IllegalArgumentException e) {
			e.getMessage();
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	/**
	 * Eine Person entfernt eine andere aus ihrer Freundesliste.
	 * @throws IOException 
	 * 
	 */
	public void freundEntfernen(Person anforderer, Person freundEntfernen) throws IOException {
		
		ArrayList<Person> allePersonen = getPersonenList();
		ArrayList<Person> friendsList = anforderer.getFreundlist();
		System.out.println("anforderer.getFreundlist()\nvor remove\n" + anforderer.getFreundlist());

		for(Iterator<Person> iterator = friendsList.iterator();iterator.hasNext();) {
			Person value = iterator.next();
				if(value.getPersonID() == freundEntfernen.getPersonID()) {
					iterator.remove();
				}
		}
		//System.out.println("friendsList nach remove\n" + friendsList);
		anforderer.setFreundlist(friendsList);
		System.out.println("anforderer.getFreundlist()\nnach remove\n" + anforderer.getFreundlist());

		personenListAktualisieren(allePersonen);
	}
	
	/**
	 * Eine Person fügt eine andere Person hinzu.
	 * @throws IOException 
	 */
	public void freundHinzufuegen(Person anforderer, Person freundHinzufuegen) throws IOException {
		
		ArrayList<Person> personenList = getPersonenList();
		
		
		for(Person person : personenList){
			if(person.getPersonID() == anforderer.getPersonID()) {
				person.getFreundlist().add(freundHinzufuegen);
			}
			
		}
		personenListAktualisieren(personenList);
	}
		
		// to do:
		// - nachricht		
	
	
	/**
	 * Eine Person wird zum Netzwerk hinzugefügt.
	 * @throws IOException 
	 */
	public void personHinzufugen(Person personHinzuzufugen) throws IOException {
		

			
			if(personenList.size()>0) {
				personHinzuzufugen.setPersonID(personenList.get(0).getPersonID() + 1);
			}
			
			else {

				personHinzuzufugen.setPersonID(1);
			}
			
			personenList.add(0, personHinzuzufugen);
			personenListAktualisieren(personenList);
		}

	/**
	 * Mit dieser Methode stellt ein/eine AdministratorIn eine Person
	 * als AdministratorIn.
	 * @throws IOException 
	 */
	@Override
	public void adminStellen(Person admin, Person user) throws IOException {
		ArrayList<Person> personenList = getPersonenList();
		for(Person person : personenList)
			if(person.getPersonID() == user.getPersonID())
				person.setAdmin(true);
		personenListAktualisieren(personenList);
			
	}
	
	
	
	/**
	 * Eine Peron wird von AdministratorIn gesperrt.
	 * @throws IOException 
	 */
	public void personSperren(Person admin, Person user) throws IOException {
		ArrayList<Person> personenList = getPersonenList();
		for(Person person : personenList)
			if(person.getPersonID() == user.getPersonID())
				person.setGesperrt(true);
		personenListAktualisieren(personenList);
			
	}
	
	/**
	 * Eine bereits gesperrte Person wird von AdministratorIn entsperrt.
	 * @throws IOException 
	 */
	public void personEntsperren(Person admin, Person user) throws IOException {
		
		ArrayList<Person> personenList = getPersonenList();
		for(Person person : personenList)
			if(person.getPersonID() == user.getPersonID())
				person.setGesperrt(false);
		personenListAktualisieren(personenList);
	}
	
	/**
	 * Ein Beitrag wird von AdministratorIn gesperrt, bzw. vom Netzwerk entfernt.
	 */
	//sekundarni use case, admin brise beitrag
	public void beitragSperren(Beitrag beitrag) {
	}
	
	//ForscherIn	
	//statistik
	
	//Beitrag
	
	/**
	 * Liste aller Beiträge wird aktualisiert.
	 */
	public void beitragListeZuAktualisieren(ArrayList<Beitrag> listZuAktualisieren) {
		try {
			OutputStream outp=new FileOutputStream(pfadBeitragList);
			try {
				ObjectOutputStream oop = new ObjectOutputStream(outp);
				oop.writeObject(listZuAktualisieren);
				oop.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Mit dieser Methode bekommt man alle Beiträge im Netzwerk.
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<Beitrag> getAlleBeitraege() {
		
		try {
			InputStream inp=new FileInputStream(pfadBeitragList);
			try {
				ObjectInputStream oinp=new ObjectInputStream(inp);
				try {
					beitragList=(ArrayList<Beitrag>)oinp.readObject();
					inp.close();			
				
				} 	
				catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		    }
			catch (IOException e) {
			e.printStackTrace();
		    }
	    }
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
		
	return beitragList;
    }
	
	/**
	 * Mit dieser Methode bekommt man die Liste aller Beiträge
	 * einer Person.
	 */
	public ArrayList<Beitrag> getBeitragList(Person person) {
		
		ArrayList<Beitrag> beitraege = getAlleBeitraege();
		ArrayList<Beitrag> ergebnis = new ArrayList<Beitrag>();
		int id = person.getPersonID();
		
		for(Beitrag beitrag : beitraege) {
			
			if(id == beitrag.getBesitzerID()) {
				ergebnis.add(beitrag);
			}
		}
		return ergebnis;
		
	}
	
	
	/**
	 * Mit dieser Methode teilt eine Person einen Beitrag.
	 * 
	 */
	public void beitragHinzufugen(Person person, Beitrag beitragZuErstellen) {
		
		ArrayList<Beitrag> beitraege = getAlleBeitraege();
		
		
				beitraege.add(0,beitragZuErstellen);
				beitragListeZuAktualisieren(beitraege);
		}
	
	/**
	 * Mit dieser Methode findet man einen Beitrag über die ID.
	 * Es wird eine Liste mit allen Beiträgen erstellt und diese
	 * nach der BeitragID durchsucht.
	 */
	public Beitrag getBeitragbyID(int beitragID) {
		
		ArrayList<Beitrag> alle = getAlleBeitraege();
		
		for(Beitrag beitrag : alle) {
			if ( beitragID == beitrag.getBeitragID()) {
				return beitrag;
			}
		}

		return null;
	}
	
	/**
	 * Mit dieser Methode kann eine Person ihren eigenen Beitrag löschen.
	 * Nachdem überprüft wird ob Beitrag zu Besitzer gehört (und das true ergibt), wird der Beitrag
	 * aus der Beitragsliste entfernt (falls gefunden) und die Liste aktualisiert.
	 * Falls Beitrag nicht zu Besitzer gehört, wird eine Benachrichtigung angezeigt.
	 */
	public void beitragLoschen(Person besitzer, Beitrag beitragZuLoschen) {
		
		if(besitzer.getPersonID() == beitragZuLoschen.getBesitzerID() || besitzer.isAdmin()) {
			ArrayList<Beitrag> alle = getAlleBeitraege();
			//System.out.println(alle.size() + " = size");

				
			for(Iterator<Beitrag> iterator = alle.iterator(); iterator.hasNext();) {
				Beitrag value = iterator.next();
				if(value.getBeitragID() == beitragZuLoschen.getBeitragID())
					iterator.remove();
			}	
			beitragListeZuAktualisieren(alle);
			System.out.println("Beitrag wurde erfolgreich entfernt!" );
		}
		else {
			System.out.println("Sie können diesen Beitrag nicht löschen!");
		}
	}



public void kommentieren(int beitragID, String kommentar) {
	
	ArrayList<Beitrag> alleBeitrage = getAlleBeitraege();
	
	for(Beitrag beitrag : alleBeitrage) {
		if(beitrag.getBeitragID() == beitragID) {
			beitrag.getKommentare().add(kommentar);
			System.out.println(beitrag.toString());
		}
	}
	beitragListeZuAktualisieren(alleBeitrage);

	
	
	//getBeitragbyID(beitragID).getKommentare().add(kommentar);
}
	@Override
	public void forscherHinzufugen(Forscher forscherHinzuzufugen) {
		if(forscherList.size()>0) {
			forscherHinzuzufugen.setForscherID(forscherList.get(0).getForscherID() + 1);
		}
		
		else {
			forscherHinzuzufugen.setForscherID(1);
		}
		
		forscherList.add(0, forscherHinzuzufugen);
		try {
			forscherListAktualisieren(forscherList);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	private void forscherListAktualisieren(ArrayList<Forscher> listeZuAktualisieren) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(pfadForscherList);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(listeZuAktualisieren);
		oos.flush();
		
		fos.close();
		oos.close();
	
	}


	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Forscher> getForscherList() {
		try {
			InputStream inp=new FileInputStream(pfadForscherList);
			try {
				ObjectInputStream oinp=new ObjectInputStream(inp);
				try {
					forscherList=(ArrayList<Forscher>) oinp.readObject();
					inp.close();			
				
				}
				
				catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		    }
			
			catch (IOException e) {
			e.printStackTrace();
		    }
	    }
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
		
		return forscherList;
	}
	
public Forscher getForscherByID(int id) {
		
		try {
			forscherList = getForscherList();
			for(Forscher forscher : forscherList) {
					if(id==forscher.getForscherID()) {
						return forscher;
					}
			}
				throw new IllegalArgumentException("Person wurde nicht gefunden!");
		}
		
		catch(IllegalArgumentException e) {
			e.getMessage();
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	
	@SuppressWarnings("unchecked")
	public ArrayList<Statistik> getStatistikList() {
		try {
			InputStream inp=new FileInputStream(pfadStatistikList);
			try {
				ObjectInputStream oinp=new ObjectInputStream(inp);
				try {
					statistikList=(ArrayList<Statistik>) oinp.readObject();
					inp.close();			
				
				}
				
				catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		    }
			
			catch (IOException e) {
			e.printStackTrace();
		    }
	    }
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
		
		return statistikList;
	}
	
	@Override
	public void statistikErstellen(int forscherId) {
		
		ArrayList<Statistik> statistikListe = getStatistikList();
		
		int forscherID = forscherId;
		int ingesamtBeitrag = getAlleBeitraege().size();
		int ingesamtPerson = getPersonenList().size();
		int ingesamtLike = 0;
			for(Beitrag beitrag : getAlleBeitraege())
				ingesamtLike += beitrag.getGeffaltMirAngaben();
		double durschnittLike = 0;
		if(getAlleBeitraege().size() != 0)
			durschnittLike = ingesamtLike / getAlleBeitraege().size();
		double durschnittBeitragProPerson = 0;
		if(getPersonenList().size() !=0 )
			durschnittBeitragProPerson = getAlleBeitraege().size() / getPersonenList().size();
		
		Statistik statistik = new Statistik(Calendar.getInstance(), 1, forscherID, ingesamtBeitrag, ingesamtPerson, ingesamtLike, durschnittLike, durschnittBeitragProPerson);
		if(statistikListe.size()>0) {
			statistik.setStatistikID(statistikListe.get(0).getStatistikID() + 1);
		}
		
		else {
			statistik.setStatistikID(1);
		}
		
		statistikListe.add(0, statistik);
		try {
			statistikListAktualisieren(statistikListe);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void statistikListAktualisieren(ArrayList<Statistik> statistikListe) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(pfadStatistikList);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(statistikListe);
		oos.flush();
		
		fos.close();
		oos.close();		
	}


	@SuppressWarnings("unchecked")
	public ArrayList<Nachricht> getNachrichtList() {
		try {
			InputStream inp=new FileInputStream(pfadNachrichtList);
			try {
				ObjectInputStream oinp=new ObjectInputStream(inp);
				try {
					nachrichtList=(ArrayList<Nachricht>) oinp.readObject();
					inp.close();			
				
				}
				
				catch (ClassNotFoundException e) {
				e.printStackTrace();
				}
		    }
			
			catch (IOException e) {
			e.printStackTrace();
		    }
	    }
		
		catch (FileNotFoundException e) {
		e.printStackTrace();
	    }
		
		return nachrichtList;
	}
	
private void nachrichtListAktualisieren(ArrayList<Nachricht> nachrichtListe) throws IOException {
		
		FileOutputStream fos = new FileOutputStream(pfadNachrichtList);
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(nachrichtListe);
		oos.flush();
		
		fos.close();
		oos.close();		
	}


@Override
public ArrayList<Nachricht> konversationFinden(int id1, int id2) {
	
	ArrayList<Nachricht> nachrichtListe = getNachrichtList();
	ArrayList<Nachricht> ergebnis = new ArrayList<Nachricht>();

	for(Nachricht nachricht : nachrichtListe) {
		if(nachricht.getUser1id() == id1 && nachricht.getUser2id()==id2 || nachricht.getUser1id() == id2 && nachricht.getUser2id()==id1){
			ergebnis.add(nachricht);
			return ergebnis;
		}
	}
	return null;
}

@Override
public void nachrichtHinzufugen(int personID, int personID2, String nachricht) throws IOException {
	
	System.out.println("nachrichtHinzufugen - Serialized");
	boolean check = false;
	for(Nachricht iterator : getNachrichtList()) {
		if((iterator.getUser1id() == personID && iterator.getUser2id()==personID2)){
			System.out.println("true - Serialized");
			iterator.getNachrichtInhalt().add(nachricht);
			check=true;
		}
	}	
			if(check == false){
				System.out.println("check == false - Serialized");
				Nachricht neuNachricht = new Nachricht(personID, personID2);

				neuNachricht.getNachrichtInhalt().add(nachricht);
				getNachrichtList().add(neuNachricht);
				nachrichtListAktualisieren(getNachrichtList());
				
				
				
				System.out.println(neuNachricht.toString());
				System.out.println(getNachrichtList().toString());

			}
	}
}



