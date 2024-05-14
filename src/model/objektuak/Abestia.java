package model.objektuak;

import java.sql.Blob;

public class Abestia extends Audio {

	public Abestia(String idAudio, String izena, int iraupena, Blob irudia) {
		super(idAudio, izena, iraupena, irudia);
	}
	public Abestia(String idAudio, String izena) {
		super(idAudio, izena);
	}
	public Abestia(String newID, String newIzena, int newDenbora) {
		super(newID, newIzena,newDenbora);
	}

	
}
