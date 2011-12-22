package ch.i10a.media.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import ch.i10a.media.database.dao.IDao;


@RunWith(JMock.class) 
public class DatabaseTest {

	Mockery context;
	IDao dao;

	@Before
	public void initialize() {
		context = new JUnit4Mockery();
		dao = context.mock(IDao.class);
	}

	@Test
	public void loadDatabaseObjectTest() {
		context.checking(new Expectations() {
			{
				oneOf(dao).load();
				will(returnValue(null));
			}
		});
	}

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
