package com.blogproject.jblog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogproject.jblog.repository.BlogDAO;
import com.blogproject.jblog.vo.BlogVO;
import com.blogproject.jblog.vo.CategoryVO;
import com.blogproject.jblog.vo.PostVO;
import com.blogproject.jblog.vo.UserVO;


@Service
public class BlogServiceImple implements BlogService {

	@Autowired
	BlogDAO blogDAOImple;
	
	
	@Override
	public BlogVO getPage(String id){
		BlogVO vo = blogDAOImple.getPage(id);
		return vo;
	}
	@Override
	public List<PostVO> getPost(Long no) {
		List<PostVO> list = blogDAOImple.getPost(no);
		return list;
	}

	@Override
	public List<CategoryVO> getCate(Long no) {
		List<CategoryVO> list = blogDAOImple.getCate(no);
		return list;
	}
	
	@Override
	public BlogVO getBlogAdmin(String id) {
		BlogVO vo = blogDAOImple.getBlogAdmin(id);
		return vo;
		
	}
	@Override
	public BlogVO getBlogAdmin(Long no) {
		BlogVO vo = blogDAOImple.getBlogAdmin(no);
		return vo;
	}
	@Override
	public boolean update(BlogVO vo) {
		int updatedCount = blogDAOImple.update(vo);
		return updatedCount == 1;
	}
	@Override
	public boolean insertCate(CategoryVO vo) {
		int insertedCount = blogDAOImple.insertCate(vo);
		return insertedCount == 1;
	}
	@Override
	public boolean write(PostVO vo) {
		int writedCount = blogDAOImple.write(vo);
		return writedCount == 1;
	}
	
	
			

}
