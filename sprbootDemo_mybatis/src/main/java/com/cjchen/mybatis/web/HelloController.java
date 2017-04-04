package com.cjchen.mybatis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cjchen.mybatis.dao.UserMapper;
import com.cjchen.mybatis.modle.User;

@Controller
public class HelloController {
	@Autowired
	private UserMapper userMapper;
	
    @RequestMapping("/hello")
    public String index(ModelMap map) {
    	User user = userMapper.findByName("testAA");
        map.addAttribute("user", user);
        return "index";
    }

}