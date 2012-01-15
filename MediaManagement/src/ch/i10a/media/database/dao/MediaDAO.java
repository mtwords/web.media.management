package ch.i10a.media.database.dao;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ch.i10a.media.common.DBException;
import ch.i10a.media.common.UtilLib;
import ch.i10a.media.database.MediaDTO;

/**
 * Data access object to store, update, delete and load media data.
 * Should be accessed by <code>DaoFactory.loadDaoStrategy(DaoFactory.TYPE_MEDIA)</code>
 * @author OA, PK
 *
 */
public class MediaDAO extends AbstractDAO {

	@Override
	public void save(Object rec) throws DBException {
		MediaDTO dto = (MediaDTO) rec;

		if (dto.getMovieRec() != null) {
			saveMovie(dto);
			saveCategorie(dto);
		}
		if (dto.getEpisodeRec() != null) {
			saveEpisode(dto);
		}
		// TODO implement others!
	}

	/**
	 * Insert media into table 'movie'
	 */
	private void saveMovie(MediaDTO dto) throws DBException {
		PreparedStatement ps = null;
		Connection connection = null;

		try {
			connection = getConnection();

			ps = connection.prepareStatement(
					"insert into movie(title, originalTitle, duration, icon, thumbnail, type, keywords, description) "
							+ "values(?,?,?,?,?,?,?,?)");

			// set values
			ps.setString(1, dto.getMovieRec().getTitle());
			ps.setString(2, dto.getMovieRec().getOriginalTitle());
			ps.setString(3, String.valueOf(dto.getMovieRec().getDuration()));
			ps.setBinaryStream(4, new ByteArrayInputStream(dto.getMovieRec().getIcon()));
			ps.setBinaryStream(5, new ByteArrayInputStream(dto.getMovieRec().getThumbnail()));
			ps.setString(6, "0");
			ps.setString(7, UtilLib.convertArrayToString(dto.getMovieRec().getSearchTerms()));
			ps.setString(8,	dto.getMovieRec().getDescription());

			ps.executeUpdate();
		} catch (ClassNotFoundException ex) {
			throw new DBException("err.db.driver_could_not_be_loaded");
		} catch (SQLException ex) {
			throw new DBException("err.db.statement_failed");
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	private void saveEpisode(MediaDTO dto) throws DBException {
		PreparedStatement ps = null;
		Connection connection = null;

		try {
			connection = getConnection();
			ps = connection.prepareStatement("insert into episode(episodeTitle, description, year, saveLocation, saveDate, mId) "
					+ "values(?,?,?,?,?,(Select mId from movie where title = '" + dto.getMovieRec().getTitle() + "'))");
	
			ps.setString(1, dto.getEpisodeRec().getEpisodeTitle());
			ps.setString(2,	dto.getEpisodeRec().getDescription());
			ps.setString(3, dto.getEpisodeRec().getYear());
			ps.setString(4,	dto.getEpisodeRec().getSaveLocation());
			ps.setDate(5, dto.getEpisodeRec().getSaveDate());

			ps.executeUpdate();
		} catch (ClassNotFoundException ex) {
			throw new DBException("err.db.driver_could_not_be_loaded");
		} catch (SQLException ex) {
			throw new DBException("err.db.statement_failed");
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Insert info into table 'category'
	 */
	private void saveCategorie(MediaDTO dto) throws DBException {
		PreparedStatement ps = null;
		Connection connection = null;

		try {
			connection = getConnection();

			ps = connection.prepareStatement("insert into category(category, mId) "
							+ "values(?,(Select mId from movie where title = '" + dto.getMovieRec().getTitle() + "'))");

			ps.setString(1, dto.getMovieRec().getTitle());

			ps.executeUpdate();
		} catch (ClassNotFoundException ex) {
			throw new DBException("err.db.driver_could_not_be_loaded");
		} catch (SQLException ex) {
			throw new DBException("err.db.statement_failed");
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Insert info into table 'language'
	 */
	private void saveLanguage(MediaDTO dto) throws DBException {
		PreparedStatement ps = null;
		Connection connection = null;

		try {
			connection = getConnection();

			ps = connection.prepareStatement("insert into language(lang, mId) "
					+ "values(?,(Select mId from movie where title =  '" + dto.getMovieRec().getTitle() + "'))");

			ps.setString(1, "E");
		
			ps.executeUpdate();
		} catch (ClassNotFoundException ex) {
			throw new DBException("err.db.driver_could_not_be_loaded");
		} catch (SQLException ex) {
			throw new DBException("err.db.statement_failed");
		} finally {
			try {
				ps.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(Object rec) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object rec) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object load(String name) throws DBException {
		MediaDTO dto = new MediaDTO();

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = getConnection();
			ps = con.prepareStatement("﻿SELECT * FROM 'movie' where title = \"" + name +"\"");
			rs = ps.executeQuery();

			int i = 1;
			dto.getMovieRec().setMovieId(rs.getInt(i++));
			dto.getMovieRec().setTitle(rs.getString(i++));
			dto.getMovieRec().setOriginalTitle(rs.getString(i++));
			dto.getMovieRec().setDuration(rs.getInt(i++));
			dto.getMovieRec().setIcon(UtilLib.convertToByteArray(rs.getBinaryStream(i++)));
			dto.getMovieRec().setThumbnail(UtilLib.convertToByteArray(rs.getBinaryStream(i++)));
			dto.getMovieRec().setType(rs.getInt(i++));
			dto.getMovieRec().setSearchTerms(UtilLib.convertStringToArray(rs.getString(i++)));
			dto.getMovieRec().setDescription(rs.getString(i++));
		} catch (ClassNotFoundException ex) {
			throw new DBException("err.db.driver_could_not_be_loaded");
		} catch (SQLException ex) {
			throw new DBException("err.db.statement_failed");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

}
