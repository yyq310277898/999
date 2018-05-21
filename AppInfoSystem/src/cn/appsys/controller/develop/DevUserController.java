package cn.appsys.controller.develop;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cn.appsys.pojo.DevUser;
import cn.appsys.service.developer.DevUserService;
import cn.appsys.tools.Constants;

/**
 * Controller描述类
 * @author 第一使徒天骄
 *RequestMapping访问路径
 *resource实例化
 *Logger日志输出
 */
@Controller
@RequestMapping(value="/dev")
public class DevUserController {
	@Resource
	private DevUserService devUserService;
	private Logger logger=Logger.getLogger(DevUserController.class);
	
	@RequestMapping(value="/login")
	public String login()
	{
		logger.debug("Login");
		return "devlogin";		//devlogin 视图名JSP的名称 
	}
	
	@RequestMapping(value="/dologin")
	public String login(@RequestParam String devCode,@RequestParam String devPassword,HttpSession session,HttpServletRequest request)
	{
		logger.debug("Login");
		
		DevUser user=null;
		user=devUserService.login(devCode, devPassword);
		if(null!=user)
		{
			//放入session  Constants工具类 DEV_USER_SESSION 常量
			session.setAttribute(Constants.DEV_USER_SESSION, user);
			return "redirect:/dev/flatform/main"; //header路径
		}else
		{
			//保留在devlogin.jsp，提示信息
			request.setAttribute("error","用户名或密码不正确");
		}
		return "devlogin";
	}
	
	@RequestMapping(value="/flatform/main")
	public String main(HttpSession session)
	{
		if(session.getAttribute(Constants.DEV_USER_SESSION)==null)
		{
			return "redirect:/dev/login";
		}
		return "developer/main";
	}
	@RequestMapping(value="/logout")
	public String logout(HttpSession session)
	{
		//清除session
		session.removeAttribute("user");
		return "devlogin";
	}
}
