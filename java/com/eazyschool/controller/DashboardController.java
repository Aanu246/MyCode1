package com.eazyschool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eazyschool.model.Person;
import com.eazyschool.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class DashboardController {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	private Environment environment;
	
	//Reading properties using @Value annotation
	@Value("${eazyschool.pageSize}")
	private int defaultPageSize;
	
	@Value("${eazyschool.contact.successMsg}")
	private String message;
	
	@RequestMapping("/dashboard")
	public String displayDashboard(Model model, Authentication authentication,HttpSession session) {
		Person person = personRepository.readByEmail(authentication.getName());
		model.addAttribute("username",person.getName());
		model.addAttribute("roles",authentication.getAuthorities().toString());
		if(null != person.getEazyClass() && null != person.getEazyClass().getName()) {
			model.addAttribute("enrolledClass", person.getEazyClass().getName());
		}
		session.setAttribute("LoggedInPerson",person);
		logMessages();
		//throw new RuntimeException("it's been a bad day");
		return "dashboard.html";
	}
	
	
	private void logMessages() {
		log.error("Error message from the Dashboard page");
		log.warn("Warning message from the Dashboard page");
		log.info("Info message from the Dashboard page");
		log.debug("Debug message from the Dashboard page");
		log.trace("Trace message from the Dashboard page");
		
		log.error("defaultPageSize value with @Value annotation is: "+defaultPageSize);
		log.error("successMsg value with @Value annotation is :"+message);
		
		
		//Reading properties Environment interface
		log.info("defaultPageSize value with Environment is : "+environment.getProperty("eazyschool.pageSize"));
		log.info("successMsg value with Environment is : "+environment.getProperty("eazyschool.contact.successMsg"));
		log.info("Java Home environment variable using Envirionment is : "+environment.getProperty("JAVA_HOME"));
	}
	
		
	
	
}
