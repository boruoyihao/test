package com.ketangpai.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Param;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;
import net.paoding.rose.web.annotation.rest.Post;

/**
 * @author E-mail:zhaolizhen2009@gmail.com
 * @version createTime：2015年2月27日 下午2:36:51
 * 
 */
@Path("")
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	private static final String user = "ketangpai";

	private static final String pwd = "/?ketangpai2015?/";

	@Get("")
	public String login(Invocation inv) {
		return "login";
	}

	@Get("login")
	public String login() {
		return "login";
	}

	@Post("login")
	public String login(Invocation inv, @Param("username") String username,
			@Param("password") String password) {
		logger.debug("user is logging");
		if (username.equals(user) && password.equals(pwd)) {
			inv.getRequest().getSession().setAttribute("username", user);
			inv.getRequest().getSession().setAttribute("password", pwd);
			return "r:email/batchemail";
		}
		return "r:login";
	}

}
