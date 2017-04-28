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
import com.haibei.pojo.lock.Water;
import com.haibei.pojo.lock.WaterExample;
import com.haibei.pojo.lock.WaterExample.Criteria;
import com.haibei.service.lock.WaterService;

@Controller
@RequestMapping("/water")
public class WaterController {

	@Resource
	private WaterService waterService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("water");
		return "/water/index";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		WaterExample example = new WaterExample();
		Criteria criteria = example.createCriteria();
		if (page.getConditions() != null) {
			/*if (page.getConditions().get("seqNo") != null && !page.getConditions().get("seqNo").equals("")) {
				criteria.andSeqNoEqualTo(page.getConditions().get("seqNo").toString());
			}*/
			if (page.getConditions().get("devId") != null && !page.getConditions().get("devId").equals("")) {
				criteria.andDevIdEqualTo(page.getConditions().get("devId").toString());
			}
			if (page.getConditions().get("eventId") != null && !page.getConditions().get("eventId").equals("")) {
				criteria.andEventIdEqualTo(Short.parseShort(page.getConditions().get("eventId").toString()));
			}
			if (page.getConditions().get("lockId") != null && !page.getConditions().get("lockId").equals("")) {
				criteria.andLockIdEqualTo(page.getConditions().get("lockId").toString());
			}
			if (page.getConditions().get("userName") != null && !page.getConditions().get("userName").equals("")) {
				criteria.andUserNameLike("%" +page.getConditions().get("userName").toString()+"%");
			}
		}
		//page.setNumPerPage(10);
		page.setTotalCount(waterService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", waterService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(Water app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", waterService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(Water app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", waterService.insertSelective(app));
		
		return model;
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(Water app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", waterService.deleteByPrimaryKey(app.getSeqNo()));
		
		return model;
	}
	
}
