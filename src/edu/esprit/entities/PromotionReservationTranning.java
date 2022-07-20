package edu.esprit.entities;

import java.util.Random;

public class PromotionReservationTranning {

	private int id;
	private String code; 
	private String organizer; 
	private String percent; 
	private int nb;
	
	public PromotionReservationTranning() {
		this.code = this.generateRandomPassword();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PromotionReservationTranning(String organizer, String percent, int nb) {
		super();
		this.code = this.generateRandomPassword();
		this.organizer = organizer;
		this.percent = percent;
		this.nb = nb;
	}
	
	public String generateRandomPassword() {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRST!@#$%&abcdefghijk";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(8);
		for (int i = 0; i < 8; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		if(this.code != null && !this.code.isEmpty()) {
			this.code = code;			
		}
		else {
			System.out.println("Code already generated");
		}
	}
	public void setCodeForList(String code) {
			this.code = code;			
	}
	public String getOrganizer() {
		return organizer;
	}
	
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getPercent() {
		return percent;
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}	
}
