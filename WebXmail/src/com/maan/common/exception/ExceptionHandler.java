package com.maan.common.exception;


import com.maan.common.util.LogUtil;

import com.opensymphony.xwork2.ActionSupport;

import freemarker.log.Logger;

public class ExceptionHandler extends ActionSupport{
	final org.slf4j.Logger logger = LogUtil.getLogger(ExceptionHandler.class);
	private static final long serialVersionUID = 1L;
	private Exception exception;

    public String execute() {
    	try{
    		if(exception != null){
    			logger.error("*****  I HAVE NOT LOGGED THIS EXCEPTION! *****");
                addActionError(exception.toString());
                return ERROR; // Everything went OK, we just want to redirect to the error page"
            } else {
                logger.error("***** TRIED TO LOG EXCEPTION BUT EXCEPTION WAS NULL! I HAVE NOT LOGGED THIS EXCEPTION! *****");
            }

            addActionError(getText("actionUnhandledExceptionHandler.could.not.log.exception"));
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
        return "error";
    }

    /**
     * @param exception the exception to set
     */
    public void setException(Exception exception) {
        this.exception = exception;
    }
}
