package com.webdev.services;

import com.webdev.dto.ModuleDTO;
import com.webdev.dto.UserDTO;

public interface CommonService {
	public UserDTO[] getUserList();

	public ModuleDTO[] getModuleList();
}
