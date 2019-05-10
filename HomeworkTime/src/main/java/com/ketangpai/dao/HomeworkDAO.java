package com.ketangpai.dao;

import java.util.List;

import com.ketangpai.model.Homework;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月3日 下午2:53:18
 * 
 */

@DAO(catalog = "ketangpaimail.master")
public interface HomeworkDAO {

	String CHARACTER_COLUMNS = "id,uid,courseid,title,description,endtime";

	String CHARACTER_FIELDS = ":homework.id,:homework.uid,:homework.courseid,:homework.title,homework.description,:homework.endtime";

	@SQL("SELECT "
			+ "id,uid,courseid,title,left(description,60) as description,endtime"
			+ " FROM iyinsitan_homework WHERE endtime>=:starttime AND endtime<:endtime order by endtime asc")
	public List<Homework> queryHomeworkList(
			@SQLParam("starttime") Long starttime,
			@SQLParam("endtime") Long endtime);

}
