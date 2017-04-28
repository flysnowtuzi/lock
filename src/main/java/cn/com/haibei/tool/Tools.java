/**
 * @author gaol
 *
 */
package cn.com.haibei.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang.ArrayUtils;

public class Tools {

	public static String byte2HexString(byte b) {
		String hex = Integer.toHexString(b & 0xFF);
		if (hex.length() == 1)
			hex = '0' + hex;
		return hex;
	}

	public static String byte2HexString(byte[] b) {
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1)
				hex = '0' + hex;
			bf.append(hex);
		}
		return bf.toString();
	}

	public static byte[] hexString2Bytes(String src) {
		int l = src.length() / 2;
		byte[] ret = new byte[l];
		for (int i = 0; i < l; i++) {
			ret[i] = (byte) Integer.valueOf(src.substring(i * 2, i * 2 + 2), 16).byteValue();
		}
		return ret;
	}

	public static String[] hexString2Array(String src) {
		int l = src.length() / 2;
		String[] ret = new String[l];
		for (int i = 0; i < l; i++) {
			ret[i] = src.substring(i * 2, i * 2 + 2);
		}
		return ret;
	}

	public static String hexStringArray2String(String[] src, boolean reverse) {
		if (reverse)
			ArrayUtils.reverse(src);
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < src.length; i++)
			bf.append(src[i]);
		return bf.toString();
	}

	public static String getIp(String ip) {
		return ip.substring(ip.indexOf("/") + 1, ip.indexOf(":"));
	}

	// AESECB128加密
	public static String encrypt(String sSrc, String sKey) throws Exception {
		byte[] raw = hexString2Bytes(sKey);
		SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");// "算法/模式/补码方式"
		cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
		byte[] b = hexString2Bytes(sSrc);
		byte[] b1 = ArrayUtils.subarray(b, 0, 16);
		byte[] b2 = ArrayUtils.subarray(b, 16, 32);
		byte[] encrypted1 = cipher.doFinal(b1);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < encrypted1.length; i++) {
			sb.append(byte2HexString(encrypted1[i]));
		}
		byte[] encrypted2 = cipher.doFinal(b2);
		for (int i = 0; i < encrypted2.length; i++)
			sb.append(byte2HexString(encrypted2[i]));

		return sb.toString();

	}

	// AESECB128解密
	public static String decrypt(String sSrc, String sKey) throws Exception {
		StringBuffer sb = new StringBuffer();
		try {
			byte[] raw = hexString2Bytes(sKey);
			;
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);

			byte[] encrypted = hexString2Bytes(sSrc);

			try {
				byte[] original = cipher.doFinal(encrypted);
				for (int i = 0; i < original.length; i++)
					sb.append(byte2HexString(original[i]));
			} catch (Exception e) {
				System.out.println(e.toString());
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return sb.toString();
	}

	public static String getTimeHex() {
		SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd-HH-mm-ss");
		String s = sdf.format(new Date());
		// System.out.println(s);
		String[] ss = s.split("-");
		int[] d = new int[ss.length + 1];
		String[] sss = new String[d.length];
		d[0] = 20;
		for (int i = 0; i < ss.length; i++) {
			d[i + 1] = Integer.parseInt(ss[i]);
		}
		for (int i = 0; i < d.length; i++) {
			sss[i] = Integer.toHexString(d[i]);
			if (sss[i].length() == 1)
				sss[i] = '0' + sss[i];
		}
		StringBuffer bf = new StringBuffer();
		for (int i = 0; i < sss.length; i++) {
			bf.append(sss[i]);
		}
		// System.out.println(bf.toString());
		return bf.toString();
	}

	public static String getTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
		return sdf.format(new Date());
	}

	public static byte calcCrc8(byte[] data) {
		return calcCrc8(data, 0, data.length, (byte) 0);
	}

	private static byte calcCrc8(byte[] data, int offset, int len, byte preval) {
		byte ret = preval;
		for (int i = offset; i < (offset + len); ++i) {
			ret = crc8_tab[(0x00ff & (ret ^ data[i]))];
		}
		return ret;
	}

	static byte[] crc8_tab = { (byte) 0, (byte) 94, (byte) 188, (byte) 226, (byte) 97, (byte) 63, (byte) 221, (byte) 131, (byte) 194, (byte) 156,
			(byte) 126, (byte) 32, (byte) 163, (byte) 253, (byte) 31, (byte) 65, (byte) 157, (byte) 195, (byte) 33, (byte) 127, (byte) 252,
			(byte) 162, (byte) 64, (byte) 30, (byte) 95, (byte) 1, (byte) 227, (byte) 189, (byte) 62, (byte) 96, (byte) 130, (byte) 220, (byte) 35,
			(byte) 125, (byte) 159, (byte) 193, (byte) 66, (byte) 28, (byte) 254, (byte) 160, (byte) 225, (byte) 191, (byte) 93, (byte) 3,
			(byte) 128, (byte) 222, (byte) 60, (byte) 98, (byte) 190, (byte) 224, (byte) 2, (byte) 92, (byte) 223, (byte) 129, (byte) 99, (byte) 61,
			(byte) 124, (byte) 34, (byte) 192, (byte) 158, (byte) 29, (byte) 67, (byte) 161, (byte) 255, (byte) 70, (byte) 24, (byte) 250,
			(byte) 164, (byte) 39, (byte) 121, (byte) 155, (byte) 197, (byte) 132, (byte) 218, (byte) 56, (byte) 102, (byte) 229, (byte) 187,
			(byte) 89, (byte) 7, (byte) 219, (byte) 133, (byte) 103, (byte) 57, (byte) 186, (byte) 228, (byte) 6, (byte) 88, (byte) 25, (byte) 71,
			(byte) 165, (byte) 251, (byte) 120, (byte) 38, (byte) 196, (byte) 154, (byte) 101, (byte) 59, (byte) 217, (byte) 135, (byte) 4,
			(byte) 90, (byte) 184, (byte) 230, (byte) 167, (byte) 249, (byte) 27, (byte) 69, (byte) 198, (byte) 152, (byte) 122, (byte) 36,
			(byte) 248, (byte) 166, (byte) 68, (byte) 26, (byte) 153, (byte) 199, (byte) 37, (byte) 123, (byte) 58, (byte) 100, (byte) 134,
			(byte) 216, (byte) 91, (byte) 5, (byte) 231, (byte) 185, (byte) 140, (byte) 210, (byte) 48, (byte) 110, (byte) 237, (byte) 179,
			(byte) 81, (byte) 15, (byte) 78, (byte) 16, (byte) 242, (byte) 172, (byte) 47, (byte) 113, (byte) 147, (byte) 205, (byte) 17, (byte) 79,
			(byte) 173, (byte) 243, (byte) 112, (byte) 46, (byte) 204, (byte) 146, (byte) 211, (byte) 141, (byte) 111, (byte) 49, (byte) 178,
			(byte) 236, (byte) 14, (byte) 80, (byte) 175, (byte) 241, (byte) 19, (byte) 77, (byte) 206, (byte) 144, (byte) 114, (byte) 44,
			(byte) 109, (byte) 51, (byte) 209, (byte) 143, (byte) 12, (byte) 82, (byte) 176, (byte) 238, (byte) 50, (byte) 108, (byte) 142,
			(byte) 208, (byte) 83, (byte) 13, (byte) 239, (byte) 177, (byte) 240, (byte) 174, (byte) 76, (byte) 18, (byte) 145, (byte) 207,
			(byte) 45, (byte) 115, (byte) 202, (byte) 148, (byte) 118, (byte) 40, (byte) 171, (byte) 245, (byte) 23, (byte) 73, (byte) 8, (byte) 86,
			(byte) 180, (byte) 234, (byte) 105, (byte) 55, (byte) 213, (byte) 139, (byte) 87, (byte) 9, (byte) 235, (byte) 181, (byte) 54,
			(byte) 104, (byte) 138, (byte) 212, (byte) 149, (byte) 203, (byte) 41, (byte) 119, (byte) 244, (byte) 170, (byte) 72, (byte) 22,
			(byte) 233, (byte) 183, (byte) 85, (byte) 11, (byte) 136, (byte) 214, (byte) 52, (byte) 106, (byte) 43, (byte) 117, (byte) 151,
			(byte) 201, (byte) 74, (byte) 20, (byte) 246, (byte) 168, (byte) 116, (byte) 42, (byte) 200, (byte) 150, (byte) 21, (byte) 75,
			(byte) 169, (byte) 247, (byte) 182, (byte) 232, (byte) 10, (byte) 84, (byte) 215, (byte) 137, (byte) 107, 53 };
}