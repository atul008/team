package com.team.service.helper;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class WordFrequencyCalculator {
	private Logger logger = Logger.getLogger(WordFrequencyCalculator.class);

	public Map<String, Integer> calculate(List<String> words) {
		logger.info("WordFrequencyCalculator  words : " + words);
		Map<String, Integer> freq = words.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(s -> 1)));
		logger.info("WordFrequencyCalculator  freq : " + freq);
		return freq;
	}
}
