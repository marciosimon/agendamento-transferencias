package br.com.msf.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/agendamento")
public class HomeController {

	@RequestMapping("/")
	public ModelAndView init(ModelMap model) {
		return new ModelAndView("home", model);
	}
	
}