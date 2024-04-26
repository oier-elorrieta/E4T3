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
	private int kontAbestiak;
	private int iraupena;
	private Musikaria musikaria;
	private ArrayList<Abestia> abestiak;
	

	public Album(String id, String izenburua, Date urtea, int kontAbestiak, int iraupena ,Blob irudia) {
		this.id = id;
		this.izenburua = izenburua;
		this.urtea = urtea;
		this.kontAbestiak = kontAbestiak;
		this.iraupena = iraupena;
		this.irudia = irudia;
	}
	
	public Album(String id, String izenburua,int kontAbestiak) {
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
	
	public int getKontAbestiak() {
		return kontAbestiak;
	}

	public void setKontAbestiak(int kontAbestiak) {
		this.kontAbestiak = kontAbestiak;
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
		return Objects.equals(generoa, other.generoa) && Objects.equals(id, other.id)
				&& Objects.equals(irudia, other.irudia) && Objects.equals(izenburua, other.izenburua)
				&& Objects.equals(musikaria, other.musikaria) && Objects.equals(urtea, other.urtea);
	}

}
