package model.objektuak.bezero;

import java.util.Date;

public class Free extends Bezero {

	public Free(int id, String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna) {
		super(id, izena, abizena, hizkuntza, erabiltzaileIzena, pasahitza, jaioteguna, erregistroEguna);
	}
	
	public Free(String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna) {
		super(izena, abizena, hizkuntza, erabiltzaileIzena, pasahitza, jaioteguna, erregistroEguna);
	}
}
