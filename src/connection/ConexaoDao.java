package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoDao {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/BancoPopulado";
	private static final String USER = "root";
	private static final String PASS = "Ba56Zn30Ga31";

	//Open Connection
	public static Connection getConnection() {


			try {
				Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USER, PASS);

			} catch (ClassNotFoundException | SQLException ex) {
				throw new RuntimeException("Conex�o com servidor falhou:", ex);
			}
	}

	//Close Connection
	public static void closeConnection(Connection con) {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	//Second try close
	public static void closeConnection(Connection con, PreparedStatement stmt) {

			closeConnection(con);

			try {
				if(stmt != null) {
					stmt.close();
				}

			} catch (SQLException ex) {
				Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	//Final try close
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

		closeConnection(con, stmt);

		try {
			if(rs != null) {
				rs.close();
			}

		} catch (SQLException ex) {
			Logger.getLogger(ConexaoDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
