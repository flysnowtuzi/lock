package cn.com.haibei.tool;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TokenTools {

	public static String createMD5Token(String[] values) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		StringBuffer buf = new StringBuffer(512);
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			if (value == null) {
				continue;
			}
			buf.append(value);
		}
		byte[] bufTemp = buf.toString().getBytes("UTF-8");
		MessageDigest mdTemp = MessageDigest.getInstance("MD5");
		mdTemp.update(bufTemp);
		byte[] md5Result = mdTemp.digest();
		return byte2String(md5Result);
	}

	public static String createMD5Token(String first, String cert, String[] values) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		StringBuffer buf = new StringBuffer(512);
		for (int i = 0; i < values.length; i++) {
			buf.append(first);
			String value = values[i];
			if (value == null) {
				continue;
			}
			buf.append(value);
		}
		buf.append(cert);

		byte[] bufTemp = buf.toString().getBytes("UTF-8");
		MessageDigest mdTemp = MessageDigest.getInstance("MD5");
		mdTemp.update(bufTemp);
		byte[] md5Result = mdTemp.digest();
		return byte2String(md5Result);
	}

	public static String byte2String(byte[] buf) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			if ((buf[i] & 0xff) < 0x10) {
				result.append('0');
			}
			result.append((Integer.toHexString(buf[i] & 0xff)));
		}
		return result.toString();
	}

	public static String genSHA1Token(String[] values, String cert) {
		Arrays.sort(values);
		StringBuffer buf = new StringBuffer(512);
		for (int i = 0; i < values.length; i++) {
			String value = values[i];
			if (value == null) {
				continue;
			}
			buf.append(value);
		}
		buf.append(cert);
		//System.out.println(buf.toString());
		byte[] bufTemp = null;
		try {
			bufTemp = buf.toString().getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		MessageDigest mdTemp = null;
		try {
			mdTemp = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		mdTemp.update(bufTemp);
		byte[] sha1Result = mdTemp.digest();
		return byte2String(sha1Result);
	}

	public static Map<String, String> getSYS(List<Map<String, String>> sys, String sysid) {
		for (int i = 0; i < sys.size(); i++) {
			if (sys.get(i).get("sysid").equals(sysid))
				return sys.get(i);
		}
		return null;
	}

	public static Map<String, Object> checkSHA1Token(List<Map<String, String>> sys, String sysid, String[] param, Long stamp, String token) {
		Map<String, Object> rtn = new HashMap<String, Object>();
		Long d = (System.currentTimeMillis() - stamp) / (1000 * 60);
		// 签名10分钟内有效
		if (d > 10) {
			rtn.put("code", 6);
			rtn.put("msg", "签名失效");
			return rtn;
		}

		Map<String, String> s = getSYS(sys, sysid);
		if (null == s) {
			rtn.put("code", 3);
			rtn.put("msg", "系统编号(SYSID)错误");
			return rtn;
		}
		if (!s.get("status").equals("0")) {
			rtn.put("code", 4);
			rtn.put("msg", "证书已停用");
			return rtn;
		}
		for (int i = 0; i < param.length; i++)
			System.out.println(param[i]);
		String t = TokenTools.genSHA1Token(param, s.get("cert"));
		System.out.println("compute token:" + t);
		System.out.println("url token:" + token);
		if (!t.equals(token)) {
			rtn.put("code", 5);
			rtn.put("msg", "系统签名不符");
			return rtn;
		}
		rtn.put("code", 0);
		return rtn;
	}
}
