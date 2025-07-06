package com.dddn.service.impl;

import com.dddn.mapper.OperatorLogMapper;
import com.dddn.pojo.OperatorLog;
import com.dddn.pojo.PageParam;
import com.dddn.pojo.PageResult;
import com.dddn.service.OperatorLogService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorLogServiceImpl implements OperatorLogService {
    private final OperatorLogMapper operatorLogMapper;

    public OperatorLogServiceImpl(@Qualifier("operatorLogMapper") OperatorLogMapper operatorLogMapper) {
        this.operatorLogMapper = operatorLogMapper;
    }

    @Override
    public PageResult<OperatorLog> listLog(PageParam pageParam) {
        PageHelper.startPage(pageParam.getPage(), pageParam.getPageSize());
        List<OperatorLog> operatorLogList = operatorLogMapper.getOperatorLogList();
        Page<OperatorLog> p = (Page<OperatorLog>) operatorLogList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }
}
