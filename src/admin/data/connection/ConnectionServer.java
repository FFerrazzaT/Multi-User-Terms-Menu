package data.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionServer {

	private static String local = null;
	private static String port = null;
	private static String database = null;
	private static String user = null;
	private static String password = null;
	
	public static String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		ConnectionServer.local = local;
	}

	public static String getPort() {
		return port;
	}

	public void setPort(String port) {
		ConnectionServer.port = port;
	}

	public static String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		ConnectionServer.database = database;
	}

	public static String getUser() {
		return user;
	}

	public void setUser(String user) {
		ConnectionServer.user = user;
	}

	public static String getPassword() {
		return password;
	}

	public void setPassword(String cs) {
		ConnectionServer.password = cs;
	}

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://"+ local +":"+ port + "/" + database;
	private static final String USER = user;
	private static final String PASS = password;

	//Open Connection
	public static Connection getConnection() {


			try {
				Class.forName(DRIVER);
				return DriverManager.getConnection(URL, USER, PASS);

			} catch (ClassNotFoundException | SQLException ex) {
				throw new RuntimeException("Conexão com servidor falhou:", ex);
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
