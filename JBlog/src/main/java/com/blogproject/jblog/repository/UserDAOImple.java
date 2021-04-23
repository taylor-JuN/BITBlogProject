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
	
	@Transactional
	@Override
	public int insert(UserVO vo) {
		int insertedCount = 0;
		
		try {
			insertedCount = sqlSession.insert("users.insert", vo);
			
			System.out.println("sqlSession : " + insertedCount);
			
		}catch(Exception e) {
			System.err.println("exception : " + e.getMessage());
			throw new UserDAOException("join exception");
		}
		
		return insertedCount;
	}
	
	@Override
	public int makeBlog(UserVO vo) {
		int insertedCount =0;
		insertedCount = sqlSession.insert("users.makeblog", vo);
		
		return insertedCount;
	}
	
	@Override
	public int makeCategory(UserVO vo) {
		int insertedCount = 0;
		insertedCount = sqlSession.insert("users.makecategory", vo);
		
		return insertedCount;
	}

	@Override
	public UserVO selectUser(String id, String password) {
		Map<String, String> userMap = new HashMap<>();
		userMap.put("id", id);
		userMap.put("password", password);
		
		UserVO vo = sqlSession.selectOne("users.selectUserByIDAndPassword", userMap);
		System.out.println("selectuserid and pass" + vo);
		return vo;
	}

	@Override
	public UserVO selectUser(String id) {
		UserVO vo = sqlSession.selectOne("users.selectUserByID", id);
		System.out.println("selectuserid" + vo);
		return vo;
	}

	@Override
	public String selectUserName(Long no) {
		String name = sqlSession.selectOne("users.selectUserByNo", no);
		return name;
	}
	
	
}
