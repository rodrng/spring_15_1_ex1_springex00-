package com.javagyeongmin.spring_15_1_ex;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(@ModelAttribute Student student, BindingResult result) { // 바인딩사용하려면 모델어틀리비트로 객체명 줄이지 않아도 써줘야함
		
		
		String page = "loginOk";
		Studentvalidator validator = new Studentvalidator();
		validator.validate(student, result);
		
		if(result.hasErrors()) { // 에러가 있으면 login으로 보낸다
			page = "login";
		}
		
		
		return page; // 에러가 없으면 loginOk으로 보낸다
	}
}
