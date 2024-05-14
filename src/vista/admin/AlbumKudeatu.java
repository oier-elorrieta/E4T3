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
import model.dao.AlbumDao;
import model.dao.ArtistaDao;
import model.dao.PlayListDao;
import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Artista;
import model.objektuak.Audio;
import model.objektuak.Musikaria;
import model.objektuak.PlayList;

import java.awt.*;

public class AlbumKudeatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	AlbumDao albumdao = new AlbumDao();
	private JTable table;
	private DefaultTableModel model;
	
	ArrayList<Album> albumList = new ArrayList<Album>();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AlbumKudeatu(Musikaria musikaria) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlbumKudeatu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		albumList = albumdao.getAlbumakByMusikaria(musikaria);
		
		

		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiMusikaKudeatu();
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);

		JLabel lblArtistak = new JLabel("Albumak kudeatu");
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
		
		
		JButton btnIkusi = new JButton("Ikusi");

		
		table = new JTable();
		
		String[] stringAux = {"Izena"};
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		model.setColumnIdentifiers(stringAux);
			
		panelKontenidoa.add(table, BorderLayout.CENTER);
		Object[] aux = new Object[1];

		for (int i = 0 ; i < albumList.size(); i++) {
			aux[0] = albumList.get(i).getIzenburua(); 
            model.addRow(aux);
		}
		

		
		btnBerriaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newIzena = null;
				Date newUrtea = new Date();
				String newUrteast = null;
				String newGeneroa = null;
				String newDeskripzioa = null;
				
				boolean tc = true;
				
				
				newIzena = JOptionPane.showInputDialog("Sartu izena mesedez");
				
				if(newIzena != null) {
					
					do {
						
						if (newUrtea == null) {
							JOptionPane.showMessageDialog(null, "Baliozko data bat sartu mesedez", "", JOptionPane.ERROR_MESSAGE);
						}
						newUrteast = JOptionPane.showInputDialog("Sartu urtea mesedez (YYYY-MM-DD)");
						if (newUrtea != null) {
							newUrtea = Funtzioak.stringToDate(newUrteast);
							Date dateAux = new Date();
							int dataTest = newUrtea.compareTo(dateAux);
							if(dataTest == 0 || dataTest > 0) {
								newUrtea = null;
							}
						}
						newUrtea = new Date();
					}while(newUrtea == null);
					
			
					
					if(newUrteast != null) {
						newGeneroa = JOptionPane.showInputDialog("Sartu Generoa mesedez");
						if(newGeneroa != null) {
							newDeskripzioa = JOptionPane.showInputDialog("Sartu deskripzioa mesedez");
							if (newDeskripzioa != null) {
								String newID = "";
								try {
									newID = albumdao.getLastId();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								newID = Funtzioak.gehituID(newID);
								
								Album albumAux = new Album(newID,newIzena,newUrtea,newGeneroa,newDeskripzioa);
								
								try {
									albumdao.newAlbum(albumAux,musikaria);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								try {
									albumList = albumdao.getAlbumakByMusikaria(musikaria);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
								FuntzioBista.irekiAlbumKudeatu(musikaria);
								dispose();
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
						artistadao.deleteArtistaByIzena(artistaList.get(index));
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiMusikaKudeatu();
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Aukeratu artista batº ezabatzeko mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
		panelBotoiak.add(btnBerriaSortu);
		panelBotoiak.add(btnEzabatu);
		panelBotoiak.add(btnEditatu);
		panelBotoiak.add(btnIkusi);



	}

}
