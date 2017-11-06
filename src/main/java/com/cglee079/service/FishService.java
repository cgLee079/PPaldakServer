package com.cglee079.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cglee079.dao.FishDAO;
import com.cglee079.log.Log;
import com.cglee079.model.Fish;

@Service
public class FishService {
	private FishDAO fishDAO;

	@Autowired
	public void setFishDAO(FishDAO fishDAO) {
		this.fishDAO = fishDAO;
	}

	public Fish getFish(String id){
		return fishDAO.getFish(id);
	}
	
	public List<Fish> getFishsByOwner(String owner) {
		return fishDAO.getFishsByOwner(owner);
	}

	public List<Fish> getFishsByOwnerAndFishname(String owner, String fishname) {
		return fishDAO.getFishsByOwnerAndFishname(owner, fishname);
	}

	public List<Fish> getFishsInPeriod(String st_time, String end_time) {
		return fishDAO.getFishsInPeriod(st_time, end_time);
	}

	public List<Fish> getFishsInPeriodBySpecies(String species, String st_time, String end_time) {
		return fishDAO.getFishsInPeriodBySpecies(species, st_time, end_time);
	}

	public boolean insert(Fish fish) {
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
