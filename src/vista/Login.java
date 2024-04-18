package vista;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Aldagaiak;
import model.db.DB_funtzioak;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

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
    

	/**
	 * Create the frame.
	 */
	public Login() {
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
        panel.setLayout(null); // Usamos un layout nulo para posicionar manualmente los componentes

        lblUsuario = new JLabel("Usuario:");
        lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsuario.setBounds(70, 50, 80, 20); // Posición y tamaño del label de usuario
        panel.add(lblUsuario);

        textFieldBezeroa = new JTextField();
        textFieldBezeroa.setBounds(160, 50, 150, 20); // Posición y tamaño del campo de texto de usuario
        panel.add(textFieldBezeroa);

        lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setHorizontalAlignment(SwingConstants.RIGHT);
        lblContraseña.setBounds(70, 80, 80, 20); // Posición y tamaño del label de contraseña
        panel.add(lblContraseña);

        passwordFieldPasahitza = new JPasswordField();
        passwordFieldPasahitza.setBounds(160, 80, 150, 20); // Posición y tamaño del campo de contraseña
        panel.add(passwordFieldPasahitza);

        comboBoxRoles = new JComboBox<String>();
        comboBoxRoles.addItem("Bezeroa");
        comboBoxRoles.addItem("Admin");
        comboBoxRoles.setBounds(160, 110, 150, 20); // Posición y tamaño del ComboBox
        panel.add(comboBoxRoles);
        
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String bezeroa = textFieldBezeroa.getText();
        		String pasahitza = passwordFieldPasahitza.getText();
        		try {
        			System.out.println(DB_funtzioak.komprobatuErabiltzailea(bezeroa, pasahitza));
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		
        	}
        });
        btnLogin.setBounds(120, 150, 90, 30); // Posición y tamaño del botón Login
        panel.add(btnLogin);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnRegistrar.setBounds(240, 150, 90, 30); // Posición y tamaño del botón Registrar
        panel.add(btnRegistrar);
	}
}
