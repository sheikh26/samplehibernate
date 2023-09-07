package com.webdev.services;

import java.util.List;

import com.webdev.dto.ApplicationDTO;

public interface ApplicationService {
	
	public ApplicationDTO addApplication(ApplicationDTO dto);
	public int deleteApplication(ApplicationDTO dto);
	public ApplicationDTO updateApplication(ApplicationDTO dto);	
	public ApplicationDTO getApplication(int Id);
	public List getApplicationList();
}
