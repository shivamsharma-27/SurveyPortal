package com.cg.apps.surveyapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(FeedbackNotFoundException.class)
	public String handleFeedbackNotFound(FeedbackNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(TopicNotFoundException.class)
	public String handleTopicNotFound(TopicNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(SurveyNotFoundException.class)
	public String handleSurveyNotFound(SurveyNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(SurveyorNotFoundException.class)
	public String handleSurveyorNotFound(SurveyorNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(ParticipantNotFoundException.class)
	public String handleParticipantNotFound(ParticipantNotFoundException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidOptionException.class)
	public String handleInvalidOption(InvalidOptionException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidParticipantException.class)
	public String handleInvalidParticipant(InvalidParticipantException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidQuestionTextException.class)
	public String handleInvalidQuestion(InvalidQuestionTextException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSurveyException.class)
	public String handleInvalidSurvey(InvalidSurveyException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidSurveyorException.class)
	public String handleInvalidSurveyor(InvalidSurveyorException e) {
		return e.getMessage();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(InvalidTopicNameException.class)
	public String handleInvalidTopicName(InvalidTopicNameException e) {
		return e.getMessage();
	}
}
