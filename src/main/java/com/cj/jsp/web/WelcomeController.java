package com.cj.jsp.web;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cj.jsp.domain.Users;
import com.cj.jsp.service.UserService;

@Controller
public class WelcomeController {
	@Autowired
	private UserService userServiceImpl;

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@GetMapping("/welcome")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}
	@GetMapping("/userLists")
	public String userList(Map<String, Object> model) {
		List<Users> findAll = userServiceImpl.findAll();
		model.put("users", findAll);
		return "userList";
	}
	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

}