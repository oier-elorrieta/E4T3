package model.objektuak;

import java.util.Objects;

public abstract class Artistak {
	protected int id;
	protected String izen_Artistikoa;
	protected String irudia;
	protected String deskribapena;
	
	public Artistak(int id, String izen_Artistikoa, String irudia, String deskribapena) {
		this.id = id;
		this.izen_Artistikoa = izen_Artistikoa;
		this.irudia = irudia;
		this.deskribapena = deskribapena;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzen_Artistikoa() {
		return izen_Artistikoa;
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
		Artistak other = (Artistak) obj;
		return Objects.equals(deskribapena, other.deskribapena) && id == other.id
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izen_Artistikoa, other.izen_Artistikoa);
	}

	@Override
	public String toString() {
		return "Artistak [id=" + id + ", Izen_Artistikoa=" + izen_Artistikoa + ", irudia=" + irudia + ", Deskribapena="
				+ deskribapena + "]";
	}
	
	
	
	
	
	
	
	
}
