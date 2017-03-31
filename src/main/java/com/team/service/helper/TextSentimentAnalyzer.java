package com.team.service.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.team.constant.Sentiment;

@Component
public class TextSentimentAnalyzer {
	@Autowired
	WordProvider wordProvider;
	private Logger logger = Logger.getLogger(TextSentimentAnalyzer.class);

	public String analyze(List<String> words) {
		logger.info("words to analyze : " + words);
		int score = 0;
		for (String word : words) {
			score += wordProvider.isPositive(word) ? 1 : wordProvider.isNegative(word) ? -1 : 0;
		}
		logger.info("TextSentimentAnalyzer score : " + score);
		return score > 2 ? Sentiment.POSITIVE.getLabel() : (score < -2 ? Sentiment.NEGATIVE.getLabel() : Sentiment.NEUTRAL.getLabel());
	}

}
