package vista.bezeroa.playlist;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.Aldagaiak;
import model.dao.AbestiaDao;
import model.dao.PlayListDao;
import model.objektuak.Audio;
import model.objektuak.PlayList;
import vista.interfaseak.Header;

import java.awt.*;
import javax.swing.JTable;

public class NirePlaylist extends JFrame implements Header {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PlayListDao playlistdao = new PlayListDao();
	AbestiaDao abestiadao = new AbestiaDao();
	private JTable table;
	private DefaultTableModel model;
	
	ArrayList<PlayList> playlistak;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public NirePlaylist() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NirePlaylist.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		
		playlistak = new ArrayList<PlayList>();
	
		
		/* 	ARRAY DE MUSIKARIAK PARA RELLENAR EL VIEW, NOMBRE Y REPODUCCIONES, STRING, INT */
		playlistak = playlistdao.getPlayListak(true);
		
		/* TO DELETE */ System.out.println(playlistak);
		
		
		headerKokatu("Nire Playlist");

		JPanel panelKontenidoa = new JPanel();
		contentPane.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotoiak = new JPanel();
		panelKontenidoa.add(panelBotoiak, BorderLayout.EAST);
		panelBotoiak.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBerriaSortu = new JButton("Berria Sortu");
		
		
		JButton btnEzabatu = new JButton("Ezabatu");
		
		
		JButton btnImportatu = new JButton("Importatu");
		
		
		JButton btnExportatu = new JButton("Exportatu");
		
		JButton btnJarraitu = new JButton("Jarraitu");
		
		
		table = new JTable();
		
		String[] stringAux = {"Izena"};
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		model.setColumnIdentifiers(stringAux);
			
		panelKontenidoa.add(table, BorderLayout.CENTER);
		Object[] aux = new Object[1];

		for (int i = 0 ; i < playlistak.size(); i++) {
			aux[0] = playlistak.get(i).getIzena(); 
            model.addRow(aux);
		}
		

		
		btnBerriaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* METER LBEL O ALGO PARA PREGUNTAR EL NOMBRE DE LA PLAYLIST */
	
	
				String newIzena = JOptionPane.showInputDialog("Sartu izena mesedez");
	
		  
				String newID = "";
				try {
					newID = playlistdao.getLastId();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				newID = Funtzioak.gehituID(newID);
				Date newDate = new Date();
				PlayList newPlayList = new PlayList(newID,newIzena,newDate,Aldagaiak.erabiltzailea);
		
				
				try {
					if(playlistdao.newPlayList(newPlayList)) {
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiNirePlaylist();
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "Ezin dituzu playlist gehiago sortu premium izan gabe", "", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
				if (index != -1 && index != 0) {
					try {
						playlistdao.deletePlayListById(playlistak.get(index));
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiNirePlaylist();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Aukeratu playlist bat ezabatzeko mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
				
				
			}
		});
		
		btnImportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnExportatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnJarraitu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
				PlayList playlist = new PlayList();
				
				playlist = playlistak.get(index);
				
				if (index == -1) {
					JOptionPane.showMessageDialog(null, "Aukeratu playlist bat mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}else {
					ArrayList<Audio> abestiaAux = new ArrayList<Audio>();
					
					try {
						abestiaAux = abestiadao.getAbestiaByPlayListID(playlist);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					playlist.setAbestiak(abestiaAux);
					
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiAbestiakPlayList(playlist);
					dispose();
				}
				
				
			}
			
		});
		
		
		panelBotoiak.add(btnBerriaSortu);
		panelBotoiak.add(btnEzabatu);
		panelBotoiak.add(btnImportatu);
		panelBotoiak.add(btnExportatu);
		panelBotoiak.add(btnJarraitu);


	}

	@Override
	public void headerKokatu(String text) {
		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		

		// Erabiltzailearen izena bistaratzeko botoia
		JButton btnPerfil = new JButton(Aldagaiak.erabiltzailea.getErabiltzaileIzena());
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErregistroa();
				dispose();
			}
		});
		btnPerfil.setSize(325, 20);
		panelHeader.add(btnPerfil, BorderLayout.EAST);

		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiBezeroMenu();
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblNewLabel, BorderLayout.CENTER);
	}

}