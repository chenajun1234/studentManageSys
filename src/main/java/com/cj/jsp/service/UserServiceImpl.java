package com.cj.jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cj.jsp.domain.Users;
import com.cj.jsp.repsotory.UsersRepsotory;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UsersRepsotory usersRepsotory;

	public List<Users> findAll() {
		Iterable<Users> findAll = usersRepsotory.findAll();
		return (List<Users>) findAll;
	}

	public Users save(Users users) {
		return usersRepsotory.save(users);
	}

	public int updateNameById(Users users) {
		return usersRepsotory.updateUsersName(users.getName(), users.getId());
	}

	public Users getUserById(Long id) {
		return usersRepsotory.findOne(id);
	}

	public void deleteUserByid(Long id) {
		usersRepsotory.delete(id);
	}

	@Override
	public Users update(Users users) {
		return usersRepsotory.saveAndFlush(users);
	}

	@Override
	public void flush() {
		usersRepsotory.flush();
	}

	
}
