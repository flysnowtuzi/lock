package com.haibei.util.token;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class SignToken {
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
		// System.out.println(buf.toString());
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

	
}
