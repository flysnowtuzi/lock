package com.haibei.service.lock;

import com.haibei.pojo.lock.Cmd;
import com.haibei.pojo.lock.CmdExample;
import java.util.List;

public interface CmdService {
    int countByExample(CmdExample example);

    Cmd selectByPrimaryKey(String seqNo);

    List<Cmd> selectByExample(CmdExample example);

    int deleteByPrimaryKey(String seqNo);

    int updateByPrimaryKeySelective(Cmd record);

    int updateByPrimaryKey(Cmd record);

    int deleteByExample(CmdExample example);

    int updateByExampleSelective(Cmd record, CmdExample example);

    int updateByExample(Cmd record, CmdExample example);

    int insert(Cmd record);

    int insertSelective(Cmd record);
}