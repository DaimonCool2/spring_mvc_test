package kz.java.training.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kz.java.training.entity.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login-page", method = RequestMethod.GET)
	public ModelAndView loginPage(@ModelAttribute() User user) {
		return new ModelAndView("login", "user", user);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String main2() {
		return "main";
	}
	
//проверка редиректа	
//	@RequestMapping(value = "/main", method = RequestMethod.GET)
//	public ModelAndView mainMethod(@ModelAttribute User user) {
//		return new ModelAndView("main", "user", user);
//	}	
//	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
//	public String checkUser(@ModelAttribute User user, RedirectAttributes rd) {
//		rd.addFlashAttribute("user", user);
//		return "redirect:/main";
//	}
	
	@RequestMapping(value = "/failed", method = RequestMethod.GET)
	public ModelAndView failed() {
		return new ModelAndView("login-failed", "message", "Login failed!");
	}
	
	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
	public String checkUser(@Valid @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes rd) {
		if(bindingResult.hasErrors()) {
			rd.addFlashAttribute("org.springframework.validation.BindingResult.user", bindingResult);
		    rd.addFlashAttribute("user2", user);
			return "redirect:/m";
		}
		
		return "main";
	}
	
	@RequestMapping(value = "/checkStrength", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
	@ResponseBody
	public String checkStrength(@RequestParam String password) {
		if(password.length() >= 1 && password.length() < 5) {
			return "Слабый";
		} else if(password.length() >= 5 && password.length() < 7) {
			return "Средний";
		} else if(password.length() >= 7) {
			return "Сильный";
		}
		return "";
	}

//	@RequestMapping(value = "/check-user", method = RequestMethod.POST)
//	public ModelAndView checkUser(@ModelAttribute User user) {
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("main");
//		modelAndView.addObject("user", user);
//		
//		return modelAndView;
//	}
	
/*	
 * веб сервисы
 * @RequestMapping(value = "/get-json-user", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public User getJsonUser(@RequestParam("name") String name) {
		User user = new User();
		user.setName(name);
		return user;
	}
	
	@RequestMapping(value = "/put-json-user", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<String> setJsonUser(@RequestBody User user) {
		logger.info(user.getName());
		return new ResponseEntity<String>(HttpStatus.ACCEPTED);
	}*/
	
}
