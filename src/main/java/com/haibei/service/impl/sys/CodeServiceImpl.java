package com.haibei.service.impl.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.haibei.dao.sys.CodeMapper;
import com.haibei.pojo.sys.Code;
import com.haibei.pojo.sys.CodeExample;
import com.haibei.service.sys.CodeService;
import com.haibei.service.sys.SequenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CodeServiceImpl implements CodeService {
    @Autowired
    private CodeMapper codeMapper;
    @Autowired
    private SequenceService sequenceService;
    
    private Map<String, List<Code>> codes;

	/*
	 * �õ���̬code��
	 */
	public  Map<String, List<Code>> getCodes() {
		if (codes == null || codes.isEmpty()) {
			CodeExample codeExample = new CodeExample();
			codeExample.setOrderByClause(" code_name,code_parent_no,code_order");
			List<Code> sCodes = this.codeMapper.selectByExample(codeExample);
			if (codes == null) {
				codes = new HashMap<String, List<Code>>();
			}
			List<Code> tempCodes = new ArrayList<Code>();
			//String keyName;
			for (int i = 0; i < sCodes.size(); i++) {
				if (sCodes.get(i).getCodeParentNo().equals("0")) {
					tempCodes = new ArrayList<Code>();
					codes.put(sCodes.get(i).getCodeName(), tempCodes);
				} else {
					tempCodes.add(sCodes.get(i));
				}
			}
		}
		return codes;
	}
    
    public int countByExample(CodeExample example) {
        int count = this.codeMapper.countByExample(example);
        return count;
    }

    public Code selectByPrimaryKey(Integer codeId) {
        return this.codeMapper.selectByPrimaryKey(codeId);
    }

    public List<Code> selectByExample(CodeExample example) {
        return this.codeMapper.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer codeId) {
    	if(codes!=null){
    		codes.clear();
    	}
        return this.codeMapper.deleteByPrimaryKey(codeId);
    }

    public int updateByPrimaryKeySelective(Code record) {
    	if(codes!=null){
    		codes.clear();
    	}
        return this.codeMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Code record) {
    	if(codes!=null){
    		codes.clear();
    	}
        return this.codeMapper.updateByPrimaryKey(record);
    }

    public int deleteByExample(CodeExample example) {
    	if(codes!=null){
    		codes.clear();
    	}
        return this.codeMapper.deleteByExample(example);
    }

    public int updateByExampleSelective(Code record, CodeExample example) {
    	if(codes!=null){
    		codes.clear();
    	}
        return this.codeMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(Code record, CodeExample example) {
    	if(codes!=null){
    		codes.clear();
    	}
        return this.codeMapper.updateByExample(record, example);
    }

    public int insert(Code record) {
    	if(codes!=null){
    		codes.clear();
    	}
    	record.setCodeId(this.sequenceService.getSequences("SYS_CODE"));
        return this.codeMapper.insert(record);
    }

    public int insertSelective(Code record) {
    	//System.out.println(this.sequenceService.getSequences("SYS_CODE"));
    	if(codes!=null){
    		codes.clear();
    	}
    	record.setCodeId(this.sequenceService.getSequences("SYS_CODE"));
        return this.codeMapper.insertSelective(record);
    }
    //TODO
    public List<Code> selectCodeType(){
    	CodeExample example=new CodeExample();
    	example.createCriteria().andCodeParentNoEqualTo("0");
    	example.setOrderByClause("nlssort(code_describing,'NLS_SORT=SCHINESE_PINYIN_M')");
    	
    	
    	return this.selectByExample(example);
    }
    public List<Code> queryCodes(String codeName){
    	CodeExample example=new CodeExample();
    	example.createCriteria().andCodeNameEqualTo(codeName).andCodeParentNoNotEqualTo("0");
    	return this.selectByExample(example);
    	
    	
    };
}