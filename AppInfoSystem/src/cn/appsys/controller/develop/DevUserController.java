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
 * Controller������
 * @author ��һʹͽ�콾
 *RequestMapping����·��
 *resourceʵ����
 *Logger��־���
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
		return "devlogin";		//devlogin ��ͼ��JSP������ 
	}
	
	@RequestMapping(value="/dologin")
	public String login(@RequestParam String devCode,@RequestParam String devPassword,HttpSession session,HttpServletRequest request)
	{
		logger.debug("Login");
		
		DevUser user=null;
		user=devUserService.login(devCode, devPassword);
		if(null!=user)
		{
			//����session  Constants������ DEV_USER_SESSION ����
			session.setAttribute(Constants.DEV_USER_SESSION, user);
			return "redirect:/dev/flatform/main"; //header·��
		}else
		{
			//������devlogin.jsp����ʾ��Ϣ
			request.setAttribute("error","�û��������벻��ȷ");
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
		//���session
		session.removeAttribute("user");
		return "devlogin";
	}
}
