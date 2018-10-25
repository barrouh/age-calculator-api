package com.barrouh.agecalculatorapi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DefaultController {

	final static Logger LOGGER = LogManager.getLogger(DefaultController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = "/getAge", method = RequestMethod.GET)
	public String findDiffsRefresh(ModelMap model) {
		return "index";
	}
	
	@RequestMapping(value = "/getAge", method = RequestMethod.POST)
	public ModelAndView doTranslate( 
			@RequestParam(value = "birthdate", required = true) String birthdate) {

		ModelAndView model = new ModelAndView();
		
		LOGGER.info(birthdate);	
		
		
		model.setViewName("index");
		model.addObject("translatedText", birthdate);

		return model;

	}

}
