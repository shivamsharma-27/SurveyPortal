package com.cg.apps.surveyapp.survey.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.ParticipantDetails;
import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.survey.service.ISurveyService;
import com.cg.util.ParticipantUtil;
import com.cg.util.SurveyUtil;

@RestController
@RequestMapping("/survey")
@Validated
public class SurveyController {
	@Autowired
	private ISurveyService surveyService;

	@Autowired
	private SurveyUtil surveyUtil;

	private ParticipantUtil partUtil;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from survey controller";
	}

	@PostMapping("/update")
	public SurveyDetails updateSurvey(@RequestBody @Valid Survey survey) {
		Survey sur = surveyService.updateSurveyDescription(survey.getId(), survey.getDescription());
		return surveyUtil.toDetails(sur);
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public SurveyDetails add(@RequestBody @Valid Survey survey) {

		Survey sur = surveyService.add(survey);
		return surveyUtil.toDetails(sur);
	}

	@GetMapping("/count/surveys")
	public int countFeedbacksInSurvey(@RequestBody @Valid Survey survey) {
		int count = 0;
		count = surveyService.countFeedbacksInSurvey(survey);
		return count;
	}

	@GetMapping("/participants")
	public List<ParticipantDetails> findParticipants(@RequestBody @Valid Survey survey) {
		List<Participant> participants = surveyService.findParticipants(survey);
		return partUtil.toDetails(participants);
	}

}
