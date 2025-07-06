package com.dddn.mapper;

import com.dddn.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void addExpr(List<EmpExpr> exprList);

    void deleteExpr(List<Integer> ids);
}
