package data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDao {

	private static final String URL = "jdbc:mysql://localhost/";
	private static final String USER = "root";
	private static final String PASS = "Ba56Zn30Ga31";

	//Open Connection
	public static Connection getConnection() {


			try {
				return DriverManager.getConnection(URL, USER, PASS);

			} catch (SQLException ex) {
				throw new RuntimeException("Conex�o com servidor falhou:", ex);
			}
	}

	//Close Connection
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException ex) {
				Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
