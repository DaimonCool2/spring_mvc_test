package kz.java.training.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.RegistrationUser;
import kz.java.training.entity.User;
import kz.java.training.service.RegistrationManager;
import kz.java.training.validator.RegistrationUserValidator;

@Controller
public class RegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private RegistrationUserValidator confirmPasswordValidator;

	@Autowired
	@Qualifier("registrationManagerImpl")
	private RegistrationManager registrationManager;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(@ModelAttribute("repeatRegUser") RegistrationUser regUser) {
		return new ModelAndView("registration", "regUser", regUser);
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute() RegistrationUser regUser, BindingResult bindingResult,
			RedirectAttributes rd) {
		confirmPasswordValidator.validate(regUser, bindingResult);
		if (bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.regUser", bindingResult);
			rd.addFlashAttribute("repeatRegUser", regUser);
			return "redirect:/registration";
		} else {
			registrationManager.registrateUser(regUser);
			return "redirect:/login-page";
		}

		// return "login";
	}
	
	

}
