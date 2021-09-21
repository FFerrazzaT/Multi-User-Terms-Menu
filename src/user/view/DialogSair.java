package view;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DialogSair {

	protected static int opt = JOptionPane.showConfirmDialog(null, "Deseja Sair?", "confirmação", 1, 3,
															new ImageIcon(
																	DialogSair.class.getResource(
																		"/icons/23651_exit_system_xfce_icon.png")));


	public static void main(String[] args) {

		//  Caixa de confirmacao para o item sair da janela Principal


		switch (opt)
		{
		case 0:
			System.out.println("sim");
			JanelaPrincipal.autenticadoRebloqueio();
			break;
			
		case 1:
			System.out.println("n�o");
			break;
			
		case 2:
			System.out.println("cancelar");
			break;
			
		default:
			System.out.println("nenhuma opt");
			break;
		}
	}
}
