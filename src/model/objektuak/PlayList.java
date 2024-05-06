package model.objektuak;

import java.util.*;

import model.objektuak.bezero.Bezero;

public class PlayList {

	private String id;
	private String izena;
	private Date sorreraData;
	private Bezero bezeroa;
	private int abestiKont;
	private ArrayList<Abestia> abestiak;

	/**
     * PlayList-a sortzen du identifikadorearekin, izenarekin, sorrera datarekin, 
     * bezeroarekin, eta abesti zerrenda batekin.
     * 
     * @param id PlayList-aren identifikadorea
     * @param izena PlayList-aren izena
     * @param sorreraData PlayList-aren sorrera data
     * @param bezeroa PlayList-a sortu duen bezeroa
     * @param abestiak PlayList-eko abesti zerrenda
     */
    public PlayList(String id, String izena, Date sorreraData, Bezero bezeroa, ArrayList<Abestia> abestiak) {
        this.id = id;
        this.izena = izena;
        this.sorreraData = sorreraData;
        this.bezeroa = bezeroa;
        this.abestiak = abestiak;
    }

    /**
     * PlayList-a sortzen du identifikadorearekin, izenarekin, sorrera datarekin, 
     * eta bezeroarekin, abesti zerrendarik gabe.
     * 
     * @param id PlayList-aren identifikadorea
     * @param izena PlayList-aren izena
     * @param sorreraData PlayList-aren sorrera data
     * @param bezeroa PlayList-a sortu duen bezeroa
     */
    public PlayList(String id, String izena, Date sorreraData, Bezero bezeroa) {
        this.id = id;
        this.izena = izena;
        this.sorreraData = sorreraData;
        this.bezeroa = bezeroa;
    }

    /**
     * PlayList-a sortzen du identifikadorearekin, izenarekin, eta abesti 
     * kopuruarekin.
     * 
     * @param id PlayList-aren identifikadorea
     * @param izena PlayList-aren izena
     * @param abestiKont PlayList-eko abesti kopurua
     */
    public PlayList(String id, String izena, int abestiKont) {
        this.id = id;
        this.izena = izena;
        this.abestiKont = abestiKont;
    }

    /**
     * PlayList-aren identifikadorea itzultzen du.
     * 
     * @return PlayList-aren identifikadorea
     */
    public String getId() {
        return id;
    }

    /**
     * PlayList-aren identifikadorea ezartzen du.
     * 
     * @param id PlayList-aren identifikadorea
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * PlayList-aren izena itzultzen du.
     * 
     * @return PlayList-aren izena
     */
    public String getIzena() {
        return izena;
    }

    /**
     * PlayList-aren izena ezartzen du.
     * 
     * @param izena PlayList-aren izena
     */
    public void setIzena(String izena) {
        this.izena = izena;
    }

    /**
     * PlayList-aren sorrera data itzultzen du.
     * 
     * @return PlayList-aren sorrera data
     */
    public Date getSorreraData() {
        return sorreraData;
    }

    /**
     * PlayList-aren sorrera data ezartzen du.
     * 
     * @param sorreraData PlayList-aren sorrera data
     */
    public void setSorreraData(Date sorreraData) {
        this.sorreraData = sorreraData;
    }

    /**
     * PlayList-a sortu duen bezeroa itzultzen du.
     * 
     * @return PlayList-a sortu duen bezeroa
     */
    public Bezero getBezeroa() {
        return bezeroa;
    }

    /**
     * PlayList-a sortu duen bezeroa ezartzen du.
     * 
     * @param bezeroa PlayList-a sortu duen bezeroa
     */
    public void setBezeroa(Bezero bezeroa) {
        this.bezeroa = bezeroa;
    }

    /**
     * PlayList-eko abesti kopurua itzultzen du.
     * 
     * @return PlayList-eko abesti kopurua
     */
    public int getAbestiKont() {
        return abestiKont;
    }

    /**
     * PlayList-eko abesti kopurua ezartzen du.
     * 
     * @param abestiKont PlayList-eko abesti kopurua
     */
    public void setAbestiKont(int abestiKont) {
        this.abestiKont = abestiKont;
    }

    /**
     * PlayList-eko abestiak itzultzen ditu.
     * 
     * @return PlayList-eko abesti zerrenda
     */
    public ArrayList<Abestia> getAbestiak() {
        return abestiak;
    }

    /**
     * PlayList-eko abestiak ezartzen ditu.
     * 
     * @param abestiak PlayList-eko abesti zerrenda
     */
    public void setAbestiak(ArrayList<Abestia> abestiak) {
        this.abestiak = abestiak;
    }

    /**
     * PlayList objektuaren informazio laburra itzultzen du.
     * 
     * @return PlayList objektuaren informazio laburra
     */
    @Override
    public String toString() {
        return "PlayList [id=" + id + ", izena=" + izena + ", sorreraData=" + sorreraData 
               + ", bezeroa=" + bezeroa + ", abestiak=" + abestiak + "]";
    }

}
