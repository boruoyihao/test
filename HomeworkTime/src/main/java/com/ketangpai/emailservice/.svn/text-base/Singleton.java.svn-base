package com.ketangpai.emailservice;

import com.aliyun.mqs.client.CloudQueue;
import com.aliyun.mqs.client.DefaultMQSClient;
import com.aliyun.mqs.client.MQSClient;
import com.ketangpai.model.MQS;
import com.ketangpai.config.Config;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 下午4:16:46
 * 
 */
public class Singleton {

	private static MQS mqs = new MQS();

	private static final String mqsurl = "http://%s.mqs-%s.aliyuncs.com";

	private static CloudQueue cloudQueue = null;

	static {
		mqs.setQueueOwnerId(Config.getQueueOwnerId());
		mqs.setRegion(Config.getRegion());
		mqs.setAccessKeyId(Config.getAccessKeyId());
		mqs.setAccessKeySecret(Config.getAccessKeySecret());
		mqs.setMyQueue(Config.getMyQueue());
	}

	/**
	 * using the message queue of alibaba
	 */

	private Singleton() {

	}

	public static CloudQueue getCloudQueue() {
		if (null == cloudQueue) {
			synchronized (Singleton.class) {
				if (null == cloudQueue) {
					MQSClient client = new DefaultMQSClient(String.format(
							mqsurl, mqs.getQueueOwnerId(), mqs.getRegion()),
							mqs.getAccessKeyId(), mqs.getAccessKeySecret());
					cloudQueue = client.getQueueRef(mqs.getMyQueue());
				}
			}
		}

		return cloudQueue;
	}
}
