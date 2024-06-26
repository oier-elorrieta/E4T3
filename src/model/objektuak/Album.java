package model.objektuak;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Album {

	private String id;
	private String izenburua;
	private Date urtea;
	private String generoa;
	private Blob irudia;
	private String deskripzioa;
	private int kontAbestiak;
	private int iraupena;
	private Musikaria musikaria;
	private ArrayList<Abestia> abestiak;

	public Album(String id, String izenburua, Date urtea, int kontAbestiak, int iraupena, Blob irudia,
			String deskripzioa) {
		this.id = id;
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.kontAbestiak = kontAbestiak;
		this.iraupena = iraupena;
		this.irudia = irudia;
		this.deskripzioa = deskripzioa;
	}

	/**
	 * Albumaren eraikitzailea (konfiguratzaile osoa).
	 * 
	 * @param id        Albumaren identifikazioa.
	 * @param izenburua Albumaren izenburua.
	 * @param urtea     Albumaren argitalpen urtea.
	 * @param generoa   Albumaren genero musikala.
	 * @param irudia    Albumaren irudia.
	 * @param musikaria Albumarekin lotutako musikaria.
	 * @param abestiak  Albumak dituen abestien zerrenda.
	 */
	public Album(String id, String izenburua, Date urtea, String generoa, Blob irudia, Musikaria musikaria,
			ArrayList<Abestia> abestiak) {
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
	 * 
	 * @param id           Albumaren identifikazioa.
	 * @param izenburua    Albumaren izenburua.
	 * @param kontAbestiak Albumak dituen abestien kopurua.
	 */
	public Album(String id, String izenburua, int kontAbestiak) {
		this.id = id;
		this.izenburua = izenburua;
		this.kontAbestiak = kontAbestiak;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIzenburua() {
		return izenburua;
	}

	public void setIzenburua(String izenburua) {
		this.izenburua = izenburua;
	}

	public Date getUrtea() {
		return urtea;
	}

	public void setUrtea(Date urtea) {
		this.urtea = urtea;
	}

	public String getGeneroa() {
		return generoa;
	}

	public void setGeneroa(String generoa) {
		this.generoa = generoa;
	}

	public Blob getIrudia() {
		return irudia;
	}

	public void setIrudia(Blob irudia) {
		this.irudia = irudia;
	}

	public String getDeskripzioa() {
		return deskripzioa;
	}

	public void setDeskripzioa(String deskripzioa) {
		this.deskripzioa = deskripzioa;
	}

	public int getKontAbestiak() {
		return kontAbestiak;
	}

	public void setKontAbestiak(int kontAbestiak) {
		this.kontAbestiak = kontAbestiak;
	}

	public int getIraupena() {
		return iraupena;
	}

	public void setIraupena(int iraupena) {
		this.iraupena = iraupena;
	}

	public Musikaria getMusikaria() {
		return musikaria;
	}

	public void setMusikaria(Musikaria musikaria) {
		this.musikaria = musikaria;
	}

	public ArrayList<Abestia> getAbestiak() {
		return abestiak;
	}

	public void setAbestiak(ArrayList<Abestia> abestiak) {
		this.abestiak = abestiak;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", izenburua=" + izenburua + ", urtea=" + urtea + ", generoa=" + generoa
				+ ", irudia=" + irudia + ", musikaria=" + musikaria + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Album other = (Album) obj;
		return Objects.equals(abestiak, other.abestiak) && Objects.equals(deskripzioa, other.deskripzioa)
				&& Objects.equals(generoa, other.generoa) && Objects.equals(id, other.id) && iraupena == other.iraupena
				&& Objects.equals(izenburua, other.izenburua) && kontAbestiak == other.kontAbestiak
				&& Objects.equals(musikaria, other.musikaria) && Objects.equals(urtea, other.urtea);
	}

}
