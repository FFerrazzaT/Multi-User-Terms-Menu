package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.text.MaskFormatter;

import controller.ControleAutenticar;
import dao.DaoLoggin;
import dao.DaoTelaTermoCompromisso;
import model.ModeloTermoCompromisso;
import net.miginfocom.swing.MigLayout;

@SuppressWarnings({ "serial", "unused" })
public class TelaTermoCompromisso extends JPanel {
	protected static JTextField fieldAreaEstagio;
	protected static JTextField fieldBeneficios;
	protected static JTextField fieldPrincAtiv;
	protected static JTextField fieldNomeAluno;
	protected static JTextField fieldNomeCurso;
	protected static JTextField fieldNomeOrientador;
	protected static JTextField fieldNomeUni;
	protected static JTextField fieldNomeRepUni;
	protected static JTextField fieldRazaoSoc;
	protected static JTextField fieldNomeRepCur;
	protected static JTextField fieldInfo;
	protected static JFormattedTextField formattedValBolsa;
	protected static JButton buttonLimparTela;
	protected static JButton butonLerTC;
	protected static JTextField fieldNomeRepresentanteEmp;
	protected static JTextField fieldFimEstagio;
	protected static JTextField fieldInicioEstagio;
	protected static JTextField fieldCHDiaria;
	protected static JTextField fieldCHSemanal;
	protected static JTextField fieldHorarioInicio;
	protected static JTextField fieldHorarioSaida;
	
	public int chhora;
	public int chsema;
	protected static JTextField fieldCPFAluno;
	protected static JTextField fieldCNPJEmpresa;
	
	/**
	 * Create the panel.
	 */
	public TelaTermoCompromisso() {
		setBackground(new Color(204, 204, 255));
		setLayout(new MigLayout("", "[::180,left][250,grow][150][150,grow,right]", "[::5][35][10][30][30][30][30][30][30][30][30][30][30][][40]"));
		setBounds(100, 100, 750, 500);

		JLabel lblTituloTdC = new JLabel("Termo de Compromisso");
		lblTituloTdC.setBackground(Color.WHITE);
		lblTituloTdC.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Text preview.png")));
		lblTituloTdC.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(lblTituloTdC, "flowx,cell 0 1 4 1");

		JSeparator separator_1 = new JSeparator();
		separator_1.setLocation(new Point(0, 1));
		separator_1.setForeground(Color.DARK_GRAY);
		add(separator_1, "cell 0 2 4 1,growx");

		JLabel labelNomeAluno = new JLabel("Nome do aluno:");
		labelNomeAluno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeAluno, "cell 0 3,alignx right");

		fieldNomeAluno = new JTextField();
		fieldNomeAluno.setEditable(false);
		fieldNomeAluno.setColumns(10);
		add(fieldNomeAluno, "cell 1 3,growx");
		//labelFimEstagio.setLabelFor(fieldFimEstagio);

		JButton btnInformacao = new JButton("");
		btnInformacao.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/About.png")));
		add(btnInformacao, "flowx,cell 2 3");
		btnInformacao.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				DaoTelaTermoCompromisso.informacao();
			}

		});

		JLabel labelCPFAluno = new JLabel("CPF do aluno:");
		labelCPFAluno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCPFAluno, "cell 2 3,alignx trailing,aligny center");
		
		//CPF ALUNO----------------------
		fieldCPFAluno = new JTextField();
		fieldCPFAluno.setColumns(10);
		add(fieldCPFAluno, "cell 3 3,growx");
		
		fieldCPFAluno.addKeyListener(new KeyAdapter() 
		{
	         public void keyPressed(KeyEvent e) 
	         {
	        	 int key = e.getKeyCode();
	        	 if (key == KeyEvent.VK_ENTER) 
	        	 {  
	        		System.out.println("ENTER");
	        		DaoTelaTermoCompromisso daoTelaTermoCompromisso = new DaoTelaTermoCompromisso();
					daoTelaTermoCompromisso.read(fieldCPFAluno.getText());
	        	 }
	         }
	    });
		//-------------------------------
		
		JLabel labelNomeCurso = new JLabel("Nome do curso:");
		labelNomeCurso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeCurso, "cell 0 4,alignx trailing");

		fieldNomeCurso = new JTextField();
		fieldNomeCurso.setEditable(false);
		fieldNomeCurso.setColumns(10);
		add(fieldNomeCurso, "cell 1 4,growx");

		JLabel labelCNPJEmpresa = new JLabel("CNPJ da empresa:");
		labelCNPJEmpresa.setToolTipText("O mesmo tipo de opera\u00E7\u00E3o com a tecla ENTER pode ser realizada para o campo de CNPJ da empresa");
		labelCNPJEmpresa.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Info.png")));
		labelCNPJEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCNPJEmpresa, "cell 2 4,alignx trailing");
		
		//CNPJ EMPRESA----------------------
		fieldCNPJEmpresa = new JTextField();
		fieldCNPJEmpresa.setColumns(10);
		add(fieldCNPJEmpresa, "cell 3 4,growx");
		
		fieldCNPJEmpresa.addKeyListener(new KeyAdapter() 
		{
	         public void keyPressed(KeyEvent e) 
	         {
	        	 int key = e.getKeyCode();
	        	 if (key == KeyEvent.VK_ENTER) 
	        	 {  
	        		System.out.println("ENTER");
	        		DaoTelaTermoCompromisso daoTelaTermoCompromisso = new DaoTelaTermoCompromisso();
					daoTelaTermoCompromisso.read(fieldCNPJEmpresa.getText());
	        	 }
	         }
	    });
		//-------------------------------

		JLabel labelNomeOrientador = new JLabel("Nome do orientador:");
		labelNomeOrientador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeOrientador, "cell 0 5,alignx trailing");

		fieldNomeOrientador = new JTextField();
		fieldNomeOrientador.setEditable(false);
		fieldNomeOrientador.setColumns(10);
		add(fieldNomeOrientador, "cell 1 5,growx");

		JLabel labelRazaoSoc = new JLabel("Raz\u00E3o social (empresa):");
		labelRazaoSoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelRazaoSoc, "cell 2 5,alignx trailing");

		fieldRazaoSoc = new JTextField();
		fieldRazaoSoc.setColumns(15);
		add(fieldRazaoSoc, "cell 3 5,growx");

		JLabel labelNomeUni = new JLabel("Nome da universidade:");
		labelNomeUni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeUni, "cell 0 6,alignx trailing");

		fieldNomeUni = new JTextField();
		fieldNomeUni.setEditable(false);
		fieldNomeUni.setColumns(10);
		add(fieldNomeUni, "cell 1 6,growx");

		JLabel labelNomeRepCur = new JLabel("Nome do rep. (curso):");
		labelNomeRepCur.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Help symbol.png")));
		labelNomeRepCur.setToolTipText("rep - representante");
		labelNomeRepCur.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeRepCur, "cell 2 6,alignx trailing");

		fieldNomeRepCur = new JTextField();
		fieldNomeRepCur.setColumns(15);
		add(fieldNomeRepCur, "cell 3 6,growx");

		JLabel labelNomeRepUni = new JLabel("Nome do rep. (uni):");
		labelNomeRepUni.setToolTipText("rep - representante; uni - universidade");
		labelNomeRepUni.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Help symbol.png")));
		labelNomeRepUni.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeRepUni, "cell 0 7,alignx trailing");

		fieldNomeRepUni = new JTextField();
		fieldNomeRepUni.setEditable(false);
		fieldNomeRepUni.setColumns(10);
		add(fieldNomeRepUni, "cell 1 7,growx");

		JLabel labelInfo = new JLabel("Informa\u00E7\u00F5es compl:");
		labelInfo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelInfo, "cell 2 7,alignx trailing");

		fieldInfo = new JTextField();
		fieldInfo.setColumns(15);
		add(fieldInfo, "cell 3 7,growx");

		JLabel labelInicioEstagio = new JLabel("In\u00EDcio do est\u00E1gio:");
		labelInicioEstagio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelInicioEstagio, "flowx,cell 0 8,alignx right,aligny center");
		
		JLabel labelNomeRepEmp = new JLabel("Nome do rep. (empresa):");
		labelNomeRepEmp.setToolTipText("rep - representante");
		labelNomeRepEmp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelNomeRepEmp, "cell 2 8,alignx trailing");
		
		fieldNomeRepresentanteEmp = new JTextField();
		fieldNomeRepresentanteEmp.setColumns(15);
		add(fieldNomeRepresentanteEmp, "cell 3 8,growx");

		JLabel labelCHDiaria = new JLabel("CH di\u00E1ria:");
		labelCHDiaria.setToolTipText("CH - Carga Hor\u00E1ria (N\u00E3o pode ser maior do que 6 horas)");
		labelCHDiaria.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Help symbol.png")));
		labelCHDiaria.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCHDiaria, "cell 0 9,alignx right,aligny center");

		JLabel labelValBolsa = new JLabel("Valor da bolsa:");
		labelValBolsa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelValBolsa, "flowx,cell 2 9,alignx trailing,growy");

	    formattedValBolsa = new JFormattedTextField();
		add(formattedValBolsa, "cell 3 9,growx");

		JLabel labelHorarioInicio = new JLabel("Hor\u00E1rio de in\u00EDcio:");
		labelHorarioInicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelHorarioInicio, "cell 0 10,alignx trailing");

		JLabel labelAreaEstagio = new JLabel("\u00C1rea do est\u00E1gio:");
		labelAreaEstagio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelAreaEstagio, "cell 2 10,alignx right,aligny center");

		fieldAreaEstagio = new JTextField();
		add(fieldAreaEstagio, "cell 3 10,growx");
		fieldAreaEstagio.setColumns(10);
		labelAreaEstagio.setLabelFor(fieldAreaEstagio);

		JLabel labelBeneficios = new JLabel("Benef\u00EDcios:");
		labelBeneficios.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelBeneficios, "flowx,cell 0 11,alignx right,aligny center");

		fieldBeneficios = new JTextField();
		add(fieldBeneficios, "cell 1 11,growx,aligny center");
		fieldBeneficios.setColumns(10);

		JLabel labelPrincAtiv = new JLabel("Principais atividades:");
		labelPrincAtiv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelPrincAtiv, "cell 2 11,alignx right,aligny center");

		fieldPrincAtiv = new JTextField();
		add(fieldPrincAtiv, "cell 3 11,growx");
		fieldPrincAtiv.setColumns(10);
		labelPrincAtiv.setLabelFor(fieldPrincAtiv);
		
				buttonLimparTela = new JButton("Limpar Tela");
				buttonLimparTela.setFont(new Font("Tahoma", Font.PLAIN, 13));
				buttonLimparTela.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

							// TODO Auto-generated method stub
							DaoTelaTermoCompromisso.botaoLimparTTC();
					}
				});
				buttonLimparTela.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource(
										 "/icons/37263_monitor_erase_icon.png")));
				add(buttonLimparTela, "cell 2 12,alignx center,growy");

		JLabel labelOperacoesCRUD = new JLabel("Opera\u00E7\u00F5es");
		labelOperacoesCRUD.setBackground(new Color(255, 255, 255));
		labelOperacoesCRUD.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Database.png")));
		labelOperacoesCRUD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(labelOperacoesCRUD, "cell 0 13 4 1,alignx center");

		JToolBar toolBarOpCRUDTC = new JToolBar();
		toolBarOpCRUDTC.setBackground(new Color(153, 153, 255));
		toolBarOpCRUDTC.setRollover(true);
		toolBarOpCRUDTC.setEnabled(false);
		toolBarOpCRUDTC.setFloatable(false);
		add(toolBarOpCRUDTC, "cell 0 14 4 1,grow");

		Component verticalStrut_3 = Box.createVerticalStrut(20);
		verticalStrut_3.setBackground(new Color(135, 206, 250));
		toolBarOpCRUDTC.add(verticalStrut_3);

		JButton buttonCriarTC = new JButton("  Criar  ");
		buttonCriarTC.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonCriarTC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonCriarTC.setToolTipText("");
		buttonCriarTC.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDTC.add(buttonCriarTC);
		buttonCriarTC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonCriarTC.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Create.png")));
////////////////////////////////////////
		//BOTAO CRIAR
		
		buttonCriarTC.addActionListener(new java.awt.event.ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				System.out.println("criar");
				
				ModeloTermoCompromisso p = new ModeloTermoCompromisso();
				DaoTelaTermoCompromisso dao = new DaoTelaTermoCompromisso();
		
				try 
				{
					int cchoraInt = Integer.parseInt(getFieldCHDiaria().getText());
					int chsemaInt = Integer.parseInt(getFieldCHSemanal().getText());
					
					chhora = cchoraInt;
					chsema = chsemaInt;
					
				} 
				catch (Exception e2) 
				{
					System.out.println("ERRRRROOO");
				}

				System.out.println(chhora + "..." + chsema);
				
				if(chhora<6 && chsema<30)
				{
					p.setNomeAluno(fieldNomeAluno.getText());
					p.setNomeCurso(fieldNomeCurso.getText());
					p.setNomeOrientador(fieldNomeOrientador.getText());
					p.setNomeUniversidade(fieldNomeUni.getText());
					p.setNomeRepresentanteUni(fieldNomeRepUni.getText());
					p.setRazaoSocial(fieldRazaoSoc.getText());
					p.setNomeRepresentanteConc(fieldNomeRepCur.getText());
					p.setBeneficios(fieldBeneficios.getText());
					p.setAreaEstagio(fieldAreaEstagio.getText());
					p.setPrincipaisAtv(fieldPrincAtiv.getText());
					p.setConcedenteCnpj(fieldCNPJEmpresa.getText());
					p.setCpfAluno(fieldCPFAluno.getText());
					p.setInicioEstagio(fieldInicioEstagio.getText());
					p.setInicioEstagio(fieldFimEstagio.getText());
					p.setFimEstagio(fieldFimEstagio.getText());
					p.setChDiaria(fieldCHDiaria.getText());
					p.setChSemanal(fieldCHSemanal.getText());
			
					p.setHrInicio(fieldNomeAluno.getText());
					p.setHrFim(fieldNomeAluno.getText());
					p.setValorBolsa(formattedValBolsa.getText());
			    
					dao.create(p);
			    
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Não foi possivel salvar", " Alerta ",
												  JOptionPane.ERROR_MESSAGE);
				}

			}

		});
		
		////////////////////////////////
////////////////////////////////////////
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		toolBarOpCRUDTC.add(verticalStrut_2);

		butonLerTC = new JButton("  Ler  ");
		butonLerTC.setAlignmentX(Component.CENTER_ALIGNMENT);
		butonLerTC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		butonLerTC.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDTC.add(butonLerTC);
		butonLerTC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		butonLerTC.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/List.png")));

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		toolBarOpCRUDTC.add(verticalStrut_1);

		JButton buttonFazerUpTC = new JButton("  Atualizar  ");
		buttonFazerUpTC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonFazerUpTC.setBackground(new Color(220, 220, 220));
		buttonFazerUpTC.setAlignmentX(Component.CENTER_ALIGNMENT);
		toolBarOpCRUDTC.add(buttonFazerUpTC);
		buttonFazerUpTC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonFazerUpTC.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Download.png")));

		Component verticalStrut = Box.createVerticalStrut(20);
		toolBarOpCRUDTC.add(verticalStrut);

		JButton buttonRemoverTC = new JButton("  Remover  ");
		buttonRemoverTC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		buttonRemoverTC.setBackground(new Color(220, 220, 220));
		toolBarOpCRUDTC.add(buttonRemoverTC);
		buttonRemoverTC.setFont(new Font("Tahoma", Font.PLAIN, 17));
		buttonRemoverTC.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Remove.png")));

		Component verticalStrut_4 = Box.createVerticalStrut(20);
		toolBarOpCRUDTC.add(verticalStrut_4);
		
		fieldHorarioInicio = new JTextField();
		fieldHorarioInicio.setEditable(false);
		fieldHorarioInicio.setColumns(10);
		add(fieldHorarioInicio, "flowx,cell 1 10");

		Component horizontalStrut_4_3_5_1_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_1.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_1, "cell 1 10");

		JLabel labelHorarioSaida = new JLabel("Hor\u00E1rio de sa\u00EDda:");
		labelHorarioSaida.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelHorarioSaida, "cell 1 10");
		
		fieldCHDiaria = new JTextField();
		fieldCHDiaria.setEditable(false);
		fieldCHDiaria.setColumns(10);
		add(fieldCHDiaria, "flowx,cell 1 9");

		Component horizontalStrut_4_3_5_1_1_2 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_2.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_2, "cell 1 9");

		Component horizontalStrut_4_3_5_1_1_4 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_4.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_4, "cell 1 9");

		Component horizontalStrut_4_3_5_1_1_3 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1_3.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1_3, "cell 1 9");

		JLabel labelCHSemanal = new JLabel("CH semanal:");
		labelCHSemanal.setIcon(new ImageIcon(TelaTermoCompromisso.class.getResource("/icons/Help symbol.png")));
		labelCHSemanal.setToolTipText("CH - Carga Hor\u00E1ria (N\u00E3o pode ser maior do que 30 horas)");
		labelCHSemanal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelCHSemanal, "cell 1 9,alignx right,aligny center");
		
		fieldInicioEstagio = new JTextField();
		fieldInicioEstagio.setEditable(false);
		fieldInicioEstagio.setColumns(10);
		add(fieldInicioEstagio, "flowx,cell 1 8");

		Component horizontalStrut_4_3_5_1_1 = Box.createHorizontalStrut(20);
		horizontalStrut_4_3_5_1_1.setPreferredSize(new Dimension(0, 0));
		add(horizontalStrut_4_3_5_1_1, "cell 1 8");

		JLabel labelFimEstagio = new JLabel("Fim do est\u00E1gio:");
		labelFimEstagio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		add(labelFimEstagio, "cell 1 8,alignx right,aligny center");
		buttonRemoverTC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

		//mascara
		MaskFormatter valorBolsa = null;
			try {
				valorBolsa = new MaskFormatter("####,## R$");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			valorBolsa.install(formattedValBolsa);
			
			fieldFimEstagio = new JTextField();
			fieldFimEstagio.setEditable(false);
			fieldFimEstagio.setColumns(10);
			add(fieldFimEstagio, "cell 1 8");
			
			fieldCHSemanal = new JTextField();
			fieldCHSemanal.setEditable(false);
			fieldCHSemanal.setColumns(10);
			add(fieldCHSemanal, "cell 1 9");
			
			fieldHorarioSaida = new JTextField();
			fieldHorarioSaida.setEditable(false);
			fieldHorarioSaida.setColumns(10);
			add(fieldHorarioSaida, "cell 1 10");
	}

	public static JTextField getFieldCNPJEmpresa() {
		return fieldCNPJEmpresa;
	}

	@SuppressWarnings("static-access")
	public void setFieldCNPJEmpresa(JTextField fieldCNPJEmpresa) {
		this.fieldCNPJEmpresa = fieldCNPJEmpresa;
	}

	public static JTextField getFieldCPFAluno() {
		return fieldCPFAluno;
	}

	@SuppressWarnings("static-access")
	public void setFieldCPFAluno(JTextField fieldCPFAluno) {
		this.fieldCPFAluno = fieldCPFAluno;
	}

	public static JTextField getFieldNomeRepresentanteEmp() {
		return fieldNomeRepresentanteEmp;
	}

	@SuppressWarnings("static-access")
	public void setFieldNomeRepresentanteEmp(JTextField fieldNomeRepresentanteEmp) {
		this.fieldNomeRepresentanteEmp = fieldNomeRepresentanteEmp;
	}

	public static JTextField getFieldCHDiaria() {
		return fieldCHDiaria;
	}

	@SuppressWarnings("static-access")
	public void setFieldCHDiaria(JTextField fieldCHDiaria) {
		this.fieldCHDiaria = fieldCHDiaria;
	}

	public static JTextField getFieldCHSemanal() {
		return fieldCHSemanal;
	}

	@SuppressWarnings("static-access")
	public void setFieldCHSemanal(JTextField fieldCHSemanal) {
		this.fieldCHSemanal = fieldCHSemanal;
	}

	public JTextField getFieldHorarioInicio() {
		return fieldHorarioInicio;
	}

	@SuppressWarnings("static-access")
	public void setFieldHorarioInicio(JTextField fieldHorarioInicio) {
		this.fieldHorarioInicio = fieldHorarioInicio;
	}

	public static JTextField getFieldHorarioSaida() {
		return fieldHorarioSaida;
	}

	@SuppressWarnings("static-access")
	public void setFieldHorarioSaida(JTextField fieldHorarioSaida) {
		this.fieldHorarioSaida = fieldHorarioSaida;
	}
	
	public static void metodoDevolveValor(String cpfaluno, String nomealuno, String nomecurso,
										  String representantecord, String universidade, 
										  String representanteuni) 
	{

		getFieldCPFAluno().setText(cpfaluno);
		getFieldNomeAluno().setText(nomealuno);
		getFieldNomeCurso().setText(nomecurso);
		getFieldNomeUni().setText(universidade);
		getFieldNomeRepUni().setText(representanteuni);
		getFieldNomeRepCur().setText(representantecord);
		
		System.out.println("atualizou!");

	}

	public static void limparTela() 
	{

		getFieldCPFAluno().setText(null);
		getFieldCNPJEmpresa().setText(null);
		getFieldRazaoSoc().setText(null);
		getFieldNomeRepCur().setText(null);
		getFieldNomeRepresentanteEmp().setText(null);
		getFieldInfo().setText(null);
		getFormattedValBolsa().setText(null);
		getFieldAreaEstagio().setText(null);
		getFieldPrincAtiv().setText(null);
		getFieldInicioEstagio().setText(null);
		getFieldFimEstagio().setText(null);
		getFieldCHDiaria().setText(null);
		getFieldCHSemanal().setText(null);
		getFieldHorarioSaida().setText(null);
		getFieldBeneficios().setText(null);
		System.out.println("limpou!");

	}

	public static JButton getButtonLimparTela() {
		return buttonLimparTela;
	}

	public void setButtonLimparTela(JButton buttonLimparTela) {
		TelaTermoCompromisso.buttonLimparTela = buttonLimparTela;
	}

	public static JButton getButonLerTC() {
		return butonLerTC;
	}

	public void setButonLerTC(JButton butonLerTC) {
		TelaTermoCompromisso.butonLerTC = butonLerTC;
	}

	public static JTextField getFieldAreaEstagio() {
		return fieldAreaEstagio;
	}

	public void setFieldAreaEstagio(JTextField fieldAreaEstagio) {
		TelaTermoCompromisso.fieldAreaEstagio = fieldAreaEstagio;
	}

	public static JTextField getFieldBeneficios() {
		return fieldBeneficios;
	}

	public void setFieldBeneficios(JTextField fieldBeneficios) {
		TelaTermoCompromisso.fieldBeneficios = fieldBeneficios;
	}

	public static JTextField getFieldPrincAtiv() {
		return fieldPrincAtiv;
	}

	public void setFieldPrincAtiv(JTextField fieldPrincAtiv) {
		TelaTermoCompromisso.fieldPrincAtiv = fieldPrincAtiv;
	}

	public static JTextField getFieldNomeAluno() {
		return fieldNomeAluno;
	}

	public void setFieldNomeAluno(JTextField fieldNomeAluno) {
		TelaTermoCompromisso.fieldNomeAluno = fieldNomeAluno;
	}

	public static JTextField getFieldNomeCurso() {
		return fieldNomeCurso;
	}

	public void setFieldNomeCurso(JTextField fieldNomeCurso) {
		TelaTermoCompromisso.fieldNomeCurso = fieldNomeCurso;
	}

	public static JTextField getFieldNomeOrientador() {
		return fieldNomeOrientador;
	}

	public void setFieldNomeOrientador(JTextField fieldNomeOrientador) {
		TelaTermoCompromisso.fieldNomeOrientador = fieldNomeOrientador;
	}

	public static JTextField getFieldNomeUni() {
		return fieldNomeUni;
	}

	public void setFieldNomeUni(JTextField fieldNomeUni) {
		TelaTermoCompromisso.fieldNomeUni = fieldNomeUni;
	}

	public static JTextField getFieldNomeRepUni() {
		return fieldNomeRepUni;
	}

	public void setFieldNomeRepUni(JTextField fieldNomeRepUni) {
		TelaTermoCompromisso.fieldNomeRepUni = fieldNomeRepUni;
	}

	public static JTextField getFieldRazaoSoc() {
		return fieldRazaoSoc;
	}

	public void setFieldRazaoSoc(JTextField fieldRazaoSoc) {
		TelaTermoCompromisso.fieldRazaoSoc = fieldRazaoSoc;
	}

	public static JTextField getFieldNomeRepCur() {
		return fieldNomeRepCur;
	}

	public void setFieldNomeRepCur(JTextField fieldNomeRepCur) {
		TelaTermoCompromisso.fieldNomeRepCur = fieldNomeRepCur;
	}

	public static JTextField getFieldInfo() {
		return fieldInfo;
	}

	public void setFieldInfo(JTextField fieldInfo) {
		TelaTermoCompromisso.fieldInfo = fieldInfo;
	}

	public static JFormattedTextField getFormattedValBolsa() {
		return formattedValBolsa;
	}

	public static void setFormattedValBolsa(JFormattedTextField formattedValBolsa) {
		TelaTermoCompromisso.formattedValBolsa = formattedValBolsa;
	}

	public static JTextField getFieldFimEstagio() {
		return fieldFimEstagio;
	}

	public static void setFieldFimEstagio(JTextField fieldFimEstagio) {
		TelaTermoCompromisso.fieldFimEstagio = fieldFimEstagio;
	}

	public static JTextField getFieldInicioEstagio() {
		return fieldInicioEstagio;
	}

	public static void setFieldInicioEstagio(JTextField fieldInicioEstagio) {
		TelaTermoCompromisso.fieldInicioEstagio = fieldInicioEstagio;
	}

}
