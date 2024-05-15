package model.objektuak;

import java.sql.Blob;

public class Podcaster extends Artista {

	/**
     * Podcaster bat sortzen du identifikadorearekin, izen artistikoarekin, 
     * irudiarekin, eta deskribapenarekin.
     * 
     * @param id Podcaster-aren identifikadorea
     * @param izen_Artistikoa Podcaster-aren izen artistikoa
     * @param irudia Podcaster-aren irudia
     * @param deskribapena Podcaster-aren deskribapena
     */
    public Podcaster(String id, String izen_Artistikoa, Blob irudia, String deskribapena) {
        super(id, izen_Artistikoa, irudia, deskribapena);
    }
    
    public Podcaster(String id, String izen_Artistikoa, String deskribapena) {
        super(id, izen_Artistikoa, deskribapena);
    }

    /**
     * Podcaster bat sortzen du izen artistikoarekin eta entzunaldi kopuruarekin.
     * 
     * @param izena Podcaster-aren izen artistikoa
     * @param entzunaldi Entzunaldi kopurua
     */
    public Podcaster(String izena, int entzunaldi) {
        super(izena, entzunaldi);
    }

    
    
    /**
     * Podcaster objektuaren informazio laburra itzultzen du.
     * 
     * @return Podcaster objektuaren informazio laburra
     */
    @Override
    public String toString() {
        return super.toString();
    }



	
	public boolean equals(Podcaster obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
    
    

}
