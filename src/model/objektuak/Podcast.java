package model.objektuak;

import java.sql.Blob;
import java.util.Objects;

public class Podcast extends Audio {

	private String kolaboratzaileak;
	private Podcaster podcaster;

	/**
	 * Podcast bat sortzen du identifikadorearekin, izenarekin, iraupenarekin,
	 * irudiarekin, kolaboratzaileekin eta podcaster batekin.
	 * 
	 * @param idAudio          Podcast-aren identifikadorea
	 * @param izena            Podcast-aren izena
	 * @param iraupena         Podcast-aren iraupena segundoetan
	 * @param irudia           Podcast-aren irudia
	 * @param kolaboratzaileak Podcast-eko kolaboratzaileen izenak
	 * @param podcaster        Podcast-eko podcasterra
	 */
	public Podcast(String idAudio, String izena, int iraupena, Blob irudia, String kolaboratzaileak,
			Podcaster podcaster) {
		super(idAudio, izena, iraupena, irudia);
		this.kolaboratzaileak = kolaboratzaileak;
		this.podcaster = podcaster;
	}

	public Podcast(String idAudio, String izena, int iraupena, String kolaboratzaileak, Blob irudia) {
		super(idAudio, izena, iraupena);
		this.kolaboratzaileak = kolaboratzaileak;
		this.irudia = irudia;
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

	/**
	 * Podcast objektuaren informazio laburra itzultzen du.
	 * 
	 * @return Podcast objektuaren informazio laburra
	 */
	@Override
	public String toString() {
		String txt = super.toString();
		return txt + " Podcast [kolaboratzaileak=" + kolaboratzaileak + ", podcaster=" + podcaster + "]";
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
