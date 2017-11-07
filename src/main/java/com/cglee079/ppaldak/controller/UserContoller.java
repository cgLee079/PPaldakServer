package com.cglee079.ppaldak.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cglee079.ppaldak.log.Log;
import com.cglee079.ppaldak.model.UserVo;
import com.cglee079.ppaldak.service.UserService;

@Controller
public class UserContoller {

	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@ResponseBody
	@RequestMapping(value = "/login", produces="application/json;charset=UTF-8", method = { RequestMethod.POST })
	public HashMap<String, Object> login(HttpSession session, String id, String pwd) {
		HashMap<String, Object> response = new HashMap<>();
		Log.line();
		Log.i("## login");
		Log.i("id 	: " + id);
		Log.i("pwd 	: " + pwd);
		Log.line();

		/* check database */
		boolean result = userService.checkUser(id, pwd);
		if(result){
			UserVo user = userService.getUser(id);
			session.setAttribute("id", id);
			response.put("result", true);
			response.put("user", user.toJSONStr());
		} else{
			response.put("result", false); 
		}
		
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/join", method = { RequestMethod.POST }, params = { "modify" } )
	public HashMap<String, Object> modify(UserVo user) {
		HashMap<String, Object> response = new HashMap<>();
		
		Log.line();
		Log.i("## modify");
		Log.i(user.toString());
		
		response.put("result", userService.update(user));
		
		return response;

	}
	
	@ResponseBody
	@RequestMapping(value = "/join", method = { RequestMethod.POST }, params = { "!modify" })
	public HashMap<String, Object> join(Model model, UserVo user) {
		HashMap<String, Object> response = new HashMap<>();

		Log.line();
		Log.i("## join");
		Log.i(user.toString());

		response.put("result", userService.insert(user));
		return response;
	}

	@RequestMapping(value = "/saveUserImage")
	public void saveFishImage(String id, String filename, @RequestParam("image") MultipartFile multipartFile, HttpServletRequest request) throws IllegalStateException, IOException {
		Log.line();
		Log.i("## save user image");
		Log.i("id 		: " + id);
		Log.i("filename : " + filename);
		Log.i("filesize	: " + multipartFile.getSize());
		Log.i("# save start");

		String path = request.getSession().getServletContext().getRealPath("/resources/images");
		File file = new File(path, filename);

		multipartFile.transferTo(file);

		Log.i("# save end");
	}
}
