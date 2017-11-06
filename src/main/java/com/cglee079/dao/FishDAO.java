package com.cglee079.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cglee079.model.FishVo;

@Repository
public class FishDAO {
	private static final String namespace="com.cglee079.mapper.FishMapper";

	@Autowired
	private SqlSessionTemplate sqlSession;	

	public boolean insert(FishVo fish) {
		return sqlSession.update(namespace + ".insert", fish ) == 1;
	}
	
	public boolean delete(String id) {
		HashMap<String, Object> map=new HashMap<String, Object>();
		map.put("id", id);
		return sqlSession.update(namespace + ".delete", map ) == 1;
	}
	
	public FishVo getFish(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return sqlSession.selectOne(namespace + ".get", map);
	}
	
	public List<FishVo> getMyFishs(String owner, String search) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("owner", owner);
		map.put("search", search);
		return sqlSession.selectList(namespace + ".mylist", map);
	}

	public List<FishVo> getAllFishs(String stDate, String endDate, String species) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("stDate", stDate);
		map.put("endDate", endDate);
		map.put("species", species);
		return sqlSession.selectList(namespace + ".list", map);
	}
}
