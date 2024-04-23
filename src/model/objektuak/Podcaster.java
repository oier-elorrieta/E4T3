package model.objektuak;

public class Podcaster extends Artistak {

	public Podcaster(String id, String izen_Artistikoa, String irudia, String deskribapena) {
		super(id, izen_Artistikoa, irudia, deskribapena);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Podcaster [id=" + id + ", izen_Artistikoa=" + izen_Artistikoa + ", irudia=" + irudia + ", deskribapena="
				+ deskribapena + "]";
	}

}
