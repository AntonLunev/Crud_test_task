package com.anton.model;


import java.io.Serializable;
import java.util.*;
//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User  implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO) //for autonumber
	private Integer userId;
	@Column
	private String name;
	@Column
	private Integer age;
	@Column
	private Boolean isAdmin;
	@Column
	private Date createDate;
	
	
	public User(){}
	
	
	public User(Integer userId, String name, Integer age, Boolean isAdmin, Date createDate) {
		super();
		this.userId = userId;
		this.name = name;
		this.age = age;
		this.isAdmin = isAdmin;
		this.createDate = createDate;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
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


	public Boolean getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	

}
