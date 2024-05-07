package model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.Audio;

public class ErreprodukzioaDao {
	public boolean erreprodukzioaGehitu(Audio audio) throws SQLException {
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		Date data = new Date();
		java.sql.Date sqlDate = new java.sql.Date(data.getTime());

		String kontsulta = "INSERT INTO Erreprodukzioak (ID_Bezeroa, ID_Audio, Fecha) values (" + Aldagaiak.erabiltzailea.getId()
				+ ",'" + audio.getIdAudio() + "','" + sqlDate + "')";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
		return true;

	}
}
