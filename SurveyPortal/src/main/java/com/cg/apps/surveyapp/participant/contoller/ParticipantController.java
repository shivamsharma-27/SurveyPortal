package com.cg.apps.surveyapp.participant.contoller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.surveyapp.dto.FeedbackDetails;
import com.cg.apps.surveyapp.dto.ParticipantDetails;
import com.cg.apps.surveyapp.feedback.entities.Feedback;
import com.cg.apps.surveyapp.participant.entities.Participant;
import com.cg.apps.surveyapp.participant.service.IParticipantService;
import com.cg.util.FeedbackUtil;
import com.cg.util.ParticipantUtil;

@RestController
@RequestMapping("/participant")
@Validated
public class ParticipantController {

	@Autowired
	private IParticipantService participantService;

	@Autowired
	private ParticipantUtil partUtil;

	@Autowired
	private FeedbackUtil feedUtil;

	@RequestMapping("/hello")
	public String greet() {

		return "Hello!! from participant controller";
	}

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public ParticipantDetails addParticipant(@RequestBody @Valid Participant participantDetails) {
		Participant part = participantService.register(participantDetails);
		return partUtil.toDetails(part);
	}

	@GetMapping("/all")
	public List<ParticipantDetails> findAll() {
		List<Participant> participants = participantService.findAll();
		return partUtil.toDetails(participants);
	}

	@GetMapping("/count/participations")
	public int countParticipations(@RequestBody @Valid Participant participant) {
		int count = 0;
		count = participantService.countParticipations(participant);
		return count;
	}

	@PostMapping("/update")
	public ParticipantDetails updateParticipant(@RequestBody @Valid Participant participant) {

		Participant part = participantService.update(participant);
		return partUtil.toDetails(part);
	}

	@GetMapping("/find/feedback/{dateTime}")
	public List<FeedbackDetails> findFeedbacksByParticipantAfterDateTime(@RequestBody @Valid Participant participant,
			@PathVariable("dateTime") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDate dateTime) {
		List<Feedback> feedbacks = participantService.findFeedbacksByParticipantAfterDateTime(participant, dateTime);
		return feedUtil.toDetails(feedbacks);
	}
}
