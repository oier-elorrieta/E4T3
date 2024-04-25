package model.objektuak.bezero;

import java.util.*;

public abstract class Bezero {
	protected int id;
	protected String izena;
	protected String abizena;
	protected String hizkuntza;
	protected String erabiltzaileIzena;
	protected String pasahitza;
	protected Date jaioteguna;
	protected Date erregistroEguna;

	public Bezero(int id, String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna) {
		this.id = id;
		this.izena = izena;
		this.abizena = abizena;
		this.hizkuntza = hizkuntza;
		this.erabiltzaileIzena = erabiltzaileIzena;
		this.pasahitza = pasahitza;
		this.jaioteguna = jaioteguna;
		this.erregistroEguna = erregistroEguna;
	}
	
	public Bezero(String izena, String abizena, String hizkuntza, String erabiltzaileIzena, String pasahitza,
			Date jaioteguna, Date erregistroEguna) {
		this.izena = izena;
		this.abizena = abizena;
		this.hizkuntza = hizkuntza;
		this.erabiltzaileIzena = erabiltzaileIzena;
		this.pasahitza = pasahitza;
		this.jaioteguna = jaioteguna;
		this.erregistroEguna = erregistroEguna;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getAbizena() {
		return abizena;
	}

	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	public String getHizkuntza() {
		return hizkuntza;
	}

	public void setHizkuntza(String hizkuntza) {
		this.hizkuntza = hizkuntza;
	}

	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
	}

	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}

	public String getPasahitza() {
		return pasahitza;
	}

	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	public Date getJaioteguna() {
		return jaioteguna;
	}

	public void setJaioteguna(Date jaioteguna) {
		this.jaioteguna = jaioteguna;
	}

	public Date getErregistroEguna() {
		return erregistroEguna;
	}

	public void setErregistroEguna(Date erregistroEguna) {
		this.erregistroEguna = erregistroEguna;
	}

	@Override
	public String toString() {
		return "Bezero [izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza + ", erabiltzaileIzena="
				+ erabiltzaileIzena + ", pasahitza=" + pasahitza + ", jaioteguna=" + jaioteguna + ", erregistroEguna="
				+ erregistroEguna + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bezero other = (Bezero) obj;
		return Objects.equals(izena, other.izena) && Objects.equals(abizena, other.abizena)
				&& Objects.equals(hizkuntza, other.hizkuntza)
				&& Objects.equals(erabiltzaileIzena, other.erabiltzaileIzena)
				&& Objects.equals(pasahitza, other.pasahitza) && Objects.equals(jaioteguna, other.jaioteguna)
				&& Objects.equals(erregistroEguna, other.erregistroEguna);

	}

}
