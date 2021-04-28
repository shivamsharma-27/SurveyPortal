package com.cg.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.apps.surveyapp.dto.FeedbackDetails;
import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.survey.entities.Survey;

@Component
public class SurveyUtil {

	@Autowired
	private FeedbackUtil feedUtil;
	@Autowired
	private SurveyorUtil surveyorUtil;

	public SurveyDetails toDetails(Survey survey) {
		List<Feedback> feedbacks = survey.getFeedbacks();
		List<FeedbackDetails> feedDetails = new ArrayList<>();
		if (feedbacks != null) {
			for (Feedback feedback : feedbacks) {
				feedDetails.add(new FeedbackDetails(feedUtil.toDetails(feedback)));
			}
		}
		SurveyDetails surveyDetail = new SurveyDetails(survey.getId(), survey.getDescription(),
				survey.getPublishedDateTime(), survey.getEndDateTime(), survey.getActive());
		surveyDetail.setFeedbacks(feedDetails);
		return surveyDetail;
	}

	public List<SurveyDetails> toDetails(List<Survey> surveys) {
		List<SurveyDetails> surveyList = new ArrayList<>();
		for (Survey survey : surveys) {
			surveyList.add(toDetails(survey));
		}
		return surveyList;
	}

}
