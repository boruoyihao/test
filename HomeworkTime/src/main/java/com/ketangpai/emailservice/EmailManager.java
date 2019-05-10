package com.ketangpai.emailservice;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 下午9:34:21
 * 
 */
public interface EmailManager {

	public boolean sendMessage(String title, String receiver, String content);

}
