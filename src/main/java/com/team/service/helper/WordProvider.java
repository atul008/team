package com.team.service.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class WordProvider {
	private final String negativeWords = "cry,hate,fuck,kill,die,disgusting,awful,terrible,horrible";
	private final String postiveWords = "happy,like,amazing,good,love,agree,wonderful,true,enjoyable,great,incedible";
	private List<String> negativeList;
	private List<String> positiveList;
	
	@PostConstruct
	public void contruct(){
		negativeList = new ArrayList<String>(Arrays.asList(negativeWords.split(",")));
		positiveList = new ArrayList<String>(Arrays.asList(postiveWords.split(",")));
	}
	
	public Boolean isNegative(String word){
		return negativeList.contains(word);
	}

	public Boolean isPositive(String word){
		return positiveList.contains(word);
	}
}
