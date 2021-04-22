package com.blogproject.jblog.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.blogproject.jblog.services.FileUploadService;


@RequestMapping("/fileupload")
@Controller
public class FileUploadController {

	private static Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	
	@Autowired
	FileUploadService fileUploadService;
	
	@RequestMapping({"","/","form"})
	public String form() {
		return "fileupload/form";
	}
	
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	public String upload(@RequestParam MultipartFile uploadfile, Model model) {
		String saveFileName = fileUploadService.store(uploadfile);
		logger.debug("저장된 파일명 : " + saveFileName);
		String urlImage = "upload-images/" + saveFileName;
		logger.debug("이미지 요청 url : " + urlImage);
		model.addAttribute("urlImage", urlImage);
		
		return "fileupload/result";
	}
}
