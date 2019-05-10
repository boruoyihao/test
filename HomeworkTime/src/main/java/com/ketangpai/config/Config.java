package com.ketangpai.config;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月10日 下午4:54:46 </br> MQS static data
 */
public class Config {

	private static String QueueOwnerId = "ebqvtuw9a1";

	private static String Region = "cn-hangzhou";

	private static String AccessKeyId = "4SdsFVptIKbbMSRn";

	private static String AccessKeySecret = "Z92w2AIgcksZLmwhmfYgyirrsSJGNH";

	private static String MyQueue = "ketangpai-email-mq";

	public static String getQueueOwnerId() {
		return QueueOwnerId;
	}

	public static void setQueueOwnerId(String queueOwnerId) {
		QueueOwnerId = queueOwnerId;
	}

	public static String getRegion() {
		return Region;
	}

	public static void setRegion(String region) {
		Region = region;
	}

	public static String getAccessKeyId() {
		return AccessKeyId;
	}

	public static void setAccessKeyId(String accessKeyId) {
		AccessKeyId = accessKeyId;
	}

	public static String getAccessKeySecret() {
		return AccessKeySecret;
	}

	public static void setAccessKeySecret(String accessKeySecret) {
		AccessKeySecret = accessKeySecret;
	}

	public static String getMyQueue() {
		return MyQueue;
	}

	public static void setMyQueue(String myQueue) {
		MyQueue = myQueue;
	}

}
