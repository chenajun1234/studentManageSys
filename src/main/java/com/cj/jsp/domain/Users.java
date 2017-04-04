package com.cj.jsp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="cj_users")//设置数据库中表名字 
public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2857063330797063926L;
	@Id
	@Column(name = "uses_id")
	@GeneratedValue
	private Long id;
	
	String name;
	
	String address;
	
	int age;

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


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age + "]";
	}

}