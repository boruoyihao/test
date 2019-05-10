package com.ketangpai.utils;

import java.util.ArrayList;
import java.util.List;

import com.ketangpai.model.Member;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月8日 上午11:40:58
 * 
 */
public class HtmlUtils {

	private static String htmlpart = "<span style=\"font-size:14px;display:block;line-height:18px;font-family:'Helvetica Neue',helvetica,sans-serif;color:#1C5C76;\">\n<div style=\"color:#333 ;display:inline;text-decoration:none;cursor:text;margin-right:20px;\">%s</div>\n<div style=\"color:#333 ;position:absolute;left:100px;display:inline;text-decoration:none;cursor:text;margin-right:20px;\">%s</div>\n</span>";

	private static String htmladdpart = "<span style=\"font-size:14px;line-height:18px;font-family:'Helvetica Neue',helvetica,sans-serif;color:#1C5C76;\">\n<div style=\"margin-top:5px;color:#A52A2A ;display:block;text-decoration:none;cursor:text;\">新增学生如下:</div>\n%s\n</span>";

	private static String htmldelpart = "<span style=\"font-size:14px;line-height:18px;font-family:'Helvetica Neue',helvetica,sans-serif;color:#1C5C76;\">\n<div style=\"margin-top:5px;color:#A52A2A ;display:block;text-decoration:none;cursor:text;\">退课学生如下:</div>\n%s\n</span>";

	private static String getHtml(List<Member> member) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < member.size(); i++) {
			sb.append(String.format(htmlpart, member.get(i).getUsername(),
					member.get(i).getStno()));
			sb.append("\n");
		}
		return sb.toString();
	}

	public static String getAddHtml(List<Member> member) {
		if (0 == member.size())
			return "";
		return String.format(htmladdpart, getHtml(member));
	}

	public static String getDelHtml(List<Member> member) {
		if (0 == member.size())
			return "";
		return String.format(htmldelpart, getHtml(member));
	}

	public static void main(String args[]) {
		// System.out.println(String.format(htmlpart, "赵立振","1301211108"));
		Member m = new Member();
		m.setId(0);
		m.setStno("12");
		m.setEmail("zhaolizhen@126.com");
		m.setUsername("赵立振");
		List<Member> list = new ArrayList<Member>();
		list.add(m);
		System.out.println(getDelHtml(list));
	}
}
