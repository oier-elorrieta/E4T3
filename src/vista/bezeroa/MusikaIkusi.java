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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.AlbumDao;
import model.dao.PodcastDao;
import model.objektuak.Musikaria;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextPane;
import model.objektuak.*;

public class MusikaIkusi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	PodcastDao podcastDao = new PodcastDao();
	ArrayList <Audio> audioList;
	
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MusikaIkusi(Podcaster podcasts) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MusikaDeskubritu.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		audioList = new ArrayList<Audio>();
		audioList = podcastDao.getPodcastByPodcasterId(podcasts);
		
		
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
				FuntzioBista.irekiAlbumDeskubritu(null);
				dispose();
			}
		});
		panelHeader.add(btnAtzera, BorderLayout.WEST);
		
		JLabel lblNewLabel = new JLabel(podcasts.getIzen_Artistikoa() + "-aren musika");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panelHeader.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JPanel panelPodcastTabla = new JPanel();
		panel_1.add(panelPodcastTabla);
		panelPodcastTabla.setLayout(new BorderLayout(0, 0));
		
		
		String[] stringAux = {""};
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(25);
		panelPodcastTabla.add(table, BorderLayout.CENTER);
		table.getTableHeader().setReorderingAllowed(false);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				@SuppressWarnings("unused")
				String podcastIzena = podcasts.get(index) + "";
				
				Podcast podcast = null;
				try {
					podcast = podcasts.getIzen_Artistikoa(podcastIzena);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErreprodukzioa(null);
				dispose();
			}
		});
		model.setColumnIdentifiers(stringAux);
		
		Object[] aux = new Object[2];
		for (int i = 0 ; i < podcastList.size(); i++) {
			aux[0] = podcastList.get(i).getIzena() + " (" + podcastList.get(i).getIraupena() + ")";
			System.out.println(podcastList);
            model.addRow(aux);
        }
		System.out.println(podcasts);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panelPodcastTabla.add(lblNewLabel_1, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		panelPodcastTabla.add(lblNewLabel_2, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_3 = new JLabel("      ");
		panelPodcastTabla.add(lblNewLabel_3, BorderLayout.WEST);
		
		JLabel lblNewLabel_4 = new JLabel("      ");
		panelPodcastTabla.add(lblNewLabel_4, BorderLayout.EAST);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPaneDeskripzioa = new JTextPane();
		textPaneDeskripzioa.setEditable(false);
		//textPaneDeskripzioa.setText("Mota: " + podcasts.getEzaugarria() + "\n" + podcasts.getDeskribapena());
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
		
		/*
		ImageIcon icon = null;
		try {
			icon = new ImageIcon(podcasts.getIrudia().getBytes(1, (int) podcasts.getIrudia().length()));
		} catch (SQLException e1) {
			 TODO Auto-generated catch block
			e1.printStackTrace();
		}
		*/
		
		JLabel lblIrudia = new JLabel("");
		lblIrudia.setHorizontalAlignment(SwingConstants.CENTER);
		// lblIrudia.setIcon(icon);
		panel_5.add(lblIrudia, BorderLayout.CENTER);
		
		JLabel lblNewLabel_10 = new JLabel(" ");
		panel_5.add(lblNewLabel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel_11 = new JLabel("      ");
		panel_5.add(lblNewLabel_11, BorderLayout.WEST);
		
		JLabel lblNewLabel_12 = new JLabel(" ");
		panel_5.add(lblNewLabel_12, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_13 = new JLabel("      ");
		panel_5.add(lblNewLabel_13, BorderLayout.EAST);
	}
}
