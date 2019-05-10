package com.ketangpai.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ketangpai.dao.UnionDAO;
import com.ketangpai.model.Course;
import com.ketangpai.model.Member;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月3日 下午8:33:02
 * 
 */
@Service
public class UnionService {

	@Autowired
	private UnionDAO unionDAO;

	public List<String> getundoHomeworkList(Integer courseid, Integer homeworkid) {
		return unionDAO.getStudentEmailList(courseid, homeworkid);
	}

	public Integer getCourseStudentCount(Integer courseid) {
		return unionDAO.getCourseStudentCount(courseid);
	}

	public Integer getDoHomeworkCount(Integer homeworkid) {
		return unionDAO.getDoHomeworkCount(homeworkid);
	}

	public List<String> getTeacherEmailList(Integer courseid) {
		return unionDAO.getTeacherEmailList(courseid);
	}

	public List<Course> getWeekDynamicCourseInfo(Long starttime, Long endtime) {
		return unionDAO.getWeekDynamicCourseInfo(starttime, endtime);
	}

	public Integer getChooseCourseCount(Integer courseid) {
		return unionDAO.getChooseCourseCount(courseid);
	}

	public List<Member> getWeekDynamicAddInfo(Integer courseid, Long starttime,
			Long endtime) {
		return unionDAO.getWeekDynamicAddInfo(courseid, starttime, endtime);
	}

	public List<Member> getWeekDynamicDelInfo(Integer courseid, Long starttime,
			Long endtime) {
		return unionDAO.getWeekDynamicDelInfo(courseid, starttime, endtime);
	}

}
