package model.objektuak;

import java.sql.Blob;
import java.util.Objects;

public abstract class Artista {
	protected String id;
	protected String izen_Artistikoa;
	protected Blob irudia;
	protected String deskribapena;
	protected int erreprodukzioak;

	/**
	 * Artista izen artistikoarekin eta erreprodukzio kopuruarekin sortzen du.
	 * 
	 * @param izen_Artistikoa Artista edo taldearen izen artistikoa
	 * @param erreprodukzioak Artista edo taldearen erreprodukzio kopurua
	 */
	public Artista(String izen_Artistikoa, int erreprodukzioak) {
		this.izen_Artistikoa = izen_Artistikoa;
		this.erreprodukzioak = erreprodukzioak;
	}

	/**
	 * Artista identifikadorearekin, izen artistikoarekin, irudiarekin eta
	 * deskribapenarekin sortzen du.
	 * 
	 * @param id              Artista edo taldearen identifikadorea
	 * @param izen_Artistikoa Artista edo taldearen izen artistikoa
	 * @param irudia          Artista edo taldearen irudia
	 * @param deskribapena    Artista edo taldearen deskribapena
	 */
	public Artista(String id, String izen_Artistikoa, Blob irudia, String deskribapena) {
		this.id = id;
		this.izen_Artistikoa = izen_Artistikoa;
		this.irudia = irudia;
		this.deskribapena = deskribapena;
	}

	/**
	 * Artista edo taldearen identifikadorea itzultzen du.
	 * 
	 * @return Artista edo taldearen identifikadorea
	 */
	public String getId() {
		return id;
	}

	/**
	 * Artista edo taldearen identifikadorea ezartzen du.
	 * 
	 * @param id Artista edo taldearen identifikadorea
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Artista edo taldearen izen artistikoa itzultzen du.
	 * 
	 * @return Artista edo taldearen izen artistikoa
	 */
	public String getIzen_Artistikoa() {
		return izen_Artistikoa;
	}

	/**
	 * Artista edo taldearen izen artistikoa ezartzen du.
	 * 
	 * @param izen_Artistikoa Artista edo taldearen izen artistikoa
	 */
	public void setIzen_Artistikoa(String izen_Artistikoa) {
		this.izen_Artistikoa = izen_Artistikoa;
	}

	/**
	 * Artista edo taldearen irudia itzultzen du.
	 * 
	 * @return Artista edo taldearen irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Artista edo taldearen irudia ezartzen du.
	 * 
	 * @param irudia Artista edo taldearen irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Artista edo taldearen deskribapena itzultzen du.
	 * 
	 * @return Artista edo taldearen deskribapena
	 */
	public String getDeskribapena() {
		return deskribapena;
	}

	/**
	 * Artista edo taldearen deskribapena ezartzen du.
	 * 
	 * @param deskribapena Artista edo taldearen deskribapena
	 */
	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}

	/**
	 * Artista edo taldearen erreprodukzio kopurua itzultzen du.
	 * 
	 * @return Artista edo taldearen erreprodukzio kopurua
	 */
	public int getErreprodukzioak() {
		return erreprodukzioak;
	}

	/**
	 * Artista edo taldearen erreprodukzio kopurua ezartzen du.
	 * 
	 * @param erreprodukzioak Artista edo taldearen erreprodukzio kopurua
	 */
	public void setErreprodukzioak(int erreprodukzioak) {
		this.erreprodukzioak = erreprodukzioak;
	}

	/**
	 * Artista edo taldearen berdintasuna konparatzen du.
	 * 
	 * @param obj Konparatzen den objektua
	 * @return Berdina bada egia itzultzen du, bestela gezurra
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(deskribapena, other.deskribapena) && erreprodukzioak == other.erreprodukzioak
				&& Objects.equals(id, other.id) && Objects.equals(irudia, other.irudia)
				&& Objects.equals(izen_Artistikoa, other.izen_Artistikoa);
	}

	/**
	 * Artista edo taldearen informazio laburra itzultzen du.
	 * 
	 * @return Artista edo taldearen informazio laburra
	 */
	@Override
	public String toString() {
		return "Artista [id=" + id + ", izen_Artistikoa=" + izen_Artistikoa + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + ", erreprodukzioak=" + erreprodukzioak + "]";
	}

}