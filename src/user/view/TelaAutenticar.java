package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import controller.ControleAutenticar;
import dao.DaoLoggin;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class TelaAutenticar extends JPanel {

	@SuppressWarnings("unused")
	private JPanel contentPane;
	public static JTextField textFieldNomeUser;
	public static JPasswordField passwordFieldUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TelaAutenticar frame = new TelaAutenticar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAutenticar()
	{
		setBounds(100, 100, 850, 500);
		setLayout(new MigLayout("", "[10px,grow]", "[10px,grow]"));

		JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, "cell 0 0,grow");

		JPanel panelDados = new JPanel();
		panelDados.setBackground(Color.GRAY);
		splitPane.setRightComponent(panelDados);
		panelDados.setLayout(new MigLayout("", "[100px:n][grow]", "[][][]"));

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelDados.add(lblUsurio, "cell 0 0,alignx right");

		textFieldNomeUser = new JTextField();
		textFieldNomeUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textFieldNomeUser.setColumns(20);
		panelDados.add(textFieldNomeUser, "cell 1 0,growx");

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelDados.add(lblSenha, "flowy,cell 0 1,alignx trailing");

		passwordFieldUser = new JPasswordField();
		passwordFieldUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordFieldUser.setColumns(20);
		panelDados.add(passwordFieldUser, "cell 1 1,growx");

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setIcon(new ImageIcon(TelaAutenticar.class.getResource("/icons/37263_monitor_erase_icon.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelDados.add(btnLimpar, "cell 0 2,grow");

		btnLimpar.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				System.out.println("limpando a tela loggin");
				ControleAutenticar.botaoLimparAutenticacao();
			}

		});

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon(TelaAutenticar.class.getResource("/icons/59481_login_icon.png")));
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelDados.add(btnEntrar, "cell 1 2,alignx center,growy");
		
		btnEntrar.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				
				String usuarioString = getTextFieldNomeUser().getText();
				String senhaString = new String(passwordFieldUser.getPassword());
				
				DaoLoggin.recebeAsStrings(usuarioString, senhaString);
				
				DaoLoggin log = new DaoLoggin();
				if(log.checklogin(usuarioString, senhaString)) 
				{
					JOptionPane.showMessageDialog(null, "Acesso Garantido", " Info ",
					JOptionPane.INFORMATION_MESSAGE,
					new ImageIcon(ControleAutenticar.class.getResource("/icons/Apply.png")));
					ControleAutenticar.botaoConfirmarAutenticacao();
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Usuario ou Senha não encontrados", " Alerta ",
					JOptionPane.ERROR_MESSAGE,
					new ImageIcon(ControleAutenticar.class.getResource("/icons/Alert.png")));
				}
				
			}

		});

		JPanel panelmagem = new JPanel();
		panelmagem.setBackground(Color.GRAY);
		splitPane.setLeftComponent(panelmagem);
		panelmagem.setLayout(null);

		JLabel lblImagem = new JLabel("");
		lblImagem.setIcon(new ImageIcon(TelaAutenticar.class.getResource("/icons/24252_cryptography_lock_password_secret_icon.png")));
		lblImagem.setBounds(364, 50, 128, 160);
		panelmagem.add(lblImagem);

	}

	public static void limparTela()
	{

		textFieldNomeUser.setText(null);
		passwordFieldUser.setText(null);
		System.out.println("limpou!");

	}

	public static JTextField getTextFieldNomeUser() {
		return textFieldNomeUser;
	}

	public void setTextFieldNomeUser(JTextField textFieldNomeUser) {
		TelaAutenticar.textFieldNomeUser = textFieldNomeUser;
	}

	public static JPasswordField getPasswordFieldUser() {
		return passwordFieldUser;
	}

	public void setPasswordFieldUser(JPasswordField passwordFieldUser) {
		TelaAutenticar.passwordFieldUser = passwordFieldUser;
	}

}
