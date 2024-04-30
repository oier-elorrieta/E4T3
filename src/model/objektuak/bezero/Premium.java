package model.objektuak.bezero;

import java.util.Date;
import java.util.Objects;

public class Premium extends Bezero {
	private Date iraungitzeData;

	/**
	 * Premium bezero bat sortzen du identifikadorearekin, izenarekin, abizenarekin,
	 * hizkuntzarekin, erabiltzaile izenarekin, pasahitzarekin, jaiotegunarekin,
	 * erregistro egunarekin, eta iraungitze datarekin.
	 * 
	 * @param id                Premium bezeroaren identifikadorea
	 * @param izena             Premium bezeroaren izena
	 * @param abizena           Premium bezeroaren abizena
	 * @param hizkuntza         Premium bezeroaren hizkuntza
	 * @param erabiltzaileIzena Premium bezeroaren erabiltzaile izena
	 * @param pasahitza         Premium bezeroaren pasahitza
	 * @param jaioteguna        Premium bezeroaren jaioteguna
	 * @param erregistroEguna   Premium bezeroaren erregistro eguna
	 * @param iraungitzeData    Premium kontuaren iraungitze data
	 */
	public Premium(int id, String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna, Date iraungitzeData) {
		super(id, izena, abizena, hizkuntza, erabiltzaileIzena, pasahitza, jaioteguna, erregistroEguna);
		this.iraungitzeData = iraungitzeData;
	}

	/**
	 * Premium bezero bat sortzen du izenarekin, abizenarekin, hizkuntzarekin,
	 * erabiltzaile izenarekin, pasahitzarekin, jaiotegunarekin, erregistro
	 * egunarekin, eta iraungitze datarekin, identifikadore barik.
	 * 
	 * @param izena             Premium bezeroaren izena
	 * @param abizena           Premium bezeroaren abizena
	 * @param hizkuntza         Premium bezeroaren hizkuntza
	 * @param erabiltzaileIzena Premium bezeroaren erabiltzaile izena
	 * @param pasahitza         Premium bezeroaren pasahitza
	 * @param jaioteguna        Premium bezeroaren jaioteguna
	 * @param erregistroEguna   Premium bezeroaren erregistro eguna
	 * @param iraungitzeData    Premium kontuaren iraungitze data
	 */
	public Premium(String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna, Date iraungitzeData) {
		super(izena, abizena, hizkuntza, erabiltzaileIzena, pasahitza, jaioteguna, erregistroEguna);
		this.iraungitzeData = iraungitzeData;
	}

	/**
	 * Premium kontuaren iraungitze data itzultzen du.
	 * 
	 * @return Premium kontuaren iraungitze data
	 */
	public Date getIraungitzeData() {
		return iraungitzeData;
	}

	/**
	 * Premium kontuaren iraungitze data ezartzen du.
	 * 
	 * @param iraungitzeData Premium kontuaren iraungitze data
	 */
	public void setIraungitzeData(Date iraungitzeData) {
		this.iraungitzeData = iraungitzeData;
	}

	/**
	 * Premium kontuaren iraungitze data urtez handitzen du.
	 * 
	 * @return Berritutako iraungitze data
	 */
	@SuppressWarnings("deprecation")
	public Date premiumErosi() {
		int year = iraungitzeData.getYear();
		year++;
		iraungitzeData.setYear(year);
		return iraungitzeData;
	}

	/**
	 * Premium objektuaren informazio laburra itzultzen du.
	 * 
	 * @return Premium objektuaren informazio laburra
	 */
	@Override
	public String toString() {
		return super.toString() + " Premium [iraungitzeData=" + iraungitzeData + "]";
	}

	/**
	 * Premium objektuaren berdintasuna konparatzen du.
	 * 
	 * @param obj Konparatzen den objektua
	 * @return Berdina bada, egia; bestela, gezurra itzultzen du
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Premium other = (Premium) obj;
		return Objects.equals(iraungitzeData, other.iraungitzeData);
	}

}
