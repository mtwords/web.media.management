package ch.i10a.media.database.dao;


public abstract class DaoFactory {

	public static final int TYPE_MEDIA = 0;
	public static final int TYPE_USER = 1;

	public static IDao loadDaoStrategy(int type) {
		switch (type) {
			case TYPE_MEDIA:
				return new MediaDAO();
			case TYPE_USER:
				return new UserDAO();
		}
		return null;
	}
}
