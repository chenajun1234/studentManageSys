package com.cj.jsp.repsotory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cj.jsp.domain.Users;


public interface UsersRepsotory extends JpaRepository<Users, Long>{
	@Modifying
	@Query("UPDATE Users u SET u.name= ?1 WHERE u.id= ?2 ")
	int updateUsersName(String name,Long userId);
	//等价上面
//	@Query("UPDATE Users u SET u.name=:name1 WHERE u.id=:userId ")
//	int updateUsersName(@Param("name")String name,@Param("userId")Long userId);
}
