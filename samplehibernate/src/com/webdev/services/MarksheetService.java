package com.webdev.services;

import java.util.List;

import com.webdev.dto.MarksheetDTO;

public interface MarksheetService {

	public MarksheetDTO getMarkSheet(String rollNo) throws Exception;

	public int addMarkSheet(MarksheetDTO dto) throws Exception;

	public int updateMarkSheet(MarksheetDTO dto) throws Exception;

	public int deleteMarkSheet(MarksheetDTO dto) throws Exception;

	public List listMarksheet() throws Exception;

	public List getMeritList() throws Exception;

}