package com.jspdatabase.vinayak.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Bean")
public class BeanDetails {
	
	@Id
	private String username;
	private String name;
	
	private Integer mobile_number;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Integer mobile_number) {
		this.mobile_number = mobile_number;
	}
	
	
	public BeanDetails() {
		super();
	}
	public BeanDetails(String username, String name, Integer mobile_number) {
		super();
		this.username = username;
		this.name = name;
		this.mobile_number = mobile_number;
	}
	@Override
	public String toString() {
		return "BeanDetails [username=" + username + ", name=" + name + ", mobile_number=" + mobile_number + "]";
	}
	

}
