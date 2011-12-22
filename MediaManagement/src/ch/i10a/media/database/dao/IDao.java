package ch.i10a.media.database.dao;

public interface IDao {

	public void save(Object rec);
	public void update(Object rec);
	public void delete(Object rec);
	public Object load();

}
