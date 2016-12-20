package user;

import static org.junit.Assert.assertEquals;

import bl.userbl.MD5Util;

public class Testmd {

	
	
	public static void main(String[] args) {
		String s1="12345679";
		String s2="66666666";
		String s3="88888888";
		String s4="cc151250005";
		String s5="CC15ruanjian";
		MD5Util md=new MD5Util();
		String s6=md.md5Encode(s1);
		String s7=md.md5Encode(s2);
		String s8=md.md5Encode(s3);
		String s9=md.md5Encode(s4);
		String s10=md.md5Encode(s5);
		System.out.println(s6);

	}

}
