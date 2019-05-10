package com.ketangpai.model;

import com.alibaba.fastjson.JSONObject;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月2日 上午10:28:59
 * @function 发送到邮件队列的Model数据结构
 */
public class EmailRecord {

	private int id;

	private String title;

	private String content;

	private String receiver;

	private int createtime;

	private int updatetime;

	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public int getCreatetime() {
		return createtime;
	}

	public void setCreatetime(int createtime) {
		this.createtime = createtime;
	}

	public int getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(int updatetime) {
		this.updatetime = updatetime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getObjectJSON() {
		EmailRecordJSON emailRecordJSON = new EmailRecordJSON();
		emailRecordJSON.setId(String.valueOf(id));
		emailRecordJSON.setTitle(title);
		emailRecordJSON.setReceiver(receiver);
		emailRecordJSON.setContent(content);
		return JSONObject.toJSONString(emailRecordJSON); // alibaba FastJSON
	}

	@Override
	public String toString() {
		return "EmailRecord [id=" + id + ", title=" + title + ", content="
				+ content + ", receiver=" + receiver + ", createtime="
				+ createtime + ", updatetime=" + updatetime + ", status="
				+ status + "]";
	}
}

class EmailRecordJSON {

	private String id;

	private String title;

	private String content;

	private String receiver;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}
