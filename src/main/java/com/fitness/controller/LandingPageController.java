package com.fitness.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/")
@Controller
public class LandingPageController {

	  
	    public String index() {
	        return "index";
	    }
}
