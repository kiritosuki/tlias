package com.dddn.controller;

import com.dddn.pojo.Result;
import com.dddn.service.UploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    private final UploadService uploadService;
    private static final Logger log = LoggerFactory.getLogger(UploadController.class);

    public UploadController(@Qualifier("uploadServiceImpl") UploadService uploadService){
        this.uploadService = uploadService;
    }

    @PostMapping("/upload")
    public Result uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        log.info("上传文件-file: {}",file);
        String url = uploadService.uploadFile(file);
        return Result.success(url);
    }
}
