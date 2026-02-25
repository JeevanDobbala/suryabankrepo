package com.model;

public class StudentModel {

	private int sid;
	private String Fname;
	private String Lname;
	private String Fathername;
	private String Gender;
	private String Age;
	private String Passedout;
	private String Phno;
	private String Email;

	public StudentModel() {
	}

	public StudentModel(int sid, String fname, String lname, String fathername, String gender, String age,
			String passedout, String phno, String email) {
		super();
		this.sid = sid;
		this.Fname = fname;
		this.Lname = lname;
		this.Fathername = fathername;
		this.Gender = gender;
		this.Age = age;
		this.Passedout = passedout;
		this.Phno = phno;
		this.Email = email;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		this.Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		this.Lname = lname;
	}

	public String getFathername() {
		return Fathername;
	}

	public void setFathername(String fathername) {
		this.Fathername = fathername;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		this.Gender = gender;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		this.Age = age;
	}

	public String getPassedout() {
		return Passedout;
	}

	public void setPassedout(String passedout) {
		this.Passedout = passedout;
	}

	public String getPhno() {
		return Phno;
	}

	public void setPhno(String i) {
		this.Phno = i;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	@Override
	public String toString() {
		return "StudentModel [stdid=" + sid + ", Fname=" + Fname + ", Lname=" + Lname + ", Fathername=" + Fathername
				+ ", Gender=" + Gender + ", Age=" + Age + ", Passedout=" + Passedout + ", Phno=" + Phno + ", Email="
				+ Email + "]";
	}

}
