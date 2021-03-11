package com.example.demo.email;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.mail.MessagingException;

@Controller
public class EmailController {

    @Autowired
    public EmailService emailService;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();

        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);
    }

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String createMail(Model model,
                             @ModelAttribute("mailObject") EmailObject mailObject,
                             Errors errors) throws MessagingException {
        if (errors.hasErrors()) {
            return "errors";
        }
        emailService.send(mailObject.getTo(),
                mailObject.getSubject(), mailObject.getText());

        return "";
    }

}