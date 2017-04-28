package com.haibei.service.impl.lock;

import com.haibei.dao.lock.TypeMapper;
import com.haibei.pojo.lock.Type;
import com.haibei.pojo.lock.TypeExample;
import com.haibei.service.lock.TypeService;
import com.haibei.service.sys.SequenceService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private SequenceService sequenceService;

    public int countByExample(TypeExample example) {
        int count = this.typeMapper.countByExample(example);
        return count;
    }

    public Type selectByPrimaryKey(Short devType) {
        return this.typeMapper.selectByPrimaryKey(devType);
    }

    public List<Type> selectByExample(TypeExample example) {
        return this.typeMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Short devType) {
        return this.typeMapper.deleteByPrimaryKey(devType);
    }

    public int updateByPrimaryKeySelective(Type record) {
        return this.typeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Type record) {
        return this.typeMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(TypeExample example) {
        return this.typeMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Type record, TypeExample example) {
        return this.typeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Type record, TypeExample example) {
        return this.typeMapper.updateByExample(record, example);
    }

    public int insert(Type record) {
    	record.setDevType(Short.parseShort(this.sequenceService.getSequences("HAIBEI_DEVICE_TYPE_T").toString()));
        return this.typeMapper.insert(record);
    }

    public int insertSelective(Type record) {
    	record.setDevType(Short.parseShort(this.sequenceService.getSequences("HAIBEI_DEVICE_TYPE_T").toString()));
        return this.typeMapper.insertSelective(record);
    }
}