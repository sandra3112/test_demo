package ro.digitalnation.structure;

import java.util.ArrayList;

import ro.digitalnation.activitati.Curs;
import ro.digitalnation.activitati.Material;
import ro.digitalnation.activitati.Rush;
import ro.digitalnation.activitati.Tema;
import ro.digitalnation.basic.Explorer;
import ro.digitalnation.basic.Persoana;
import ro.digitalnation.basic.Trainer;

public class Track {
	private Curs curs;
	
	public Track() {
		pouplate();
	}
	
	public Track(Curs curs) {
		super();
		this.curs = curs;
	}

	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}
	
	private void pouplate() {
		// Temporary (until learning how to populate)
		Persoana e1 = new Explorer("Andrei", "Alexandru", "Bucuresti", 35, false);
		Persoana t1 = new Trainer("Popescu", "Ana", "Cluj", 45, false);
		
		Persoana e2 = new Explorer("Pop", "Mihai", "Bucuresti", 35, false);
		Persoana e3 = new Explorer("Sandu", "Matei", "Bucuresti", 35, false);
		Persoana t2 = new Trainer("Ion", "Sorina", "Bucuresti", 35, false);
		ArrayList<Persoana> exploreri = new ArrayList<Persoana>();
		exploreri.add(e1);
		exploreri.add(e2);
		exploreri.add(e3);
		exploreri.add(t2);
		
		Curs c = new Curs("JAVA", "mediu", t1, exploreri, 1000);
		
		c.getActivitati().put("RUSH 1.0", new Rush());
		c.getActivitati().put("Variabile si tipuri", new Material());
		c.getActivitati().put("Tema 1 - quiz", new Tema());
		c.getActivitati().put("RUSH 2.0", new Rush());
		c.getActivitati().put("OOP basics - clase, obiecte, instante", new Material());
		c.getActivitati().put("Tema 2 - practice in eclipse", new Tema());
		
		this.curs = c;
	}
	
}
