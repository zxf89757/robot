package com.hfut.test.model;

public class Dialog {
	private Integer dlogid;	
	private Integer uid;	
	private Integer robid;
	private String question;
	private String answer;
	private String dateCreated;
	private Integer mode;
	
	public Integer getDlogid() {
		return dlogid;
	}
	public void setDlogid(Integer dlogid) {
		this.dlogid = dlogid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getRobid() {
		return robid;
	}
	public void setRobid(Integer robid) {
		this.robid = robid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Integer getMode() {
		return mode;
	}
	public void setMode(Integer mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "Dialog [dlogid=" + dlogid + ", uid=" + uid + ", robid=" + robid + ", question=" + question + ", answer="
				+ answer + ", dateCreated=" + dateCreated + ", mode=" + mode + "]";
	}
	public Dialog(Integer dlogid, Integer uid, Integer robid, String question, String answer, String dateCreated,
			Integer mode) {
		super();
		this.dlogid = dlogid;
		this.uid = uid;
		this.robid = robid;
		this.question = question;
		this.answer = answer;
		this.dateCreated = dateCreated;
		this.mode = mode;
	}
	public Dialog() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
