package com.cjchen.mybatis.modle;

import javax.persistence.Column;

public class User {
	@Column(name = "uses_id")
	private Long id;
	
	private String name;
	private Integer age;

	// 省略getter和setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}

}