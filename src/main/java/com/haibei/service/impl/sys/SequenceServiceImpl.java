package com.haibei.service.impl.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haibei.dao.sys.SequenceMapper;
import com.haibei.pojo.sys.Sequence;
import com.haibei.pojo.sys.SequenceExample;
import com.haibei.service.sys.SequenceService;

@Service
public class SequenceServiceImpl implements SequenceService {
    @Autowired
    private SequenceMapper sequenceMapper;

    public int countByExample(SequenceExample example) {
        int count = this.sequenceMapper.countByExample(example);
        return count;
    }

    public Sequence selectByPrimaryKey(String sequenceCode) {
        return this.sequenceMapper.selectByPrimaryKey(sequenceCode);
    }

    public List<Sequence> selectByExample(SequenceExample example) {
        return this.sequenceMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(String sequenceCode) {
        return this.sequenceMapper.deleteByPrimaryKey(sequenceCode);
    }

    public int updateByPrimaryKeySelective(Sequence record) {
        return this.sequenceMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Sequence record) {
        return this.sequenceMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(SequenceExample example) {
        return this.sequenceMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Sequence record, SequenceExample example) {
        return this.sequenceMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Sequence record, SequenceExample example) {
        return this.sequenceMapper.updateByExample(record, example);
    }

    public int insert(Sequence record) {
        return this.sequenceMapper.insert(record);
    }

    public int insertSelective(Sequence record) {
        return this.sequenceMapper.insertSelective(record);
    }
    public Integer getSequences(String tableName){
    	Map<String,Object> record=new HashMap<String,Object>();
    	record.put("tableName", tableName);
    	record.put("sequId", 1);
    	this.sequenceMapper.getSequences(record);
    	return (Integer)record.get("sequId");
    };
}