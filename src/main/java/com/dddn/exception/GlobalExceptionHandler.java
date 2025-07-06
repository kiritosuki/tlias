package com.dddn.exception;

import com.dddn.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private final View error;

    public GlobalExceptionHandler(View error) {
        this.error = error;
    }

    @ExceptionHandler
    public Result HandleException(Exception e){
        log.error("程序出错啦~",e);
        return Result.error("程序出错啦! 请联系后端开发人员~");
    }

    @ExceptionHandler
    public Result HandleDuplicateKeyException(DuplicateKeyException e){
        log.error("用户输入了已存在的用户名",e);
        String msg = e.getMessage();
        int index = msg.indexOf("Duplicate entry");
        String errorMsg = msg.substring(index);
        String res = errorMsg.split(" ")[2];
        return Result.error(res + " 已存在!");
    }

    @ExceptionHandler
    public Result HandleIllegalArgumentException(IllegalArgumentException e){
        log.error("用户在删除时没有选中要删除的对象", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

    @ExceptionHandler
    public Result HandleClazzHasStudentException(ClazzHasStudentsException e){
        log.error("用户尝试删除其下有学生的班级", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

    @ExceptionHandler
    public Result HandleStudentHasNotClazzIdException(StudentHasNotClazzIdException e){
        log.error("用户在添加学生时没有指定班级", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

    @ExceptionHandler
    public Result HandleNoResourceFoundException(NoResourceFoundException e){
        log.error("用户在删除时没有指定学生", e);
        return Result.error("请先选择你要删除的学生~");
    }

    @ExceptionHandler
    public Result HandleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e){
        log.error("用户输入了无效的参数", e);
        return Result.error("请输入有效的参数~");
    }

    @ExceptionHandler
    public Result HandleIllegalParamException(IllegalParamException e){
        log.error("用户输入了非法的参数", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

    @ExceptionHandler
    public Result HandleNumOutOfBoundException(NumOutOfBoundException e){
        log.error("用户输入的参数使参数的范围溢出", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

    @ExceptionHandler
    public Result HandleDeptHasEmpsException(DeptHasEmpsException e){
        log.error("用户尝试删除其下有员工的部门", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

    @ExceptionHandler
    public Result HandleLoginErrorException(LoginErrorException e){
        log.error("用户输入了错误的用户名或者密码", e);
        String errorMsg = e.getMessage();
        return Result.error(errorMsg);
    }

}
