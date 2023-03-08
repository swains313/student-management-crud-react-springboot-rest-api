package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.javaguides.springboot.entity.MailRequest;
import net.javaguides.springboot.entity.MailResponse;
import net.javaguides.springboot.entity.User;
import net.javaguides.springboot.service.EmailService;

@Controller
public class MailController {
	
	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		User user=new User();
		user.setName("saumya");
		model.put("name", user.getName());
		model.put("location", "Bangalore,India");		
		return service.sendEmail(request, model);
	}

}
