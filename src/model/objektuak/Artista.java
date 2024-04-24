package model.objektuak;

import java.util.Objects;

public abstract class Artista {
	protected String id;
	protected String izen_Artistikoa;
	protected String irudia;
	protected String deskribapena;
	protected int erreprodukzioak;
	
	public Artista(String izen_Artistikoa, int erreprodukzioak) {
		this.izen_Artistikoa = izen_Artistikoa;
		this.erreprodukzioak = erreprodukzioak;
	}
	
	public Artista(String id, String izen_Artistikoa, String irudia, String deskribapena) {
		this.id = id;
		this.izen_Artistikoa = izen_Artistikoa;
		this.irudia = irudia;
		this.deskribapena = deskribapena;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIzen_Artistikoa() {
		return izen_Artistikoa;
	}
	
	public int geterreprodukzioak() {
		return erreprodukzioak;
	}

	public void setIzen_Artistikoa(String izen_Artistikoa) {
		this.izen_Artistikoa = izen_Artistikoa;
	}
	
	public String getIrudia() {
		return irudia;
	}

	public void setIrudia(String irudia) {
		this.irudia = irudia;
	}

	public String getDeskribapena() {
		return deskribapena;
	}

	public void setDeskribapena(String deskribapena) {
		this.deskribapena = deskribapena;
	}
	
	


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artista other = (Artista) obj;
		return Objects.equals(deskribapena, other.deskribapena) && id == other.id
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izen_Artistikoa, other.izen_Artistikoa);
	}

	@Override
	public String toString() {
		return "Artista [id=" + id + ", izen_Artistikoa=" + izen_Artistikoa + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + ", erreprodukzioak=" + erreprodukzioak + "]";
	}
}