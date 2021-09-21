package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;

import controller.ControleTelaPrincipal;
import dao.DaoTelaTermoCompromisso;
import javax.swing.JLabel;
import java.awt.Font;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JanelaPrincipal extends JFrame {

	private static JPanel contentPaneFundo;

	private static CardLayout cardFundo;

	private static JMenu JMenuGerenciar = new JMenu("Gerenciar");
	private PanelPrincipalDeFundo PanelPrincipalDeFundo;
	private TelaConcedente telaConcedente;
	private TelaCurso telaCurso;
	private TelaEstagiario telaEstagiario;
	private TelaAutenticar telaAutenticar;
	private TelaTermoCompromisso telaTermoCompromisso;
	
	public static boolean ativar = false;

	//int opt;
	private static JanelaPrincipal frame;
	private static JTextField txtStatusAutenticacao;
	private JTextField txtStatusDeConexo;
	private static JTextField txtUsuario;
	@SuppressWarnings("unused")
	private static JLabel lblIconeStatusAutentic = new JLabel("");
	@SuppressWarnings("unused")
	private static JLabel lblFotoUser = new JLabel("");
	
	private static String textoNomeUser = "--";
	private static String iconeStatus = "/icons/No-entry.png";
	private static String textoStatusAutentic = "não autenticado";
	
	//	Metodo que desbloqueia o gerenciar
	public static void autenticadoDesbloqueio()
	{
		ativar = true;
	}
	//====================================
	
//	M�todo que re-bloqueia o gerenciar
	public static void autenticadoRebloqueio()
	{
		ativar = false;
		cardFundo.show(contentPaneFundo, "PanelPrincipalDeFundo");
		System.out.println("Ninguem logado!");
		
		textoNomeUser = "--";
		iconeStatus = "/icons/No-entry.png";
		textoStatusAutentic = "não autenticado";
	}
	//====================================

	public static void bobLogado()
	{
		System.out.println("Bob logado!");
		
		iconeStatus = "/icons/OK.png";
		textoNomeUser = "Bob";
		textoStatusAutentic = "autenticado";
	}
	
	public static void hopperLogado()
	{
		System.out.println("Hopper logado!");
		
		iconeStatus = "/icons/OK.png";
		textoNomeUser = "Hopper";
		textoStatusAutentic = "autenticado";
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					frame = new JanelaPrincipal();
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
	public JanelaPrincipal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(JanelaPrincipal.class.getResource(
					"/icons/Computer 16x16.png")));
		setBackground(Color.LIGHT_GRAY);
		setTitle("Janela Principal");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 450);
		setLocationRelativeTo(null);


		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu JMenuLogon = new JMenu("Logon");
		menuBar.add(JMenuLogon);

		JMenuItem menuItemAutenticar = new JMenuItem("Autenticar");

		JMenuLogon.add(menuItemAutenticar);

		JMenuItem menuItemSair = new JMenuItem("Sair");
		JMenuLogon.add(menuItemSair);

		JMenu JMenuGerenciar = new JMenu("Gerenciar");
		menuBar.add(JMenuGerenciar);
		
		JMenuGerenciar.setEnabled(ativar);
		
		int atraso = 0;
		ActionListener temporalizador = new ActionListener()
		{
		    public void actionPerformed(ActionEvent evento) 
		    { 
		    	JMenuGerenciar.setEnabled(ativar);
		    }
		};
		new Timer(atraso, temporalizador).start();
		
		JMenuItem menuItemEstagiario = new JMenuItem("Estagi\u00E1rio");
		JMenuGerenciar.add(menuItemEstagiario);

		JMenuItem menuItemCurso = new JMenuItem("Curso");
		JMenuGerenciar.add(menuItemCurso);

		JMenuItem menuItemConcedente = new JMenuItem("Concedente");
		JMenuGerenciar.add(menuItemConcedente);

		JMenuItem menuItemTermoCompromisso = new JMenuItem("Termo de Compromiso");
		JMenuGerenciar.add(menuItemTermoCompromisso);

		contentPaneFundo = new JPanel();
		contentPaneFundo.setBackground(SystemColor.controlHighlight);
		contentPaneFundo.setForeground(Color.LIGHT_GRAY);
		contentPaneFundo.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneFundo);
		contentPaneFundo.setLayout(new CardLayout(0, 0));

		//	icones
		menuItemAutenticar.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/Key.png")));
		menuItemSair.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/Exit.png")));
		menuItemEstagiario.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/User group.png")));
		menuItemCurso.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/Notes.png")));
		menuItemConcedente.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/Company.png")));
		menuItemTermoCompromisso.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/Text preview.png")));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setMaximumSize(new Dimension(425, 32767));
		horizontalStrut.setMinimumSize(new Dimension(425, 0));
		menuBar.add(horizontalStrut);
		
		JButton btnRetornaTelaPrincipal = new JButton("Retornar \u00E0 tela principal");
		btnRetornaTelaPrincipal.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnRetornaTelaPrincipal.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRetornaTelaPrincipal.setHorizontalAlignment(SwingConstants.RIGHT);
		btnRetornaTelaPrincipal.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRetornaTelaPrincipal.setIcon(new ImageIcon(JanelaPrincipal.class.getResource("/icons/Home.png")));
		menuBar.add(btnRetornaTelaPrincipal);
		//--------

		btnRetornaTelaPrincipal.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				cardFundo.show(contentPaneFundo, "PanelPrincipalDeFundo");
			}

		});
		
		//	alguns dos metodos da tela loggin
		menuItemAutenticar.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				cardFundo.show(contentPaneFundo, "telaAutenticar");
				JMenuGerenciar.setEnabled(true);
			}

		});
		////////////////////////////////////

		menuItemSair.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				ControleTelaPrincipal.itemSair();
				if(DialogSair.opt==0) 
				{
					System.out.println("saiu!");;
				}
			}

		});

		menuItemEstagiario.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				ControleTelaPrincipal.itemEstagiario();
				cardFundo.show(contentPaneFundo, "telaEstagiario");
			}

		});

		menuItemCurso.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				ControleTelaPrincipal.itemCurso();
				cardFundo.show(contentPaneFundo, "telaCurso");
			}

		});

		menuItemConcedente.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				ControleTelaPrincipal.itemConcedente();
				cardFundo.show(contentPaneFundo, "telaConcedente");
			}

		});

		menuItemTermoCompromisso.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				ControleTelaPrincipal.itemTermoCompromisso();
				DaoTelaTermoCompromisso.botaoLimparTTC();
				cardFundo.show(contentPaneFundo, "telaTermoCompromisso");
			}

		});
		//---------------------

		cardFundo = new CardLayout( 0, 0 );
		contentPaneFundo.setLayout(cardFundo);

		PanelPrincipalDeFundo = new PanelPrincipalDeFundo();
		telaConcedente = new TelaConcedente();
		telaCurso = new TelaCurso();
		telaEstagiario = new TelaEstagiario();
		telaAutenticar = new TelaAutenticar();
		telaTermoCompromisso = new TelaTermoCompromisso();

		contentPaneFundo.add(PanelPrincipalDeFundo, "PanelPrincipalDeFundo");
		PanelPrincipalDeFundo.setLayout(new MigLayout("", "[grow]", "[grow]"));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(0, 0, 128));
		splitPane.setPreferredSize(new Dimension(185, 25));
		splitPane.setMinimumSize(new Dimension(185, 25));
		PanelPrincipalDeFundo.add(splitPane, "cell 0 0,grow");
		
		JLabel lblFotoUser = new JLabel("");
		lblFotoUser.setBackground(Color.RED);
		splitPane.setLeftComponent(lblFotoUser);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		splitPane.setRightComponent(panel);
		panel.setLayout(new MigLayout("", "[grow]", "[150][][150]"));
		
		txtStatusDeConexo = new JTextField();
		txtStatusDeConexo.setBackground(SystemColor.activeCaption);
		txtStatusDeConexo.setEditable(false);
		txtStatusDeConexo.setText("Status de conex\u00E3o:");
		txtStatusDeConexo.setFont(new Font("Consolas", Font.PLAIN, 30));
		txtStatusDeConexo.setColumns(10);
		panel.add(txtStatusDeConexo, "cell 0 0,growx,aligny bottom");
		
		txtUsuario = new JTextField();
		txtUsuario.setBackground(SystemColor.activeCaption);
		
		txtUsuario.setFont(new Font("Consolas", Font.PLAIN, 30));
		txtUsuario.setEditable(false);
		txtUsuario.setColumns(10);
		panel.add(txtUsuario, "flowx,cell 0 1");
		
		JLabel lblIconeStatusAutentic = new JLabel("");
		
		panel.add(lblIconeStatusAutentic, "cell 0 1");
		
		txtStatusAutenticacao = new JTextField();
		txtStatusAutenticacao.setForeground(new Color(25, 25, 112));
		txtStatusAutenticacao.setBackground(SystemColor.activeCaption);
		txtStatusAutenticacao.setEditable(false);
		txtStatusAutenticacao.setFont(new Font("Consolas", Font.PLAIN, 30));
		
		panel.add(txtStatusAutenticacao, "cell 0 1,growx,aligny center");
		txtStatusAutenticacao.setColumns(10);
		contentPaneFundo.add(telaConcedente, "telaConcedente");
		contentPaneFundo.add(telaCurso, "telaCurso");
		contentPaneFundo.add(telaEstagiario, "telaEstagiario");
		contentPaneFundo.add(telaTermoCompromisso, "telaTermoCompromisso");
		contentPaneFundo.add(telaAutenticar, "telaAutenticar");
		
		ActionListener temporalizadorPainelFundo = new ActionListener()
		{
		    public void actionPerformed(ActionEvent evento) 
		    { 
		    	txtStatusAutenticacao.setText(textoStatusAutentic);
				lblIconeStatusAutentic.setIcon(new ImageIcon(JanelaPrincipal.class.getResource(iconeStatus)));
				txtUsuario.setText(textoNomeUser);
		    }
		};
		new Timer(atraso, temporalizadorPainelFundo).start();
	}

	//	Getters e Setters
	public CardLayout getCardFundo() {
		return cardFundo;
	}

	@SuppressWarnings("static-access")
	public void setCardFundo(CardLayout cardFundo) {
		this.cardFundo = cardFundo;
	}

	public TelaConcedente getTelaConcedente() {
		return telaConcedente;
	}

	public void setTelaConcedente(TelaConcedente telaConcedente) {
		this.telaConcedente = telaConcedente;
	}

	public TelaCurso getTelaCurso() {
		return telaCurso;
	}

	public void setTelaCurso(TelaCurso telaCurso) {
		this.telaCurso = telaCurso;
	}

	public TelaEstagiario getTelaEstagiario() {
		return telaEstagiario;
	}

	public void setTelaEstagiario(TelaEstagiario telaEstagiario) {
		this.telaEstagiario = telaEstagiario;
	}

	public TelaAutenticar getTelaAutenticar() {
		return telaAutenticar;
	}

	public void setTelaAutenticar(TelaAutenticar telaAutenticar) {
		this.telaAutenticar = telaAutenticar;
	}

	public TelaTermoCompromisso getTelaTermoCompromisso() {
		return telaTermoCompromisso;
	}

	public void setTelaTermoCompromisso(TelaTermoCompromisso telaTermoCompromisso) {
		this.telaTermoCompromisso = telaTermoCompromisso;
	}

	public PanelPrincipalDeFundo getPanelPrincipalDeFundo() {
		return PanelPrincipalDeFundo;
	}

	public void setPanelPrincipalDeFundo(PanelPrincipalDeFundo panelPrincipalDeFundo) {
		PanelPrincipalDeFundo = panelPrincipalDeFundo;
	}

	public JMenu getJMenuGerenciar() {
		return JMenuGerenciar;
	}

	public void setJMenuGerenciar(JMenu jMenuGerenciar) {
		JMenuGerenciar = jMenuGerenciar;
	}
}
