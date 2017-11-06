package com.cglee079.model;

import com.google.gson.Gson;

public class UserVo {
	private String id;
	private String pwd;
	private String name;
	private String gender;
	private String birth;
	private String ph;

	public UserVo() {
		super();
	}

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender + ", birth="
				+ birth + ", ph=" + ph + "]";
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPh() {
		return ph;
	}

	public void setPh(String ph) {
		this.ph = ph;
	}

}
