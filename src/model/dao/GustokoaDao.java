package model.dao;

import java.sql.*;

import model.db.DB_Konexioa;
import model.objektuak.Gustokoa;

public class GustokoaDao {

	private Connection conex = null;

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

	private boolean gustokoaGehitu(Gustokoa gustokoa) throws SQLException {

		Statement sentencia = conex.createStatement();

		String kontsulta = "INSERT INTO Gustokoak (ID_Bezeroa, ID_Audio) values (" + gustokoa.getBezeroa().getId()
				+ ",'" + gustokoa.getAbestia().getIdAudio() + "')";
		sentencia.executeUpdate(kontsulta);
		return true;

	}

	private boolean gustokoaKendu(Gustokoa gustokoa) throws SQLException {

		Statement sentencia = conex.createStatement();

		String kontsulta = "DELETE from Gustokoak where ID_Bezeroa=" + gustokoa.getBezeroa().getId() + " and ID_Audio='"
				+ gustokoa.getAbestia().getIdAudio() + "';";
		sentencia.executeUpdate(kontsulta);
		return true;

	}
}
