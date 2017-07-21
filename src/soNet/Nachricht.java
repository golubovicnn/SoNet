package soNet;

import java.util.ArrayList;

public class Nachricht {
	
	private int user1id;
	private int user2id;
	private ArrayList<String> nachrichtInhalt = new ArrayList<String>();


	public Nachricht(int user1id, int user2id) {
		super();
		this.user1id = user1id;
		this.user2id = user2id;
	}


	public int getUser1id() {
		return user1id;
	}


	public void setUser1id(int user1id) {
		this.user1id = user1id;
	}


	public int getUser2id() {
		return user2id;
	}


	public void setUser2id(int user2id) {
		this.user2id = user2id;
	}


	public ArrayList<String> getNachrichtInhalt() {
		return nachrichtInhalt;
	}


	public void setNachrichtInhalt(ArrayList<String> nachrichtInhalt) {
		this.nachrichtInhalt = nachrichtInhalt;
	}


	@Override
	public String toString() {
		return "Nachricht [user1id=" + user1id + ", user2id=" + user2id + ", nachrichtInhalt=" + nachrichtInhalt + "]";
	}

}
