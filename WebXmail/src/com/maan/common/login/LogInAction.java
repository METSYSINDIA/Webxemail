package com.maan.common.login;
/**
 * @author Shanish Kumar.G
 *
 * Common Login Template
 */

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.slf4j.Logger;


import com.maan.common.util.LogUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;


public class LogInAction extends ActionSupport  implements  ModelDriven<LogIn>,SessionAware{
	final Logger logger=LogUtil.getLogger(LogInAction.class);
	private static final long serialVersionUID = 10001L;
	private LogInService service=new LogInService();
	private LogIn login=new LogIn();
	private Map<String, Object> session;
	
	public LogIn getModel() { 
		return login;
	}
	
	public String auth(){
		
		try{
			login=service.auth(login);
			if(login!=null && login.getCompany()!=null){

				session.put("objCompany", login.getCompany());
				session.put("objlogin", login);
				return SUCCESS;
			}

			else
				return INPUT;
		}catch (Exception e) {
			e.printStackTrace();
			return INPUT;
		}

	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
		
	}
	
	
	public String init() {
		return "tilesinit";
	}
	 
	
}
