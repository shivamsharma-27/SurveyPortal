package com.cg.apps.surveyapp.surveyor.controller;

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

import com.cg.apps.surveyapp.dto.SurveyDetails;
import com.cg.apps.surveyapp.dto.SurveyorDetails;
import com.cg.apps.surveyapp.survey.entities.Survey;
import com.cg.apps.surveyapp.surveyor.entities.Surveyor;
import com.cg.apps.surveyapp.surveyor.service.ISurveyorService;
import com.cg.util.SurveyUtil;
import com.cg.util.SurveyorUtil;

@RestController
@RequestMapping("/surveyor")
@Validated
public class SurveyorController {

	@Autowired
	private ISurveyorService surveyorService;
	@Autowired
	private SurveyorUtil surveyorUtil;

	private SurveyUtil surveyUtil;

	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/add")
	public SurveyorDetails addSurveyor(@RequestBody @Valid Surveyor surveyorDetails) {

		Surveyor surveyor = surveyorService.register(surveyorDetails);
		return surveyorUtil.toDetails(surveyor);
	}

	@GetMapping("/find/all")
	public List<SurveyorDetails> findAll() {
		List<Surveyor> surveyors = surveyorService.findAll();
		return surveyorUtil.toDetails(surveyors);
	}

	@GetMapping("find/id/{id}")
	public SurveyorDetails findById(@PathVariable("id") Long id) {
		Surveyor surveyor = surveyorService.findById(id);
		return surveyorUtil.toDetails(surveyor);
	}

	@GetMapping("/find/survey/{datetime}")
	public List<SurveyDetails> findAllSurveysBySurveyorAfterDateTime(@RequestBody @Valid Surveyor surveyor,
			@PathVariable("dateTime") @DateTimeFormat(pattern = "dd-mm-yyyy") LocalDate dateTime) {

		List<Survey> surveys = surveyorService.findAllSurveysBySurveyorAfterDateTime(surveyor, dateTime);
		return surveyUtil.toDetails(surveys);
	}

	@PostMapping("/update")
	public Surveyor updateSurveyor(@RequestBody @Valid Surveyor surveyorDetails) {

		return surveyorService.update(surveyorDetails);
	}
}
