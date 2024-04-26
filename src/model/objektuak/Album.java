package model.objektuak;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Album {

	private String id;
	private String izenburua;
	private Date urtea;
	private String generoa;
	private String irudia;
	private int kontAbestiak;
	private Musikaria musikaria;
	private ArrayList<Abestia> abestiak;

	/**
     * Albumaren eraikitzailea (konfiguratzaile osoa).
     * @param id Albumaren identifikazioa.
     * @param izenburua Albumaren izenburua.
     * @param urtea Albumaren argitalpen urtea.
     * @param generoa Albumaren genero musikala.
     * @param irudia Albumaren irudia.
     * @param musikaria Albumarekin lotutako musikaria.
     * @param abestiak Albumak dituen abestien zerrenda.
     */
    public Album(String id, String izenburua, Date urtea, String generoa, String irudia, Musikaria musikaria, ArrayList<Abestia> abestiak) {
        this.id = id;
        this.izenburua = izenburua;
        this.urtea = urtea;
        this.generoa = generoa;
        this.irudia = irudia;
        this.musikaria = musikaria;
        this.abestiak = abestiak;
    }

    /**
     * Albumaren eraikitzailea (konfigurazio minimoa).
     * @param id Albumaren identifikazioa.
     * @param izenburua Albumaren izenburua.
     * @param kontAbestiak Albumak dituen abestien kopurua.
     */
    public Album(String id, String izenburua, int kontAbestiak) {
        this.id = id;
        this.izenburua = izenburua;
        this.setKontAbestiak(kontAbestiak);
    }

    /**
     * Albumaren identifikazioa lortzen du.
     * @return Albumaren identifikazioa.
     */
    public String getId() {
        return id;
    }

    /**
     * Albumaren identifikazioa ezartzen du.
     * @param id Albumaren identifikazioa.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Albumaren izenburua lortzen du.
     * @return Albumaren izenburua.
     */
    public String getIzenburua() {
        return izenburua;
    }

    /**
     * Albumaren izenburua ezartzen du.
     * @param izenburua Albumaren izenburua.
     */
    public void setIzenburua(String izenburua) {
        this.izenburua = izenburua;
    }

    /**
     * Albumaren argitalpen urtea lortzen du.
     * @return Albumaren urtea.
     */
    public Date getUrtea() {
        return urtea;
    }

    /**
     * Albumaren argitalpen urtea ezartzen du.
     * @param urtea Albumaren urtea.
     */
    public void setUrtea(Date urtea) {
        this.urtea = urtea;
    }

    /**
     * Albumaren genero musikala lortzen du.
     * @return Albumaren generoa.
     */
    public String getGeneroa() {
        return generoa;
    }

    /**
     * Albumaren genero musikala ezartzen du.
     * @param generoa Albumaren generoa.
     */
    public void setGeneroa(String generoa) {
        this.generoa = generoa;
    }

    /**
     * Albumaren irudia lortzen du.
     * @return Albumaren irudia.
     */
    public String getIrudia() {
        return irudia;
    }

    /**
     * Albumaren irudia ezartzen du.
     * @param irudia Albumaren irudia.
     */
    public void setIrudia(String irudia) {
        this.irudia = irudia;
    }

    /**
     * Albumarekin lotutako musikaria lortzen du.
     * @return Albumaren musikaria.
     */
    public Musikaria getMusikaria() {
        return musikaria;
    }

    /**
     * Albumaren musikaria ezartzen du.
     * @param musikaria Albumaren musikaria.
     */
    public void setMusikaria(Musikaria musikaria) {
        this.musikaria = musikaria;
    }

    /**
     * Albumaren abestien zerrenda lortzen du.
     * @return Albumak dituen abestiak.
     */
    public ArrayList<Abestia> getAbestiak() {
        return abestiak;
    }

    /**
     * Albumaren abestien zerrenda ezartzen du.
     * @param abestiak Albumak dituen abestiak.
     */
    public void setAbestiak(ArrayList<Abestia> abestiak) {
        this.abestiak = abestiak;
    }

    /**
     * Albumaren deskribapen laburra.
     * @return Albumaren deskribapena.
     */
    @Override
    public String toString() {
        return "Album [id=" + id + ", izenburua=" + izenburua + ", urtea=" + urtea + ", generoa=" + generoa + ", irudia=" + irudia + ", musikaria=" + musikaria + "]";
    }

    /**
     * Albumaren berdintasuna egiaztatzeko.
     * @param obj Konparatzeko objektua.
     * @return Albumak berdinak diren ala ez.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Album other = (Album) obj;
        return Objects.equals(generoa, other.generoa) && Objects.equals(id, other.id) && Objects.equals(irudia, other.irudia) && Objects.equals(izenburua, other.izenburua) && Objects.equals(musikaria, other.musikaria) && Objects.equals(urtea, other.urtea);
    }

	public int getKontAbestiak() {
		return kontAbestiak;
	}

	public void setKontAbestiak(int kontAbestiak) {
		this.kontAbestiak = kontAbestiak;
	}

}
