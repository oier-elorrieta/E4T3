package model.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import control.salbuespenak.abestiaExists;
import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.Audio;
import model.objektuak.PlayList;

public class PlayListDao {
	Connection conex;
		
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
	public boolean insertAbestiaIntoPlayList(PlayList playlist, Audio abestia)  {
		try {
		conex = DB_Konexioa.bezeroa();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "INSERT INTO Playlist_Abestiak (ID_List, ID_Audio) VALUES ('"+ playlist.getId() + "', '" + abestia.getIdAudio() + "');";
		if(abestiaInPlaylist(playlist,abestia)) {
			throw new abestiaExists();
		}
	
		sentencia.executeUpdate(kontsulta);
		}catch(abestiaExists ae) {
			JOptionPane.showMessageDialog(null, "Abesti hau sure playlistean daukazu", "", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}catch(SQLException ex) {
			return false;
		}
		try {
			DB_Konexioa.itxi();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	private boolean abestiaInPlaylist(PlayList playlist, Audio abestia) throws SQLException{
		
		Statement sent = conex.createStatement();
		String kontsulta = "select * from Playlist_Abestiak where ID_List ='" + playlist.getId() + "' and ID_Audio ='" + abestia.getIdAudio() + "';";
		
		ResultSet aux = sent.executeQuery(kontsulta);
		
		if(aux.next()) {
			return true;
		}else {
			return false;
		}
		
	}
}
