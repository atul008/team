package com.team.service.helper;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TextSanitizer {
	@Autowired
	private WordProvider wordProvider;
    private Logger logger = Logger.getLogger(TextSanitizer.class);
    
	public List<String> sanitize(String text) {
		logger.info("Test before sanitization : " + text);
		List<String> words = Arrays.asList(text.split(" "));
		List<String> sanitzedList = words.stream().filter(word -> !wordProvider.isNegative(word))
				.collect(Collectors.toList());

		logger.info("Test after sanitization : " + sanitzedList.toString());
		return sanitzedList;
	}
}
