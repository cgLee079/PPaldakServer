package com.cglee079.ppaldak.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglee079.ppaldak.dao.UserDAO;
import com.cglee079.ppaldak.log.Log;
import com.cglee079.ppaldak.model.UserVo;

@Service
public class UserService {
	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public UserVo getUser(String id) {
		return userDAO.getUser(id);
	}

	public boolean insert(UserVo user) {
		String id = user.getId();
		UserVo userDB = userDAO.getUser(id);
		if(userDB != null){
			return false;
		} else{
			return userDAO.insert(user);
		}
		
	}

	public boolean update(UserVo user) {
		String id 	= user.getId();
		UserVo userDB = userDAO.getUser(id);
		if(userDB != null){
			return userDAO.update(user);	
		} else {
			Log.i("#id : " + id + "		don't have id");
			return false;
		}
		
	}
	
	public boolean checkUser(String id, String password){
		UserVo user = userDAO.getUser(id);
		
		if(user == null){
			Log.i("#id : " + id + "		don't have id");
			return false;
		}
		if(user.getPwd().equals(password)){
			Log.i("## User Information ##");
			Log.i(user.toString());
			return true;
		} else { 
			Log.i("#id : " + id + "		password is wrong");
			return false; 
		}
		
	}

}
