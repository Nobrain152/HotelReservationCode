package bl.userbl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/** 
 * 采用MD5加密
 * @author 
 */
public class MD5Util {
    /*** 
     * MD5加密 生成32位md5码
     * @param 待加密字符串
     * @return 返回32位md5码
     */
    public  String md5Encode(String inStr)  {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return "";
        }

        byte[] byteArray;
		try {
			byteArray = inStr.getBytes("UTF-8");
		    byte[] md5Bytes = md5.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
		    for (int i = 0; i < md5Bytes.length; i++) {
		        int val = ((int) md5Bytes[i]) & 0xff;
		        if (val < 16) {
		            hexValue.append("0");
		        }
		        hexValue.append(Integer.toHexString(val));
		    }
		    return hexValue.toString();  
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
       return null;
    }

    
}