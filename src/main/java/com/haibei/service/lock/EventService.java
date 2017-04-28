package com.haibei.service.lock;

import com.haibei.pojo.lock.Event;
import com.haibei.pojo.lock.EventExample;
import java.util.List;

public interface EventService {
    int countByExample(EventExample example);

    Event selectByPrimaryKey(Short eventId);

    List<Event> selectByExample(EventExample example);

    int deleteByPrimaryKey(Short eventId);

    int updateByPrimaryKeySelective(Event record);

    int updateByPrimaryKey(Event record);

    int deleteByExample(EventExample example);

    int updateByExampleSelective(Event record, EventExample example);

    int updateByExample(Event record, EventExample example);

    int insert(Event record);

    int insertSelective(Event record);
}