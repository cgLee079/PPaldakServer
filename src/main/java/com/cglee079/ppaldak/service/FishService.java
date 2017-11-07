package com.cglee079.ppaldak.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglee079.ppaldak.dao.FishDAO;
import com.cglee079.ppaldak.log.Log;
import com.cglee079.ppaldak.model.FishVo;

@Service
public class FishService {
	private FishDAO fishDAO;

	@Autowired
	public void setFishDAO(FishDAO fishDAO) {
		this.fishDAO = fishDAO;
	}

	public FishVo getFish(String id){
		return fishDAO.getFish(id);
	}
	
	public List<FishVo> getMyFishs(String owner, String fishname) {
		return fishDAO.getMyFishs(owner, fishname);
	}

	public List<FishVo> getAllFishs(String stDate, String endDate, String species) {
		return fishDAO.getAllFishs(stDate, endDate, species);
	}

	public boolean insert(FishVo fish) {
		boolean result = fishDAO.insert(fish);
		if(result){ 
			Log.i("# insert success");
		} else {
			Log.i("# insert fail");
		}
		return result;
	}

	public boolean delete(String id) {
		return fishDAO.delete(id);
	}
}
