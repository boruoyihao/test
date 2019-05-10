package com.ketangpai.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月3日 上午11:25:34
 * 
 */
public class TimeTask {

	private static final Logger logger = LoggerFactory
			.getLogger(TimeTask.class);

	@Autowired
	private TaskManager taskManager;

	public void serveralMinutesJob() {
		logger.debug("serveralMinutes Job");
		taskManager.serveralMinutesTask();
	}

	// weekly dynamic infomation task for teacher
	public void getWeeklyDynamicInfo() {
		logger.debug("weekly dynamic infomation task for teacher");
		taskManager.weekDynamicTask();
	}

}
