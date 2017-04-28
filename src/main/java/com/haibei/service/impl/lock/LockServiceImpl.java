package com.haibei.service.impl.lock;

import com.haibei.dao.lock.LockMapper;
import com.haibei.dao.sys.SequenceMapper;
import com.haibei.pojo.lock.Lock;
import com.haibei.pojo.lock.LockExample;
import com.haibei.pojo.sys.Sequence;
import com.haibei.service.lock.LockService;
import com.haibei.service.sys.SequenceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockServiceImpl implements LockService {
    @Autowired
    private LockMapper lockMapper;

    public int countByExample(LockExample example) {
        int count = this.lockMapper.countByExample(example);
        return count;
    }

    public Lock selectByPrimaryKey(String lockId) {
        return this.lockMapper.selectByPrimaryKey(lockId);
    }

    public List<Lock> selectByExample(LockExample example) {
        return this.lockMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String lockId) {
        return this.lockMapper.deleteByPrimaryKey(lockId);
    }

    public int updateByPrimaryKeySelective(Lock record) {
        return this.lockMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Lock record) {
        return this.lockMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(LockExample example) {
        return this.lockMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Lock record, LockExample example) {
        return this.lockMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Lock record, LockExample example) {
        return this.lockMapper.updateByExample(record, example);
    }

    public int insert(Lock record) {
    	//record.setLockId(this.sequenceService.getSequences("HAIBEI_LOCK_T").toString());
        return this.lockMapper.insert(record);
    }

    public int insertSelective(Lock record) {
    	//record.setLockId(this.sequenceService.getSequences("HAIBEI_LOCK_T").toString());
        return this.lockMapper.insertSelective(record);
    }
}