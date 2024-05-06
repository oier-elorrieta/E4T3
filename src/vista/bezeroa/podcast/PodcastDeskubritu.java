package vista.bezeroa.podcast;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.PodcasterDao;
import model.objektuak.*;

public class PodcastDeskubritu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	PodcasterDao podcasterdao = new PodcasterDao();
	ArrayList<Podcaster> podcasters;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public PodcastDeskubritu() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PodcastDeskubritu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		podcasters = new ArrayList<Podcaster>();
	
		
		/* 	ARRAY DE PODCASTERS PARA RELLENAR EL VIEW, NOMBRE Y REPODUCCIONES, STRING, INT */
		podcasters = podcasterdao.getPodcaster();
		
		/* TO DELETE */ System.out.println(podcasters);

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
				FuntzioBista.irekiBezeroMenu();
				dispose();
			}
		});
		panel.add(btnAtzera, BorderLayout.WEST);

		JLabel lblNewLabel = new JLabel("Podcast deskubritu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblNewLabel_1 = new JLabel("          ");
		panel_2.add(lblNewLabel_1, BorderLayout.WEST);
		
		JLabel lblNewLabel_2 = new JLabel("          ");
		panel_2.add(lblNewLabel_2, BorderLayout.EAST);
		
		JLabel lblNewLabel_3 = new JLabel("  ");
		panel_2.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		panel_2.add(lblNewLabel_4, BorderLayout.SOUTH);

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		String[] stringAux = {"Musikaria", "Erreprodukzioa"};
		
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
				String podcasterIzena = podcasters.get(index).getIzen_Artistikoa();
				
				Podcaster podcast = null;
				try {
					podcast = podcasterdao.getPodcasterByIzena(podcasterIzena);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiPodcastIkusi(podcast);
				dispose();
			}
		});
		model.setColumnIdentifiers(stringAux);
			
		scrollPane.setViewportView(table);
		Object[] aux = new Object[2];
		for (int i = 0 ; i < podcasters.size(); i++) {
			aux[0] = podcasters.get(i).getIzen_Artistikoa();
			aux[1] = podcasters.get(i).getErreprodukzioak();
			
            model.addRow(aux);
        }

	}

}
