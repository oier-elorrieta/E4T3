package model.objektuak;

public class Podcast extends Audio {

	private String kolaboratzaileak;
	private Podcaster podcaster;

	/**
     * Podcast bat sortzen du identifikadorearekin, izenarekin, iraupenarekin,
     * irudiarekin, kolaboratzaileekin eta podcaster batekin.
     * 
     * @param idAudio Podcast-aren identifikadorea
     * @param izena Podcast-aren izena
     * @param iraupena Podcast-aren iraupena segundoetan
     * @param irudia Podcast-aren irudia
     * @param kolaboratzaileak Podcast-eko kolaboratzaileen izenak
     * @param podcaster Podcast-eko podcasterra
     */
    public Podcast(String idAudio, String izena, int iraupena, String irudia, String kolaboratzaileak, Podcaster podcaster) {
        super(idAudio, izena, iraupena, irudia);
        this.kolaboratzaileak = kolaboratzaileak;
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
        return txt + " Podcast [kolaboratzaileak=" + kolaboratzaileak 
                     + ", podcaster=" + podcaster + "]";
    }
}
