package com.haibei.service.lock;

import com.haibei.pojo.lock.Type;
import com.haibei.pojo.lock.TypeExample;
import java.util.List;

public interface TypeService {
    int countByExample(TypeExample example);

    Type selectByPrimaryKey(Short devType);

    List<Type> selectByExample(TypeExample example);

    int deleteByPrimaryKey(Short devType);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    int deleteByExample(TypeExample example);

    int updateByExampleSelective(Type record, TypeExample example);

    int updateByExample(Type record, TypeExample example);

    int insert(Type record);

    int insertSelective(Type record);
}