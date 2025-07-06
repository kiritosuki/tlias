package com.dddn.service;

import com.dddn.pojo.OperatorLog;
import com.dddn.pojo.PageParam;
import com.dddn.pojo.PageResult;

public interface OperatorLogService {
    PageResult<OperatorLog> listLog(PageParam pageParam);
}
