package com.cs310.fountainfinder.client;

import java.io.Serializable;


public class FountainSerializable implements Serializable {
	private double lng;
	private double lat;
	private String id;
	private String location;
	private String status;
	private String maintainer;
	
	
	 /**
	  * Update Fountain ID and location
	  * @param id is the ID to identify a fountain
	  * @param local is the LatLng of the fountain
	  */
	public FountainSerializable(String ID) {
		id = ID;
	}
	
	public FountainSerializable() {
		// empty constructor: remove if we're using the one that takes an ID
	}

	/**
	 * Sets and id
	 * @param id is the string to identify a fountain
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets an id of a Fountain
	 * @return the id as a string
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Set the lat value of coordinates
	 * @param local is the latLong
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	/**
	 * Set the value of longitude given a double 
	 * @param lng the double value of longitude
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	/**
	 *  When called gives the value of the Latitude of the Coordinates
	 * @return latitude as double
	 */
	public double getLat() {
		return lat;
	}
	
	/**
	 * When called gives the value of the longitude of the coordinated
	 * @return longitude as double
	 */
	
	public double getLng() {
		return lng;
	}
	
	/**
	 *  Take the string that are lat,long,alt and convert via string.split into an array of [lat, long, alt]
	 *  which can then be converted into a latLong
	 * @param lalo The string form the KML of coordinates
	 */
	public void setLatLong(String lalo) {
	String delims = "[,]";
	String[] indi = lalo.split(delims);
	this.lat = Double.valueOf(indi[0]);
	this.lng = Double.valueOf(indi[1]);
	}
	

	
	/**
	 * Set the location as a string
	 * @param is the location as a string
	 */
	public void setLocation(String l) {
		this.location = l;
	}
	
	/**
	 * return the location
	 * @return the location of the fountain as a string
	 */
	public String getLocation() {
		return location;
	}
	
	
	/**
	 * set the status of the fountain
	 * @param stat is the status as a string of the fountain
	 */
	public void setStatus(String stat) {
		this.status = stat;
	}
	
	/**
	 * Return the status of the fountain
	 * @return the status of the fountain as a sting
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * Set the maintainer for the fountain
	 * @param name is the string of the maintainer
	 */
	public void setMaintainer(String name){
		this.maintainer = name;
	}
	
	/**
	 * Return who maintains the fountain
	 * @return the maintainer of the fountain as a String
	 */
	public String getMaintainer() {
		return maintainer;
	}
}


