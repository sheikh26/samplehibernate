package com.nenosystems.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;

import com.nenosystems.dto.UserDTO;

public class UserServiceJdbcImpl implements UserService {

	Connection con = null;

	Statement stmt = null;

	public UserServiceJdbcImpl() {

		try {

			ResourceBundle rb = ResourceBundle
					.getBundle("com.nenosystems.resource.system");

			String driverName = rb.getString("database.driver");

			Class.forName(driverName);

			Connection con = DriverManager.getConnection(rb
					.getString("database.url"), rb.getString("database.user"),
					rb.getString("database.password"));

			stmt = con.createStatement();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public UserDTO authenticate(UserDTO dto) {

		ResultSet rs = null;

		String sql = "select * from users where LOGIN_ID= '" + dto.getUserId()
				+ "' and PASSWORD= '" + dto.getPassword() + "'";
		System.out.println(sql);

		try {

			rs = stmt.executeQuery(sql);

			if (rs.next()) {

				System.out.println("Got User");
				dto.setId(rs.getInt("ID"));
				dto.setFirstName(rs.getString("FIRST_NAME"));
				dto.setLastName(rs.getString("LAST_NAME"));
				dto.setUserId(rs.getString("LOGIN_ID"));
				dto.setPassword(rs.getString("PASSWORD"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;

	}

	public UserDTO addUser(UserDTO dto) {
		return null;
	}

	public UserDTO deleteUser(UserDTO dto) {
		return null;
	}

	public UserDTO getUser(int id) {
		return null;
	}

	public UserDTO getUser(String loginId) {
		return null;
	}

	public UserDTO updateUser(UserDTO dto) {
		return null;
	}

	public List getUsers() {
		return null;
	}

}
