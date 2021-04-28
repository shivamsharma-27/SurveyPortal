package com.cg.apps.surveyapp.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SurveyDetails {

	private Long id;

	private String description;

	private TopicDetails topic;

	private SurveyorDetails postedBy;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate publishedDateTime;
	@JsonFormat(pattern = "dd-MMM-yyyy", timezone = "Asia/Calcutta")
	private LocalDate endDateTime;
	private Boolean active;

	private List<FeedbackDetails> feedbacks = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TopicDetails getTopic() {
		return topic;
	}

	public void setTopic(TopicDetails topic) {
		this.topic = topic;
	}

	public SurveyorDetails getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(SurveyorDetails postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDate getPublishedDateTime() {
		return publishedDateTime;
	}

	public void setPublishedDateTime(LocalDate publishedDateTime) {
		this.publishedDateTime = publishedDateTime;
	}

	public LocalDate getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(LocalDate endDateTime) {
		this.endDateTime = endDateTime;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public List<FeedbackDetails> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<FeedbackDetails> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public SurveyDetails(Long id, String description, TopicDetails topic, SurveyorDetails postedBy,
			LocalDate publishedDateTime, LocalDate endDateTime, Boolean active) {
		super();
		this.id = id;
		this.description = description;
		this.topic = topic;
		this.postedBy = postedBy;
		this.publishedDateTime = publishedDateTime;
		this.endDateTime = endDateTime;
		this.active = active;
	}

	public SurveyDetails() {
		super();

	}

	public SurveyDetails(SurveyDetails details) {
		this.id = details.getId();
		this.active = details.getActive();
		this.description = details.getDescription();
		this.endDateTime = details.getEndDateTime();
		this.postedBy = details.getPostedBy();
		this.publishedDateTime = details.getPublishedDateTime();
		this.feedbacks = details.getFeedbacks();
	}

	public SurveyDetails(Long id2, String description2, SurveyorDetails details, LocalDate publishedDateTime2,
			LocalDate endDateTime2, Boolean active2) {
		this.id = id2;
		this.description = description2;
		this.postedBy = details;
		this.publishedDateTime = publishedDateTime2;
		this.endDateTime = endDateTime2;
		this.active = active2;
	}

	public SurveyDetails(Long id2, String description2, LocalDate publishedDateTime2, LocalDate endDateTime2,
			Boolean active2) {
		this.id = id2;
		this.description = description2;
		this.publishedDateTime = publishedDateTime2;
		this.endDateTime = endDateTime2;
		this.active = active2;
	}

	@Override
	public String toString() {
		return "SurveyDetails [id=" + id + ", description=" + description + ", topic=" + topic + ", publishedDateTime="
				+ publishedDateTime + ", endDateTime=" + endDateTime + ", active=" + active + "]";
	}

}
