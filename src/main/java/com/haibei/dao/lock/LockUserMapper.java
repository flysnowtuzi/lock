package com.haibei.dao.lock;

import com.haibei.pojo.lock.LockUser;
import com.haibei.pojo.lock.LockUserExample;
import com.haibei.pojo.lock.LockUserKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LockUserMapper {
    int countByExample(LockUserExample example);

    int deleteByExample(LockUserExample example);

    int deleteByPrimaryKey(LockUserKey key);

    int insert(LockUser record);

    int insertSelective(LockUser record);

    List<LockUser> selectByExample(LockUserExample example);

    LockUser selectByPrimaryKey(LockUserKey key);

    int updateByExampleSelective(@Param("record") LockUser record, @Param("example") LockUserExample example);

    int updateByExample(@Param("record") LockUser record, @Param("example") LockUserExample example);

    int updateByPrimaryKeySelective(LockUser record);

    int updateByPrimaryKey(LockUser record);
}