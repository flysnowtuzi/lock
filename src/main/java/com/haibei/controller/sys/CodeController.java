package com.haibei.controller.sys;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haibei.service.sys.CodeService;

@Controller
@RequestMapping("/sys")
public class CodeController {
	@Resource
	CodeService codeService;
	

	/*
	 * function:查询校区 param:sysId param:stamp param:token param:xqNo 校区编号
	 */
	@RequestMapping(value = "/queryCode", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> queryCode(@RequestParam(value = "codeName", required = true) String codeName) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		// 以下代码用拦截器实现
		/*
		 * String[] param = { sysId, xqNo.toString(), stamp }; Map<String,
		 * Object> c = TokenTools.checkSHA1Token(SYS, sysId, param,
		 * Long.parseLong(stamp), token); if ((Integer) c.get("statusCode") !=
		 * 0) { rtn.put("statusCode", c.get("statusCode")); rtn.put("message",
		 * c.get("message")); return rtn; }
		 */
		rtn.put("statusCode", "200");
		rtn.put("message", "success");
		rtn.put("data", codeService.queryCodes(codeName));
		

		return rtn;
	}

	
}
