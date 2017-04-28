package com.haibei.service.application;

import com.haibei.pojo.application.Application;
import com.haibei.pojo.application.ApplicationExample;
import java.util.List;

public interface ApplicationService {
    int countByExample(ApplicationExample example);

    Application selectByPrimaryKey(Long wid);

    List<Application> selectByExample(ApplicationExample example);

    int deleteByPrimaryKey(Long wid);

    int updateByPrimaryKeySelective(Application record);

    int updateByPrimaryKey(Application record);

    int deleteByExample(ApplicationExample example);

    int updateByExampleSelective(Application record, ApplicationExample example);

    int updateByExample(Application record, ApplicationExample example);

    int insert(Application record);

    int insertSelective(Application record);
}