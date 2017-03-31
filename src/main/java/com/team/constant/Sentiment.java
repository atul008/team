package com.team.constant;

public enum Sentiment {

	POSITIVE("positive"),
	NEGATIVE("negative"),
	NEUTRAL("neutral");
	
	private String label;

	Sentiment(String label){
		this.label = label;
	}

	public String getLabel() {
		return label;
	}
}
