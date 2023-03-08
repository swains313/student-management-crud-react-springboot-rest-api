package net.javaguides.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	
	
	
	public void sendEmail(String toEmail,String subject, String body)
	{
		SimpleMailMessage mailMessage=new SimpleMailMessage();
		mailMessage.setFrom("swains313@gmail.com");
		mailMessage.setTo(toEmail);
		mailMessage.setText(body);
		mailMessage.setSubject(subject);
		
		javaMailSender.send(mailMessage);
		System.out.println("Mail send successfully !!! ");
		
	}

}
