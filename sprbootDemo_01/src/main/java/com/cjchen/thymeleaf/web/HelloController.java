package com.cjchen.thymeleaf.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjchen.thymeleaf.exception.MyException;

@Controller
public class HelloController {
    
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
    	int i = 1/0;
        return "Hello World";
    }
    /**
     * 返回JSON格式
     * @throws MyException
     */
    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }
    @RequestMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("titles", "thymeleaf");
        map.addAttribute("name", "chenjun");
        return "index";
    }

}