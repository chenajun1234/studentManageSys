package com.cj.jsp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cj.jsp.domain.Users;
import com.cj.jsp.service.UserService;
/**
 *<p>GET	/users	查询用户列表
	POST	/users	创建一个用户
	GET	/users/id	根据id查询一个用户
	PUT	/users/id	根据id更新一个用户
	DELETE	/users/id	根据id删除一个用户
 </p>
 * @author cjchen
 *
 */
@RestController
@RequestMapping(value = "/users") // 通过这里配置使下面的映射都在/users下
public class UserController {

	@Autowired
	private UserService userServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getUserList() {
		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		List<Users> findAll = userServiceImpl.findAll();
		ModelAndView mv=new ModelAndView("userList");
		mv.addObject("users", findAll);
		return mv;
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView postUser(@ModelAttribute Users user) {
		// 处理"/users/"的POST请求，用来创建User
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		userServiceImpl.save(user);
		ModelAndView mv=new ModelAndView("userList");
		List<Users> findAll = userServiceImpl.findAll();
		mv.addObject("users", findAll);
		return mv;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable Long id) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		ModelAndView mv=new ModelAndView("userEdit");
		mv.addObject("user", userServiceImpl.getUserById(id));
		return mv;
//		return userServiceImpl.getUserById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute Users user) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息
		Users u = userServiceImpl.getUserById(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		u.setAddress(user.getAddress());
		userServiceImpl.flush();
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		// 处理"/users/{id}"的DELETE请求，用来删除User
		userServiceImpl.deleteUserByid(id);
		return "success";
	}

}