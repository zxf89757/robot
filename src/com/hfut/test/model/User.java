package com.hfut.test.model;

/**
 * @author zhangxf23941
 *
 */
public class User {
	private Integer uid;
	private String dateCreated;
	private String username;
	private String password;
	private String telno;
	private String sex;
	private String dateLastActived;
	private String ipCreated;
	private String ipLastActived;
	private String image;
	private Integer count;
	private String uuid;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getDateLastActived() {
		return dateLastActived;
	}
	public void setDateLastActived(String dateLastActived) {
		this.dateLastActived = dateLastActived;
	}
	public String getIpCreated() {
		return ipCreated;
	}
	public void setIpCreated(String ipCreated) {
		this.ipCreated = ipCreated;
	}
	public String getIpLastActived() {
		return ipLastActived;
	}
	public void setIpLastActived(String ipLastActived) {
		this.ipLastActived = ipLastActived;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", dateCreated=" + dateCreated + ", username=" + username + ", password=" + password
				+ ", telno=" + telno + ", sex=" + sex + ", dateLastActived=" + dateLastActived + ", ipCreated="
				+ ipCreated + ", ipLastActived=" + ipLastActived + ", image=" + image + ", count=" + count + ", uuid="
				+ uuid + "]";
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Integer uid, String dateCreated, String username, String password, String telno, String sex,
			String dateLastActived, String ipCreated, String ipLastActived, String image, Integer count, String uuid) {
		super();
		this.uid = uid;
		this.dateCreated = dateCreated;
		this.username = username;
		this.password = password;
		this.telno = telno;
		this.sex = sex;
		this.dateLastActived = dateLastActived;
		this.ipCreated = ipCreated;
		this.ipLastActived = ipLastActived;
		this.image = image;
		this.count = count;
		this.uuid = uuid;
	}
	
}