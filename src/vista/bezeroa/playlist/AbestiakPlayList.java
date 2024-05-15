package vista.bezeroa.playlist;

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
import model.dao.AbestiaDao;

import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import model.objektuak.*;
import vista.interfaseak.Header;

public class AbestiakPlayList extends JFrame implements Header {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	AbestiaDao abestiDao = new AbestiaDao();
	ArrayList<Audio> abestiList;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public AbestiakPlayList(PlayList playlist) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AbestiakPlayList.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		headerKokatu(playlist.getIzena() + "");

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panelTabla = new JPanel();
		panel_1.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel_1 = new JLabel(" ");
		panelTabla.add(lblNewLabel_1, BorderLayout.NORTH);

		JLabel lblNewLabel_2 = new JLabel(" ");
		panelTabla.add(lblNewLabel_2, BorderLayout.SOUTH);

		JLabel lblNewLabel_3 = new JLabel("      ");
		panelTabla.add(lblNewLabel_3, BorderLayout.WEST);

		JLabel lblNewLabel_4 = new JLabel("      ");
		panelTabla.add(lblNewLabel_4, BorderLayout.EAST);

		ImageIcon icon = null;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelTabla.add(scrollPane, BorderLayout.CENTER);

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
				int indexTable = table.getSelectedRow();
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				
				FuntzioBista.irekiErreprodukzioa(playlist.getAbestiak(), indexTable);
				dispose();
			}

		});
		model.setColumnIdentifiers(stringAux);

		scrollPane.setViewportView(table);
		Object[] aux = new Object[1];
		for (int i = 0; i < playlist.getAbestiak().size(); i++) {
			String iraupena = Funtzioak.secondsToString(playlist.getAbestiak().get(i).getIraupena());
			aux[0] = playlist.getAbestiak().get(i).getIzena() + " (" + iraupena + ")";
			model.addRow(aux);
		}
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
				FuntzioBista.irekiNirePlaylist();
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);

		JLabel lblAlbumIzena = new JLabel(text);
		lblAlbumIzena.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAlbumIzena.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblAlbumIzena, BorderLayout.CENTER);
	}
}
