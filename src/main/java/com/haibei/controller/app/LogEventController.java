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
import com.haibei.pojo.lock.LogEvent;
import com.haibei.pojo.lock.LogEventExample;
import com.haibei.pojo.lock.LogEventExample.Criteria;
import com.haibei.service.lock.LogEventService;

@Controller
@RequestMapping("/log")
public class LogEventController {

	@Resource
	private LogEventService logService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("log");
		return "/log/index";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		LogEventExample example = new LogEventExample();
		Criteria criteria = example.createCriteria();
		if (page.getConditions() != null) {
			if (page.getConditions().get("levelString") != null && !page.getConditions().get("levelString").equals("")) {
				criteria.andLevelStringEqualTo(page.getConditions().get("levelString").toString());
			}
			/*
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
			}*/
		}
		//page.setNumPerPage(10);
		page.setTotalCount(logService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", logService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(LogEvent app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", logService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(LogEvent app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", logService.insertSelective(app));
		
		return model;
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(LogEvent app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", logService.deleteByPrimaryKey(app.getEventId()));
		
		return model;
	}
	
}
