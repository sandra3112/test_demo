package ro.digitalnation.basic;

public class Trainer extends Persoana {

	public Trainer(String nume, String prenume, String oras, Integer varsta, boolean casatorita) {
		super(nume, prenume, oras, varsta, casatorita);
	}

	@Override
	public String obtineIdentificator() {
		// TODO Auto-generated method stub
		return "trainer_" + super.obtineIdentificator();
	}

	@Override
	public String getResponsabilitati() {
		return "Pregatirea materialelor, evaluarea temelor, crearea contextului de lucru, raspunderea la intrebari";
	}
}
