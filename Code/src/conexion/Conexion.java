package conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	
		private static final String driver=
				"com.mysql.cj.jdbc.Driver";
		private static final String url=
				"jdbc:mysql://localhost:3306/packagelog?serverTimezone=UTC";
		
		private static final String user="root";
		private static final String pwd="";
		
		static {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static Connection getConnection() {
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection(url, user, pwd);
				System.out.println("conexion realizada");
			} catch (SQLException e) {
				System.out.println("conexion NO realizada");
				e.printStackTrace();
			}
		
		return conn;
		
		}
		public static void closeConnection(Connection conn) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

