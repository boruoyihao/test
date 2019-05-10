package com.ketangpai.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月7日 下午3:04:29
 * 
 */
public class FileUtils {

	/**
	 * read common File by the relative path
	 **/
	public static String getFileContent(String path) {

		PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = patternResolver.getResource(path);

		BufferedReader reader = null;
		StringBuffer sb = new StringBuffer();

		try {
			InputStreamReader isr = new InputStreamReader(
					resource.getInputStream(), "UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			// every time read one line
			while ((tempString = reader.readLine()) != null) {
				sb.append(tempString);
				sb.append("\n");
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != reader) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}
}
