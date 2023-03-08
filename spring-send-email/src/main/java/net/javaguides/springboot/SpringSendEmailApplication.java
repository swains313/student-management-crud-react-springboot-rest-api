package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringSendEmailApplication {

	@Autowired
	private EmailSenderService emailSenderService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSendEmailApplication.class, args);
	}
	
	
	@EventListener(ApplicationReadyEvent.class)
	public void sendMail()
	{
		emailSenderService.sendEmail("saumyaswain00@gmail.com", "this is subject", "this is body of sggsgs email");
	}

}
