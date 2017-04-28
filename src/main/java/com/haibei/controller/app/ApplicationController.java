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
import com.haibei.pojo.application.ApplicationExample;
import com.haibei.pojo.application.ApplicationExample.Criteria;
import com.haibei.service.application.ApplicationService;



@Controller
@RequestMapping("/application")
public class ApplicationController {
	@Resource
	ApplicationService applicationService;
//	@InitBinder
//	public void init(WebDataBinder binder) {
//
//	binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
//
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("application");
		return "/application/index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		ApplicationExample example = new ApplicationExample();
		Criteria criteria = example.createCriteria();
		if (page.getConditions() != null) {
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
		}
		//page.setNumPerPage(10);
		page.setTotalCount(applicationService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", applicationService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(Application app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", applicationService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(Application app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", applicationService.insertSelective(app));
		
		return model;
	}
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(Application app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", applicationService.deleteByPrimaryKey(app.getWid()));
		
		return model;
	}
}
