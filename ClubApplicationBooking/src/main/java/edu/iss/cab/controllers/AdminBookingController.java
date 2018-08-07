package edu.iss.cab.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.cab.model.Facility;
import edu.iss.cab.service.FacilityService;

@RequestMapping(value = "/booking")
@Controller
public class AdminBookingController {
	@Autowired
	private FacilityService fService;

	@RequestMapping(value = "/facilities", method = RequestMethod.GET)
	public ModelAndView showFacilities() {
		ModelAndView mav = new ModelAndView("facility-book");
		List<Facility> facilityList = fService.findAllFacilitiesWithStatus();
		mav.addObject("facilityList", facilityList);
		return mav;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView bookingFacilityPage(@PathVariable String id) {
		ModelAndView mav = new ModelAndView("book-make");
		//Facility facility = fService.findFacility(id);
		//mav.addObject("facility", facility);
		return mav;
	}
}
