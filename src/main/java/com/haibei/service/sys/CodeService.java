package com.haibei.service.sys;

import java.util.List;
import java.util.Map;

import com.haibei.pojo.sys.Code;
import com.haibei.pojo.sys.CodeExample;



public interface CodeService {
    int countByExample(CodeExample example);

    Code selectByPrimaryKey(Integer codeId);

    List<Code> selectByExample(CodeExample example);

    int deleteByPrimaryKey(Integer codeId);

    int updateByPrimaryKeySelective(Code record);

    int updateByPrimaryKey(Code record);

    int deleteByExample(CodeExample example);

    int updateByExampleSelective(Code record, CodeExample example);

    int updateByExample(Code record, CodeExample example);

    int insert(Code record);

    int insertSelective(Code record);
    
    List<Code> selectCodeType();
    
    Map<String, List<Code>> getCodes();
    List<Code> queryCodes(String codeName);
}