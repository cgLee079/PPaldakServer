package com.cglee079.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cglee079.log.Log;
import com.cglee079.model.FishVo;
import com.cglee079.service.FishService;

@Controller
public class FishController {
	private FishService fishService;

	@Autowired
	public void setFishService(FishService fishService) {
		this.fishService = fishService;
	}

	@RequestMapping(value = "/saveFish")
	public void saveFish(Model model, FishVo fish) {
		Log.line();
		Log.i("## save fish");
		Log.i(fish.toString());
		
		/* 시연 미스 */
//		String date	 		= fish.getDate();
//		String dateDiv[] 	= date.split("/");
//		String newDate 		= dateDiv[0].trim()+ "/" + dateDiv[1].trim() + "/" + dateDiv[2].trim();
//		Log.i(newDate);
//		fish.setDate(newDate);
		
		fishService.insert(fish);
	}

	@RequestMapping(value = "/deleteFish")
	public void deleteFish(HttpSession session, String id) {
		Log.line();
		Log.i("## delete fish");
		Log.i("id: " + id);
		Log.i("# delete start");
		
		String filename	= id + ".jpg";
		String path 	= session.getServletContext().getRealPath("/resources/images");
		
		File	fshImg 		= new File(path, filename);
		boolean fshdel		= false;
		boolean fshImgdel 	= false;
		
		fshdel =  fishService.delete(id);
		if (fshImg.exists()) { fshImgdel = fshImg.delete(); }
		
		/* */
		if (fshdel) { Log.i("info deleted"); }
		else { Log.i("info deleted fail"); }
		
		if (fshImgdel) { Log.i("image deleted"); }
		else { Log.i("image deleted fail"); }
		
		Log.i("# delete end");
	}

	@RequestMapping(value = "/saveFishImage")
	public void saveFishImage(HttpSession session, String id, @RequestParam("image") MultipartFile multipartFile) throws IllegalStateException, IOException {
		Log.line();
		Log.i("## save fish image");
		Log.i("id : " + id);
		Log.i("filesize  :" + multipartFile.getSize());
		Log.i("# save start");

		String path		= session.getServletContext().getRealPath("/resources/images");
		String filename = id + ".jpg";
		File fshImg = new File(path, filename);

		multipartFile.transferTo(fshImg);

		Log.i("# save end");
	}

	@ResponseBody
	@RequestMapping(value = "/selectMyFish")
	public HashMap<String, Object> selectMyFishs(HttpSession session, String fishname) {
		Log.line();
		Log.i("## select my fishs");

		String owner = (String) session.getAttribute("id");
		
		/* select my fish list */
		List<FishVo> fishs = fishService.getMyFishs(owner, fishname);
		Log.i("selected database");
		
		JSONArray fishArray	= new JSONArray();
		if (fishs != null) {
			int size	= fishs.size();
			for (int i = 0; i < size; i++) {
				fishArray.put(i, fishs.get(i).toJSONStr());
			}
		}

		HashMap<String, Object> response = new HashMap<>();
		response.put("fishs", fishArray.toString());
		return response;
	}

	@ResponseBody
	@RequestMapping(value = "/selectAllFish")
	public HashMap<String, Object> selectAllFishs(String stDate, String endDate, String species) {
		Log.line();
		Log.i("## select all fishs");
		Log.i("stDate	= " + stDate);
		Log.i("endDate	= " + endDate);
		Log.i("Species	= " + species);

		List<FishVo> fishs = fishService.getAllFishs(stDate, endDate, species);
		Log.i("selected database");

		JSONArray 	fishArray 	= new JSONArray();
		if (fishs != null) {
			int size	= fishs.size();
			for (int i = 0; i < size; i++) {
				fishArray.put(i, fishs.get(i).toJSONStr());
			}
		}
		
		HashMap<String, Object> response = new HashMap<>();
		response.put("fishs", fishArray);

		return response;
	}
}
