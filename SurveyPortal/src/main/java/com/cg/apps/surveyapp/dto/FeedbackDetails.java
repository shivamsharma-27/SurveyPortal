package com.cg.apps.surveyapp.dto;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.question.entities.Option;
import com.fasterxml.jackson.annotation.JsonFormat;

public class FeedbackDetails {
	private Long id;

	private SurveyDetails survey;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate postedDateTime;

	private ParticipantDetails participant;

	private Map<Long, Option> chosenAnswers = new HashMap<>();

	public FeedbackDetails() {
		super();

	}

	public FeedbackDetails(Long id, SurveyDetails survey, LocalDate postedDateTime, ParticipantDetails participant,
			Map<Long, Option> chosenAnswers) {
		super();
		this.id = id;
		this.survey = survey;
		this.postedDateTime = postedDateTime;
		this.participant = participant;
		this.chosenAnswers = chosenAnswers;
	}

	public FeedbackDetails(SurveyDetails survey, LocalDate postedDateTime, ParticipantDetails participant,
			Map<Long, Option> chosenAnswers) {
		super();
		this.survey = survey;
		this.postedDateTime = postedDateTime;
		this.participant = participant;
		this.chosenAnswers = chosenAnswers;
	}

	public FeedbackDetails(FeedbackDetails details) {
		this.id = details.getId();
		this.chosenAnswers = details.getChosenAnswers();
		this.participant = details.getParticipant();
		this.postedDateTime = details.getPostedDateTime();
		this.survey = details.getSurvey();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SurveyDetails getSurvey() {
		return survey;
	}

	public void setSurvey(SurveyDetails survey) {
		this.survey = survey;
	}

	public LocalDate getPostedDateTime() {
		return postedDateTime;
	}

	public void setPostedDateTime(LocalDate postedDateTime) {
		this.postedDateTime = postedDateTime;
	}

	public ParticipantDetails getParticipant() {
		return participant;
	}

	public void setParticipant(ParticipantDetails participant) {
		this.participant = participant;
	}

	public Map<Long, Option> getChosenAnswers() {
		return chosenAnswers;
	}

	public void setChosenAnswers(Map<Long, Option> chosenAnswers) {
		this.chosenAnswers = chosenAnswers;
	}

	@Override
	public String toString() {
		return "FeedbackDetails [id=" + id + ", postedDateTime=" + postedDateTime + ", chosenAnswers=" + chosenAnswers
				+ "]";
	}

}
