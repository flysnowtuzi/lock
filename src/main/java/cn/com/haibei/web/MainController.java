package cn.com.haibei.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.haibei.bean.Job;
import cn.com.haibei.bean.Lock;
import cn.com.haibei.bean.Water;
import cn.com.haibei.service.DaoDelegate;
import cn.com.haibei.service.JobService;
import cn.com.haibei.service.SocketServer;
import cn.com.haibei.tool.CoreException;

@Controller
public class MainController extends AbstractController {
	@Autowired
	private SocketServer ss;

	@Autowired
	private JobService job;
	@Autowired
	private DaoDelegate dao;

	@RequestMapping(value = "/index")
	public String indexHandler() {
		return "index";
	}
	
	@RequestMapping(value = "/system")
	public String system() {
		return "system";
	}

	@RequestMapping(value = "/log")
	public String logHandler() {
		return "log";
	}
	
	@RequestMapping(value = "/start")
	public String startServiceHandler(HttpServletRequest request, ModelMap model) {
		System.out.println("click start service");
		ss.StartService();
		model.put("msg", "服务启动");
		return "system";
	}

	@RequestMapping(value = "/stop")
	public String stopServcieHandler(HttpServletRequest request, ModelMap model) {
		ss.StopService();
		model.put("msg", "服务停止");
		return "system";
	}

	@RequestMapping(value = "openLock")
	public String openLockHandler(HttpServletRequest request, ModelMap model, @RequestParam(value = "lock_id", required = true) String lock_id,
			@RequestParam(value = "identify", required = true) String identify) {
		try {
			job.remoteOpenLock(lock_id, identify);
		} catch (CoreException e) {
			model.put("msg", e.getMessage());
			e.printStackTrace();
			return "redirect:/lock/getAllLock2";
		}
		model.put("msg", "Cmd running");
		return "redirect:/lock/getAllLock2";
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

	@RequestMapping(value = "/syncTime")
	public String syncTimeHandler(HttpServletRequest request, ModelMap model, @RequestParam(value = "lock_id", required = true) String lockId) {
		String seqno = "";
		Water w = null;
		try {
			seqno = job.setLockTime(lockId);
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
					return "redirect:/lock/getAllLock2";
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
		return "redirect:/lock/getAllLock2";
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
