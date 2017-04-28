package com.haibei.service.lock;

import com.haibei.pojo.lock.Water;
import com.haibei.pojo.lock.WaterExample;
import java.util.List;

public interface WaterService {
    int countByExample(WaterExample example);

    Water selectByPrimaryKey(Long seqNo);

    List<Water> selectByExample(WaterExample example);

    int deleteByPrimaryKey(Long seqNo);

    int updateByPrimaryKeySelective(Water record);

    int updateByPrimaryKey(Water record);

    int deleteByExample(WaterExample example);

    int updateByExampleSelective(Water record, WaterExample example);

    int updateByExample(Water record, WaterExample example);

    int insert(Water record);

    int insertSelective(Water record);
}