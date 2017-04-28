package com.haibei.service.impl.application;

import com.haibei.dao.application.ApplicationMapper;
import com.haibei.pojo.application.Application;
import com.haibei.pojo.application.ApplicationExample;
import com.haibei.service.application.ApplicationService;
import com.haibei.service.sys.SequenceService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private SequenceService sequenceService;
    public int countByExample(ApplicationExample example) {
        int count = this.applicationMapper.countByExample(example);
        return count;
    }

    public Application selectByPrimaryKey(Long wid) {
        return this.applicationMapper.selectByPrimaryKey(wid);
    }

    public List<Application> selectByExample(ApplicationExample example) {
        return this.applicationMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Long wid) {
        return this.applicationMapper.deleteByPrimaryKey(wid);
    }

    public int updateByPrimaryKeySelective(Application record) {
        return this.applicationMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Application record) {
        return this.applicationMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(ApplicationExample example) {
        return this.applicationMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Application record, ApplicationExample example) {
        return this.applicationMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Application record, ApplicationExample example) {
        return this.applicationMapper.updateByExample(record, example);
    }

    public int insert(Application record) {
    	record.setWid((Long)this.sequenceService.getSequences("t_ams_application").longValue());
    	//record.setWid(wid);
        return this.applicationMapper.insert(record);
    }

    public int insertSelective(Application record) {
    	record.setWid((Long)this.sequenceService.getSequences("t_ams_application").longValue());
        return this.applicationMapper.insertSelective(record);
    }
}