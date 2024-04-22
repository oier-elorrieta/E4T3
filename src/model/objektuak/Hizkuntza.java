package model.objektuak;

/**
 * Klasea Hizkuntza objektuak kudeatzeko erabiltzen da.
 */
public class Hizkuntza {
    private String ID_Hizkuntza; // Hizkuntzaren identifikazioa
    private String Deskribapena; // Hizkuntzaren deskribapena
    
    /**
     * Eraikitzailea Hizkuntza objektu bat sortzeko.
     * @param iD_Hizkuntza Hizkuntzaren identifikazioa
     * @param deskribapena Hizkuntzaren deskribapena
     */
    public Hizkuntza(String iD_Hizkuntza, String deskribapena) {
        ID_Hizkuntza = iD_Hizkuntza;
        Deskribapena = deskribapena;
    }

    /**
     * Hizkuntzaren identifikazioa itzultzen duen metodoa.
     * @return Hizkuntzaren identifikazioa
     */
    public String getID_Hizkuntza() {
        return ID_Hizkuntza;
    }

    /**
     * Hizkuntzaren deskribapena itzultzen duen metodoa.
     * @return Hizkuntzaren deskribapena
     */
    public String getDeskribapena() {
        return Deskribapena;
    }
}
