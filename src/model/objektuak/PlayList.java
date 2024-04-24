package model.objektuak;

import java.util.Date;
import java.util.Objects;
import java.util.ArrayList;

import model.objektuak.bezero.Bezero;

public class PlayList {

	private String id;
	private String izena;
	private Date sorreraData;
	private Bezero bezeroa;
	private ArrayList<Abestia> abestiak;

	public PlayList(String id, String izena, Date sorreraData, Bezero bezeroa, ArrayList<Abestia> abestiak) {
		this.id = id;
		this.izena = izena;
		this.sorreraData = sorreraData;
		this.bezeroa = bezeroa;
		this.abestiak = abestiak;
	}
	
	public PlayList(String id, String izena, Date sorreraData, Bezero bezeroa) {
		this.id = id;
		this.izena = izena;
		this.sorreraData = sorreraData;
		this.bezeroa = bezeroa;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public ArrayList<Abestia> getAbestiak() {
		return abestiak;
	}

	public void setAbestiak(ArrayList<Abestia> abestiak) {
		this.abestiak = abestiak;
	}

	@Override
	public String toString() {
		return "PlayList [id=" + id + ", izena=" + izena + ", sorreraData=" + sorreraData + ", bezeroa=" + bezeroa
				+ ", abestiak=" + abestiak + "]";
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
