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
import com.haibei.pojo.lock.LockUser;
import com.haibei.pojo.lock.LockUserExample;
import com.haibei.pojo.lock.LockUserExample.Criteria;
import com.haibei.pojo.lock.LockUserKey;
import com.haibei.service.lock.LockUserService;

@Controller
@RequestMapping("/lockUser")
public class LockUserController {

	@Resource
	private LockUserService lockUserService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		System.out.println("lockUser");
		return "/lockUser/index";
	}
	@RequestMapping(value = "/list", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> list(@ModelAttribute("page") Page page) {
		Map<String, Object> model=new HashMap<String,Object>();
		// List<XQ> xqList=xQservice.selectByExample(null);
		LockUserExample example = new LockUserExample();
		Criteria criteria = example.createCriteria();
		if (page.getConditions() != null) {
			if (page.getConditions().get("lockId") != null && !page.getConditions().get("lockId").equals("")) {
				criteria.andLockIdEqualTo(page.getConditions().get("lockId").toString());
			}
			if (page.getConditions().get("userName") != null && !page.getConditions().get("userName").equals("")) {
				criteria.andUserNameLike("%" +page.getConditions().get("userName").toString()+"%");
			}
			if (page.getConditions().get("userId") != null && !page.getConditions().get("userId").equals("")) {
				criteria.andUserIdEqualTo(page.getConditions().get("userId").toString());
			}
		}
		//page.setNumPerPage(10);
		page.setTotalCount(lockUserService.countByExample(example));
		example.setRowsPerPage(page.getNumPerPage());
		example.setLimitStart((page.getPageNum() - 1) * page.getNumPerPage());
		
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", lockUserService.selectByExample(example));
		System.out.println(page.getPageNum());
		model.put("page", page);

		return model;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> update(LockUser app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", lockUserService.updateByPrimaryKeySelective(app));
		
		return model;
	}
	@RequestMapping(value = "/add", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> insert(LockUser app) {
		Map<String, Object> model=new HashMap<String,Object>();
	
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", lockUserService.insertSelective(app));
		
		return model;
	}
	
	@RequestMapping(value = "/del", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> del(LockUser app) {
		Map<String, Object> model=new HashMap<String,Object>();
		LockUserKey key = new LockUserKey();
		key.setLockId(app.getLockId());
		key.setCardPhyid(app.getCardPhyid());
		key.setOpenType(app.getOpenType());
		key.setUserId(app.getUserId());
		model.put("statusCode", "200");
		model.put("message", "success");
		model.put("data", lockUserService.deleteByPrimaryKey(key));
		
		return model;
	}
	
}
