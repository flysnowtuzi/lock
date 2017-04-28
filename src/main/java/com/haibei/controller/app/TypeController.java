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
import com.haibei.pojo.lock.Type;
import com.haibei.pojo.lock.TypeExample;
import com.haibei.pojo.lock.TypeExample.Criteria;
import com.haibei.service.lock.TypeService;

@Controller
@RequestMapping("/type")
public class TypeController {

	@Resource
	private TypeService typeService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("type");
		return "/type/index";
	}
	
	@RequestMapping(value = "/queryType", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> queryType() {
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
		rtn.put("data", typeService.selectByExample(null));
		

		return rtn;
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		TypeExample example = new TypeExample();
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
		page.setTotalCount(typeService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", typeService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(Type app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", typeService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(Type app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", typeService.insertSelective(app));
		
		return model;
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(Type app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", typeService.deleteByPrimaryKey(app.getDevType()));
		
		return model;
	}
	
}
