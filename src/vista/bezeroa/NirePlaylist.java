package vista.bezeroa;

import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.PlayListDao;
import model.objektuak.PlayList;

import java.awt.*;
import javax.swing.JTable;

public class NirePlaylist extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	PlayListDao playlistdao = new PlayListDao();
	private JTable table;
	private DefaultTableModel model;

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

		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));
		
		ArrayList<PlayList> playlistak = new ArrayList<PlayList>();
	
		
		/* 	ARRAY DE MUSIKARIAK PARA RELLENAR EL VIEW, NOMBRE Y REPODUCCIONES, STRING, INT */
		playlistak = playlistdao.getPlayListak();
		
		/* TO DELETE */ System.out.println(playlistak);

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

		JLabel lblNewLabel = new JLabel("Nire Playlist");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panelKontenidoa = new JPanel();
		contentPane.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new BorderLayout(0, 0));
		
		JPanel panelBotoiak = new JPanel();
		panelKontenidoa.add(panelBotoiak, BorderLayout.EAST);
		panelBotoiak.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnBerriaSortu = new JButton("Berria Sortu");
		panelBotoiak.add(btnBerriaSortu);
		
		JButton btnEzabatu = new JButton("Ezabatu");
		panelBotoiak.add(btnEzabatu);
		
		JButton btnImportatu = new JButton("Importatu");
		panelBotoiak.add(btnImportatu);
		
		JButton btnExportatu = new JButton("Exportatu");
		panelBotoiak.add(btnExportatu);
		
		table = new JTable();
		
		String[] stringAux = {"Izena"};
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(table.getSelectedRow());
			}
		});
		model.setColumnIdentifiers(stringAux);
			
		panelKontenidoa.add(table, BorderLayout.CENTER);
		Object[] aux = new Object[1];
		
		for (int i = 0 ; i < playlistak.size(); i++) {
			aux[0] = playlistak.get(i).getIzena(); 
			
            model.addRow(aux);
		}

	}

}
