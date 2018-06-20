package com.hfut.test.model;

public class Robot {
	private Integer robid;	
	private String name;	
	private String sex;
	private Integer age;
	private String dateCreated;
	private Integer count;
	public Integer getRobid() {
		return robid;
	}
	public void setRobid(Integer robid) {
		this.robid = robid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Robot [robid=" + robid + ", name=" + name + ", sex=" + sex + ", age=" + age + ", dateCreated="
				+ dateCreated + ", count=" + count + "]";
	}
	public Robot(Integer robid, String name, String sex, Integer age, String dateCreated, Integer count) {
		super();
		this.robid = robid;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.dateCreated = dateCreated;
		this.count = count;
	}
	public Robot() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
