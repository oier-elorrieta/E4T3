package model.objektuak;

import java.sql.Blob;

public class Abestia extends Audio {
	
	private String deskribapena;

	public Abestia(String idAudio, String izena, int iraupena, Blob irudia) {
		super(idAudio, izena, iraupena, irudia);
	}
	public Abestia(String newID, String newIzena, int newDenbora, String deskribapena) {
		super(newID, newIzena,newDenbora);
		this.deskribapena = deskribapena;
	}
	public String getDeskribapena() {
		return deskribapena;
	}
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	
	

	
}
