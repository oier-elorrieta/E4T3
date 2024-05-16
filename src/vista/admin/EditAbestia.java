package vista.admin;


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import control.funtzioak.Funtzioak;
import model.Aldagaiak;
import model.dao.AbestiaDao;
import model.objektuak.Abestia;
import model.objektuak.Album;
import model.objektuak.Audio;
import model.objektuak.Musikaria;
import vista.bezeroa.playlist.NirePlaylist;
import vista.interfaseak.Header;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class EditAbestia extends JFrame implements Header {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDekribapena;
	private JTextField textFieldIzena;
	private JTextField textFieldIraupena;
	
	AbestiaDao abestiadao = new AbestiaDao();
	
	Album albumRet;
	Musikaria musikariaRet;

	public EditAbestia(Audio audio,Album albumAux, Musikaria musikariAux) {
		albumRet = albumAux;
		musikariaRet = musikariAux;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NirePlaylist.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerKokatu("Abestiak Editatu");
		
		JPanel panelKontenidoa = new JPanel();
		contentPane.add(panelKontenidoa, BorderLayout.CENTER);
		panelKontenidoa.setLayout(new BorderLayout(0, 0));
		
		JPanel panelLabel = new JPanel();
		panelKontenidoa.add(panelLabel, BorderLayout.CENTER);
		panelLabel.setLayout(new GridLayout(0, 2, 20, 100));
		
		JLabel lblIzena = new JLabel("Izena: ");
		lblIzena.setHorizontalAlignment(SwingConstants.RIGHT);
	
		panelLabel.add(lblIzena);
		
		textFieldIzena = new JTextField();
		textFieldIzena.setColumns(10);
		textFieldIzena.setText(audio.getIzena());
		panelLabel.add(textFieldIzena);
		
		JLabel lblIraupena = new JLabel("Iraupena:  (Segundutan)");
		lblIraupena.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblIraupena);
		
		textFieldIraupena = new JTextField();
		textFieldIraupena.setColumns(10);
		String iraupena = Integer.toString(audio.getIraupena());
		textFieldIraupena.setText(iraupena);
		panelLabel.add(textFieldIraupena);
		
		JLabel lblDeskribapena = new JLabel("Deskribapena:  ");
		lblDeskribapena.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblDeskribapena);
		
		textFieldDekribapena = new JTextField();
		textFieldDekribapena.setColumns(10);
		Abestia abestiAux = (Abestia) audio;
		textFieldDekribapena.setText(abestiAux.getDeskribapena());
		panelLabel.add(textFieldDekribapena);
		
		JLabel lblNewLabel = new JLabel("                                                                                                 ");
		panelKontenidoa.add(lblNewLabel, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panelKontenidoa.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1 = new JLabel(" ");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panelKontenidoa.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel_1_1 = new JLabel(" ");
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel(" ");
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_1 = new JLabel(" ");
		panel_1.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4_1 = new JLabel(" ");
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_5_1 = new JLabel(" ");
		panel_1.add(lblNewLabel_5_1);
		
		JPanel panelBotoiak = new JPanel();
		contentPane.add(panelBotoiak, BorderLayout.SOUTH);
		
		JButton btnApply = new JButton("Gorde");
		btnApply.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String izena = textFieldIzena.getText();
				String iraupenatxt = textFieldIraupena.getText();
				int iraupena = Integer.parseInt(iraupenatxt);
				String deskribapena = textFieldDekribapena.getText();
				
				
				if (izena.equals("") || deskribapena.equals("") || iraupenatxt.equals("")) {
					JOptionPane.showMessageDialog(null, "Guztia bete mesedez!", "", JOptionPane.ERROR_MESSAGE);
					
				}else {
					
				
					Abestia newAudio = new Abestia(audio.getIdAudio(),izena,iraupena,deskribapena);
					
					try {
						abestiadao.updateAbestia(newAudio);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "Dena ondo gorde da!", "", JOptionPane.INFORMATION_MESSAGE);
					FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
	                FuntzioBista.irekiAdminMenu();
	                dispose();
				}
			}
		});
		panelBotoiak.add(btnApply);
		
		
	}

	@Override
	public void headerKokatu(String text) {
        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        // Titulua
        JLabel lblTitulua = new JLabel(text);
        lblTitulua.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulua.setFont(new Font("Tahoma", Font.PLAIN, 40));
        panel_1.add(lblTitulua);
        
        // Atzera botoia
        JButton btnAtzera = new JButton("Atzera");
        btnAtzera.setSize(325, 20);
        btnAtzera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
                FuntzioBista.irekiAbestiaKudeatu(albumRet,musikariaRet);
                dispose();
            }
        });
        panel_1.add(btnAtzera, BorderLayout.WEST);
	}
}

