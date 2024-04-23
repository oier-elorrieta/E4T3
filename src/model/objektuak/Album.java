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
	private Musikaria musikaria;
	private ArrayList<Abestia> abestiak;

	public Album(String id, String izenburua, Date urtea, String generoa, String irudia, Musikaria musikaria,
			ArrayList<Abestia> abestiak) {
		super();
		this.id = id;
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.generoa = generoa;
		this.irudia = irudia;
		this.musikaria = musikaria;
		this.abestiak = abestiak;
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

	public String getIrudia() {
		return irudia;
	}

	public void setIrudia(String irudia) {
		this.irudia = irudia;
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
				+ ", irudia=" + irudia + ", musikaria=" + musikaria + ", abestiak=" + abestiak + "]";
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
		return Objects.equals(abestiak, other.abestiak) && Objects.equals(generoa, other.generoa)
				&& Objects.equals(id, other.id) && Objects.equals(irudia, other.irudia)
				&& Objects.equals(izenburua, other.izenburua) && Objects.equals(musikaria, other.musikaria)
				&& Objects.equals(urtea, other.urtea);
	}

}