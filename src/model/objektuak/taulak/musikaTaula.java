package model.objektuak.taulak;

import java.awt.Button;

public class musikaTaula {
	
	private String izena;
	private int erreprodukzioak;
	private Button button;
	
	public musikaTaula() {
		
	}
	
	public musikaTaula(String izena, int erreprodukzioak, Button button) {
		super();
		this.izena = izena;
		this.erreprodukzioak = erreprodukzioak;
		this.button = button;
	}

	public String getIzena() {
		return izena;
	}


	public void setIzena(String izena) {
		this.izena = izena;
	}


	public int getErreprodukzioak() {
		return erreprodukzioak;
	}


	public void setErreprodukzioak(int erreprodukzioak) {
		this.erreprodukzioak = erreprodukzioak;
	}


	public Button getButton() {
		return button;
	}


	public void setButton(Button button) {
		this.button = button;
	}
	
}
