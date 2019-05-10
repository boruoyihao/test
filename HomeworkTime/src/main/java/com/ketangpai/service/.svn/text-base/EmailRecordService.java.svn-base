package com.ketangpai.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ketangpai.dao.EmailRecordDAO;
import com.ketangpai.model.EmailRecord;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 上午11:20:44
 * @function service层调用DAO层，记录要发送的邮件并返回ID
 */
@Service
public class EmailRecordService {

	@Autowired
	private EmailRecordDAO emailRecordDAO;

	public int addEmailRecord(EmailRecord emailrecord) {
		return emailRecordDAO.addEmailRecord(emailrecord);
	}

}
