package com.haibei.controller.app;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haibei.core.Page;
import com.haibei.pojo.application.Application;
import com.haibei.pojo.lock.Cmd;
import com.haibei.pojo.lock.CmdExample;
import com.haibei.pojo.lock.CmdExample.Criteria;
import com.haibei.service.lock.CmdService;

@Controller
@RequestMapping("/cmd")
public class CmdController {

	@Resource
	private CmdService cmdService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("cmd");
		return "/cmd/index";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		CmdExample example = new CmdExample();
		Criteria criteria = example.createCriteria();
		if (page.getConditions() != null) {
			if (page.getConditions().get("seqNo") != null && !page.getConditions().get("seqNo").equals("")) {
				criteria.andSeqNoLike("%"+page.getConditions().get("seqNo").toString()+"%");
			}
			if (page.getConditions().get("devId") != null && !page.getConditions().get("devId").equals("")) {
				criteria.andDevIdEqualTo(page.getConditions().get("devId").toString());
			}
			if (page.getConditions().get("eventId") != null && !page.getConditions().get("eventId").equals("")) {
				criteria.andEventIdEqualTo(Short.parseShort(page.getConditions().get("eventId").toString()));
			}
			if (page.getConditions().get("lockId") != null && !page.getConditions().get("lockId").equals("")) {
				criteria.andLockIdEqualTo(page.getConditions().get("lockId").toString());
			}
			if (page.getConditions().get("startDate") != null && !page.getConditions().get("startDate").equals("")) {
				criteria.andTimeCreateGreaterThan(page.getConditions().get("startDate").toString());
			}
			if (page.getConditions().get("endDate") != null && !page.getConditions().get("endDate").equals("")) {
				criteria.andTimeCreateLessThanOrEqualTo(page.getConditions().get("endDate").toString());
			}
		}
		//page.setNumPerPage(10);
		page.setTotalCount(cmdService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", cmdService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(Cmd app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", cmdService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(Cmd app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", cmdService.insertSelective(app));
		
		return model;
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(Cmd app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", cmdService.deleteByPrimaryKey(app.getSeqNo()));
		
		return model;
	}
	
}
