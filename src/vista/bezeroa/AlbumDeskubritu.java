package vista.bezeroa;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.Aldagaiak;
import model.dao.AlbumDao;
import model.objektuak.Musikaria;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import model.objektuak.*;

public class AlbumDeskubritu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	AlbumDao albumdao = new AlbumDao();

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public AlbumDeskubritu(Musikaria musikaria) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusikaDeskubritu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		ArrayList<Album> albumak = albumdao.getAlbumakByMusikaria(musikaria);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

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
		panel.add(btnPerfil, BorderLayout.EAST);

		// Atzera botoia
		JButton btnAtzera = new JButton("Atzera");
		btnAtzera.setSize(325, 20);
		btnAtzera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiMusikaDeskubritu();
				dispose();
			}
		});
		panel.add(btnAtzera, BorderLayout.WEST);

		JLabel lblIzenArtistikoa = new JLabel(musikaria.getIzen_Artistikoa() + "-aren Albumak");
		lblIzenArtistikoa.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblIzenArtistikoa.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblIzenArtistikoa, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel panelAlbumTabla = new JPanel();
		panel_1.add(panelAlbumTabla);
		panelAlbumTabla.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel(" ");
		panelAlbumTabla.add(lblNewLabel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel(" ");
		panelAlbumTabla.add(lblNewLabel_2, BorderLayout.SOUTH);

		JLabel lblNewLabel_3 = new JLabel("      ");
		panelAlbumTabla.add(lblNewLabel_3, BorderLayout.WEST);

		JLabel lblNewLabel_4 = new JLabel("      ");
		panelAlbumTabla.add(lblNewLabel_4, BorderLayout.EAST);

		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JTextPane textPaneDeskripzioa = new JTextPane();
		textPaneDeskripzioa.setEditable(false);
		textPaneDeskripzioa.setFocusable(false);
		textPaneDeskripzioa.setText("Mota: " + musikaria.getEzaugarria() + "\n" + musikaria.getDeskribapena());
		panel_4.add(textPaneDeskripzioa, BorderLayout.CENTER);

		JLabel lblNewLabel_5 = new JLabel(" ");
		panel_4.add(lblNewLabel_5, BorderLayout.NORTH);

		JLabel lblNewLabel_6 = new JLabel(" ");
		panel_4.add(lblNewLabel_6, BorderLayout.SOUTH);

		JLabel lblNewLabel_7 = new JLabel("      ");
		panel_4.add(lblNewLabel_7, BorderLayout.WEST);

		JLabel lblNewLabel_8 = new JLabel("      ");
		panel_4.add(lblNewLabel_8, BorderLayout.EAST);

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(musikaria.getIrudia().getBytes(1, (int) musikaria.getIrudia().length()));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JLabel lblIrudia = new JLabel("");
		lblIrudia.setHorizontalAlignment(SwingConstants.CENTER);
		lblIrudia.setIcon(icon);
		panel_5.add(lblIrudia, BorderLayout.CENTER);

		JLabel lblNewLabel_10 = new JLabel(" ");
		panel_5.add(lblNewLabel_10, BorderLayout.NORTH);

		JLabel lblNewLabel_11 = new JLabel("      ");
		panel_5.add(lblNewLabel_11, BorderLayout.WEST);

		JLabel lblNewLabel_12 = new JLabel(" ");
		panel_5.add(lblNewLabel_12, BorderLayout.SOUTH);

		JLabel lblNewLabel_13 = new JLabel("      ");
		panel_5.add(lblNewLabel_13, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelAlbumTabla.add(scrollPane, BorderLayout.CENTER);

		// **************************************************************************
		String[] stringAux = { "ABESTIAK" };

		model = new DefaultTableModel();
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();

				String albumID = albumak.get(index).getId();

				@SuppressWarnings("unused")
				String albumIzena = albumak.get(index).getIzenburua();

				Album album = null;
				try {
					album = albumdao.getAlbumById(albumID);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiMusikaIkusi(musikaria, album);
				dispose();
			}

		});
		model.setColumnIdentifiers(stringAux);

		scrollPane.setViewportView(table);
		Object[] aux = new Object[1];
		for (int i = 0; i < albumak.size(); i++) {
			aux[0] = albumak.get(i).getIzenburua() + " (" + albumak.get(i).getKontAbestiak() + ")";
			model.addRow(aux);

		}
	}
}
