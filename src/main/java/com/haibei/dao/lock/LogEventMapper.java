package com.haibei.dao.lock;

import com.haibei.pojo.lock.LogEvent;
import com.haibei.pojo.lock.LogEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogEventMapper {
    int countByExample(LogEventExample example);

    int deleteByExample(LogEventExample example);

    int deleteByPrimaryKey(Long eventId);

    int insert(LogEvent record);

    int insertSelective(LogEvent record);

    List<LogEvent> selectByExample(LogEventExample example);

    LogEvent selectByPrimaryKey(Long eventId);

    int updateByExampleSelective(@Param("record") LogEvent record, @Param("example") LogEventExample example);

    int updateByExample(@Param("record") LogEvent record, @Param("example") LogEventExample example);

    int updateByPrimaryKeySelective(LogEvent record);

    int updateByPrimaryKey(LogEvent record);
}