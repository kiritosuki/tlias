package com.dddn.aspect;

import com.dddn.anno.LogOperator;
import com.dddn.mapper.OperatorLogMapper;
import com.dddn.pojo.OperatorLog;
import com.dddn.pojo.Result;
import com.dddn.utils.CurrentLocal;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect()
@Component
public class OperatorLogAspect {
    private final OperatorLogMapper operatorLogMapper;

    public OperatorLogAspect(@Qualifier("operatorLogMapper") OperatorLogMapper operatorLogMapper) {
        this.operatorLogMapper = operatorLogMapper;
    }

    @Around("@annotation(logOperator)")
    public Result around(ProceedingJoinPoint joinPoint, LogOperator logOperator) throws Throwable {
        Long statTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long costTime = endTime - statTime;
        // 创建OperatorLog对象
        OperatorLog operatorLog = new OperatorLog(
                getOperatorEmpId(),
                LocalDateTime.now(),
                joinPoint.getTarget().getClass().getName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()),
                result == null ? "null" : result.toString(),
                costTime
        );
        operatorLogMapper.addOperatorLog(operatorLog);
        return (Result) result;
    }

    public int getOperatorEmpId(){
        return CurrentLocal.getThreadLocal();
    }
}
