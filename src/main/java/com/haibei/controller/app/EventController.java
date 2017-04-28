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
import com.haibei.pojo.lock.Event;
import com.haibei.pojo.lock.EventExample;
import com.haibei.pojo.lock.EventExample.Criteria;
import com.haibei.service.lock.EventService;

@Controller
@RequestMapping("/event")
public class EventController {

	@Resource
	private EventService eventService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("event");
		return "/event/index";
	}
	
	@RequestMapping(value = "/queryEvent", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> queryEvent() {
		Map<String, Object> rtn = new HashMap<String, Object>();
		rtn.put("statusCode", "200");
		rtn.put("message", "success");
		rtn.put("data", eventService.selectByExample(null));
		

		return rtn;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		EventExample example = new EventExample();
		Criteria criteria = example.createCriteria();
		/*if (page.getConditions() != null) {
			if (page.getConditions().get("appType") != null && !page.getConditions().get("appType").equals("")) {
				criteria.andAppTypeEqualTo(page.getConditions().get("appType").toString());
			}
			//isUseable
			if (page.getConditions().get("isUseable") != null && !page.getConditions().get("isUseable").equals("")) {
				criteria.andIsUseableEqualTo(page.getConditions().get("isUseable").toString());
			}
			if (page.getConditions().get("projectName") != null && !page.getConditions().get("projectName").equals("")) {
				criteria.andProjectNameLike("%"+page.getConditions().get("projectName").toString()+"%");
			}
		}*/
		//page.setNumPerPage(10);
		page.setTotalCount(eventService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", eventService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(Event app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", eventService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(Event app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", eventService.insertSelective(app));
		
		return model;
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(Event app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", eventService.deleteByPrimaryKey(app.getEventId()));
		
		return model;
	}
	
}
