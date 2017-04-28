package com.haibei.service.lock;

import com.haibei.pojo.lock.LockUser;
import com.haibei.pojo.lock.LockUserExample;
import com.haibei.pojo.lock.LockUserKey;

import java.util.List;

public interface LockUserService {
    int countByExample(LockUserExample example);

    LockUser selectByPrimaryKey(LockUserKey key);

    List<LockUser> selectByExample(LockUserExample example);

    int deleteByPrimaryKey(LockUserKey key);

    int updateByPrimaryKeySelective(LockUser record);

    int updateByPrimaryKey(LockUser record);

    int deleteByExample(LockUserExample example);

    int updateByExampleSelective(LockUser record, LockUserExample example);

    int updateByExample(LockUser record, LockUserExample example);

    int insert(LockUser record);

    int insertSelective(LockUser record);
}