package com.barrouh.agecalculatorapi;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
public class DefaultController {

	static final Logger LOGGER = LogManager.getLogger(DefaultController.class);
	
	private AgeCalculator ageCalculator = new AgeCalculator();
	
	private Gson gsonResult = new GsonBuilder().setPrettyPrinting().create();

	@ResponseBody
	@GetMapping(value = "/", headers = "Accept=*/*")
	public String getAgeGet() {
		return "";
	}

	@ResponseBody
	@GetMapping(value = "getAge", headers = "Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAgeGet(@RequestParam(value = "birthdate", required = true) String birthdate,
			@RequestParam(value = "ageAtTheDateOf", required = false) String ageAtTheDateOf,
			@RequestParam(value = "ageAs", required = false) String ageAs) {
		if (!ageCalculator.isValidDate(ageAtTheDateOf)) {
			ageAtTheDateOf = ageCalculator.formatDate(new Date());
		}
		LOGGER.info(ageAtTheDateOf);
		LOGGER.info(birthdate);

		if (ageAs == null || ageAs.equalsIgnoreCase("all")) {
			return gsonResult.toJson(ageCalculator.getFinalDateAsAll(birthdate, ageAtTheDateOf));
		} else {
			return gsonResult.toJson(ageCalculator.getFinalDateAs(birthdate, ageAtTheDateOf, DateTypes.getValueByName(ageAs)));		
		}
	}

	@PostMapping(value = "getAge", headers = "Accept=*/*", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getAgePost(@RequestParam(value = "birthdate", required = true) String birthdate,
			@RequestParam(value = "ageAtTheDateOf", required = false) String ageAtTheDateOf,
			@RequestParam(value = "ageAs", required = false) String ageAs) {
		if (!ageCalculator.isValidDate(ageAtTheDateOf)) {
			ageAtTheDateOf = ageCalculator.formatDate(new Date());
		}
		LOGGER.info(ageAtTheDateOf);
		LOGGER.info(birthdate);
		if (ageAs == null || ageAs.equalsIgnoreCase("all")) {
			return new Gson().toJson(ageCalculator.getFinalDateAsAll(birthdate, ageAtTheDateOf));
		} else {
			return new Gson()
					.toJson(ageCalculator.getFinalDateAs(birthdate, ageAtTheDateOf, DateTypes.getValueByName(ageAs)));
		}
	}
}
