package com.blogproject.jblog.services;

import java.util.List;

import com.blogproject.jblog.vo.BlogVO;
import com.blogproject.jblog.vo.CategoryVO;
import com.blogproject.jblog.vo.CommentVO;
import com.blogproject.jblog.vo.PostVO;
import com.blogproject.jblog.vo.UserVO;

public interface BlogService {
	
	public BlogVO getPage(String id);
	public List<PostVO> getPost(Long no);
	public List<CategoryVO> getCate(Long no);
	public BlogVO getBlogAdmin(String id);
	public BlogVO getBlogAdmin(Long no);
	public Long getPostCount(Long no);
	public boolean update(BlogVO vo);
	public boolean insertCate(CategoryVO vo);
	public boolean write(PostVO vo);
	public boolean updateLogo(BlogVO vo);
	public boolean deleteCate(Long no);
	
	public boolean insertComment(CommentVO vo);
	public boolean deleteComment(Long no);
	
	public List<CommentVO> getComment(Long no);
	
}
