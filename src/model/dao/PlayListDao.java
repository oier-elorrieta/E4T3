package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.Audio;
import model.objektuak.PlayList;

public class PlayListDao {
	
	/**
	 * Bezero baten playlist dituen bilatzen dituen metodo bat da.
	 * 
	 * @param Playlist objetua
	 * @return ArrayList playlist
	 * @throws SQLException
	 */
	public ArrayList<PlayList> getPlayListak() throws SQLException{
		ArrayList<PlayList> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.bezeroa();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from playListView where ID_Bezeroa =" + Aldagaiak.erabiltzailea.getId()+";";
		ResultSet playlistak = sentencia.executeQuery(kontsulta);

		PlayList playlistAux;

		while (playlistak.next()) {
			playlistAux = new PlayList(playlistak.getString("ID_List"), playlistak.getString("Izena"), playlistak.getInt("Abestiak"));
			retArray.add(playlistAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	/**
	 * Abesti bat playlist batean txertatzeko metodoa.
	 * 
	 * @param playlist PlayList objektua, zeina abestia gehituko duen.
	 * @param abestia Audio objektua, gehitu nahi dena.
	 * @throws SQLException SQL errore bat gertatzen bada.
	 */
	public void insertAbestiaIntoPlayList(PlayList playlist, Audio abestia) throws SQLException {
		Connection conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Playlist_Abestiak (ID_List, ID_Audio) VALUES ('"+ playlist.getId() + "', '" + abestia.getIdAudio() + "');";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
	}
}
