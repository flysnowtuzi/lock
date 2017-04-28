package cn.com.haibei.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.haibei.bean.Device;
import cn.com.haibei.service.DaoDelegate;
import cn.com.haibei.tool.TokenTools;

@RestController
public class InterfaceController extends AbstractController {

	@Autowired
	private DaoDelegate dao;

	@RequestMapping(value = "/000000", method = RequestMethod.GET, headers = "Accept=application/json")
	public Map<String, Object> getDeviceList(@RequestParam(value = "sysid", required = false) String sysid,
			@RequestParam(value = "stamp", required = false) String stamp, @RequestParam(value = "token", required = true) String token) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		List<Device> device = dao.queryDevice();
		rtn.put("code", 0);
		rtn.put("cnt", device.size());
		rtn.put("data", device);
		String[] param = { sysid, stamp };
		Map<String, Object> r = TokenTools.checkSHA1Token(SYS, sysid, param, Long.parseLong(stamp), token);
		if ((Integer) r.get("code") != 0) {
			rtn.put("code", r.get("code"));
			rtn.put("msg", r.get("msg"));
			return rtn;
		}
		return rtn;
	}
}
