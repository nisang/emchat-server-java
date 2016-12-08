package com.che.easemob.server.comm.utils;

import java.util.Random;

public class InviteCodeRule {
	
	
	/**
	 * 产生邀请码
	 * 
	 * code:1234567
	 * 第一位 0到9随机产生
	 *  中间五位 区系统时间的
	 * 第七位 code 随机产生
	 * @return
	 */
	public static String generate(){
		String str = ""+System.currentTimeMillis();
		String first = new Random().nextInt(10)+"";
		String end = new Random().nextInt(10)+"";
		String centry = str.substring(8);
		return first+centry+end;
	}
}
