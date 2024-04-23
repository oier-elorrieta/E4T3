package model.objektuak;

import java.util.Objects;

public class Musikaria extends Artista {
	private String ezaugarria;

	public Musikaria(String id, String izen_Artistikoa, String irudia, String deskribapena, String ezaugarria) {
		super(id, izen_Artistikoa, irudia, deskribapena);
		this.ezaugarria = ezaugarria;
	}

	public String getEzaugarria() {
		return ezaugarria;
	}

	public void setEzaugarria(String ezaugarria) {
		this.ezaugarria = ezaugarria;
	}

	@Override
	public String toString() {
		return "Musikaria [Id=" + id + ", izen_Artistikoa=" + izen_Artistikoa + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + ", ezaugarria=" + ezaugarria + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Musikaria other = (Musikaria) obj;
		return Objects.equals(ezaugarria, other.ezaugarria);
	}

}
