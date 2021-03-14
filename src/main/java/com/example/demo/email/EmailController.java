package com.example.demo.email;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    public EmailService emailService;

    @RequestMapping(value = "/email", method = RequestMethod.POST)
    public ResponseEntity<?> createMail(@RequestBody EmailObject emailObject) throws MessagingException {

        emailService.send(emailObject.getTo(), emailObject.getSubject(), emailObject.getText());

        return ResponseEntity.ok("Done");
    }

}