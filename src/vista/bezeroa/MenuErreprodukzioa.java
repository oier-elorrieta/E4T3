package vista.bezeroa;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.dao.AbestiaDao;
import model.dao.PlayListDao;
import model.objektuak.Audio;
import model.objektuak.PlayList;

import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;

public class MenuErreprodukzioa extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	
	PlayListDao playlistDao = new PlayListDao();
	ArrayList<PlayList> playlistList;

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public MenuErreprodukzioa(Audio abestia) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		playlistList = new ArrayList<PlayList>();
		playlistList = playlistDao.getPlayListak();

		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BorderLayout(0, 0));

		JPanel panelPodcastTabla = new JPanel();
		panel_1.add(panelPodcastTabla);
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
		
		
		Object[] aux = new Object[1];
		for (int i = 0; i < playlistList.size(); i++) {

			aux[0] = playlistList.get(i).getIzena();

			model.addRow(aux);
		}
		
		JButton btnGehitu = new JButton("Gehitu");
		panel_1.add(btnGehitu, BorderLayout.EAST);
		
		btnGehitu.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if (index == -1 ) {
					 JOptionPane.showMessageDialog(null, "Aukeratu Playlist bat mesedez", "",
								JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						playlistDao.insertAbestiaIntoPlayList(playlistList.get(index), abestia);
						 JOptionPane.showMessageDialog(null, "Sartuta", "",
									JOptionPane.INFORMATION_MESSAGE);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}

		});
		
		
	}

}
