package my.studentSystem.util;

import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB_Util {

	static String driver;
	static String DB_Url;
	static String user;
	static String password;

	static {
		

		driver = "com.mysql.jdbc.Driver";
		DB_Url = "jdbc:mysql://localhost:3306/edlee";
		user = "root";
		password = "haosql";

	}

	public static Connection open() throws SQLException {
		try {
			  
			Class.forName(driver);
			return DriverManager.getConnection(DB_Url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void close(Connection conn, PreparedStatement pstmt,
			ResultSet rs) {

		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
