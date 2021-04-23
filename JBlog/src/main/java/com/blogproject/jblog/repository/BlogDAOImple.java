package com.blogproject.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blogproject.jblog.vo.BlogVO;
import com.blogproject.jblog.vo.CategoryVO;
import com.blogproject.jblog.vo.CommentVO;
import com.blogproject.jblog.vo.PostVO;
import com.blogproject.jblog.vo.UserVO;


@Repository
public class BlogDAOImple implements BlogDAO {
	
	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public BlogVO getPage(String id) {
		BlogVO vo = sqlSession.selectOne("blog.adminBlog", id);
		return vo;
	}
	@Override
	public List<PostVO> getPost(Long no) {
		List<PostVO> list = sqlSession.selectList("blog.getPost",no);
		return list;
	}
	
	@Override
	public List<CategoryVO> getCate(Long no) {
		List<CategoryVO> list = sqlSession.selectList("blog.selectCategory", no);
		return list;
	}
	
	@Override
	public BlogVO getBlogAdmin(String id) {
		BlogVO vo = sqlSession.selectOne("blog.adminBlog",id);
		return vo;
	}
	@Override
	public BlogVO getBlogAdmin(Long no) {
		BlogVO vo = sqlSession.selectOne("blog.adminBlog2",no);
		return vo;
	}
	@Override
	public int update(BlogVO vo) {
		int updatedCount = sqlSession.update("blog.update", vo);
		return updatedCount;
	}
	
	@Override
	public int updateLogo(BlogVO vo) {
		int updatedCount = sqlSession.update("blog.updateLogo", vo);
		return updatedCount;
	}
	
	
	@Override
	public int insertCate(CategoryVO vo) {
		int insertedCount = sqlSession.insert("blog.insertCate", vo);
		return insertedCount;
	}
	@Override
	public int write(PostVO vo) {
		int writedCount = sqlSession.insert("blog.write", vo);
		return writedCount;
	}
	@Override
	public Long getPostCount(Long no) {
		long count = sqlSession.selectOne("blog.getPostCount", no);
		return count;
	}
	@Override
	public int deleteCate(Long no) {
		int deletedCount = sqlSession.update("blog.deleteCate", no);
		return deletedCount;
	}
	@Override
	public int insertComment(CommentVO vo) {
		int insertedCount = sqlSession.insert("blog.insertComment", vo);
		return insertedCount;
	}
	@Override
	public int deleteComment(Long no) {
		int deletedCount = sqlSession.delete("blog.deleteComment", no);
		return deletedCount;
	}
	@Override
	public List<CommentVO> getComment(Long no) {
		List<CommentVO> list = sqlSession.selectList("blog.getComment", no);
		return list;
	}
	
	
}
