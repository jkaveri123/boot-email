package com.jsp.boot_email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.boot_email.Service.EmailService;
import com.jsp.boot_email.dto.Email;
import com.jsp.boot_email.dto.EmailList;

@RestController
public class EmailController {
	@Autowired
	EmailService service;

	@GetMapping("/msg")
	public String message() {
		return "hi";

	}

	@PostMapping("/send")
	public String sendMsg(@RequestBody Email email) {
		try {
			service.sendMsg(email);
			return "msg send sucessfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "internal issue try again";
		}

	}

	@PostMapping("/sendAll")
	public String sendMsgs(@RequestBody EmailList list) {
		try {
			service.sendMsgs(list);
			return "msg send sucessfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "internal issue try again";
		}

	}
	
	
	@PostMapping("/sendhtml")
	public String sendhtml(@RequestBody Email email) {
		try {
			service.sendHtmlEmail(email);
			return "msg send sucessfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "internal issue try again";
		}

	}
	
	
	@PostMapping("/sendAttachment")
	public String sendAttachment(@RequestParam String to,@RequestParam String Subject,@RequestParam String body) {
		try {
			service.sendEmailWithAttachment(to, Subject, body);
			return "msg send sucessfully";

		} catch (Exception e) {
			e.printStackTrace();
			return "internal issue try again";
		}

	}

}
