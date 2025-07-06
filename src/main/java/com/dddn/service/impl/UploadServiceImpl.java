package com.dddn.service.impl;

import com.dddn.service.UploadService;
import com.dddn.utils.AliyunOSSOperator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadServiceImpl implements UploadService {
    private final AliyunOSSOperator aliyunOSSOperator;

    public UploadServiceImpl(@Qualifier("aliyunOSSOperator") AliyunOSSOperator aliyunOSSOperator){
        this.aliyunOSSOperator = aliyunOSSOperator;
    }

    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        String url = aliyunOSSOperator.uploadFile(file.getBytes(), file.getOriginalFilename());
        return url;
    }
}
