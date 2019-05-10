package com.ketangpai.sendcloud;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月12日 上午11:34:26
 * 
 */
public class SendCloudImpl implements SendCloud {

	private String url = "http://sendcloud.sohu.com/webapi/mail.send.json";

	private HttpClient httpclient = new DefaultHttpClient();

	private HttpPost httpost = new HttpPost(url);

	private static String api_user = "ketangpai"; // 正式用的时候换成正式api_user和api_key

	private static String api_key = "R0z4smheadRf3ZNN";

	private static String from = "Notify@sendmail.ketangpai.com";

	@Override
	public boolean postMail(String title, String content, String receiver) {
		boolean result = false;
		List<BasicNameValuePair> nvps = new ArrayList<BasicNameValuePair>();
		// 不同于登录SendCloud站点的帐号，您需要登录后台创建发信子帐号，使用子帐号和密码才可以进行邮件的发送。
		nvps.add(new BasicNameValuePair("api_user", api_user));
		nvps.add(new BasicNameValuePair("api_key", api_key));
		nvps.add(new BasicNameValuePair("from", from));
		nvps.add(new BasicNameValuePair("to", receiver));
		nvps.add(new BasicNameValuePair("subject", title));
		nvps.add(new BasicNameValuePair("html", content));

		try {
			httpost.setEntity(new UrlEncodedFormEntity(nvps, "UTF-8"));
			// 请求
			HttpResponse response = httpclient.execute(httpost);
			// 处理响应
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 正常返回
				// 读取xml文档
				String answer = EntityUtils.toString(response.getEntity());
				System.out.println(answer);
				result = true;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			return result;
		}

	}

}
