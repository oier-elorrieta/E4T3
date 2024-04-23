package model.objektuak.bezero;

import java.util.Date;
import java.util.Objects;

public class Premium extends Bezero {
	private Date iraungitzeData;

	public Premium(String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna, Date iraungitzeData) {
		super(izena, abizena, hizkuntza, erabiltzaileIzena, pasahitza, jaioteguna, erregistroEguna);
		this.iraungitzeData = iraungitzeData;
	}

	public Date getIraungitzeData() {
		return iraungitzeData;
	}

	public void setIraungitzeData(Date iraungitzeData) {
		this.iraungitzeData = iraungitzeData;
	}

	@Override
	public String toString() {
		String txt = "";
		txt = super.toString();

		return txt + "Premium [iraungitzeData=" + iraungitzeData + "]";
	}

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
	
	@SuppressWarnings("deprecation")
	public Date premiumErosi() {
		int year = iraungitzeData.getYear();
		year++;
		iraungitzeData.setYear(year);
		return iraungitzeData;
	}
	
}