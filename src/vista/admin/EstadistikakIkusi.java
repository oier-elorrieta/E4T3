package vista.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.EstadistikakDao;
import model.objektuak.Estadistikak;
import model.objektuak.Musikaria;
import vista.bezeroa.playlist.NirePlaylist;
import vista.interfaseak.Header;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;

public class EstadistikakIkusi extends JFrame implements Header {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private EstadistikakDao estadistikakDao;
	ArrayList<Estadistikak> estadistikak;
	
	/**
	 * Create the frame.
	 */
	public EstadistikakIkusi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NirePlaylist.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		estadistikakDao = new EstadistikakDao();
		
		setContentPane(contentPane);

		headerKokatu("Estadistikak");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		try {
			estadistikak = estadistikakDao.getEstadistikak();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String[] stringAux = { "Musikaria", "Erreprodukzioa", "Eguneko erreprodukzioak", "Hilabeteko erreprodukzioak", "Urteko erreprodukzioak" };

		model = new DefaultTableModel();
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);
		model.setColumnIdentifiers(stringAux);

		scrollPane.setViewportView(table);
		Object[] aux = new Object[5];
		for (int i = 0; i < estadistikak.size(); i++) {
			aux[0] = estadistikak.get(i).getID_Audio();
			aux[1] = estadistikak.get(i).getIzena();
			aux[2] = estadistikak.get(i).getErreprodukzioKopEguna();
			aux[3] = estadistikak.get(i).getErreprodukzioKopHilabetea();
			aux[4] = estadistikak.get(i).getErreprodukzioKopUrtea();
			model.addRow(aux);
		}
	}

	@Override
	public void headerKokatu(String text) {
		contentPane.setLayout(new BorderLayout(0, 0));
		JPanel panelHeader = new JPanel();
		contentPane.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(0, 0));

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

		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblNewLabel, BorderLayout.CENTER);
		
	}

}
