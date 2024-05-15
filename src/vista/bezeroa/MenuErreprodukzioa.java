package vista.bezeroa;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Aldagaiak;
import model.dao.PlayListDao;
import model.objektuak.*;

import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class MenuErreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;

	PlayListDao playlistDao = new PlayListDao();
	ArrayList<PlayList> playlistList;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public MenuErreprodukzioa(ArrayList<Audio> audioList, int index) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Erreprodukzioa.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		playlistList = new ArrayList<PlayList>();
		playlistList = playlistDao.getPlayListak(false);

		JPanel panelKontenidoa = new JPanel();
		contentPane.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new BorderLayout(0, 0));

		JPanel panelPodcastTabla = new JPanel();
		panelKontenidoa.add(panelPodcastTabla, BorderLayout.CENTER);
		panelPodcastTabla.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		panelPodcastTabla.add(scrollPane, BorderLayout.CENTER);

		String[] stringAux = { "PLAYLIST" };

		model = new DefaultTableModel();
		table = new JTable(model);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));
		table.setRowHeight(25);
		table.setDefaultEditor(Object.class, null);
		table.getTableHeader().setReorderingAllowed(false);

		model.setColumnIdentifiers(stringAux);

		scrollPane.setViewportView(table);
		
		JPanel panelBotoia = new JPanel();
		panelKontenidoa.add(panelBotoia, BorderLayout.EAST);

		Object[] aux = new Object[1];
		for (int i = 0; i < playlistList.size(); i++) {
			aux[0] = playlistList.get(i).getIzena();
			model.addRow(aux);
		}
				panelBotoia.setLayout(new GridLayout(0, 1, 0, 0));
				
				JLabel lblNewLabel = new JLabel(" ");
				panelBotoia.add(lblNewLabel);
		
				JButton btnGehitu = new JButton("Gehitu");
				panelBotoia.add(btnGehitu);
				btnGehitu.setSize(100, 10);
				btnGehitu.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int indexTable = table.getSelectedRow();
						if (indexTable == -1) {
							JOptionPane.showMessageDialog(null, "Aukeratu Playlist bat mesedez", "", JOptionPane.ERROR_MESSAGE);
						} else {
							try {
								playlistDao.insertAbestiaIntoPlayList(playlistList.get(indexTable), audioList.get(index));
								JOptionPane.showMessageDialog(null, "Sartuta", "", JOptionPane.INFORMATION_MESSAGE);
							} catch (SQLException e1) {
								JOptionPane.showMessageDialog(null, "Musika honek sartuta daukazu", "", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				});
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		panelBotoia.add(lblNewLabel_2);
		
		JButton btnAtzera = new JButton("Atzera");
		panelBotoia.add(btnAtzera);
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panelBotoia.add(lblNewLabel_1);
		btnAtzera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			
			}
		});

	}

}
