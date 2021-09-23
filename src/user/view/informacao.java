package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class informacao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					informacao frame = new informacao();
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
	public informacao() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(informacao.class.getResource("/icons/About.png")));
		setTitle("informacao");
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow]", "[][grow]"));
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		
		JLabel lblImagenzinha = new JLabel("");
		lblImagenzinha.setIcon(new ImageIcon(informacao.class.getResource("/icons/exemplo.PNG")));
		contentPane.add(lblImagenzinha, "cell 1 0,aligny center");
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel, "cell 0 0 1 2,grow");
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblInfo = new JLabel("");
		lblInfo.setIcon(new ImageIcon(informacao.class.getResource("/icons/51922_info_icon.png")));
		panel.add(lblInfo);
		
		JTextPane txtpnParaPreencherE = new JTextPane();
		txtpnParaPreencherE.setOpaque(false);
		txtpnParaPreencherE.setEditable(false);
		txtpnParaPreencherE.setBorder(new MatteBorder(1, 1, 1, 1, (Color) null));
		txtpnParaPreencherE.setText("Para preencher e inserir as informa\u00E7\u00F5es ao termo de compromisso, siga os procedimentos abaixo:\r\n\r\n-Insira um n\u00FAmero de CPF j\u00E1 existente para que o cliente (a tela) receba as informa\u00E7\u00F5es  \treferentes a ele;\r\n\r\n-Ao inserir o CPF no campo pressione ENTER para carregar as informa\u00E7\u00F5es nos \tcampos;\r\n\r\n-Certifique-se que o CPF inserido existe nos registros do banco de dados;");
		txtpnParaPreencherE.setBackground(new Color(230, 230, 250));
		txtpnParaPreencherE.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(txtpnParaPreencherE, "cell 1 1,alignx right,aligny center");
	}

}
