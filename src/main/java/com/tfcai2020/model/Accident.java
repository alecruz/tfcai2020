package com.tfcai2020.model;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Accident {

	@Id
	public String _id;
	
	//Ciudad
	public String path;
	
	//Pais
	//public String country;
	
	//Estado
	//public String state;
	
	//Fecha
	//public Date start_time;

	public String getId() {
		return _id;
	}

	public void setId(String id) {
		this._id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	/*public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}	*/
	
}
