package com.siruswang.pojo;

import com.mysql.jdbc.Blob;

public class VolEvent {
	int id;
	String title;
	String description;
	String organizer;
	String tel;
	int numPeople;
	String lat;
	String lng;
	int isComplete;
	int uid;
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
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
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	public int getIsComplete() {
		return isComplete;
	}
	public void setIsComplete(int isComplete) {
		this.isComplete = isComplete;
	}
	@Override
	public String toString() {
		return "VolEvent [id=" + id + ", title=" + title + ", description=" + description + ", organizer=" + organizer + ", tel=" + tel + ", numPeople=" + numPeople + ", lat=" + lat + ", lng="
				+ lng + ", isComplete=" + isComplete + "]";
	}
	
	public VolEvent() {}
	public VolEvent(int id, String title, String description, Blob img, String organizer, String tel, int numPeople,
			String lat, String lng, int isComplete) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.organizer = organizer;
		this.tel = tel;
		this.numPeople = numPeople;
		this.lat = lat;
		this.lng = lng;
		this.isComplete = isComplete;
		this.uid = uid;
	}
}