package com.haibei.dao.lock;

import com.haibei.pojo.lock.Lock;
import com.haibei.pojo.lock.LockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LockMapper {
    int countByExample(LockExample example);

    int deleteByExample(LockExample example);

    int deleteByPrimaryKey(String lockId);

    int insert(Lock record);

    int insertSelective(Lock record);

    List<Lock> selectByExample(LockExample example);

    Lock selectByPrimaryKey(String lockId);

    int updateByExampleSelective(@Param("record") Lock record, @Param("example") LockExample example);

    int updateByExample(@Param("record") Lock record, @Param("example") LockExample example);

    int updateByPrimaryKeySelective(Lock record);

    int updateByPrimaryKey(Lock record);
}