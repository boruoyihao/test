package com.ketangpai.emailservice;

import com.aliyun.mqs.client.CloudQueue;
import com.aliyun.mqs.common.ServiceException;
import com.aliyun.mqs.model.Message;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 下午6:09:19
 * 
 */
public class MQSManagerImpl implements MQSManager {

	private CloudQueue cloudQueue = Singleton.getCloudQueue();

	public void pushMessage(String jsonstr, int priority) {
		try {
			Message message = new Message();
			message.setMessageBody(jsonstr);
			message.setPriority(priority); // 消息的优先级，优先级越高的消息，越容易更早被消费
			cloudQueue.putMessage(message);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
