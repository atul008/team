package com.team.controller;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team.service.TextProcessingService;
import com.team.web.model.TextProcessingResponse;
import com.team.web.model.TextSaveRequest;
import com.team.web.model.TextSaveResponse;

@RestController
@RequestMapping("/v1")
public class Controller {
	@Autowired
	private	TextProcessingService textProcessingService;
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public TextSaveResponse save(@RequestBody TextSaveRequest request) {
		String lowerCase = request.getText().toLowerCase();
		request.setText(lowerCase);
		Integer persistRequest = textProcessingService.persistRequest(request);
		return new TextSaveResponse(persistRequest);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public TextProcessingResponse process(@RequestParam(value = "id", required = true) int id) throws InterruptedException, ExecutionException {
		TextProcessingResponse processRequest = textProcessingService.processRequest(id);
		return processRequest;
	}

}
