package com.ketangpai.sendcloud;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月12日 下午12:17:22
 * 
 */
public class Singleton {

	private volatile static SendCloud sendCloudClient;

	private Singleton() {

	}

	public static SendCloud getSendCloudClient() {
		if (null == sendCloudClient) {
			synchronized (Singleton.class) {
				if (null == sendCloudClient) {
					sendCloudClient = new SendCloudImpl();
				}
			}
		}
		return sendCloudClient;
	}
}
