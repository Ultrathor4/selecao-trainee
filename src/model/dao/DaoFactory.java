package model.dao;

import db.DB;
import model.dto.UserDto;

public class DaoFactory {

	public static UserDao createUserDao() {
		return new UserDto(DB.getConnection());
	}
}
