package com.cjchen.restful.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cjchen.restful.model.Users;
import com.cjchen.restful.service.UserServiceImpl;
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
	private UserServiceImpl userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Users> getUserList() {
		// 处理"/users/"的GET请求，用来获取用户列表
		// 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
		return userService.findAll();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postUser(@ModelAttribute Users users) {
		// 处理"/users/"的POST请求，用来创建User
		// 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		userService.save(users);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Users getUser(@PathVariable Long id) {
		// 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
		// url中的id可通过@PathVariable绑定到函数的参数中
		return userService.getUserById(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public String putUser(@PathVariable Long id, @ModelAttribute Users Users) {
		// 处理"/users/{id}"的PUT请求，用来更新User信息
		Users u = userService.getUserById(id);
		u.setName(Users.getName());
		u.setAge(Users.getAge());
		userService.saveAndFlush(u);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		// 处理"/users/{id}"的DELETE请求，用来删除User
		userService.deleteUserByid(id);
		return "success";
	}

}