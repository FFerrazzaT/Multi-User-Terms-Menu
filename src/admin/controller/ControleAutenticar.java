package controller;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import view.JanelaPrincipal;
import view.TelaAutenticar;

@SuppressWarnings("serial")
public class ControleAutenticar extends TelaAutenticar
{

	public static void botaoLimparAutenticacao()
	{
		// TODO Auto-generated method stub
		System.out.println("campos limpados");
		TelaAutenticar.limparTela();
	}

	public static void botaoConfirmarAutenticacao()
	{
		// TODO Auto-generated method stub
		System.out.println("autenticação confirmada");
		
		JOptionPane.showMessageDialog(null,
				 "Autenticação realizada com sucesso.",
				 "Status Autenticação",
				 JOptionPane.INFORMATION_MESSAGE,
				 new ImageIcon(ControleAutenticar.class.getResource("/icons/Unlock.png")));
		
		JanelaPrincipal.autenticadoDesbloqueio();
	}

}
