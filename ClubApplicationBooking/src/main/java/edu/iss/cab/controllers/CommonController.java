package edu.iss.cab.controllers;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import edu.iss.cab.model.User;
import edu.iss.cab.service.UserService;

//CHIT SU SHINE
@Controller
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private UserService uService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("Home Page.");

		model.addAttribute("user", new User());
		return "login";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ModelAndView authenticate(@ModelAttribute User user, HttpSession session, BindingResult result) {
		ModelAndView mav = new ModelAndView("login");
		if (result.hasErrors()) {
			return mav;
		}
		UserSession us = new UserSession();
		if (user.getName() != null && user.getPassword() != null) {
			User u = uService.authenticate(user.getName(), user.getPassword());
			// If user is not found, return login page
			if (u == null) {
				return mav;
			} else {
				us.setUser(u);
				// PUT CODE FOR SETTING SESSION ID
				us.setSessionId(session.getId());
				mav = new ModelAndView("redirect:/booking/facilities");
			}
		} else {
			return mav;
		}
		session.setAttribute("USERSESSION", us);
		return mav;
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
