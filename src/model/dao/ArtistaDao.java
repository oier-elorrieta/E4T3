package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import model.Aldagaiak;
import model.db.DB_Konexioa;
import model.objektuak.Artista;
import model.objektuak.Audio;
import model.objektuak.Hizkuntza;
import model.objektuak.Musikaria;
import model.objektuak.PlayList;

public class ArtistaDao {
	public ArrayList<Artista> getArtistak() throws SQLException {
		ArrayList<Artista> retArray = new ArrayList<>();
		Connection conex = DB_Konexioa.admin();

		Statement sentencia = conex.createStatement();

		String kontsulta = "select * from Musikaria";
		ResultSet artistak = sentencia.executeQuery(kontsulta);

		Artista ArtistaAux;

		while (artistak.next()) {
			ArtistaAux = new Musikaria(artistak.getString("ID_Musikaria"),artistak.getString("Izen_Artistikoa"));
			retArray.add(ArtistaAux);
		}

		DB_Konexioa.itxi();
		return retArray;
	}
	
	public String getLastId() throws SQLException {
		String ret = "";
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "select ID_Musikaria from Musikaria ORDER BY char_length(ID_Musikaria) desc, substr(ID_Musikaria,3) desc;";
		ResultSet lastID = sentencia.executeQuery(kontsulta);
		try {
			lastID.next();
			ret = lastID.getString(1);
			conex.close();
			return ret;	
		}catch(SQLException e) {
			ret = "MU0";
			return ret;
		}
		
		
	}
	
	public boolean artistaGehitu(Artista artista) throws SQLException {
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		Musikaria musikariAux = (Musikaria) artista;
		

		String kontsulta = "INSERT INTO Musikaria (ID_Musikaria, Izen_Artistikoa, Ezaugarria, Deskribapena) VALUES ('"+ artista.getId() + "', '" + artista.getIzen_Artistikoa() + "', '" + musikariAux.getEzaugarria() + "', '" + artista.getDeskribapena() + "');";
		sentencia.executeUpdate(kontsulta);
		
		DB_Konexioa.itxi();
		return true;

	}
	public boolean deleteArtistaByIzena(Artista artista) throws SQLException{
		Connection conex = DB_Konexioa.admin();
		
		Statement sentencia = conex.createStatement();
		
		String kontsulta = "DELETE from Musikaria where Izen_Artistikoa='" + artista.getIzen_Artistikoa() +"';";
		
		
		try {
			sentencia.executeUpdate(kontsulta);
			DB_Konexioa.itxi();
			return true;
		}catch (Exception ex) {
			ex.printStackTrace();
			DB_Konexioa.itxi();
			return false;
		}

	}
}
