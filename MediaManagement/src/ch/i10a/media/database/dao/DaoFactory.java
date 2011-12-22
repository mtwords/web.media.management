package ch.i10a.media.database.dao;

import java.io.Serializable;

public abstract class DaoFactory<T extends Serializable> {

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
