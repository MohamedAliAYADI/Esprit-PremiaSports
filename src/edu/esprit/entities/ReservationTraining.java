package edu.esprit.entities;


import java.util.Date;

public class ReservationTraining {

	private int id;
	private int user_id;
	private int coach_id;
	private String title;
	private String type;
	private String state;
	private Date end_time;
	private Date start_time;
	private float price;
	

	public ReservationTraining () {}
	
	public ReservationTraining(int user_id, int coach_id, String title, String type, String state, Date end_time,
			Date start_time, float price) {
		super();
		this.user_id = user_id;
		this.coach_id = coach_id;
		this.title = title;
		this.type = type;
		this.state = state;
		this.end_time = end_time;
		this.start_time = start_time;
		this.price = price;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCoach_id() {
		return coach_id;
	}

	public void setCoach_id(int coach_id) {
		this.coach_id = coach_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	

}
