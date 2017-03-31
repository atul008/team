package com.team.service.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class VowelFrequencyCalculator {
	private static String vowels = "aeiou";
	private Logger logger = Logger.getLogger(VowelFrequencyCalculator.class);

	public Map<String, Integer> calcuate(List<String> words) {
		logger.info("VowelFrequencyCalculator : Words " + words);
		Map<String, Integer> freq = new HashMap<String, Integer>();
		for (String word : words) {
			for (char c : word.toCharArray()) {
				if (vowels.contains(String.valueOf(c))) {
					Integer count = freq.get(String.valueOf(c)	);
					if (count == null) {
						count = 0;
					}
					count += 1;
					freq.put(String.valueOf(c), count);
				}
			}
		}
		logger.info("VowelFrequencyCalculator : freq " + freq);
		return freq;
	}
}
