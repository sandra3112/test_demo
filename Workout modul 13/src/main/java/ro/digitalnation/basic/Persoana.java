package ro.digitalnation.basic;

public abstract class Persoana {

	//proprietatile clasei
	private String nume, prenume, oras;
	private Integer varsta;
	private boolean casatorita;
	
	//constructor cu toti parametrii
	public Persoana(String nume, String prenume, String oras, Integer varsta, boolean casatorita) {
		super();
		this.nume = nume;
		this.prenume = prenume;
		this.oras = oras;
		this.varsta = varsta;
		this.casatorita = casatorita;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPrenume() {
		return prenume;
	}

	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}

	public String getOras() {
		return oras;
	}

	public void setOras(String oras) {
		this.oras = oras;
	}

	public Integer getVarsta() {
		return varsta;
	}

	public void setVarsta(Integer varsta) {
		this.varsta = varsta;
	}

	public boolean isCasatorita() {
		return casatorita;
	}

	public void setCasatorita(boolean casatorita) {
		this.casatorita = casatorita;
	}
	
	@Override
	public String toString() {
		//Se creaza mesajul dorit pentru reprezentarea clasei
		String toString = "Nume: " + nume + ", Prenume: " + prenume + ", Varsta: " + varsta +
				", Oras: " + oras + ", casatorita: " + casatorita;
		//se returneaza acesta
		return toString;
		//In main, cand se va rula iar se va observa ca printul de la linia 42 afiseaza:
		//Nume: Antonache, Prenume: Laura, Varsta: 26, Oras: Bucuresti, casatorita: false
		//Fata de mesajul afisat fara a avea aceasta metoda implementata:
		//Persoana@7a81197d
	}
	
	public String obtineIdentificator() {
		return prenume.toLowerCase().replaceAll(" ", "").replaceAll("-", "") + "_" + nume.toUpperCase().replaceAll(" ", "").replaceAll("-", "") ;
	}
	
	public abstract String getResponsabilitati();
	
}
