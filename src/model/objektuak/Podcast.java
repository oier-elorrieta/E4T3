package model.objektuak;

import java.util.Objects;

public class Podcast extends Audio {

	private String kolaboratzaileak;
	private Podcaster podcaster;

	public Podcast(String idAudio, String izena, int iraupena, String irudia, String kolaboratzaileak,
			Podcaster podcaster) {
		super(idAudio, izena, iraupena, irudia);
		this.kolaboratzaileak = kolaboratzaileak;
		this.podcaster = podcaster;
	}

	public String getKolaboratzaileak() {
		return kolaboratzaileak;
	}

	public void setKolaboratzaileak(String kolaboratzaileak) {
		this.kolaboratzaileak = kolaboratzaileak;
	}

	public Podcaster getPodcaster() {
		return podcaster;
	}

	public void setPodcaster(Podcaster podcaster) {
		this.podcaster = podcaster;
	}

	@Override
	public String toString() {
		String txt = "";
		txt = super.toString();

		return txt + "Podcast [kolaboratzaileak=" + kolaboratzaileak + ", podcaster=" + podcaster + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Podcast other = (Podcast) obj;
		return Objects.equals(kolaboratzaileak, other.kolaboratzaileak) && Objects.equals(podcaster, other.podcaster);
	}

}
