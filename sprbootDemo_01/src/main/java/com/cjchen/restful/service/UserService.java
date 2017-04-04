package com.cjchen.restful.service;

import java.util.List;

import com.cjchen.restful.model.Users;

public interface UserService {
	public List<Users> findAll();
	public Users save(Users users);
	public int updateNameById(Users users);
}
