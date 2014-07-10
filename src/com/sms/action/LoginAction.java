package com.sms.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.client.HttpServerErrorException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sms.entity.User;

public class LoginAction extends ActionSupport {
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();

		System.out.println(request.getCharacterEncoding());

		if ("root".equals(user.getId())
				&& "root123".equals(user.getPassword())) {
			Map session = ActionContext.getContext().getSession();
			session.put("user.name", user.getId());

			System.out.println("��½�ɹ����û���=" + user.getId());
			return "success";
		}

		System.out.println("��½ʧ�ܣ��û���=" + user.getId());
		return "fail";
	}

}
