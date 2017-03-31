package com.team.web.model;

import java.util.Map;

public class TextProcessingResponse {
	private String id;
	private String start_time;
	private String end_time;
	private String status;
	private String sentiment;
	private String completed_task;
	private Map<String, Integer> word_freq;
	private Map<String, Integer> vowel_freq;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	public String getCompleted_task() {
		return completed_task;
	}
	public void setCompleted_task(String completed_task) {
		this.completed_task = completed_task;
	}
	public Map<String, Integer> getWord_freq() {
		return word_freq;
	}
	public void setWord_freq(Map<String, Integer> word_freq) {
		this.word_freq = word_freq;
	}
	public Map<String, Integer> getVowel_freq() {
		return vowel_freq;
	}
	public void setVowel_freq(Map<String, Integer> vowel_freq) {
		this.vowel_freq = vowel_freq;
	}
	
}
