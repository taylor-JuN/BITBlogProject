package com.blogproject.jblog.repository;

import com.blogproject.jblog.vo.UserVO;

public interface UserDAO {
	public int insert(UserVO vo);
	public UserVO selectUser(String id, String password);
	public UserVO selectUser(String id);
	public int makeBlog(UserVO vo);
	public int makeCategory(UserVO vo);

}
