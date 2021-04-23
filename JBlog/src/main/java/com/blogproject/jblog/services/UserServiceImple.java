package com.blogproject.jblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogproject.jblog.repository.UserDAO;
import com.blogproject.jblog.vo.UserVO;


@Service
public class UserServiceImple implements UserService {

	@Autowired
	UserDAO userDAOImple;
	
	@Override
	public boolean join(UserVO vo) {
		// TODO Auto-generated method stub
		int insertedCount = userDAOImple.insert(vo);
		
		return insertedCount == 1;
	}
	
	@Override
	public boolean makeBlog(UserVO vo) {
		// TODO Auto-generated method stub
		int insertedCount = userDAOImple.makeBlog(vo);
		return insertedCount == 1;
	}
	
	@Override
	public boolean makeCategory(UserVO vo) {
		int insertedCount = userDAOImple.makeCategory(vo);
		return insertedCount == 1;
	}

	@Override
	public UserVO getUser(String id, String password) {
		UserVO vo = userDAOImple.selectUser(id, password);
		return vo;
	}

	@Override
	public UserVO getUser(String id) {
		UserVO vo = userDAOImple.selectUser(id);
		return vo;
	}

	@Override
	public String selectUserName(Long no) {
		String name = userDAOImple.selectUserName(no);
		return name;
	}

}
