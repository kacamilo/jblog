package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원가입 (회원저장)
	public int join(UserVo userVo) {
		System.out.println("userDao:insert");
		
		return sqlSession.insert("user.insert", userVo);
	}
	
	public int joinBlog(UserVo userVo) {
		return sqlSession.insert("user.insertBlog", userVo);
	}

	public int joinCategory(UserVo userVo) {
		return sqlSession.insert("user.insertCategory", userVo);
	}
	//로그인(회원정보 가져오기)
	public UserVo login(UserVo userVo) {
		System.out.println("userDao:selectUser");
		
		return sqlSession.selectOne("user.selectUser", userVo);
	}
	
	//아이디 체크
	public UserVo selectUser(String id) {
		System.out.println("userDao:selectUser(ajax)");
		UserVo userVo = sqlSession.selectOne("user.selectById", id);
		
		System.out.println(userVo.toString()+"idchk");
		
		return userVo;
	}
}
