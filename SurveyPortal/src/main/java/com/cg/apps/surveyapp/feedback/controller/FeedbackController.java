package com.cg.apps.surveyapp.feedback.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.FeedbackDetails;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.feedback.service.IFeedbackService;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.util.FeedbackUtil;

@RestController
@RequestMapping("/feedback")
@Validated
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private FeedbackUtil feedUtil;

	@RequestMapping("/hello")
	public String greet() {
		return "Hello! from Feedback Controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public FeedbackDetails addFeedback(@RequestBody @Valid Feedback feedbackDetails) {

		Feedback feed = feedbackService.createFeedback(feedbackDetails.getSurvey(), feedbackDetails.getParticipant(),
				feedbackDetails.getChosenAnswers());
		return feedUtil.toDetails(feed);
	}

	@GetMapping("/all")
	public List<FeedbackDetails> findAll() {
		List<Feedback> feedbacks = feedbackService.findAll();
		return feedUtil.toDetails(feedbacks);
	}

	@PostMapping("/update")
	public FeedbackDetails updateFeedback(@RequestBody @Valid Feedback feedback) {

		Feedback feed = feedbackService.updateFeedback(feedback.getId(), feedback.getChosenAnswers());
		return feedUtil.toDetails(feed);
	}

	@DeleteMapping("/delete/{id}")
	public void removeByFeedbackById(@PathVariable Long feedbackId) {
		feedbackService.removeByFeedbackById(feedbackId);
	}

	@GetMapping("/find/{dateTime}")
	public List<FeedbackDetails> findFeedbacksForSurveyAfterDateTime(@RequestBody Survey survey,
			@PathVariable("dateTime") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDate dateTime) {
		List<Feedback> feedbacks = feedbackService.findFeedbacksForSurveyAfterDateTime(survey, dateTime);
		return feedUtil.toDetails(feedbacks);
	}

}
