package ar.edu.unju.fi.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

	@GetMapping("/inicio")
	public String getindex() {
		return "index";
	}
}
