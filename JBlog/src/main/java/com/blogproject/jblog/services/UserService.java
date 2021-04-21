package com.blogproject.jblog.services;

import com.blogproject.jblog.vo.UserVO;

public interface UserService {
	public boolean join(UserVO vo);
	public boolean makeBlog(UserVO vo);
	public boolean makeCategory(UserVO vo);
	public UserVO getUser(String id, String password);
	public UserVO getUser(String id);
}

