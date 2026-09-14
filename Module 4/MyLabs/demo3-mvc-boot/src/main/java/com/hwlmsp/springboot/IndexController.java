package com.hwlmsp.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = "/")	
	public String showIndexPage() {
		System.out.println(" IndexController - showIndexPage() ");
		return "index";
	}
}
