package com.ketangpai.dao;

import com.ketangpai.model.EmailRecord;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.ReturnGeneratedKeys;
import net.paoding.rose.jade.annotation.SQL;
import net.paoding.rose.jade.annotation.SQLParam;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 上午11:19:51
 * @function 记录发送邮件消息
 */
@DAO(catalog = "ketangpaimail.master")
public interface EmailRecordDAO {

	String CHARACTER_COLUMNS = "id,title,content,receiver,createtime,updatetime,status";

	String CHARACTER_FIELDS = ":emailrecord.id,:emailrecord.title,:emailrecord.content,:emailrecord.receiver,:emailrecord.createtime,:emailrecord.updatetime,:emailrecord.status";

	@ReturnGeneratedKeys
	@SQL("INSERT INTO iyinsitan_emailrecord(" + CHARACTER_COLUMNS + ") VALUES("
			+ CHARACTER_FIELDS + ")")
	public int addEmailRecord(@SQLParam("emailrecord") EmailRecord emailrecord);

}
