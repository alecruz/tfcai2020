package com.tfcai2020.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.mapping.Field;

public class Accident {

	@Id
	public String id;
	
	@Field("ID")
	public String identificador;
	
	@Field("City")
	public String city;	
	
	@Field("State")
	public String state;
		
	@Field("start_location")	
	public Point location;
	
	public double distance;
		
	public Accident() {}
	
	public Accident(String id, String identificador, String city, String state) {
		this.setId(id);
		this.setIdentificador(identificador);
		this.setCity(city);
		this.setState(state);
	}
	
	public Accident(String id, String identificador, double distance) {
		this.setId(id);
		this.setIdentificador(identificador);
		this.setDistance(distance);
	}
	
	/*@Field("Start_Time")
	public String start_time;*/
	
	
	//@GeoSpatialIndexed(type= GeoSpatialIndexType.GEO_2DSPHERE)
	//public Point start_location;

	/*public Accident(@Value("date") Date aDate, @Value("path") String aPath, @Value("city") String aCity) {
		this.setDate(aDate);
		this.setPath(aPath);
		this.setCity(aCity);
	}*/
	

	public String getId() {
		return this.id;
	}

	public void setId(String anId) {
		this.id = anId;
	}
	
	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	
	
	
	
	
	/*public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}*/

	
	

}