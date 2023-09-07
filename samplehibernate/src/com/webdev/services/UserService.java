package com.webdev.services;

import java.util.ArrayList;
import java.util.List;
import com.webdev.dto.UserDTO;
import com.webdev.exception.UserNotFoundException;

/**
 * UserService declares methods for User operations. It has got 2 implementation
 * class UserServiceHibImpl and UserServiceJdbcImpl class 
 * 
 * UserServiceHibImpl represents subsystem implemented by Hibernate fparamework
 * UserServiceJdbcImpl represents subsystem implemented by JDBC
 * 
 * @author param Sheikh
 *
 */
public interface UserService {
	
	public UserDTO authenticate(UserDTO userDto) throws UserNotFoundException;
	public UserDTO addUser(UserDTO dto);
	public UserDTO deleteUser(UserDTO dto);
	public UserDTO updateUser(UserDTO dto);	
	public List getUsers();
	public UserDTO getUser(String loginId);
	public UserDTO getUser(int id);
}
