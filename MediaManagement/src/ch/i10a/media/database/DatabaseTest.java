package ch.i10a.media.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;


public class DatabaseTest {

	@Test
	public void testConnection() {
		try {
			Connection con = getConnection();
			PreparedStatement ps = con.prepareStatement("select sysdate() from dual");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("Jupppppppieeeee: " + rs.getTime(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	// ------------------ connection things ------------------
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection( "jdbc:mysql://db4free.net:3306/mmanagement", "webmedia", "web.media");
	}
}
