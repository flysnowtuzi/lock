package com.haibei.dao.lock;

import com.haibei.pojo.lock.Water;
import com.haibei.pojo.lock.WaterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WaterMapper {
    int countByExample(WaterExample example);

    int deleteByExample(WaterExample example);

    int deleteByPrimaryKey(Long seqNo);

    int insert(Water record);

    int insertSelective(Water record);

    List<Water> selectByExample(WaterExample example);

    Water selectByPrimaryKey(Long seqNo);

    int updateByExampleSelective(@Param("record") Water record, @Param("example") WaterExample example);

    int updateByExample(@Param("record") Water record, @Param("example") WaterExample example);

    int updateByPrimaryKeySelective(Water record);

    int updateByPrimaryKey(Water record);
}