package edu.esprit.entities;

import java.util.Date;

public class Coach {

	private int id;
	private String first_name;
	private String last_name;
	private String gender;
	private String birthday;
	private String email;
	private String post_work;
	private String company_name;
	
	public Coach() {	
	}

	public Coach(String first_name, String last_name, String gender, String birthday, String email, String post_work,
			String company_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.birthday = birthday;
		this.email = email;
		this.post_work = post_work;
		this.company_name = company_name;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPost_work() {
		return post_work;
	}

	public void setPost_work(String post_work) {
		this.post_work = post_work;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	
	
}
