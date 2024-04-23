package model.objektuak;

public class Podcast extends Audio {

	private String kolaboratzaileak;
	private Podcaster podcaster;

	public Podcast(String idAudio, String izena, int iraupena, String irudia, String kolaboratzaileak, Podcaster podcaster) {
		super(idAudio, izena, iraupena, irudia);
		this.kolaboratzaileak = kolaboratzaileak;
		this.podcaster = podcaster;
	}

	@Override
	public String toString() {
		String txt ="";
		txt = super.toString();
		
		return txt + "Podcast [kolaboratzaileak=" + kolaboratzaileak + ", podcaster=" + podcaster + "]";
	}
}
