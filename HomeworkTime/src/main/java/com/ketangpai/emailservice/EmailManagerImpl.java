package com.ketangpai.emailservice;

import com.ketangpai.model.EmailRecord;
import com.ketangpai.service.EmailRecordService;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 下午9:36:10
 * 
 */
public class EmailManagerImpl implements EmailManager {

	private EmailRecordService emailRecordService;

	private MQSManager mqsManager;

	private static int priority = 8;

	public static void setPriority(int priority) {
		EmailManagerImpl.priority = priority;
	}

	public EmailManagerImpl() {

	}

	public EmailManagerImpl(EmailRecordService emailRecordService,
			MQSManager mqsManager, int priority) {
		this.emailRecordService = emailRecordService;
		this.mqsManager = mqsManager;
		this.priority = priority;
	}

	public String getEmailMessage(String title, String receiver, String content) {
		EmailRecord emailrecord = new EmailRecord();
		emailrecord.setTitle(title);
		emailrecord.setReceiver(receiver);
		emailrecord.setContent(content);
		emailrecord.setCreatetime((int) (System.currentTimeMillis() / 1000));
		emailrecord.setUpdatetime((int) (System.currentTimeMillis() / 1000));
		emailrecord.setStatus(0);
		int result = emailRecordService.addEmailRecord(emailrecord);
		emailrecord.setId(result);
		return emailrecord.getObjectJSON();

	}

	@Override
	public boolean sendMessage(String title, String receiver, String content) {
		boolean result = true;
		try {
			String message = getEmailMessage(title, receiver, content);
			mqsManager.pushMessage(message, priority);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

}
