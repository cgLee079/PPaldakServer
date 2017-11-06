package com.cglee079.model;

import com.google.gson.Gson;

public class Fish {
	private String id;
	private String owner;
	private String name;
	private String imageFile;
	private String species;
	private Double maxPower;
	private Double avgPower;
	private String date;
	private String time;
	private Integer timeing;
	private Double GPSLat;
	private Double GPSLot;

	@Override
	public String toString() {
		return "Fish [id=" + id + ", owner=" + owner + ", name=" + name + ", imageFile=" + imageFile + ", species="
				+ species + ", maxPower=" + maxPower + ", avgPower=" + avgPower + ", date=" + date + ", time=" + time
				+ ", timeing=" + timeing + ", GPSLat=" + GPSLat + ", GPSLot=" + GPSLot + "]";
	}
	
	public String toJSONStr() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Double getMaxPower() {
		return maxPower;
	}

	public void setMaxPower(Double maxPower) {
		this.maxPower = maxPower;
	}

	public Double getAvgPower() {
		return avgPower;
	}

	public void setAvgPower(Double avgPower) {
		this.avgPower = avgPower;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Integer getTimeing() {
		return timeing;
	}

	public void setTimeing(Integer timeing) {
		this.timeing = timeing;
	}

	public Double getGPSLat() {
		return GPSLat;
	}

	public void setGPSLat(Double gPSLat) {
		GPSLat = gPSLat;
	}

	public Double getGPSLot() {
		return GPSLot;
	}

	public void setGPSLot(Double gPSLot) {
		GPSLot = gPSLot;
	}

}
