package com.hfut.test.model;

public class Key {
	private Integer uid;
	private String dateCreated;
	private String key;
	private Integer conut;
	public Key() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Key(Integer uid, String dateCreated, String key, Integer conut) {
		super();
		this.uid = uid;
		this.dateCreated = dateCreated;
		this.key = key;
		this.conut = conut;
	}
	@Override
	public String toString() {
		return "Key [uid=" + uid + ", dateCreated=" + dateCreated + ", key=" + key + ", conut=" + conut + "]";
	}
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
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Integer getConut() {
		return conut;
	}
	public void setConut(Integer conut) {
		this.conut = conut;
	}
	
}
