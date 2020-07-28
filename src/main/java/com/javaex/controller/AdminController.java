package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;

@Controller
@RequestMapping("/{id}/admin")
public class AdminController {
	@Autowired
	BlogService blogService;
	
	//기본설정 페이지
	@RequestMapping("/basic")
	public String basic(Model model, @PathVariable("id")String id) {
		model.addAttribute("blogVo", blogService.select(id));
		
	}
	
	
}
