package com.jsp.boot_email.Service;
import java.io.File;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailList;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
@Service
public class EmailService {
	@Autowired
JavaMailSender mailSender;
	public void sendMsg(Email email) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email.getTo());
		message.setSubject(email.getSubject());
		message.setText(email.getBody());
		message.setFrom("jkaveridvk@gmail.com");
		mailSender.send(message);
		
		
	}
	public void sendMsgs(EmailList list) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(list.getTo());
		message.setSubject(list.getSubject());
		message.setText(list.getBody());
		message.setFrom("jkaveridvk@gmail.com");
		mailSender.send(message);
	}
	
		

		public void sendHtmlEmail(Email email) throws MessagingException {
		    MimeMessage message = mailSender.createMimeMessage();

		    message.setFrom(new InternetAddress("jkaveridvk@gmail.com"));
		    message.setRecipients(MimeMessage.RecipientType.TO, "jkaveridvk@gmail.com");
		    message.setSubject("Test email from Spring");

		    String htmlContent = "<h1>This is a test Spring Boot email</h1>" +
		                         "<p>It can contain <strong>HTML</strong> content.</p>";
		    message.setContent(htmlContent, "text/html; charset=utf-8");

		    mailSender.send(message);
		}
		
		
		public void sendEmailWithAttachment(String to, String Subject, String body) throws MessagingException, IOException {

			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(to);
			helper.setSubject(Subject);
			helper.setText(body);

			FileSystemResource file = new FileSystemResource(new File("C:\\Users\\kaver\\Downloads\\pexels-photo-931177.jpeg"));
			helper.addAttachment(file.getFilename(), file);

			mailSender.send(message);
			}
	}
