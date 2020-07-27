package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo selectBlog(String id) {
		return sqlSession.selectOne("blog.selectOne", id);
	}
	
	public List<BlogVo> selectList(){
		System.out.println("BlogDao/selectList");
		
		return sqlSession.selectList("Blog.selectList");
	}
}
