package model.objektuak.bezero;

import java.util.Date;

public class Free extends Bezero {

	/**
     * Free bezero bat sortzen du identifikadorearekin, izenarekin, abizenarekin, 
     * hizkuntzarekin, erabiltzaile izenarekin, pasahitzarekin, jaiotegunarekin,
     * eta erregistro egunarekin.
     * 
     * @param id Free bezeroaren identifikadorea
     * @param izena Free bezeroaren izena
     * @param abizena Free bezeroaren abizena
     * @param hizkuntza Free bezeroaren hizkuntza
     * @param erabiltzaileIzena Free bezeroaren erabiltzaile izena
     * @param pasahitza Free bezeroaren pasahitza
     * @param jaioteguna Free bezeroaren jaioteguna
     * @param erregistroEguna Free bezeroaren erregistro eguna
     */
    public Free(int id, String izena, String abizena, String hizkuntza, 
                String erabiltzaileIzena, String pasahitza, 
                Date jaioteguna, Date erregistroEguna) {
        super(id, izena, abizena, hizkuntza, erabiltzaileIzena, 
              pasahitza, jaioteguna, erregistroEguna);
    }

    /**
     * Free bezero bat sortzen du izenarekin, abizenarekin, hizkuntzarekin,
     * erabiltzaile izenarekin, pasahitzarekin, jaiotegunarekin, eta erregistro 
     * egunarekin, identifikadore barik.
     * 
     * @param izena Free bezeroaren izena
     * @param abizena Free bezeroaren abizena
     * @param hizkuntza Free bezeroaren hizkuntza
     * @param erabiltzaileIzena Free bezeroaren erabiltzaile izena
     * @param pasahitza Free bezeroaren pasahitza
     * @param jaioteguna Free bezeroaren jaioteguna
     * @param erregistroEguna Free bezeroaren erregistro eguna
     */
    public Free(String izena, String abizena, String hizkuntza, 
                String erabiltzaileIzena, String pasahitza, 
                Date jaioteguna, Date erregistroEguna) {
        super(izena, abizena, hizkuntza, erabiltzaileIzena, 
              pasahitza, jaioteguna, erregistroEguna);
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
    
    
}
