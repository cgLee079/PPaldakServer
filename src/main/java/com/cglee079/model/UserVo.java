package com.cglee079.model;

import com.google.gson.Gson;

public class UserVo {
	private String id;
	private String password;
	private String name;
	private String gender;
	private String birth;
	private String phoneNumber;
	private String imageFile;

	public UserVo() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", phoneNumber=" + phoneNumber + ", imageFile=" + imageFile + "]";
	}

	public String toJSONStr() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imgFile) {
        this.imageFile = imgFile;
    }

}
