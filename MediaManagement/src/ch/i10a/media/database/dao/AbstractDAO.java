package ch.i10a.media.database.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class for importing the database drivers and establish a connection the the database
 */
public abstract class AbstractDAO implements IDao {

	// ------------------ connection things ------------------
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection( "jdbc:mysql://db4free.net:3306/mmanagement", "webmedia", "web.media");
	}

}
