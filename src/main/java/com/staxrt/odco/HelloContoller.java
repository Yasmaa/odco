package com.staxrt.odco;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloContoller {
	
	@GetMapping("/")
	String hello() {
			return "hello im asma";
		}
	

}
