package com.ketangpai.sendcloud;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月12日 上午11:32:24
 * 
 */
public interface SendCloud {

	boolean postMail(String title, String content, String receiver);

}
