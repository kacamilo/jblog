package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	// 블로그 메인
	@RequestMapping("/{id}")
	public String main(Model model, @PathVariable("id") String id) {
		// 정보 (id, blogTitle, logoFile)
		model.addAttribute("blogVo", blogService.select(id));
		
		//카테고리 리스트
		model.addAttribute("cateList", blogService.categoryList(id));

		return "blog/blog-main";
		
	}
	
}
