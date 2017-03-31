package com.team.constant;

public enum TaskStatus {
	
	IN_PROGRESS("in_progress"),
	COMPLETED("completed");
	
	private String label;
	
	TaskStatus(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
	
}
