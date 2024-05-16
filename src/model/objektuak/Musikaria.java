package model.objektuak;

import java.sql.Blob;
import java.util.Objects;

public class Musikaria extends Artista {
	private String ezaugarria;

	/**
     * Musikaria objektua sortzen du identifikadorearekin, izen artistikoarekin,
     * irudiarekin, deskribapenarekin, eta ezaugarri gehigarri batekin.
     * 
     * @param id Musikariaren identifikadorea
     * @param izen_Artistikoa Musikariaren izen artistikoa
     * @param irudia Musikariaren irudia
     * @param deskribapena Musikariaren deskribapena
     * @param ezaugarria Musikariaren ezaugarri gehigarria
     */
    public Musikaria(String id, String izen_Artistikoa, Blob irudia, String deskribapena, String ezaugarria) {
        super(id, izen_Artistikoa, irudia, deskribapena);
        this.ezaugarria = ezaugarria;
    }
    
    public Musikaria(String id, String izen_Artistikoa, String deskribapena, String ezaugarria) {
        super(id, izen_Artistikoa, deskribapena);
        this.ezaugarria = ezaugarria;
    }
    public Musikaria(String id, String izen_Artistikoa) {
    	 super(id, izen_Artistikoa);
    }

    /**
     * Musikaria izen artistikoarekin eta entzunaldi kopuruarekin sortzen du.
     * 
     * @param izen_Artistikoa Musikariaren izen artistikoa
     * @param entzunaldi Entzunaldi kopurua
     */
    public Musikaria(String izen_Artistikoa, int entzunaldi) {
        super(izen_Artistikoa, entzunaldi);
    }
    

    /**
     * Musikariaren ezaugarria itzultzen du.
     * 
     * @return Musikariaren ezaugarria
     */
    public String getEzaugarria() {
        return ezaugarria;
    }

    /**
     * Musikariaren ezaugarria ezartzen du.
     * 
     * @param ezaugarria Musikariaren ezaugarria
     */
    public void setEzaugarria(String ezaugarria) {
        this.ezaugarria = ezaugarria;
    }

    /**
     * Musikaria objektuaren informazio laburra itzultzen du, Artista klaseko 
     * informazioa barne.
     * 
     * @return Musikaria objektuaren informazio laburra
     */
    @Override
    public String toString() {
        String txt = super.toString();
        return txt + " Musikaria [ezaugarria=" + ezaugarria + "]";
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musikaria other = (Musikaria) obj;
		return Objects.equals(ezaugarria, other.ezaugarria);
	}

    
}
