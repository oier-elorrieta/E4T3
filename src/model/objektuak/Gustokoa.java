package model.objektuak;

import model.objektuak.bezero.Bezero;

public class Gustokoa {

	private Bezero bezeroa;
	private Audio abestia;

	public Gustokoa(Bezero bezeroa, Audio abestia) {
		this.bezeroa = bezeroa;
		this.abestia = abestia;
	}

	public Bezero getBezeroa() {
		return bezeroa;
	}

	public Audio getAbestia() {
		return abestia;
	}


}
