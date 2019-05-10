package com.ketangpai.task;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ketangpai.emailservice.EmailManager;
import com.ketangpai.model.Course;
import com.ketangpai.model.Homework;
import com.ketangpai.model.Member;
import com.ketangpai.sendcloud.Singleton;
import com.ketangpai.service.HomeworkService;
import com.ketangpai.service.UnionService;
import com.ketangpai.utils.DateUtils;
import com.ketangpai.utils.FileUtils;
import com.ketangpai.utils.HtmlUtils;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月4日 下午5:42:29 </br>using the quartz framework as
 *          the time management system
 */
public class TaskManager {

	private static final Logger logger = LoggerFactory
			.getLogger(TaskManager.class);

	private static Integer preHours = 8;

	private static Long preSecond = (long) preHours * 3600;

	private static Long weekSecond = (long) 7 * 24 * 3600;

	private static String notifystu = "";

	private static String notifystuover = "";

	private static String notifytea = "";

	private static String weektea = "";

	private static String preTitle = "【%s】作业到期提醒"; // date

	private static String title = "【%s】 作业超期提醒"; // date

	private static String titletea = "【%s】 作业提交情况";

	private static String weekTitle = "%s-本周学生动态 "; // class' name

	private static Set<String> blackset = new HashSet<String>();

	// load the template to memory as the static data when the project start.
	static {
		logger.debug("load the Email templet");
		notifystu = FileUtils.getFileContent("classpath:email/notifystu.html");
		notifystuover = FileUtils
				.getFileContent("classpath:email/notifystuover.html");
		notifytea = FileUtils.getFileContent("classpath:email/notifytea.html");
		weektea = FileUtils.getFileContent("classpath:email/weektea.html");
		String blacklist = FileUtils.getFileContent("classpath:blacklist");
		String temp[] = blacklist.split("\n");
		for (int i = 0; i < temp.length; i++) {
			blackset.add(temp[i]);
		}
		logger.debug("load the Email templet finished");
	}

	private HomeworkService homeworkService;

	private UnionService unionService;

	private EmailManager emailManager;

	private Integer minutes;

	public TaskManager() {
		logger.debug("Default TaskManager is running");
	}

	public TaskManager(HomeworkService homeworkService,
			UnionService unionService, EmailManager emailManager,
			Integer minutes) {
		logger.debug("TaskManger is initialising,minutes=" + minutes);
		this.homeworkService = homeworkService;
		this.unionService = unionService;
		this.emailManager = emailManager;
		this.minutes = minutes;
	}

	// every week 24:00 execute task ,scan the dynamic info of course and then
	// email teacher
	public void weekDynamicTask() {
		logger.debug(DateUtils.format(System.currentTimeMillis())
				+ "weekDynamicTask is executing");
		List<Course> courselist = unionService.getWeekDynamicCourseInfo(
				DateUtils.getCurrentSecond() - weekSecond,
				DateUtils.getCurrentSecond());
		for (int i = 0; i < courselist.size(); i++) {
			List<String> teacheremail = unionService
					.getTeacherEmailList(courselist.get(i).getId());
			logger.debug("teachers' email list=" + teacheremail);
			List<Member> memberaddlist = unionService.getWeekDynamicAddInfo(
					courselist.get(i).getId(), DateUtils.getCurrentSecond()
							- weekSecond, DateUtils.getCurrentSecond());

			List<Member> memberdellist = unionService.getWeekDynamicDelInfo(
					courselist.get(i).getId(), DateUtils.getCurrentSecond()
							- weekSecond, DateUtils.getCurrentSecond());

			Integer choosecount = unionService.getChooseCourseCount(courselist
					.get(i).getId());

			String weekContent = MessageFormat.format(weektea, courselist
					.get(i).getCoursename(), String.valueOf(memberaddlist
					.size()), String.valueOf(memberdellist.size()), String
					.valueOf(choosecount), HtmlUtils.getAddHtml(memberaddlist),
					HtmlUtils.getDelHtml(memberdellist));

			teacheremail = filterblacklist(teacheremail);// 过滤黑名单邮箱

			for (int j = 0; j < teacheremail.size(); j++) {
				// Singleton.getSendCloudClient().postMail(String.format(weekTitle,courselist.get(i).getCoursename()),
				// weekContent, teacheremail.get(j));
				emailManager.sendMessage(String.format(weekTitle, courselist
						.get(i).getCoursename()), teacheremail.get(j),
						weekContent);
				logger.debug(DateUtils.formatYMDHM(System.currentTimeMillis())
						+ "send week's dynamic info to teacher "
						+ teacheremail.get(j));
			}

		}
	}

	// every 10 minutes execute
	public void serveralMinutesTask() {
		logger.debug("Server Minutes is running");
		List<Homework> list = homeworkService.queryHomeworkList(
				DateUtils.getCurrentSecond() - minutes * 60,
				DateUtils.getCurrentSecond());
		List<Homework> pre8list = homeworkService.queryHomeworkList(
				DateUtils.getCurrentSecond() + preSecond - minutes * 60,
				DateUtils.getCurrentSecond() + preSecond);
		logger.debug("queueTask's size=" + list.size() + ",prequeue's size="
				+ pre8list.size());
		logger.debug("扫描出的结果" + list.toString());
		queueTask(list);
		prequeueTask(pre8list);
		logger.debug("Server Minutes finished");
	}

	// right time Task
	private void queueTask(List<Homework> list) {
		for (int i = 0; i < list.size(); i++) {
			Homework homework = list.get(i);
			// Student related info
			List<String> studentemail = unionService.getundoHomeworkList(
					homework.getCourseid(), homework.getId());
			logger.debug("before filter" + studentemail.toString());
			logger.debug("after filter" + studentemail.toString());
			logger.debug("studentemail.size=" + studentemail.size()
					+ ",content=" + studentemail.toString());
			String contentstu = MessageFormat.format(notifystuover,
					homework.getTitle(), homework.getDescription(),
					DateUtils.formatYMDHM(homework.getEndtime() * 1000));

			logger.debug("before filter=" + studentemail.toString());
			studentemail = filterblacklist(studentemail); // 过滤
			logger.debug("after filter=" + studentemail.toString());

			for (int j = 0; j < studentemail.size(); j++) {
				// Singleton.getSendCloudClient().postMail(String.format(title,DateUtils.formatYMD(System.currentTimeMillis())),
				// contentstu, studentemail.get(j));
				emailManager.sendMessage(String.format(title,
						DateUtils.formatYMD(System.currentTimeMillis())),
						studentemail.get(j), contentstu);
				logger.debug(DateUtils.formatYMDHM(System.currentTimeMillis())
						+ "send Email to Student" + studentemail.get(j)
						+ ",finished");
			}

			// Teacher related info
			List<String> teacheremail = unionService
					.getTeacherEmailList(homework.getCourseid());
			logger.debug("teacheremail.size=" + teacheremail.size()
					+ ",content=" + teacheremail.toString());
			Integer dohomeworkcount = unionService.getDoHomeworkCount(homework
					.getId());
			Integer courseStudentcount = unionService
					.getCourseStudentCount(homework.getCourseid());
			String contenttea = MessageFormat.format(notifytea,
					homework.getTitle(), homework.getDescription(),
					DateUtils.formatYMDHM(homework.getEndtime() * 1000),
					String.valueOf(courseStudentcount - dohomeworkcount),
					String.valueOf(dohomeworkcount));

			teacheremail = filterblacklist(teacheremail);// 过滤黑名单邮箱

			for (int j = 0; j < teacheremail.size(); j++) {
				// Singleton.getSendCloudClient().postMail(String.format(title,DateUtils.formatYMD(System.currentTimeMillis())),
				// contenttea, teacheremail.get(j));
				emailManager.sendMessage(String.format(titletea,
						DateUtils.formatYMD(System.currentTimeMillis())),
						teacheremail.get(j), contenttea);
				logger.debug(DateUtils.formatYMDHM(System.currentTimeMillis())
						+ "send Email to Teacher" + teacheremail.get(j)
						+ ",finished");
			}
		}
		list.clear();
	}

	// before 8 hours' endtime
	private void prequeueTask(List<Homework> list) {
		for (int i = 0; i < list.size(); i++) {
			Homework homework = list.get(i);
			List<String> studentemail = unionService.getundoHomeworkList(
					homework.getCourseid(), homework.getId());
			studentemail = filterblacklist(studentemail); // 过滤
			for (int j = 0; j < studentemail.size(); j++) {
				String content = MessageFormat.format(notifystu,
						homework.getTitle(), homework.getDescription(),
						DateUtils.formatYMDHM(homework.getEndtime() * 1000));
				// Singleton.getSendCloudClient().postMail(String.format(preTitle,DateUtils.formatYMD(System.currentTimeMillis())),
				// content, studentemail.get(j));
				emailManager.sendMessage(String.format(preTitle,
						DateUtils.formatYMD(System.currentTimeMillis())),
						studentemail.get(j), content);
				logger.debug(DateUtils.formatYMDHM(System.currentTimeMillis())
						+ "send preEmail to Student" + studentemail.get(j)
						+ ",finished");
			}
		}
		list.clear();

	}

	// filter the black list
	private List<String> filterblacklist(List<String> list) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			if (!blackset.contains(list.get(i).trim())) {
				result.add(list.get(i).trim());
			}
		}
		list.clear();
		return result;
	}

}
