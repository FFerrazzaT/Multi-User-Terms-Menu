package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import data.connection.ConexaoDao;
import view.JanelaPrincipal;

public class DaoLoggin
{
	
	public static String usuarioStringComparacao = "";
	public static String senhaStringComparacao = "";
	
	public static void recebeAsStrings(String usuarioString, String senhaString)
	{
		usuarioStringComparacao = usuarioString;
		senhaStringComparacao = senhaString;
		
		System.out.println(usuarioStringComparacao + " " + senhaStringComparacao);
	}
	
	//CRUD
	
	//	LER DO BANCO E VERIFICAR
		public boolean checklogin(String loginstring, String senhastring){
			
			Connection con = ConexaoDao.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			boolean check = false;
			
			try {
				stmt = con.prepareStatement("SELECT * FROM Loggin WHERE idUsuario = ? and senhaUsuario = ?");
				stmt.setString(1, loginstring);
				stmt.setString(2, senhastring);
				
				rs = stmt.executeQuery();
				
				if(rs.next()) {
					
					check = true;
					System.out.println(loginstring);
					System.out.println(senhastring);
					
					if(loginstring.equals("Bob")) 
						JanelaPrincipal.bobLogado();
					
					else if(loginstring.equals("Hopper")) 
						JanelaPrincipal.hopperLogado();
					
				}
				
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(null, "Leitura falhou");

			}finally {
				ConexaoDao.closeConnection(con, stmt, rs);
			}
			
			return check;
		}
}
