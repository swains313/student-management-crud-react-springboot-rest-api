package net.javaguides.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.dto.MailRequest;
import net.javaguides.springboot.dto.MailResponse;
import net.javaguides.springboot.service.EmailService;


@SpringBootApplication
@RestController
public class SentMailHtmlpageApplication {

	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		Map<String, Object> model = new HashMap<>();
		model.put("Name", request.getName());
		model.put("location", "Bangalore,India");
		return service.sendEmail(request, model);

	}

	public static void main(String[] args) {
		SpringApplication.run(SentMailHtmlpageApplication.class, args);
	}
}