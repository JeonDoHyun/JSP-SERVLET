package util;

import java.security.MessageDigest;

public class SHA256 {

	// SH1-256 해싱 알고리즘 사용법 :https://needjarvis.tistory.com/251
	public static String getSHA256(String input) {
		StringBuffer result = new StringBuffer();
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] salt = "Hello! This is Salt.".getBytes(); // salt 는 단순히 sha-256 적용하면 해커에게 해킹 당할수잇음을 방지하기위함
			digest.reset();
			digest.update(salt);
			byte[] chars = digest.digest(input.getBytes("UTF-8"));
			for (int i = 0; i < chars.length; i++) {
				String hex = Integer.toHexString(0xff & chars[i]);
				if (hex.length() == 1)
					result.append("0");
				result.append(hex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result.toString();
	}

}
