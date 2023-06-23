package com.nenosystems.dto;

public class ModuleDTO extends BaseDTO{
	
	private String moduleId;

	private String moduleName;

	private String description;	

	private String moduleLead;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getModuleLead() {
		return moduleLead;
	}

	public void setModuleLead(String moduleLead) {
		this.moduleLead = moduleLead;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getModuleId() {
		return moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public String getListDescription() {
		
		return moduleName;
	}	

	
}
