package vista.admin;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.MusikariaDao;
import model.objektuak.Musikaria;
import vista.bezeroa.playlist.NirePlaylist;
import vista.interfaseak.Header;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class EditMusikaria extends JFrame implements Header {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldDeskribapena;
	private JTextField textFieldIzena;
	
	MusikariaDao musikariadao = new MusikariaDao();

	public EditMusikaria(Musikaria musikaria) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(NirePlaylist.class.getResource(Aldagaiak.logo)));
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, Aldagaiak.resolucionX, Aldagaiak.resolucionY);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		headerKokatu("Albumak Editatu");
		
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
		textFieldIzena.setText(musikaria.getIzen_Artistikoa());
		panelLabel.add(textFieldIzena);
		
		JLabel lblEzaugarria = new JLabel("Ezaugarria:  ");
		lblEzaugarria.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblEzaugarria);
		
		JPanel panel_2 = new JPanel();
		panelLabel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JRadioButton rdbtnBakarlaria = new JRadioButton("Bakarlaria");
		rdbtnBakarlaria.setActionCommand("Bakarlaria");
		panel_2.add(rdbtnBakarlaria);
		
		JRadioButton rdbtnTaldea = new JRadioButton("Taldea");
		rdbtnTaldea.setActionCommand("Taldea");
		panel_2.add(rdbtnTaldea);
		
		ButtonGroup rdbGroup = new ButtonGroup();
		
		rdbGroup.add(rdbtnBakarlaria);
		rdbGroup.add(rdbtnTaldea);
		
		if(musikaria.getEzaugarria().equals("Bakarlaria")) {
			rdbtnBakarlaria.setSelected(true);
		}else {
			rdbtnTaldea.setSelected(true);
		}
		
		
		JLabel lblDeskribapena = new JLabel("Deskribapena:  ");
		lblDeskribapena.setHorizontalAlignment(SwingConstants.RIGHT);
		panelLabel.add(lblDeskribapena);
		
		textFieldDeskribapena = new JTextField();
		textFieldDeskribapena.setColumns(10);
		textFieldDeskribapena.setText(musikaria.getDeskribapena());
		panelLabel.add(textFieldDeskribapena);
		
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
				String ezaugarria = rdbGroup.getSelection().getActionCommand();
				String deskribapena = textFieldDeskribapena.getText();
				
				Musikaria newMusikaria = new Musikaria(musikaria.getId(),izena,musikaria.getIrudia(),deskribapena,ezaugarria);
				
				try {
					musikariadao.updateMusikaria(newMusikaria);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Dena ondo gorde da!", "", JOptionPane.INFORMATION_MESSAGE);
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
                FuntzioBista.irekiMusikaKudeatu();
                dispose();
			}
		});
		panelBotoiak.add(btnApply);
		
		
		
		

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
                FuntzioBista.irekiMusikaKudeatu();
                dispose();
            }
        });
        panel_1.add(btnAtzera, BorderLayout.WEST);
	}
}
