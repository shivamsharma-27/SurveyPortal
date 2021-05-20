package com.cg.apps.surveyapp.survey.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.ParticipantDetails;
import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.pojos.SurveyRequest;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.service.ISurveyService;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;
import com.cg.apps.surveyapp.topic.service.ITopicService;
import com.cg.util.ParticipantUtil;
import com.cg.util.SurveyUtil;

/**
 * 
 * survey controller entry point for any http request from client for crud
 * operations in survey entity
 *
 */
@RestController
@RequestMapping("/survey")
@Validated
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;
	@Autowired
	private ISurveyorService surveyorService;
	@Autowired
	private SurveyUtil surveyUtil;
	@Autowired
	private ParticipantUtil partUtil;
	@Autowired
	private ITopicService topicService;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from survey controller";
	}

	@PostMapping("/update")
	public SurveyDetails updateSurvey(@RequestBody @Valid SurveyRequest surveyDetails) {
		Survey survey = new Survey(surveyDetails.getId(), surveyDetails.getDescription(),
				topicService.findById(surveyDetails.getTopic().getId()),
				surveyorService.findById(surveyDetails.getPostedBy().getId()), surveyDetails.getActive());
		Survey sur = surveyService.updateSurveyDescription(survey.getId(), survey.getDescription());
		return surveyUtil.toDetails(sur);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public SurveyDetails add(@RequestBody @Valid SurveyRequest surveyDetails) {
		Survey survey = new Survey(surveyDetails.getDescription(),
				topicService.findById(surveyDetails.getTopic().getId()),
				surveyorService.findById(surveyDetails.getPostedBy().getId()), surveyDetails.getActive());
		Survey sur = surveyService.add(survey);
		return surveyUtil.toDetails(sur);
	}

	@GetMapping("/count/feedbacks/{surveyId}")
	public int countFeedbacksInSurvey(@PathVariable("surveyId") Long surveyId) {
		int count = 0;
		Survey survey = surveyService.findById(surveyId);
		count = surveyService.countFeedbacksInSurvey(survey);
		return count;
	}

	@GetMapping("/participants/{surveyId}")
	public List<ParticipantDetails> findParticipants(@PathVariable("surveyId") Long surveyId) {
		Survey survey = surveyService.findById(surveyId);
		return partUtil.toDetails(surveyService.findParticipants(survey));
	}

	@GetMapping("/find/{id}")
	public SurveyDetails findById(@PathVariable("id") Long id) {
		Survey survey = surveyService.findById(id);
		return surveyUtil.toDetails(survey);
	}
}
