package cn.com.haibei.web;

import java.text.SimpleDateFormat;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AbstractController {
	protected List<Map<String, String>> SYS = null;
	protected SimpleDateFormat sdf = null;
	protected final String WeiXin_ID = "gh_e42dbf95f4f8";

	protected String getParameterMap(HttpServletRequest request) {
		String params = "";
		Enumeration<String> pNames = request.getParameterNames();
		while (pNames.hasMoreElements()) {
			String name = (String) pNames.nextElement();
			String value = request.getParameter(name);
			if (!name.equals("passwd"))
				params += name + "=" + value + ";";
		}
		return params;
	}
}
