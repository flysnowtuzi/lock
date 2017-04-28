package com.haibei.service.impl.lock;

import com.haibei.dao.lock.EventMapper;
import com.haibei.pojo.lock.Event;
import com.haibei.pojo.lock.EventExample;
import com.haibei.service.lock.EventService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    private EventMapper eventMapper;

    public int countByExample(EventExample example) {
        int count = this.eventMapper.countByExample(example);
        return count;
    }

    public Event selectByPrimaryKey(Short eventId) {
        return this.eventMapper.selectByPrimaryKey(eventId);
    }

    public List<Event> selectByExample(EventExample example) {
        return this.eventMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Short eventId) {
        return this.eventMapper.deleteByPrimaryKey(eventId);
    }

    public int updateByPrimaryKeySelective(Event record) {
        return this.eventMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Event record) {
        return this.eventMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(EventExample example) {
        return this.eventMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Event record, EventExample example) {
        return this.eventMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Event record, EventExample example) {
        return this.eventMapper.updateByExample(record, example);
    }

    public int insert(Event record) {
        return this.eventMapper.insert(record);
    }

    public int insertSelective(Event record) {
        return this.eventMapper.insertSelective(record);
    }
}