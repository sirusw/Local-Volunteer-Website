package com.siruswang.pojo;

public class Volunteer {
	
	int id;
	int uid;
	int eid;
	int numPeople;
	
	String lname;
	String fname;
	String tel;
	
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
	public int getNumPeople() {
		return numPeople;
	}
	public void setNumPeople(int numPeople) {
		this.numPeople = numPeople;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Volunteer(int uid, int eid) {
		super();
		this.uid = uid;
		this.eid = eid;
	}
	public Volunteer() {}
	@Override
	public String toString() {
		return "Volunteer [id=" + id + ", uid=" + uid + ", eid=" + eid + "]";
	}
	
	
	
}
