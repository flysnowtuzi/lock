package com.haibei.service.impl.lock;

import com.haibei.dao.lock.LockUserMapper;
import com.haibei.pojo.lock.LockUser;
import com.haibei.pojo.lock.LockUserExample;
import com.haibei.pojo.lock.LockUserKey;
import com.haibei.service.lock.LockUserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockUserServiceImpl implements LockUserService {
    @Autowired
    private LockUserMapper lockUserMapper;

    public int countByExample(LockUserExample example) {
        int count = this.lockUserMapper.countByExample(example);
        return count;
    }

    public LockUser selectByPrimaryKey(LockUserKey key) {
        return this.lockUserMapper.selectByPrimaryKey(key);
    }

    public List<LockUser> selectByExample(LockUserExample example) {
        return this.lockUserMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(LockUserKey key) {
        return this.lockUserMapper.deleteByPrimaryKey(key);
    }

    public int updateByPrimaryKeySelective(LockUser record) {
        return this.lockUserMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LockUser record) {
        return this.lockUserMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(LockUserExample example) {
        return this.lockUserMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(LockUser record, LockUserExample example) {
        return this.lockUserMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(LockUser record, LockUserExample example) {
        return this.lockUserMapper.updateByExample(record, example);
    }

    public int insert(LockUser record) {
        return this.lockUserMapper.insert(record);
    }

    public int insertSelective(LockUser record) {
        return this.lockUserMapper.insertSelective(record);
    }
}