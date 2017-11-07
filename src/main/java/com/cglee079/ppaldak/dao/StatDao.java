package com.cglee079.ppaldak.dao;
//package com.cglee079.dao;
//
//import java.util.HashMap;
//import java.util.List;
//
//import org.mybatis.spring.SqlSessionTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import kr.co.changoo.model.StatVo;
//import kr.co.changoo.model.TableVo;
//
//@Repository
//public class StatDao{
//
//	static final String namespace="kr.co.changoo.mapper.StatMapper";
//	
//	@Autowired
//	private SqlSessionTemplate sqlSession;	
//	
//	public boolean insert(StatVo stat) {
//		return sqlSession.update(namespace + ".insert", stat ) == 1;
//	}
//	
//	public boolean update(StatVo stat) {
//		return sqlSession.update(namespace + ".update", stat ) == 1;
//	}
//	
//	public boolean delete(int statSeq) {
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("statSeq", statSeq);
//		return sqlSession.update(namespace + ".delete", statSeq ) == 1;
//	}
//
//	public StatVo get(int statSeq) {
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("statSeq", statSeq);
//		return sqlSession.selectOne(namespace + ".get", statSeq);
//	}
//	
//	public List<StatVo> list(Integer startRow, Integer endRow, String search) {
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("search",search);
//		map.put("startRow",startRow);
//		map.put("endRow",endRow);
//		return sqlSession.selectList(namespace + ".list",map);
//	}
//	
//	public Integer cnt(String search) {
//		HashMap<String, Object> map=new HashMap<String, Object>();
//		map.put("search",search);
//		return sqlSession.selectOne(namespace + ".cnt",map);
//	}
//
//	public String max_cre_date() {
//		return sqlSession.selectOne(namespace + ".max_cre_date");
//	}
//
//	public String max_upd_date() {
//		return sqlSession.selectOne(namespace + ".max_upd_date");
//	}
//
//	public int seq() {
//		return sqlSession.selectOne(namespace + ".seq");
//	}
//}
