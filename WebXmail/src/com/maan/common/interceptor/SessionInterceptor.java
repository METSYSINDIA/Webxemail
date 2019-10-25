package com.maan.common.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.StrutsStatics;
import com.maan.common.util.LogUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
 
public class SessionInterceptor extends AbstractInterceptor implements StrutsStatics {
	private static final long serialVersionUID = 1L;
	private static final String USER_HANDLE = "LOGIN_ID";
	private static final String LOGIN_ATTEMPT = "LOGIN_ATTEMPT";
	final org.slf4j.Logger logger = LogUtil.getLogger(SessionInterceptor.class);
	public String intercept(ActionInvocation invocation) throws Exception 
	  {
	    logger.info("Session Interceptor");
	    try{
	    	final ActionContext context = invocation.getInvocationContext ();
	   	    HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
	   	    HttpSession session =  request.getSession (true);
	   	    if(session==null)
	   	    	return "session"; 
	    }catch (Exception e) {
	    	e.printStackTrace();
		}
	 
	   // Object user = session.getAttribute (USER_HANDLE);
	   // String loginAttempt = request.getParameter (LOGIN_ATTEMPT); 
	    //if(user==null && StringUtils.isBlank(loginAttempt))
	         // return "session"; 
	      return invocation.invoke();
	  }
}