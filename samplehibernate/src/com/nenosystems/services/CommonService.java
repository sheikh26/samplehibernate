package com.nenosystems.services;

import com.nenosystems.dto.ModuleDTO;
import com.nenosystems.dto.UserDTO;

public interface CommonService {
	public UserDTO[] getUserList();

	public ModuleDTO[] getModuleList();
}
