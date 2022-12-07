package model.dao;

import model.entities.User;

public interface UserDao {

	public void systemLogin(User objUser);
	public void insertUser(User objUser);
	
}
