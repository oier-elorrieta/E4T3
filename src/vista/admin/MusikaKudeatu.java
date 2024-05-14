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
import model.dao.PlayListDao;
import model.objektuak.Abestia;
import model.objektuak.Artista;
import model.objektuak.Audio;
import model.objektuak.Musikaria;
import model.objektuak.PlayList;

import java.awt.*;

public class MusikaKudeatu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ArtistaDao artistadao = new ArtistaDao();
	private JTable table;
	private DefaultTableModel model;
	
	ArrayList<Artista> artistaList = new ArrayList<Artista>();

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MusikaKudeatu() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusikaKudeatu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		
		artistaList = artistadao.getArtistak();

		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiAdminMenu();
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);

		JLabel lblArtistak = new JLabel("Artistak kudeatu");
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

		for (int i = 0 ; i < artistaList.size(); i++) {
			aux[0] = artistaList.get(i).getIzen_Artistikoa(); 
            model.addRow(aux);
		}
		

		
		btnBerriaSortu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String newIzena = null;
				String newDeskribapena = null;
				String newEzaugarria = null;
				
				newIzena = JOptionPane.showInputDialog("Sartu izena mesedez");
				if(newIzena != null) {
					newDeskribapena = JOptionPane.showInputDialog("Sartu deskribapena mesedez");
				}
				
				if (newDeskribapena != null) {
					Object[] options = { "Bakarlaria", "Taldea" };

					int opcion = JOptionPane.showOptionDialog(null, "", "Aukeratu bat mesedez", JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					
					if(opcion == 0) {
						newEzaugarria = "Bakarlaria";
					}else {
						newEzaugarria = "Taldea";
					}
					String newID = "";
					try {
						newID = artistadao.getLastId();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					newID = Funtzioak.gehituID(newID);
					
					Artista artistaAux = new Musikaria(newID,newIzena,newDeskribapena,newEzaugarria);
					
					try {
						artistadao.artistaGehitu(artistaAux);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiMusikaKudeatu();
					dispose();
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
					JOptionPane.showMessageDialog(null, "Aukeratu artista bat ezabatzeko mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnEditatu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
				if (index != -1) {
					
					Musikaria musikaria = (Musikaria) artistaList.get(index);
					
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiEditMusikaria(musikaria);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Aukeratu artista bat mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		btnIkusi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				
				if (index != -1) {
					
					Musikaria musikaria = (Musikaria) artistaList.get(index);
					
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
					FuntzioBista.irekiAlbumKudeatu(musikaria);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Aukeratu artista bat mesedez", "", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		
		
		panelBotoiak.add(btnBerriaSortu);
		panelBotoiak.add(btnEzabatu);
		panelBotoiak.add(btnEditatu);
		panelBotoiak.add(btnIkusi);



	}

}