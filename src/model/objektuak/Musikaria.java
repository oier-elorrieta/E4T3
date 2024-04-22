package model.objektuak;

import java.util.Objects;

public class Musikaria extends Artistak {
	private String Ezaugarria;

	public Musikaria(int id, String izen_Artistikoa, String irudia, String deskribapena, String ezaugarria) {
		super(id, izen_Artistikoa, irudia, deskribapena);
		Ezaugarria = ezaugarria;
	}

	public String getEzaugarria() {
		return Ezaugarria;
	}

	public void setEzaugarria(String ezaugarria) {
		Ezaugarria = ezaugarria;
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
		return Objects.equals(Ezaugarria, other.Ezaugarria);
	}

	
	
	
	
	

}
