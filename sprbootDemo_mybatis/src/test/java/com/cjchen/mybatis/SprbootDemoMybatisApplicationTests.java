package com.cjchen.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjchen.mybatis.dao.UserMapper;
import com.cjchen.mybatis.modle.User;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SprbootDemoMybatisApplicationTests {
	@Autowired
	private UserMapper userMapper;
	
	@Test
	@Rollback
	public void findByName() throws Exception {
		User u = userMapper.findByName("testAA");
		System.out.println(u);
	}

	@Test
	public void contextLoads() {
	}

}
