package edu.hust.tu.projecti.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
	/**
	 * Đăng nhập
	 * @param uname Tài khoản
	 * @param passwd Mật khẩu
	 * @return ID người dùng, null nếu thất bại
	 * @throws SQLException Lỗi connection
	 */
	public static Integer login(String uname, String passwd) throws SQLException {
		Connection connection = Database.getConnection();
		PreparedStatement statement;
		statement = connection.prepareStatement("Select UID from Users "
				+ "where Users.Name = ? and Users.Passwd = ?");
		statement.setString(1, uname);
		statement.setString(2, passwd);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) return resultSet.getInt("UID");

		return null;
	}

	/**
	 * Tạo tài khoản trong Database
	 * @param uname tên tài khoản
	 * @param passwd mật khẩu
	 * @throws SQLException khi có lỗi connection hoặc tên người dùng đã tồn tại (error code : 19)
	 */
	public static void signUp(String uname, String passwd) throws SQLException {
		Connection connection = Database.getConnection();
		PreparedStatement statement;
		statement = connection.prepareStatement("INSERT INTO Users " +
				"(Name, Passwd) " +
				"VALUES(?, ?);");
		statement.setString(1, uname);
		statement.setString(2, passwd);

		statement.executeUpdate();
	}
}
