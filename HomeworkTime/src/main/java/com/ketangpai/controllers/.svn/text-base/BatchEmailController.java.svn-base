package com.ketangpai.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ketangpai.emailservice.EmailManager;
import com.ketangpai.model.Row;
import com.ketangpai.sendcloud.Singleton;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.HttpFeatures;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月27日 下午2:44:14
 * 
 */
@Path("")
public class BatchEmailController {

	private static final Logger logger = LoggerFactory
			.getLogger(BatchEmailController.class);

	@Autowired
	private EmailManager emailManager;

	@Get("email/batchemail")
	public String batchemail(Invocation inv) {
		logger.debug("email/batchemail is running");

		return "batchemail";
	}

	@Post("email/batchemail")
	@HttpFeatures(contentType = "application/json", charset = "utf-8")
	public String batchemail(Invocation inv, @Param("file") MultipartFile file,
			@Param("title") String title, @Param("content") String content) {
		logger.debug("file name=" + file.getOriginalFilename() + ",title="
				+ title + ",content=" + content);
		List<Row> list = new ArrayList<Row>();
		try {
			String filename = file.getOriginalFilename();
			String suffix = filename.substring(filename.lastIndexOf(".") + 1);

			if (suffix.equalsIgnoreCase("xlsx")) {
				InputStream in = file.getInputStream();
				XSSFWorkbook hwk = new XSSFWorkbook(in);// 将is流实例到 一个excel流里
				XSSFSheet sh = hwk.getSheetAt(0);// 得到book第一个工作薄sheet
				int rows = sh.getLastRowNum() + 1 - sh.getFirstRowNum(); // 总行数
				for (int i = 0; i < rows; i++) {
					XSSFRow row = sh.getRow(i);
					int cols = row.getLastCellNum() - row.getFirstCellNum(); // 该行的总列数
					Row rowtemp = new Row();
					rowtemp.setId(i);
					// rowtemp.setName(row.getCell(0).toString());
					rowtemp.setName("");
					rowtemp.setEmail(row.getCell(1).toString());
					list.add(rowtemp);
				}
			} else if (suffix.equalsIgnoreCase("xls")) {
				InputStream in = file.getInputStream();
				HSSFWorkbook hwk = new HSSFWorkbook(in);// 将is流实例到 一个excel流里
				HSSFSheet sh = hwk.getSheetAt(0);// 得到book第一个工作薄sheet
				int rows = sh.getLastRowNum() + 1 - sh.getFirstRowNum(); // 总行数
				for (int i = 0; i < rows; i++) {
					HSSFRow row = sh.getRow(i);
					int cols = row.getLastCellNum() - row.getFirstCellNum(); // 该行的总列数
					Row rowtemp = new Row();
					rowtemp.setId(i);
					// rowtemp.setName(row.getCell(0).toString());
					rowtemp.setName("");
					rowtemp.setEmail(row.getCell(1).toString());
					list.add(rowtemp);
				}
			} else if (suffix.equalsIgnoreCase("txt")) {
				String line = "";
				InputStream in = file.getInputStream();
				InputStreamReader isr = new InputStreamReader(in, "UTF-8");
				BufferedReader reader = new BufferedReader(isr);
				int i = 0;
				while ((line = reader.readLine()) != null) {
					Row rowtemp = new Row();
					rowtemp.setId(i++);
					// rowtemp.setName(row.getCell(0).toString());
					rowtemp.setName("");
					rowtemp.setEmail(line.trim());
					list.add(rowtemp);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 1; i < list.size(); i++) {
			logger.debug("batch email address=" + i + list.get(i).getEmail());
			if (list.get(i).getEmail().contains("@yahoo.com.cn")) {
				logger.debug("jump the yahoo email " + list.get(i).getEmail());
				continue;
			}
			boolean result = Singleton.getSendCloudClient().postMail(title,
					content, list.get(i).getEmail());
			list.get(i).setStatus(result);
		}

		list.remove(0);
		inv.addModel("resultlist", list);
		return "batchemailsuc";
	}
}
