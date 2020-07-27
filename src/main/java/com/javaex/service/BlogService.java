package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public BlogVo select(String id) {
		return blogDao.selectBlog(id);

	}

	public List<CategoryVo> categoryList(String id) {
		return categoryDao.categoryList(id);
	}
	
	//파일 업로드
	public String blogUpdate(String id, String blogTitle, MultipartFile file) {
		System.out.println("FileUploadService/restore");
		//////////////// 데이타 추출 ////////////////
		String saveDir = "c:\\Java Study\\upload";
		
		//원파일 이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName:" + orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println("exName:" + exName);
		
		//저장파일이름
		String logoFile = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("logoFile:" + logoFile);
		
		//파일 경로
		String filePath = saveDir + "\\" + logoFile;
		System.out.println("filePath:" + filePath);
		
		//파일 사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize:" + fileSize);
		
		//////// 파일 서버에 복사 /////////////////////////////
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);
			
			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//파일 --> 필요한 정보 추출 --> DB에 저장
		
	
		return "";
		
	}
	
	
}
