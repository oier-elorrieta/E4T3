package model.dao;

import java.sql.*;

import model.db.DB_Konexioa;
import model.objektuak.Gustokoa;

public class GustokoaDao {

	private Connection conex = null;

	/**
	 * Bezeroak gustokoak zerrendan abesti bat gehitzen edo kentzen duen metodoa. 
	 * Gustokoa dagoen konprobatu eta, hala badago, abestia gehitzen du. Bestela, 
	 * kentzen du.
	 *
	 * @param gustokoa Gustokoa objektua, ID_Bezeroa eta ID_Audioarekin.
	 * @return true gustokoak zerrendan sartu bada, bestela false.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public boolean gustokoaGehiKen(Gustokoa gustokoa) throws SQLException {
		boolean sartuta = gustokoaKonprobatu(gustokoa);

		if (sartuta) {
			gustokoaGehitu(gustokoa);
			DB_Konexioa.itxi();
			return true;
		} else {
			gustokoaKendu(gustokoa);
			DB_Konexioa.itxi();
			return false;
		}
	}

	/**
	 * Gustokoa dagoen konprobatzeko metodoa.
	 *
	 * @param gustokoa Gustokoa objektua, ID_Bezeroa eta ID_Audioarekin.
	 * @return true gustokoak zerrendan ez badago, bestela false.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public boolean gustokoaKonprobatu(Gustokoa gustokoa) throws SQLException {
		conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Gustokoak where ID_Bezeroa=" + gustokoa.getBezeroa().getId()
				+ " and ID_Audio='" + gustokoa.getAbestia().getIdAudio() + "';";
		ResultSet gustokoars = sentencia.executeQuery(kontsulta);
		if (!gustokoars.next()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Gustokoak zerrendan abesti bat gehitzeko metodoa.
	 *
	 * @param gustokoa Gustokoa objektua, ID_Bezeroa eta ID_Audioarekin.
	 * @return true abestia gehitu bada.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	private boolean gustokoaGehitu(Gustokoa gustokoa) throws SQLException {

		Statement sentencia = conex.createStatement();

		String kontsulta = "INSERT INTO Gustokoak (ID_Bezeroa, ID_Audio) values (" + gustokoa.getBezeroa().getId()
				+ ",'" + gustokoa.getAbestia().getIdAudio() + "')";
		sentencia.executeUpdate(kontsulta);
		return true;

	}

	/**
	 * Gustokoak zerrendatik abesti bat kentzeko metodoa.
	 *
	 * @param gustokoa Gustokoa objektua, ID_Bezeroa eta ID_Audioarekin.
	 * @return true abestia kendu bada.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	private boolean gustokoaKendu(Gustokoa gustokoa) throws SQLException {

		Statement sentencia = conex.createStatement();

		String kontsulta = "DELETE from Gustokoak where ID_Bezeroa=" + gustokoa.getBezeroa().getId() + " and ID_Audio='"
				+ gustokoa.getAbestia().getIdAudio() + "';";
		sentencia.executeUpdate(kontsulta);
		return true;

	}
}
