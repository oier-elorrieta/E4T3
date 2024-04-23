package model.objektuak;

import java.util.Objects;

public abstract class Audio {

	protected String idAudio;
	protected String izena;
	protected int iraupena;
	protected String irudia;

	public Audio(String idAudio, String izena, int iraupena, String irudia) {
		this.idAudio = idAudio;
		this.izena = izena;
		this.iraupena = iraupena;
		this.irudia = irudia;
	}

	public String getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(String idAudio) {
		this.idAudio = idAudio;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getIraupena() {
		return iraupena;
	}

	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}

	public String getIrudia() {
		return irudia;
	}

	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}

	@Override
	public String toString() {
		return "Audio [idAudio=" + idAudio + ", izena=" + izena + ", iraupena=" + iraupena + ", irudia=" + irudia + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Audio other = (Audio) obj;
		return idAudio == other.idAudio && iraupena == other.iraupena && Objects.equals(irudia, other.irudia)
				&& Objects.equals(izena, other.izena);
	}

}
