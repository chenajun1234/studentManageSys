package com.cj.jsp.service;

import java.util.List;

import com.cj.jsp.domain.Users;

public interface UserService {

	public List<Users> findAll();

	public Users save(Users users);

	public int updateNameById(Users users);
	
	public Users update(Users users);
	
	public void flush();

	public Users getUserById(Long id);

	public void deleteUserByid(Long id);
}
