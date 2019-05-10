package com.ketangpai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ketangpai.dao.HomeworkDAO;
import com.ketangpai.model.Homework;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月3日 下午3:45:40
 * 
 */
@Service
public class HomeworkService {

	@Autowired
	private HomeworkDAO homeworkDAO;

	public List<Homework> queryHomeworkList(Long starttime, Long endtime) {
		return homeworkDAO.queryHomeworkList(starttime, endtime);
	}

}
