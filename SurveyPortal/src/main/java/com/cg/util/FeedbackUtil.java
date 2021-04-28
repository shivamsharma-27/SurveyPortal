package com.cg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.FeedbackDetails;
import com.cg.apps.surveyapp.dto.ParticipantDetails;
import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.feedback.entities.Feedback;

@Component
public class FeedbackUtil {

	@Autowired
	private ParticipantUtil partUtil;

	@Autowired
	private SurveyUtil surveyUtil;

	public FeedbackDetails toDetails(Feedback feed) {
		ParticipantDetails participant = partUtil.toDetails(feed.getParticipant());
		SurveyDetails survey = surveyUtil.toDetails(feed.getSurvey());
		return new FeedbackDetails(feed.getId(), survey, feed.getPostedDateTime(), participant,
				feed.getChosenAnswers());
	}

	public List<FeedbackDetails> toDetails(List<Feedback> feedbacks) {
		List<FeedbackDetails> feedDetails = new ArrayList<>();
		for (Feedback feedback : feedbacks) {
			feedDetails.add(toDetails(feedback));
		}
		return feedDetails;
	}

}
