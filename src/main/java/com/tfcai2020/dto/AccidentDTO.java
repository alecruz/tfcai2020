package com.tfcai2020.dto;

import java.util.Date;

import com.tfcai2020.model.Accident;

public class AccidentDTO {

	public String _id;
	
	//Ciudad
	public String path;
	
	//Pais
	//public String country;
	
	//Estado
	//public String state;
	
	//Fecha
	//public Date start_time;
	
	public AccidentDTO(Accident accident) {
		this.setId(accident.getId());
		this.setPath(accident.getPath());
		//this.setCountry(accident.getCountry());
		//this.setState(accident.getState());
		//this.setStart_time(accident.getStart_time());
	}

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
	}*/	
	
}
