package control.funtzioak;

import java.awt.Rectangle;
import java.util.ArrayList;

import model.Aldagaiak;
import model.objektuak.*;
import vista.*;
import vista.bezeroa.*;
import vista.bezeroa.musika.*;
import vista.bezeroa.playlist.NirePlaylist;
import vista.bezeroa.podcast.*;


/**
 * Kontrolatzaileak bistaren konfigurazioa kudeatzen duen klasea.
 */
public class FuntzioBista {

	/**
	 * Bistararen kokapena eta neurriak aldatzen dituen metodoa.
	 * @param kordenada Bistaren kokapena
	 * @param x Neurria X ardatzean
	 * @param y Neurria Y ardatzean
	 */
	public static void bistaAldatu(Rectangle kordenada, int x, int y) {
		kordenadak(kordenada);
		resoluzioa(x, y);
	}

	/**
	 * Bistararen kokapena aldatzen duen metodoa.
	 * @param kordenada Bistaren kokapena
	 */
	public static void kordenadak(Rectangle kordenada) {
		Aldagaiak.cordX = (int) kordenada.getX();
		Aldagaiak.cordY = (int) kordenada.getY();
	}

	/**
	 * Bistararen neurriak aldatzen dituen metodoa.
	 * @param x Neurria X ardatzean
	 * @param y Neurria Y ardatzean
	 */
	public static void resoluzioa(int x, int y) {
		Aldagaiak.resolucionX = x;
		Aldagaiak.resolucionY = y;
		if (x < 1000 || y < 650) {
			Aldagaiak.resolucionX = 1000;
			Aldagaiak.resolucionY = 650;
		}
	}

	/**
	 * Login bista irekitzen duen metodoa.
	 */
	public static void irekiLogin() {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Erregistro bista irekitzen duen metodoa.
	 */
	public static void irekiErregistroa(String botoiTextua) {
		try {
			Erregistroa frame = new Erregistroa(botoiTextua);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * BezeroMenu bista irekitzen duen metodoa.
	 */
	public static void irekiBezeroMenu() {
		try {
			BezeroMenu frame = new BezeroMenu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * MusikaDeskubritu bista irekitzen duen metodoa.
	 */
	public static void irekiMusikaDeskubritu() {
		try {
			MusikaDeskubritu frame = new MusikaDeskubritu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * PodcastDeskubritu bista irekitzen duen metodoa.
	 */
	public static void irekiPodcastDeskubritu() {
		try {
			PodcastDeskubritu frame = new PodcastDeskubritu();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * NirePlaylist bista irekitzen duen metodoa.
	 */
	public static void irekiNirePlaylist() {
		try {
			NirePlaylist frame = new NirePlaylist();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * AlbumDeskubritu bista irekitzen duen metodoa.
	 */
	public static void irekiAlbumDeskubritu(Musikaria musikaria) {
		try {
			AlbumDeskubritu frame = new AlbumDeskubritu(musikaria);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * MusikaIkusi bista irekitzen duen metodoa.
	 */
	public static void irekiMusikaIkusi(Musikaria musikaria, Album album) {
		try {
			MusikaIkusi frame = new MusikaIkusi(musikaria, album);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * PodcastIkusi bista irekitzen duen metodoa.
	 */
	public static void irekiPodcastIkusi(Podcaster podcasts) {
		try {
			PodcastIkusi frame = new PodcastIkusi(podcasts);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Erreprodukzioa bista irekitzen duen metodoa.
	 */
	public static void irekiErreprodukzioa(ArrayList<Audio> audioList, int index) {
		try {
			Erreprodukzioa frame = new Erreprodukzioa(audioList, index);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Iragarkia bista irekitzen duen metodoa.
	 */
	public static void irekiIragarkia(ArrayList<Audio> audioList, int index) {
		try {
			Iragarkia frame = new Iragarkia(audioList, index);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * MenuErreprodukzioa bista irekitzen duen metodoa.
	 */
	public static void irekiMenuErreprodukzioa(ArrayList<Audio> audioList, int index) {
		try {
			MenuErreprodukzioa frame = new MenuErreprodukzioa(audioList, index);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
