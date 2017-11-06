package com.cglee079.dao;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cglee079.model.UserVo;

@Repository
public class UserDAO {
	private static final String namespace = "com.cglee079.mapper.UserMapper";

	@Autowired
	private SqlSessionTemplate sqlSession;	

	public boolean insert(UserVo user) {
		return sqlSession.update(namespace + ".insert", user ) == 1;
	}
	
	public UserVo getUser(String id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		return sqlSession.selectOne(namespace + ".get", map);
	}

	public boolean update(UserVo user) {
		return sqlSession.update(namespace + ".update", user) == 1;
	}
}
	

