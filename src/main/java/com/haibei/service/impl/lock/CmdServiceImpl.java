package com.haibei.service.impl.lock;

import com.haibei.dao.lock.CmdMapper;
import com.haibei.pojo.lock.Cmd;
import com.haibei.pojo.lock.CmdExample;
import com.haibei.service.lock.CmdService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CmdServiceImpl implements CmdService {
    @Autowired
    private CmdMapper cmdMapper;

    public int countByExample(CmdExample example) {
        int count = this.cmdMapper.countByExample(example);
        return count;
    }

    public Cmd selectByPrimaryKey(String seqNo) {
        return this.cmdMapper.selectByPrimaryKey(seqNo);
    }

    public List<Cmd> selectByExample(CmdExample example) {
        return this.cmdMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String seqNo) {
        return this.cmdMapper.deleteByPrimaryKey(seqNo);
    }

    public int updateByPrimaryKeySelective(Cmd record) {
        return this.cmdMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Cmd record) {
        return this.cmdMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(CmdExample example) {
        return this.cmdMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Cmd record, CmdExample example) {
        return this.cmdMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Cmd record, CmdExample example) {
        return this.cmdMapper.updateByExample(record, example);
    }

    public int insert(Cmd record) {
        return this.cmdMapper.insert(record);
    }

    public int insertSelective(Cmd record) {
        return this.cmdMapper.insertSelective(record);
    }
}