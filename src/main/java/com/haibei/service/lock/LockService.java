package com.haibei.service.lock;

import com.haibei.pojo.lock.Lock;
import com.haibei.pojo.lock.LockExample;
import java.util.List;

public interface LockService {
    int countByExample(LockExample example);

    Lock selectByPrimaryKey(String lockId);

    List<Lock> selectByExample(LockExample example);

    int deleteByPrimaryKey(String lockId);

    int updateByPrimaryKeySelective(Lock record);

    int updateByPrimaryKey(Lock record);

    int deleteByExample(LockExample example);

    int updateByExampleSelective(Lock record, LockExample example);

    int updateByExample(Lock record, LockExample example);

    int insert(Lock record);

    int insertSelective(Lock record);
}