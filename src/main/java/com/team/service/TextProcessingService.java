package com.team.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.team.constant.TaskStatus;
import com.team.dao.TextDao;
import com.team.entity.TextEntity;
import com.team.service.helper.TextSanitizer;
import com.team.service.helper.TextSentimentAnalyzer;
import com.team.service.helper.VowelFrequencyCalculator;
import com.team.service.helper.WordFrequencyCalculator;
import com.team.web.model.TextProcessingResponse;
import com.team.web.model.TextSaveRequest;

@Service
public class TextProcessingService {
	@Autowired
	private TextDao textDao;
	@Autowired
	private TextSanitizer textSanitizer;
	@Autowired
	private VowelFrequencyCalculator vowelFrequencyCalculator;
	@Autowired
	private WordFrequencyCalculator wordFrequencyCalculator;
	@Autowired
	private TextSentimentAnalyzer textSentimentAnalyzer;
	@Autowired
	ThreadPoolTaskExecutor executor;

	public Integer persistRequest(TextSaveRequest request) {
		TextEntity textEntity = new TextEntity();
		textEntity.setText(request.getText());
		textDao.save(textEntity);
		return textEntity.getId();
	}

	public TextProcessingResponse processRequest(Integer id) throws InterruptedException, ExecutionException {
		Date startTime = new Date();
		TextProcessingResponse response = new TextProcessingResponse();
		TextEntity textEntity = textDao.findOne(id);
		if (textEntity != null) {
			response.setId(id.toString());
			response.setStart_time(startTime.toString());
			List<String> sanatizedList = textSanitizer.sanitize(textEntity.getText());
			Future<Map<String, Integer>> vowelFreqFuture = executor.submit(() -> vowelFrequencyCalculator.calcuate(sanatizedList));
			Map<String, Integer> wordFreq = wordFrequencyCalculator.calculate(sanatizedList);
			String sentiment = textSentimentAnalyzer.analyze(new ArrayList<String>(wordFreq.keySet()));
			response.setVowel_freq(vowelFreqFuture.get());
			response.setWord_freq(wordFreq);
			response.setSentiment(sentiment);
			response.setStatus(TaskStatus.COMPLETED.getLabel());
			response.setCompleted_task("5/5");
			Date endTime = new Date();
			response.setEnd_time(endTime.toString());
			return response;
		}
		return new TextProcessingResponse();
	}
}
