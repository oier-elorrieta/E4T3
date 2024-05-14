package model.objektuak;


/**
 * Klasea Hizkuntza objektuak kudeatzeko erabiltzen da.
 */
public class Hizkuntza {
	private String ID_Hizkuntza; // Hizkuntzaren identifikazioa
	private String Deskribapena; // Hizkuntzaren deskribapena

	/**
	 * Eraikitzailea Hizkuntza objektu bat sortzeko.
	 * 
	 * @param iD_Hizkuntza Hizkuntzaren identifikazioa
	 * @param deskribapena Hizkuntzaren deskribapena
	 */
	public Hizkuntza(String iD_Hizkuntza, String deskribapena) {
		ID_Hizkuntza = iD_Hizkuntza;
		Deskribapena = deskribapena;
	}

	/**
	 * Objektu Hizkuntza honen identifikazioa itzultzen du.
	 * 
	 * @return Objektu Hizkuntza honen identifikazioa.
	 */
	public String getID_Hizkuntza() {
		return ID_Hizkuntza;
	}

	/**
	 * Objektu Hizkuntza honen identifikazioa ezartzen du.
	 * 
	 * @param iD_Hizkuntza Objektu Hizkuntza honen berriro identifikatzeko
	 *                     identifikazioa.
	 */
	public void setID_Hizkuntza(String iD_Hizkuntza) {
		ID_Hizkuntza = iD_Hizkuntza;
	}

	/**
	 * Objektu Hizkuntza honen deskribapena itzultzen du.
	 * 
	 * @return Objektu Hizkuntza honen deskribapena.
	 */
	public String getDeskribapena() {
		return Deskribapena;
	}

	/**
	 * Objektu Hizkuntza honen deskribapena ezartzen du.
	 * 
	 * @param deskribapena Objektu Hizkuntza honen berriro deskribatzeko
	 *                     deskribapena.
	 */
	public void setDeskribapena(String deskribapena) {
		Deskribapena = deskribapena;
	}

	@Override
	public String toString() {
		return "Hizkuntza [ID_Hizkuntza=" + ID_Hizkuntza + ", Deskribapena=" + Deskribapena + "]";
	}

}
