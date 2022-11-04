package steammend.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/** 문자열을 MD5 checksum으로 변환하는 class
 * 
 * @author oz
 *
 */
public class MD5Generator {
	
	private String result;
	
<<<<<<< HEAD
	public MD5Generator(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException {
=======
	public MD5Generator(String input) throws UnsupportedEncodingException, NoSuchAlgorithmException{
>>>>>>> 64b5a69883bf581dea0840e8525d2b9d76f387d8
		MessageDigest mdMD5 = MessageDigest.getInstance("MD5");
		mdMD5.update(input.getBytes("UTF-8"));
		
		byte[] md5Hash = mdMD5.digest();
		
		StringBuilder hexMD5hash = new StringBuilder();
		for(byte b : md5Hash) {
			String hexString = String.format("%02x", b);
			hexMD5hash.append(hexString);
		}
		result = hexMD5hash.toString();
	}
	
	public String toString() {
		return result;
	}
}
