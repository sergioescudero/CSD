package dao;

import entity.User;
import exception.DaoException;

public interface UserDao extends Dao<User, String> {

	boolean isValidPassword(User user, String password);

	void setPassword(User user, String password);

	User findByEmail(String email) throws DaoException;
}
