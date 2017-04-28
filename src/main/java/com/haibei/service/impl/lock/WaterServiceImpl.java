package com.haibei.service.impl.lock;

import com.haibei.dao.lock.WaterMapper;
import com.haibei.pojo.lock.Water;
import com.haibei.pojo.lock.WaterExample;
import com.haibei.service.lock.WaterService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterServiceImpl implements WaterService {
    @Autowired
    private WaterMapper waterMapper;

    public int countByExample(WaterExample example) {
        int count = this.waterMapper.countByExample(example);
        return count;
    }

    public Water selectByPrimaryKey(Long seqNo) {
        return this.waterMapper.selectByPrimaryKey(seqNo);
    }

    public List<Water> selectByExample(WaterExample example) {
        return this.waterMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Long seqNo) {
        return this.waterMapper.deleteByPrimaryKey(seqNo);
    }

    public int updateByPrimaryKeySelective(Water record) {
        return this.waterMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Water record) {
        return this.waterMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(WaterExample example) {
        return this.waterMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Water record, WaterExample example) {
        return this.waterMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Water record, WaterExample example) {
        return this.waterMapper.updateByExample(record, example);
    }

    public int insert(Water record) {
        return this.waterMapper.insert(record);
    }

    public int insertSelective(Water record) {
        return this.waterMapper.insertSelective(record);
    }
}