package vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import control.funtzioak.FuntzioBista;
import model.Aldagaiak;
import model.dao.BezeroDao;

import java.awt.*;
import java.sql.SQLException;
import java.awt.event.*;

/**
 * Login bistaren definizioa.
 */
public class Login extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblUsuario;
	private JTextField textFieldBezeroa;
	private JLabel lblContraseña;
	private JPasswordField passwordFieldPasahitza;
	private JComboBox<String> comboBoxRoles;
	private JButton btnLogin;
	private JButton btnRegistrar;

	BezeroDao bezerodao = new BezeroDao();
	
	/**
	 * Framea sortzen duen metodoa. 
	 */
	public Login() {
		Aldagaiak.erabiltzailea = null;
		// setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource(Aldagaiak.logo)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(Aldagaiak.cordX, Aldagaiak.cordY, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, BorderLayout.NORTH);
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null); // Layout null erabiltzen dugu komponenteak manualki kokatzeko
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setBounds(70, 50, 80, 20); // Erabiltzailearen labelaren kokapena eta neurriak
		panel.add(lblUsuario);
		textFieldBezeroa = new JTextField();
		textFieldBezeroa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) btnLogin.doClick();
			}
		});
		textFieldBezeroa.setBounds(160, 50, 150, 20); // Erabiltzailearen testu eremua
		panel.add(textFieldBezeroa);
		lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContraseña.setBounds(70, 80, 80, 20); // Pasahitzaren labelaren kokapena eta neurriak
		panel.add(lblContraseña);
		passwordFieldPasahitza = new JPasswordField();
		passwordFieldPasahitza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) btnLogin.doClick();
			}
		});
		passwordFieldPasahitza.setBounds(160, 80, 150, 20); // Pasahitzaren testu eremua
		panel.add(passwordFieldPasahitza);
		comboBoxRoles = new JComboBox<String>();
		comboBoxRoles.addItem("Bezeroa");
		comboBoxRoles.addItem("Admin");
		comboBoxRoles.setBounds(160, 110, 150, 20); // ComboBox-aren kokapena eta neurriak
		panel.add(comboBoxRoles);

		/**
		 * Login botoia sakatzerakoan datu basean
		 * konprobatzen du sartu den bezeroa dagoen ala ez.
		 */
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bezeroa = textFieldBezeroa.getText();
				@SuppressWarnings("deprecation")
				String pasahitza = passwordFieldPasahitza.getText();
				String rola = (String) comboBoxRoles.getSelectedItem();
				try {
					if (bezerodao.komprobatuErabiltzailea(bezeroa, pasahitza) && rola.equals("Bezeroa")) {
						FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
						FuntzioBista.irekiBezeroMenu();
						dispose();
					} else if (bezerodao.komprobatuErabiltzailea(bezeroa, pasahitza) && rola.equals("Admin")) {
					} else {
						JOptionPane.showMessageDialog(null, "Erabiltzailea edo pasahitza ez dira zuzenak", "", JOptionPane.ERROR_MESSAGE);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(120, 150, 90, 30); // Login botoiaren kokapena eta neurriak
		panel.add(btnLogin);
		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FuntzioBista.bistaAldatu(getBounds(), getWidth(), getHeight());
				FuntzioBista.irekiErregistroa();
				dispose();
			}
		});
		btnRegistrar.setBounds(240, 150, 90, 30); // Erregistro botoiaren kokapena eta neurriak
		panel.add(btnRegistrar);
	}
	
}
