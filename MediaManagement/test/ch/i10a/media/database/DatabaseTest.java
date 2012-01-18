package ch.i10a.media.database;

import java.io.IOException;
import java.sql.Connection;
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

import ch.i10a.media.common.DBException;
import ch.i10a.media.common.UtilLib;
import ch.i10a.media.database.dao.AbstractDAO;
import ch.i10a.media.database.dao.DaoFactory;
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
	public void loadDatabaseObjectTest() throws DBException {
		context.checking(new Expectations() {
			{
				oneOf(dao).load(null);
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

	@Test
	public void deleteDBEntriesTest() {
		Connection connection = null;
		ResultSet rs = null;
		PreparedStatement psmnt = null;

		try {
			connection = getConnection();

			int s;

			// leeren von wrotescreenplay
			//
			psmnt = connection.prepareStatement("truncate wrotescreenplay");
			psmnt.executeUpdate();
			
			// leeren von has
			//
			psmnt = connection.prepareStatement("truncate has");
			s = psmnt.executeUpdate();
			// leeren von language
			//
			psmnt = connection.prepareStatement("truncate language");
			s = psmnt.executeUpdate();
			// leeren von directs
			//
			psmnt = connection.prepareStatement("truncate directs");
			s = psmnt.executeUpdate();
			// leeren von actsin
			//
			psmnt = connection.prepareStatement("truncate actsin");
			s = psmnt.executeUpdate();
			// leeren von category
			//
			psmnt = connection.prepareStatement("truncate category");
			s = psmnt.executeUpdate();
			// leeren von rating
			//
			psmnt = connection
					.prepareStatement("delete from rating where rating > 0");
			s = psmnt.executeUpdate();
			if (s > 0) {
				System.out.println("loeschen von rating erfolgreich");
			} else {
				System.out
						.println("loeschen von rating fehlgeschlagen oder Tabelle war leer.");
			}
			// leeren von person
			//
			psmnt = connection
					.prepareStatement("delete from person where pID > 0");
			s = psmnt.executeUpdate();
			if (s > 0) {
				System.out.println("loeschen von person erfolgreich");
			} else {
				System.out
						.println("loeschen von person fehlgeschlagen oder Tabelle war leer.");
			}
			// leeren von episode
			//
			psmnt = connection
					.prepareStatement("delete from episode where eID > 0");
			s = psmnt.executeUpdate();
			if (s > 0) {
				System.out.println("loeschen von episode erfolgreich");
			} else {
				System.out
						.println("loeschen von episode fehlgeschlagen oder Tabelle war leer.");
			}
			// leeren von movie
			//
			psmnt = connection
					.prepareStatement("delete from movie where mID > 0");
			s = psmnt.executeUpdate();
			if (s > 0) {
				System.out.println("loeschen von movie erfolgreich");
			} else {
				System.out
						.println("loeschen von movie fehlgeschlagen oder Tabelle war leer.");
			}

			//
			// Prüfen, ob die entsprechenden Tabellen leer sind
			//

			// Test für actsin
			rs = psmnt.executeQuery("select * from actsin");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle actsin enthält noch Einträge");
			} else {
				System.out.println("actsin ist leer");
			}
			// Test für category
			rs = psmnt.executeQuery("select * from category");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle category enthält noch Einträge");
			} else {
				System.out.println("category ist leer");
			}
			// Test für directs
			rs = psmnt.executeQuery("select * from directs");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle directs enthält noch Einträge");
			} else {
				System.out.println("directs ist leer");
			}
			// Test für episode
			rs = psmnt.executeQuery("select * from episode");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle episode enthält noch Einträge");
			} else {
				System.out.println("episode ist leer");
			}
			// Test für has
			rs = psmnt.executeQuery("select * from has");

			if (rs.next()) {
				System.out.println("ERROR: Tabelle has enthält noch Einträge");
			} else {
				System.out.println("has ist leer");
			}
			// Test für language
			rs = psmnt.executeQuery("select * from language");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle language enthält noch Einträge");
			} else {
				System.out.println("language ist leer");
			}
			// Test für movie
			rs = psmnt.executeQuery("select * from movie");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle movie enthält noch Einträge");
			} else {
				System.out.println("movie ist leer");
			}
			// Test für person
			rs = psmnt.executeQuery("select * from person");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle person enthält noch Einträge");
			} else {
				System.out.println("person ist leer");
			}
			// Test für rating
			rs = psmnt.executeQuery("select * from rating");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle rating enthält noch Einträge");
			} else {
				System.out.println("rating ist leer");
			}
			// Test für wrotescreenplay
			rs = psmnt.executeQuery("select * from wrotescreenplay");

			if (rs.next()) {
				System.out
						.println("ERROR: Tabelle wrotescreenplay enthält noch Einträge");
			} else {
				System.out.println("wrotescreenplay ist leer");
			}

		} catch (Exception ex) {
			System.out.println("Found some error : " + ex);
		} finally {
			// close all the connections.
			try {
				connection.close();
				psmnt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Test
	public void storeHotFuzzMovieTest() throws IOException, DBException {
		MediaDTO dto = new MediaDTO();
		dto.getMovieRec().setTitle("Hot Fuzz");
		dto.getMovieRec().setOriginalTitle("Hot Fuzz");
		dto.getMovieRec().setDuration(7260);
		dto.getMovieRec().setIcon(UtilLib.convertToByteArray("test/ch/i10a/media/images/hot-fuzz-poster-2.jpg"));
		dto.getMovieRec().setThumbnail(UtilLib.convertToByteArray("test/ch/i10a/media/images/thumbs/hot-fuzz-poster-2.jpg"));
		dto.getMovieRec().setGenre("0");
		dto.getMovieRec().setSearchTerms(new String[] {"Hot", "Fuzz", "England", "English"});
		dto.getMovieRec().setDescription("Jealous colleagues conspire to get a top London cop transferred to a small town and paired with a witless new partner. On the beat, the pair stumble upon a series of suspicious accidents and events.");

		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		dao.save(dto);
	}

	@Test
	public void storeChuckSerieTest() throws IOException, DBException {
		MediaDTO dto = new MediaDTO();
		// Movie-Data
		dto.getMovieRec().setTitle("Chuck");
		dto.getMovieRec().setOriginalTitle("Chuck");
		dto.getMovieRec().setDuration(1800);
		dto.getMovieRec().setIcon(UtilLib.convertToByteArray("test/ch/i10a/media/images/chuck0_1.jpg"));
		dto.getMovieRec().setThumbnail(UtilLib.convertToByteArray("test/ch/i10a/media/images/thumbs/chuck0_1.jpg"));
		dto.getMovieRec().setGenre("0");
		dto.getMovieRec().setSearchTerms(new String[] {"Chuck", "Bartowski", "Spy"});
		dto.getMovieRec().setDescription("When a twenty-something computer geek inadvertently downloads critical government secrets into his brain, CIA and NSA assign two agents to protect him and exploit such knowledge, turning his life upside down.");

		// Episode-Data (Episode 1)
		dto.getEpisodeRec().setEpisodeTitle("S01E01 - Pilot");
		dto.getEpisodeRec().setDescription("Chuck is a computer geek who gets a computer full of information zapped into his brain...information that contains secrets that the federal government desperately needs to keep in Chuck's head...and keep Chuck, himself, intact. In the opener Chuck meets a woman who agrees to go on a date with him, but she's one of the government agents who's interested more in his head than his body.");
		dto.getEpisodeRec().setYear("2007");
		dto.getEpisodeRec().setSaveLocation("O:\\vid\\Serien\\Chuck\\Season 1\\Chuck 01x01 - Pilot.avi");

		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		dao.save(dto);
	}
	@Test
	public void storeChuckEpisode2Test() throws DBException {
		MediaDTO dto = new MediaDTO();
		dto.getEpisodeRec().setEpisodeTitle("S01E02 - Chuck Versus the Helicopter");
		dto.getEpisodeRec().setDescription("The Government wants to verify the secrets are inside Chuck's head. So they send a doctor who programmed the Intersect system to examine Chuck. When the doctor's car explodes. There's evidence one of the agencies was involved, leaving Chuck unsure whom to trust.");
		dto.getEpisodeRec().setYear("2007");
		dto.getEpisodeRec().setSaveLocation("O:\\vid\\Serien\\Chuck\\Season 1\\S01E02 - Chuck Versus the Helicopter.avi");

		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		dao.save(dto);
	}
	@Test
	public void storeChuckEpisode3Test() throws DBException {
		MediaDTO dto = new MediaDTO();
		dto.getEpisodeRec().setEpisodeTitle("S01E02 - Chuck Versus the Tango");
		dto.getEpisodeRec().setDescription("A stolen piece of art is the key for locating a weapon's dealer. Chuck's up for a promotion to assistant manager at work.");
		dto.getEpisodeRec().setYear("2007");
		dto.getEpisodeRec().setSaveLocation("O:\\vid\\Serien\\Chuck\\Season 1\\Chuck 01x03 - Chuck Versus the Tango.avi");

		IDao dao = DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA);
		dao.save(dto);
	}

	// ------------------ connection things ------------------
	private Connection getConnection() throws SQLException, ClassNotFoundException {
		return AbstractDAO.getConnection();
	}
}
