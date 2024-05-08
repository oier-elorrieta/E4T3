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

	/**
	 * Bezero bat sortzen du identifikadorearekin, izenarekin, abizenarekin,
	 * hizkuntzarekin, erabiltzaile izenarekin, pasahitzarekin, jaiotegunarekin, eta
	 * erregistro egunarekin.
	 * 
	 * @param id                Bezeroaren identifikadorea
	 * @param izena             Bezeroaren izena
	 * @param abizena           Bezeroaren abizena
	 * @param hizkuntza         Bezeroaren hizkuntza
	 * @param erabiltzaileIzena Bezeroaren erabiltzaile izena
	 * @param pasahitza         Bezeroaren pasahitza
	 * @param jaioteguna        Bezeroaren jaioteguna
	 * @param erregistroEguna   Bezeroaren erregistro eguna
	 */
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

	/**
	 * Bezero bat sortzen du izenarekin, abizenarekin, hizkuntzarekin, erabiltzaile
	 * izenarekin, pasahitzarekin, jaiotegunarekin, eta erregistro egunarekin,
	 * identifikadore barik.
	 * 
	 * @param izena             Bezeroaren izena
	 * @param abizena           Bezeroaren abizena
	 * @param hizkuntza         Bezeroaren hizkuntza
	 * @param erabiltzaileIzena Bezeroaren erabiltzaile izena
	 * @param pasahitza         Bezeroaren pasahitza
	 * @param jaioteguna        Bezeroaren jaioteguna
	 * @param erregistroEguna   Bezeroaren erregistro eguna
	 */
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

	/**
	 * Bezeroaren identifikadorea itzultzen du.
	 * 
	 * @return Bezeroaren identifikadorea
	 */
	public int getId() {
		return id;
	}

	/**
	 * Bezeroaren identifikadorea ezartzen du.
	 * 
	 * @param id Bezeroaren identifikadorea
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Bezeroaren izena itzultzen du.
	 * 
	 * @return Bezeroaren izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Bezeroaren izena ezartzen du.
	 * 
	 * @param izena Bezeroaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Bezeroaren abizena itzultzen du.
	 * 
	 * @return Bezeroaren abizena
	 */
	public String getAbizena() {
		return abizena;
	}

	/**
	 * Bezeroaren abizena ezartzen du.
	 * 
	 * @param abizena Bezeroaren abizena
	 */
	public void setAbizena(String abizena) {
		this.abizena = abizena;
	}

	/**
	 * Bezeroaren hizkuntza itzultzen du.
	 * 
	 * @return Bezeroaren hizkuntza
	 */
	public String getHizkuntza() {
		return hizkuntza;
	}

	/**
	 * Bezeroaren hizkuntza ezartzen du.
	 * 
	 * @param hizkuntza Bezeroaren hizkuntza
	 */
	public void setHizkuntza(String hizkuntza) {
		this.hizkuntza = hizkuntza;
	}

	/**
	 * Bezeroaren erabiltzaile izena itzultzen du.
	 * 
	 * @return Bezeroaren erabiltzaile izena
	 */
	public String getErabiltzaileIzena() {
		return erabiltzaileIzena;
	}

	/**
	 * Bezeroaren erabiltzaile izena ezartzen du.
	 * 
	 * @param erabiltzaileIzena Bezeroaren erabiltzaile izena
	 */
	public void setErabiltzaileIzena(String erabiltzaileIzena) {
		this.erabiltzaileIzena = erabiltzaileIzena;
	}

	/**
	 * Bezeroaren pasahitza itzultzen du.
	 * 
	 * @return Bezeroaren pasahitza
	 */
	public String getPasahitza() {
		return pasahitza;
	}

	/**
	 * Bezeroaren pasahitza ezartzen du.
	 * 
	 * @param pasahitza Bezeroaren pasahitza
	 */
	public void setPasahitza(String pasahitza) {
		this.pasahitza = pasahitza;
	}

	/**
	 * Bezeroaren jaioteguna itzultzen du.
	 * 
	 * @return Bezeroaren jaioteguna
	 */
	public Date getJaioteguna() {
		return jaioteguna;
	}

	/**
	 * Bezeroaren jaioteguna ezartzen du.
	 * 
	 * @param jaioteguna Bezeroaren jaioteguna
	 */
	public void setJaioteguna(Date jaioteguna) {
		this.jaioteguna = jaioteguna;
	}

	/**
	 * Bezeroaren erregistro eguna itzultzen du.
	 * 
	 * @return Bezeroaren erregistro eguna
	 */
	public Date getErregistroEguna() {
		return erregistroEguna;
	}

	/**
	 * Bezeroaren erregistro eguna ezartzen du.
	 * 
	 * @param erregistroEguna Bezeroaren erregistro eguna
	 */
	public void setErregistroEguna(Date erregistroEguna) {
		this.erregistroEguna = erregistroEguna;
	}
	
	

	/**
	 * Bezero objektuaren informazio laburra itzultzen du.
	 * 
	 * @return Bezero objektuaren informazio laburra
	 */
	@Override
	public String toString() {
		return "Bezero [izena=" + izena + ", abizena=" + abizena + ", hizkuntza=" + hizkuntza + ", erabiltzaileIzena="
				+ erabiltzaileIzena + ", pasahitza=" + pasahitza + ", jaioteguna=" + jaioteguna + ", erregistroEguna="
				+ erregistroEguna + "]";
	}

}
