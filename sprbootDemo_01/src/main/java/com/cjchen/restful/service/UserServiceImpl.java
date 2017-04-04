package com.cjchen.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cjchen.restful.model.Users;
import com.cjchen.restful.repsotory.UsersRepsotory;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private  UsersRepsotory usersRepsotory;
	
	public List<Users> findAll(){
		Iterable<Users> findAll = usersRepsotory.findAll();
		return (List<Users>) findAll;
	}
	public Users save(Users users){
		return usersRepsotory.save(users);
	}
	public Users saveAndFlush(Users users){
		return usersRepsotory.saveAndFlush(users);
	}
	public void Flush(){
		 usersRepsotory.flush();
	}
	public int updateNameById(Users users){
		return usersRepsotory.updateUsersName(users.getName(), users.getId());
	}
	public Users getUserById(Long id){
		return usersRepsotory.findOne(id);
	}
	public void deleteUserByid(Long id){
		usersRepsotory.delete(id);
	}
}
