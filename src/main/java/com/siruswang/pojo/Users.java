package com.siruswang.pojo;

public class Users {
	int id;
	String lname;
	String fname;
	String tel;
	String pw;
	int admin;
	
	public Users(String lname, String fname, String tel, String pw) {
		super();
		this.lname = lname;
		this.fname = fname;
		this.tel = tel;
		this.pw = pw;
	}
	
	public Users() {
		
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", lname=" + lname + ", fname=" + fname + ", tel=" + tel + ", pw=" + pw + ", admin="
				+ admin + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
}
