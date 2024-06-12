package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/upload")
public class UploadController {
	@Autowired
	private AliOSSUtils aliOSSUtils;
//	@PostMapping("/")
//	public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//		log.info("文件上传：{},{},{}",username,age,image);
//		String originalFilename = image.getOriginalFilename();
//		System.out.println(originalFilename);
//		String UID = UUID.randomUUID().toString();
//		image.transferTo(new File("E://"+UID+originalFilename));
//		return Result.success();
//	}

	@PostMapping("")
	public Result upload( MultipartFile image) throws IOException {
		String originalFilename = image.getOriginalFilename();
		log.info("文件上传：{}",originalFilename);
		String url = aliOSSUtils.upload(image);
		return Result.success(url);
	}
}
