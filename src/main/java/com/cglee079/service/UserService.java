package com.cglee079.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglee079.dao.UserDAO;
import com.cglee079.log.Log;
import com.cglee079.model.User;

@Service
public class UserService {
	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public User getUser(String id) {
		return userDAO.getUser(id);
	}

	public boolean insert(User user) {
		String id = user.getId();
		User userDB = userDAO.getUser(id);
		if(userDB != null){
			return false;
		} else{
			return userDAO.insert(user);
		}
		
	}

	public boolean update(User user) {
		String id 	= user.getId();
		User userDB = userDAO.getUser(id);
		if(userDB != null){
			return userDAO.update(user);	
		} else {
			Log.i("#id : " + id + "		don't have id");
			return false;
		}
		
	}
	
	public boolean checkUser(String id, String password){
		User user = userDAO.getUser(id);
		
		if(user == null){
			Log.i("#id : " + id + "		don't have id");
			return false;
		}
		if(user.getPassword().equals(password)){
			Log.i("## User Information ##");
			Log.i("id			: " + user.getId());
			Log.i("pwd 			: " + user.getPassword());
			Log.i("gender 		: " + user.getGender());
			Log.i("phoneNumber 	: " + user.getPhoneNumber());
			Log.i("birth 		: " + user.getBirth());
			Log.i("imgFile 		: " + user.getImageFile());
			return true;
		} else { 
			Log.i("#id : " + id + "		password is wrong");
			return false; 
		}
		
	}

}
