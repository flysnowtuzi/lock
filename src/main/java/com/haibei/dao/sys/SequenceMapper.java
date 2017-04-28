package com.haibei.dao.sys;

import java.util.List;
import java.util.Map;
import com.haibei.pojo.sys.Sequence;
import com.haibei.pojo.sys.SequenceExample;
import org.apache.ibatis.annotations.Param;


public interface SequenceMapper {
    int countByExample(SequenceExample example);

    int deleteByExample(SequenceExample example);

    int deleteByPrimaryKey(String sequenceCode);

    int insert(Sequence record);

    int insertSelective(Sequence record);

    List<Sequence> selectByExample(SequenceExample example);

    Sequence selectByPrimaryKey(String sequenceCode);

    int updateByExampleSelective(@Param("record") Sequence record, @Param("example") SequenceExample example);

    int updateByExample(@Param("record") Sequence record, @Param("example") SequenceExample example);

    int updateByPrimaryKeySelective(Sequence record);

    int updateByPrimaryKey(Sequence record);
    
    void getSequences(Map<String,Object> record); 
}