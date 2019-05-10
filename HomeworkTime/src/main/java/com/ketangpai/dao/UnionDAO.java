package com.ketangpai.dao;

import java.util.List;

import com.ketangpai.model.Course;
import com.ketangpai.model.Member;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月3日 下午7:58:40
 * 
 */
@DAO(catalog = "ketangpaimail.master")
public interface UnionDAO {

	@SQL("select email from iyinsitan_ucenter_member where status=1 and id in ( select uid from iyinsitan_mycourse where courseid=:courseid and status=0 and uid not in(select uid from iyinsitan_myhomework where homeworkid=:homeworkid and status=0)) order by id")
	public List<String> getStudentEmailList(
			@SQLParam("courseid") Integer courseid,
			@SQLParam("homeworkid") Integer homeworkid);

	@SQL("select count(*) from iyinsitan_mycourse where status=0 and courseid=:courseid")
	public Integer getCourseStudentCount(@SQLParam("courseid") Integer courseid);

	@SQL("select count(*) from iyinsitan_myhomework where status=0 and homeworkid=:homeworkid")
	public Integer getDoHomeworkCount(@SQLParam("homeworkid") Integer homeworkid);

	@SQL("select email from iyinsitan_ucenter_member where status=1 and id in(select uid from iyinsitan_assistant where courseid=:courseid and status=0 and isconfirm=1 union select uid from iyinsitan_course where id=:courseid)")
	public List<String> getTeacherEmailList(
			@SQLParam("courseid") Integer courseid);

	@SQL("select id,uid,coursename from iyinsitan_course where id in(select distinct courseid from iyinsitan_mycourse where (createtime>:starttime and createtime<:endtime) or (updatetime>:starttime and updatetime<:endtime))")
	public List<Course> getWeekDynamicCourseInfo(
			@SQLParam("starttime") Long starttime,
			@SQLParam("endtime") Long endtime);

	@SQL("select count(*) from iyinsitan_mycourse where status=0 and courseid=:courseid")
	public Integer getChooseCourseCount(@SQLParam("courseid") Integer courseid);

	@SQL("select id,stno,username from iyinsitan_ucenter_member where status=1 and id in(select uid from iyinsitan_mycourse where courseid=:courseid and status=0 and createtime>:starttime and createtime<:endtime)")
	public List<Member> getWeekDynamicAddInfo(
			@SQLParam("courseid") Integer courseid,
			@SQLParam("starttime") Long starttime,
			@SQLParam("endtime") Long endtime);

	@SQL("select id,stno,username from iyinsitan_ucenter_member where status=1 and id in(select uid from iyinsitan_mycourse where courseid=:courseid and status=1 and updatetime>:starttime and updatetime<:endtime)")
	public List<Member> getWeekDynamicDelInfo(
			@SQLParam("courseid") Integer courseid,
			@SQLParam("starttime") Long starttime,
			@SQLParam("endtime") Long endtime);

}
