package com.haibei.dao.lock;

import com.haibei.pojo.lock.Cmd;
import com.haibei.pojo.lock.CmdExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CmdMapper {
    int countByExample(CmdExample example);

    int deleteByExample(CmdExample example);

    int deleteByPrimaryKey(String seqNo);

    int insert(Cmd record);

    int insertSelective(Cmd record);

    List<Cmd> selectByExample(CmdExample example);

    Cmd selectByPrimaryKey(String seqNo);

    int updateByExampleSelective(@Param("record") Cmd record, @Param("example") CmdExample example);

    int updateByExample(@Param("record") Cmd record, @Param("example") CmdExample example);

    int updateByPrimaryKeySelective(Cmd record);

    int updateByPrimaryKey(Cmd record);
}