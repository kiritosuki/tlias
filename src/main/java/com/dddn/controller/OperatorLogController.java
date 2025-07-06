package com.dddn.controller;

import com.dddn.pojo.OperatorLog;
import com.dddn.pojo.PageParam;
import com.dddn.pojo.PageResult;
import com.dddn.pojo.Result;
import com.dddn.service.OperatorLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperatorLogController {
    private static final Logger log = LoggerFactory.getLogger(OperatorLogController.class);
    private final OperatorLogService operatorLogService;

    public OperatorLogController(@Qualifier("operatorLogServiceImpl") OperatorLogService operatorLogService) {
        this.operatorLogService = operatorLogService;
    }

    // 日志列表查询
    @GetMapping("/log/page")
    public Result listLog(@ModelAttribute PageParam pageParam){
        PageResult<OperatorLog> pageResult = operatorLogService.listLog(pageParam);
        log.info("查询日志信息: {}", pageResult);
        return Result.success(pageResult);
    }

}
