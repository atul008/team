package com.team.web.model;

public class TextSaveResponse {

	String id;
	public TextSaveResponse(Integer id){
		this.id = id.toString();
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
