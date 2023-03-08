package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class A {
	
	@GetMapping("/hello")
	public void s()
	{
		System.out.println("hello view");
		System.err.println("hhhhhhhhhhhhhhhhhh");

	}

}
