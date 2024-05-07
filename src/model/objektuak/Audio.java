package model.objektuak;

import java.sql.Blob;
import java.util.Objects;

public abstract class Audio {

	protected String idAudio;
	protected String izena;
	protected int iraupena;
	protected Blob irudia;

	/**
	 * Audio objektu bat sortzen du bere identifikadorearekin, izenarekin,
	 * iraupenarekin eta irudiarekin.
	 * 
	 * @param idAudio  Audioaren identifikadorea
	 * @param izena    Audioaren izena
	 * @param iraupena Audioaren iraupena segundoetan
	 * @param irudia2  Audioaren irudia
	 */
	public Audio(String idAudio, String izena, int iraupena, Blob irudia) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
		this.irudia = irudia;
	}

	public Audio(String idAudio) {
		this.idAudio = idAudio;
	}

	public Audio(String idAudio, String izena, int iraupena) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
	}

	/**
	 * Audioaren identifikadorea itzultzen du.
	 * 
	 * @return Audioaren identifikadorea
	 */
	public String getIdAudio() {
		return idAudio;
	}

	/**
	 * Audioaren identifikadorea ezartzen du.
	 * 
	 * @param idAudio Audioaren identifikadorea
	 */
	public void setIdAudio(String idAudio) {
		this.idAudio = idAudio;
	}

	/**
	 * Audioaren izena itzultzen du.
	 * 
	 * @return Audioaren izena
	 */
	public String getIzena() {
		return izena;
	}

	/**
	 * Audioaren izena ezartzen du.
	 * 
	 * @param izena Audioaren izena
	 */
	public void setIzena(String izena) {
		this.izena = izena;
	}

	/**
	 * Audioaren iraupena itzultzen du.
	 * 
	 * @return Audioaren iraupena segundoetan
	 */
	public int getIraupena() {
		return iraupena;
	}

	/**
	 * Audioaren iraupena ezartzen du.
	 * 
	 * @param iraupena Audioaren iraupena segundoetan
	 */
	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}

	/**
	 * Audioaren irudia itzultzen du.
	 * 
	 * @return Audioaren irudia
	 */
	public Blob getIrudia() {
		return irudia;
	}

	/**
	 * Audioaren irudia ezartzen du.
	 * 
	 * @param irudia Audioaren irudia
	 */
	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	/**
	 * Audio objektuaren informazio laburra itzultzen du.
	 * 
	 * @return Audio objektuaren informazio laburra
	 */
	@Override
	public String toString() {
		return "Audio [idAudio=" + idAudio + ", izena=" + izena + ", iraupena=" + iraupena + ", irudia=" + irudia + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idAudio, iraupena, irudia, izena);
	}

	/**
	 * Audio objektuaren berdintasuna konparatzen du.
	 * 
	 * @param obj Konparatzen den objektua
	 * @return Berdina bada egia, bestela gezurra itzultzen du
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return Objects.equals(idAudio, other.idAudio) && iraupena == other.iraupena
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izena, other.izena);
	}


	


}
