package vista.admin;

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
import model.dao.ArtistaDao;
import model.dao.AudioDao;
import model.dao.PlayListDao;
import model.dao.PodcastDao;
import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Artista;
import model.objektuak.Audio;
import model.objektuak.Musikaria;
import model.objektuak.PlayList;
import model.objektuak.Podcaster;

import java.awt.*;

public class PodcastKudeatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	AudioDao audiodao = new AudioDao();
	PodcastDao podcastdao = new PodcastDao();
	private JTable table;
	private DefaultTableModel model;
	
	ArrayList<Audio> audioList = new ArrayList<Audio>();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PodcastKudeatu(Podcaster podcaster) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PodcastKudeatu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		
		audioList = podcastdao.getPodcastByPodcasterId(podcaster);

		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiPodcasterKudeatu();
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);

		JLabel lblArtistak = new JLabel("Podcast kudeatu");
		lblArtistak.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblArtistak.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblArtistak, BorderLayout.CENTER);

		JPanel panelKontenidoa = new JPanel();
		contentPane.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotoiak = new JPanel();
		panelKontenidoa.add(panelBotoiak, BorderLayout.EAST);
		panelBotoiak.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBerriaSortu = new JButton("Berria Sortu");
		
		
		JButton btnEzabatu = new JButton("Ezabatu");
		JButton btnEditatu = new JButton("Editatu");
		
		

		
		table = new JTable();
		
		String[] stringAux = {"Izena"};
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		model.setColumnIdentifiers(stringAux);
			
		panelKontenidoa.add(table, BorderLayout.CENTER);
		Object[] aux = new Object[1];

		for (int i = 0 ; i < audioList.size(); i++) {
			aux[0] = audioList.get(i).getIzena(); 
            model.addRow(aux);
		}
		

		
		btnBerriaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newIzena = null;
				String newDenborast = null;
				String newDeskribapena = null;
				int newDenbora = 0;
			
			
				
				newIzena = JOptionPane.showInputDialog("Sartu izena mesedez");
				if(newIzena != null) {
					
					newDeskribapena = JOptionPane.showInputDialog("Sartu deskribapena mesedez");
					if (newDeskribapena != null) {
					
					newDenborast = JOptionPane.showInputDialog("Sartu denbora (segundutan)");
					
					if(newDenborast != null) {
						
						newDenbora = Funtzioak.stringToInt(newDenborast);
						if(newDenbora != -1) {
							String newID = "";
							try {
								newID = audiodao.getLastId();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							newID = Funtzioak.gehituID(newID);
							
							Audio audioAux = new Abestia(newID,newIzena,newDenbora,newDeskribapena);
							
							try {
								audiodao.audioGehitu(audioAux);
								abestiadao.abestiaGehitu(audioAux, album);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
							FuntzioBista.irekiAbestiaKudeatu(album,musikariAux);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "Denbora ondo sartu mesedez", "", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					}
					
					
				}
				
			}
		});
		
		btnEzabatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
				if (index != -1) {
					try {
						audiodao.deleteAudioById(audioList.get(index));
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiAbestiaKudeatu(album, musikariAux);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Aukeratu abesti bat ezabatzeko mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
				if (index != -1) {
					
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiEditAbestia(audioList.get(index));
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Aukeratu abesti bat mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
	
		
		
		panelBotoiak.add(btnBerriaSortu);
		panelBotoiak.add(btnEzabatu);
		panelBotoiak.add(btnEditatu);




	}
}