package soNet;

import java.io.Serializable;
import java.util.Calendar;

@SuppressWarnings("serial")
public class Statistik implements Serializable {

	
	Calendar datum;
	int statistikID;
	int forscherID;
	int ingesamtBeitrag;
	int ingesamtPerson;
	int ingesamtLike;
	double durschnittLike;
	double durschnittBeitragProPerson;

	public Statistik(Calendar datum, int statistikID, int forscherID, int ingesamtBeitrag, int ingesamtPerson,
			int ingesamtLike, double durschnittLike, double durschnittBeitragProPerson) {
		super();
		this.datum = datum;
		this.statistikID = statistikID;
		this.forscherID = forscherID;
		this.ingesamtBeitrag = ingesamtBeitrag;
		this.ingesamtPerson = ingesamtPerson;
		this.ingesamtLike = ingesamtLike;
		this.durschnittLike = durschnittLike;
		this.durschnittBeitragProPerson = durschnittBeitragProPerson;
	}

	public Calendar getDatum() {
		return datum;
	}

	public void setDatum(Calendar datum) {
		this.datum = datum;
	}

	public int getStatistikID() {
		return statistikID;
	}

	public void setStatistikID(int statistikID) {
		this.statistikID = statistikID;
	}

	public int getForscherID() {
		return forscherID;
	}

	public void setForscherID(int forscherID) {
		this.forscherID = forscherID;
	}

	public int getIngesamtBeitrag() {
		return ingesamtBeitrag;
	}

	public void setIngesamtBeitrag(int ingesamtBeitrag) {
		this.ingesamtBeitrag = ingesamtBeitrag;
	}

	public int getIngesamtPerson() {
		return ingesamtPerson;
	}

	public void setIngesamtPerson(int ingesamtPerson) {
		this.ingesamtPerson = ingesamtPerson;
	}

	public int getIngesamtLike() {
		return ingesamtLike;
	}

	public void setIngesamtLike(int ingesamtLike) {
		this.ingesamtLike = ingesamtLike;
	}

	public double getDurschnittLike() {
		return durschnittLike;
	}

	public void setDurschnittLike(int durschnittLike) {
		this.durschnittLike = durschnittLike;
	}

	public double getDurschnittBeitragProPerson() {
		return durschnittBeitragProPerson;
	}

	public void setDurschnittBeitragProPerson(int durschnittBeitragProPerson) {
		this.durschnittBeitragProPerson = durschnittBeitragProPerson;
	}

	@Override
	public String toString() {
		return "Statistik von " + datum.get(Calendar.DAY_OF_MONTH) + "." + datum.get(Calendar.MONTH) + "." + datum.get(Calendar.YEAR) + ", \nStatistik ID=" + statistikID + ", \nForscher ID=" + forscherID
				+ ", \nBeiträge ingesamt: " + ingesamtBeitrag + ", \nPersonen ingesamt: " + ingesamtPerson + ", \nLikes ingesamt: "
				+ ingesamtLike + ", \nDurschnitt Likes: " + durschnittLike + ", \nDurschnitt Beiträge Pro Person="
				+ durschnittBeitragProPerson;
	}
	public String getTagMonatJahr() {
		return datum.get(Calendar.DAY_OF_MONTH) + "." + (datum.get(Calendar.MONTH)+1) + "." + datum.get(Calendar.YEAR);
	}
}
