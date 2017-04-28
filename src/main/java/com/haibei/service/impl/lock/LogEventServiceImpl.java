package com.haibei.service.impl.lock;

import com.haibei.dao.lock.LogEventMapper;
import com.haibei.pojo.lock.LogEvent;
import com.haibei.pojo.lock.LogEventExample;
import com.haibei.service.lock.LogEventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogEventServiceImpl implements LogEventService {
    @Autowired
    private LogEventMapper logEventMapper;

    public int countByExample(LogEventExample example) {
        int count = this.logEventMapper.countByExample(example);
        return count;
    }

    public LogEvent selectByPrimaryKey(Long eventId) {
        return this.logEventMapper.selectByPrimaryKey(eventId);
    }

    public List<LogEvent> selectByExample(LogEventExample example) {
        return this.logEventMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Long eventId) {
        return this.logEventMapper.deleteByPrimaryKey(eventId);
    }

    public int updateByPrimaryKeySelective(LogEvent record) {
        return this.logEventMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(LogEvent record) {
        return this.logEventMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(LogEventExample example) {
        return this.logEventMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(LogEvent record, LogEventExample example) {
        return this.logEventMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(LogEvent record, LogEventExample example) {
        return this.logEventMapper.updateByExample(record, example);
    }

    public int insert(LogEvent record) {
        return this.logEventMapper.insert(record);
    }

    public int insertSelective(LogEvent record) {
        return this.logEventMapper.insertSelective(record);
    }
}