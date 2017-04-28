package com.haibei.service.sys;

import java.util.List;

import com.haibei.pojo.sys.Sequence;
import com.haibei.pojo.sys.SequenceExample;


public interface SequenceService {
    int countByExample(SequenceExample example);

    Sequence selectByPrimaryKey(String sequenceCode);

    List<Sequence> selectByExample(SequenceExample example);

    int deleteByPrimaryKey(String sequenceCode);

    int updateByPrimaryKeySelective(Sequence record);

    int updateByPrimaryKey(Sequence record);

    int deleteByExample(SequenceExample example);

    int updateByExampleSelective(Sequence record, SequenceExample example);

    int updateByExample(Sequence record, SequenceExample example);

    int insert(Sequence record);

    int insertSelective(Sequence record);
    Integer getSequences(String tableName);
}