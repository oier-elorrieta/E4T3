package model.objektuak;

import java.util.Objects;

public class Estadistikak {
	
	private String ID_Audio;
	private String izena;
	private int erreprodukzioKopEguna;
	private int erreprodukzioKopHilabetea;
	private int erreprodukzioKopUrtea;
	
	
	public Estadistikak(String ID_Audio, String izena, int erreprodukzioKopEguna, int erreprodukzioKopHilabetea, int erreprodukzioKopUrtea) {
		this.ID_Audio = ID_Audio;
		this.izena = izena;
		this.erreprodukzioKopEguna = erreprodukzioKopEguna;
		this.erreprodukzioKopHilabetea = erreprodukzioKopHilabetea;
		this.erreprodukzioKopUrtea = erreprodukzioKopUrtea;
	}


	public String getID_Audio() {
		return ID_Audio;
	}


	public void setID_Audio(String iD_Audio) {
		ID_Audio = iD_Audio;
	}

	
	public String getIzena() {
		return izena;
	}


	public void setIzena(String izena) {
		this.izena = izena;
	}

	public int getErreprodukzioKopEguna() {
		return erreprodukzioKopEguna;
	}


	public void setErreprodukzioKopEguna(int erreprodukzioKopEguna) {
		this.erreprodukzioKopEguna = erreprodukzioKopEguna;
	}


	public int getErreprodukzioKopHilabetea() {
		return erreprodukzioKopHilabetea;
	}


	public void setErreprodukzioKopHilabetea(int erreprodukzioKopHilabetea) {
		this.erreprodukzioKopHilabetea = erreprodukzioKopHilabetea;
	}


	public int getErreprodukzioKopUrtea() {
		return erreprodukzioKopUrtea;
	}


	public void setErreprodukzioKopUrtea(int erreprodukzioKopUrtea) {
		this.erreprodukzioKopUrtea = erreprodukzioKopUrtea;
	}


	@Override
	public String toString() {
		return "Estadiktikak [ID_Audio=" + ID_Audio + ", erreprodukzioKopEguna=" + erreprodukzioKopEguna
				+ ", erreprodukzioKopHilabetea=" + erreprodukzioKopHilabetea + ", erreprodukzioKopUrtea="
				+ erreprodukzioKopUrtea + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadistikak other = (Estadistikak) obj;
		return Objects.equals(ID_Audio, other.ID_Audio) && erreprodukzioKopEguna == other.erreprodukzioKopEguna
				&& erreprodukzioKopHilabetea == other.erreprodukzioKopHilabetea
				&& erreprodukzioKopUrtea == other.erreprodukzioKopUrtea && Objects.equals(izena, other.izena);
	}
	
}
