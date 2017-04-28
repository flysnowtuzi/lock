package com.haibei.service.lock;

import com.haibei.pojo.lock.LogEvent;
import com.haibei.pojo.lock.LogEventExample;
import java.util.List;

public interface LogEventService {
    int countByExample(LogEventExample example);

    LogEvent selectByPrimaryKey(Long eventId);

    List<LogEvent> selectByExample(LogEventExample example);

    int deleteByPrimaryKey(Long eventId);

    int updateByPrimaryKeySelective(LogEvent record);

    int updateByPrimaryKey(LogEvent record);

    int deleteByExample(LogEventExample example);

    int updateByExampleSelective(LogEvent record, LogEventExample example);

    int updateByExample(LogEvent record, LogEventExample example);

    int insert(LogEvent record);

    int insertSelective(LogEvent record);
}