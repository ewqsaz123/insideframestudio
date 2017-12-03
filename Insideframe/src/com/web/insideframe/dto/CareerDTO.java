package com.web.insideframe.dto;

public class CareerDTO {
	   private int careerNo;
	   private String email;
	   private String type;
	   private String title;
	   private String roll;
	   private String cdate;
	   
	   public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public int getCareerNo() {
	      return careerNo;
	   }
	   public void setCareerNo(int careerNo) {
	      this.careerNo = careerNo;
	   }
	   public String getEmail() {
	      return email;
	   }
	   public void setEmail(String email) {
	      this.email = email;
	   }
	   public String getType() {
	      return type;
	   }
	   public void setType(String type) {
	      this.type = type;
	   }
	   public String getTitle() {
	      return title;
	   }
	   public void setTitle(String title) {
	      this.title = title;
	   }
	   public String getRoll() {
	      return roll;
	   }
	   public void setRoll(String roll) {
	      this.roll = roll;
	   }
	public CareerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CareerDTO(int careerNo, String email, String type, String title, String roll, String cdate) {
		super();
		this.careerNo = careerNo;
		this.email = email;
		this.type = type;
		this.title = title;
		this.roll = roll;
		this.cdate = cdate;
	}
	
	   
	   
	}