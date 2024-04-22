package model.objektuak;

import java.util.Date;
import java.util.Objects;

public class PlayList {

	private int id;
	private String izena;
	private Date sorreraData;
	private Bezero bezeroa;

	public PlayList(int id, String izena, Date sorreraData, Bezero bezeroa) {
		this.id = id;
		this.izena = izena;
		this.sorreraData = sorreraData;
		this.bezeroa = bezeroa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public Date getSorreraData() {
		return sorreraData;
	}

	public void setSorreraData(Date sorreraData) {
		this.sorreraData = sorreraData;
	}

	public Bezero getBezeroa() {
		return bezeroa;
	}

	public void setBezeroa(Bezero bezeroa) {
		this.bezeroa = bezeroa;
	}

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", izena=" + izena + ", sorreraData=" + sorreraData + ", bezeroa=" + bezeroa
				+ "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayList other = (PlayList) obj;
		return Objects.equals(bezeroa, other.bezeroa) && id == other.id && Objects.equals(izena, other.izena)
				&& Objects.equals(sorreraData, other.sorreraData);
	}

	

}