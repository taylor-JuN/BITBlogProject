package com.blogproject.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogproject.jblog.exception.UserDAOException;
import com.blogproject.jblog.vo.UserVO;


@Repository
public class UserDAOImple implements UserDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int insert(UserVO vo) {
		int insertedCount = 0;
		
		try {
			insertedCount = sqlSession.insert("users.insert", vo);	

		}catch(Exception e) {
			
			throw new UserDAOException("join exception");
		}
		
		return insertedCount;
	}
	
	@Override
	public int makeBlog(UserVO vo) {
		int insertedCount =0;
		
		try {
			insertedCount = sqlSession.insert("users.makeblog", vo);
		}catch(Exception e) {
			throw new UserDAOException("makeBlog exception");
		}
		
		return insertedCount;
	}
	
	@Override
	public int makeCategory(UserVO vo) {
		int insertedCount = 0;
		
		try {
			insertedCount = sqlSession.insert("users.makecategory", vo);
		}catch(Exception e){
			throw new UserDAOException("makeCate exception");
		}
		return insertedCount;
	}

	@Override
	public UserVO selectUser(String id, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id", id);
		userMap.put("password", password);
		
		UserVO vo = null;
		
		try {
			vo = sqlSession.selectOne("users.selectUserByIDAndPassword", userMap);
		}catch(Exception e){
			throw new UserDAOException("selectUser By id and password exception");
		}
		
		return vo;
		
		
	}

	@Override
	public UserVO selectUser(String id) {
		UserVO vo = null; 
				
		try {
			vo = sqlSession.selectOne("users.selectUserByID", id);
		}catch(Exception e){
			throw new UserDAOException("selectUser By ID exception");
		}	
		
		return vo;
	}

	@Override
	public String selectUserName(Long no) {
		String name = "";
		try {
			name = sqlSession.selectOne("users.selectUserByNo", no);
		}catch(Exception e){
			throw new UserDAOException("selectUserName exception");
		}	
		return name;
	}
	
	
}
