package com.haibei.controller.app;


import java.util.HashMap;
import java.util.List;



import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.bean.Water;
import cn.com.haibei.service.DaoDelegate;
import cn.com.haibei.service.JobService;
import cn.com.haibei.service.SocketServer;
import cn.com.haibei.tool.CoreException;



@Controller
@RequestMapping("/")
public class MainController
{
	@Autowired
	private SocketServer ss;

	@Autowired
	private JobService job;
	@Autowired
	private DaoDelegate dao;
	
  @RequestMapping(value="/main",method=RequestMethod.GET)

  public String  main()
  { 

	  System.out.println("main");
	  return "/sys/main";
  }
  
  @RequestMapping(value="/menu",method=RequestMethod.GET)
  public String  menu()
  {   
	  System.out.println("menu");
	  return "sys/leftMenu";
  }
  
	@RequestMapping(value = "/log")
	public String logHandler() {
		return "log/log";
	}
  
	@RequestMapping(value = "/system")
	public String system() {
		return "system/system";
	}
	
	@RequestMapping(value = "/start")
	public String startServiceHandler(HttpServletRequest request, ModelMap model) {
		System.out.println("click start service");
		ss.StartService();
		model.put("msg", "服务启动");
		model.put("statusCode", "200");
		return "system/system";
	}

	@RequestMapping(value = "/stop")
	public String stopServcieHandler(HttpServletRequest request, ModelMap model) {
		ss.StopService();
		model.put("msg", "服务停止");
		model.put("statusCode", "200");
		return "system/system";
	}

	@RequestMapping(value = "openLock", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> openLockHandler(Lock lock) {
		Map<String, Object> model=new HashMap<String,Object>();
		String identify = "c62d1d25";
		try {
			job.remoteOpenLock(lock.getLockId(), identify);
			model.put("statusCode", "200");
		} catch (CoreException e) {
			model.put("msg", e.getMessage());
			model.put("statusCode", "500");
			e.printStackTrace();
			return model;
		}
		model.put("msg", "Cmd running");
		return model;
	}
	@RequestMapping(value = "/syncTime", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public Map<String, Object> syncTimeHandler(Lock lock) {
		Map<String, Object> model=new HashMap<String,Object>();
		//String identify = "c62d1d25";
		String seqno = "";
		Water w = null;
		try {
			seqno = job.setLockTime(lock.getLockId());
			model.put("statusCode", "200");
		} catch (CoreException e) {
			model.put("statusCode", "500");
			e.printStackTrace();
			return model;
		}
		for (int i = 0; i < 3; i++) {
			try {
				w = job.getDao().queryWaterByCmdNo(seqno);
				if (null != w) {
					model.put("msg", w.getRtnJson());
					return model;
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		
		model.put("statusCode", "500");
		return model;
	}
	@RequestMapping(value = "/addUser")
	public String addUserHandler(HttpServletRequest request, ModelMap model, @RequestParam(value = "lock_id", required = true) String lockId,
			@RequestParam(value = "identify", required = true) String identify, @RequestParam(value = "type", required = true) int type) {
		String seqno = "";
		Water w = null;
		try {
			seqno = job.addLockUser(lockId, identify, type);
		} catch (CoreException e) {
			model.put("statusCode", "417");
			model.put("msg", e.getMessage());
			//e.printStackTrace();
			return "lockUser/saveUser";
		}
		for (int i = 0; i < 3; i++) {
			try {
				w = job.getDao().queryWaterByCmdNo(seqno);
				if (null != w) {
					model.put("statusCode", "200");
					model.put("msg", "保存成功");
					return "lockUser/saveUser";
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		model.put("statusCode", "417");
		model.put("msg", "执行失败");
		return "lockUser/saveUser";
	}

	@RequestMapping(value = "/delUser")
	public String delUserHandler(HttpServletRequest request, ModelMap model, @RequestParam(value = "lock_id", required = true) String lock_id,
			@RequestParam(value = "identify", required = true) String identify, @RequestParam(value = "type", required = true) int type) {
		String seqno = "";
		Water w = null;
		try {
			seqno = job.removeLockUser(lock_id, identify, type);
		} catch (CoreException e) {
			model.put("msg", e.getMessage());
			e.printStackTrace();
			return "index";
		}

		for (int i = 0; i < 3; i++) {
			try {
				w = job.getDao().queryWaterByCmdNo(seqno);
				if (null != w) {
					model.put("msg", w.getRtnJson());
					return "index";
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		model.put("msg", "执行失败");
		return "index";
	}

	@RequestMapping(value = "/getTime")
	public String getTimeHandler(HttpServletRequest request, ModelMap model, @RequestParam(value = "lock_id", required = true) String lockId) {
		String seqno = "";
		Water w = null;
		try {
			seqno = job.getLockTime(lockId);
		} catch (CoreException e) {
			model.put("msg", e.getMessage());
			e.printStackTrace();
			return "index";
		}
		for (int i = 0; i < 3; i++) {
			try {
				w = job.getDao().queryWaterByCmdNo(seqno);
				if (null != w) {
					model.put("msg", w.getRtnJson());
					return "index";
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		model.put("msg", "执行失败");
		return "index";
	}

	

	@RequestMapping(value = "/sync")
	public String syncHandler(HttpServletRequest request, ModelMap model) {
		List<Job> l = job.getJob();
		for (Job j : l) {
			if (!j.getDev().isOnline())
				continue;
			List<Lock> lock = dao.queryLockByDevId(j.getDev().getDevId());
			if (lock.size() == 0)
				continue;
			job.setLockTime(lock.get(0).getLockId());
		}
		model.put("msg", "服务启动");
		return "system";
	}
}
