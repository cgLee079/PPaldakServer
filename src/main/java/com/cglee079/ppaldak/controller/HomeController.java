package com.cglee079.ppaldak.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/error")
	public HashMap<String, Object> home() {
		HashMap<String, Object> response = new HashMap<>();
		response.put("result", false);
		return response;
	}

}
