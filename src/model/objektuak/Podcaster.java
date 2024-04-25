package model.objektuak;

import java.sql.Blob;

public class Podcaster extends Artista {

	public Podcaster(String id, String izen_Artistikoa, Blob irudia, String deskribapena) {
		super(id, izen_Artistikoa, irudia, deskribapena);
		// TODO Auto-generated constructor stub
	}
	
	public Podcaster(String izena,int entzunaldi) {
		super(izena,entzunaldi);
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
