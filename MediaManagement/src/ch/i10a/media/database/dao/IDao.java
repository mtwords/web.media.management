package ch.i10a.media.database.dao;

import ch.i10a.media.common.DBException;

public interface IDao {

	public void save(Object dto)  throws DBException ;
	public void update(Object dto) throws DBException ;
	public void delete(Object dto) throws DBException ;
	public Object load(String name) throws DBException ;

}
