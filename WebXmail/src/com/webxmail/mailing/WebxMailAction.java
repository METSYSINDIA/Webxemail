package com.webxmail.mailing;

import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.webxmail.common.Util.FieldErrorUtil;
import com.webxmail.common.constant.WXConstant;

public class WebxMailAction extends ActionSupport implements ModelDriven<WebxMailBean>{
	/**
	 * version 1.0
	 * Author Ahamed Ibrahim
	 *  Oct 1,2019 
	 */
	private static final long serialVersionUID = 6677091252031583948L;
	private WebxMailBean bean=new WebxMailBean();
	private WebxMailService service=new WebxMailService();

	public WebxMailBean getBean() {
		return bean;
	}

	public void setBean(WebxMailBean bean) {
		this.bean = bean;
	}

	@Override
	public WebxMailBean getModel() {
		return bean;
	}

	public WebxMailService getService() {
		return service;
	}

	public void setService(WebxMailService service) {
		this.service = service;
	}
	
	public String list() {
		return "wxmailList";
	}
	public String init() {
		return "wxmailing";
	}
	
	public String save() {
		validateData();
		//addFieldError("emailSubject", "emailSubject Test");

		if(!hasActionErrors()) {
			service.insertMailData(bean);
		}
		return "wxmailing";
	}
	
	public String edit() {
		service.editMailDetails(bean);
		return "wxmailing";
	}
	private void validateData() {
		List<FieldErrorUtil> errorList=service.validateData(bean);
		setErrorList(errorList);
		

	}

	private void setErrorList(List<FieldErrorUtil> errorList) {
		if(errorList.size()>0)
			//addFieldError(fieldName, errorMessage);
			errorList.stream().forEach(err->addFieldError(err.getFieldError(), err.getFieldErrorMsg()));

	}

	private Object[] getObjVal(String constType) {
		return new Object[] {};
		
	}//
	
	public List<Map<String,Object>> getMailDetailsList(){
		return service.getMailDetailsList();	
		}
	public List<Map<String,Object>> getHeadTypeList(){
		return getCommonConstList(WXConstant.HEAD_TYPE,getObjVal(WXConstant.HEAD_TYPE));
	}
	public List<Map<String,Object>> getCheckModeList(){
		return getCommonConstList(WXConstant.CHECK_MODE,getObjVal(WXConstant.CHECK_MODE));
	}
	public List<Map<String,Object>> getCreativeTypeList(){
		return getCommonConstList(WXConstant.CREATIVE_TYPE,getObjVal(WXConstant.CREATIVE_TYPE));
	}
	public List<Map<String,Object>> getCheckProcessList(){
		return getCommonConstList(WXConstant.CHECK_PROCESS,getObjVal(WXConstant.CHECK_PROCESS));
	}
	public List<Map<String,Object>> getWxModeList(){
		return getCommonConstList(WXConstant.WX_MODE,getObjVal(WXConstant.WX_MODE));
	}
	public List<Map<String,Object>> getWxProcessList(){
		return getCommonConstList(WXConstant.WX_PROCESS,getObjVal(WXConstant.WX_PROCESS));
	}
	public List<Map<String,Object>> getWxMtaList(){
		return getCommonConstList(WXConstant.WX_MTA,getObjVal(WXConstant.WX_MTA));
	}
	public List<Map<String,Object>> getNegativeList(){
		return getCommonConstList(WXConstant.NEGATIVE,getObjVal(WXConstant.NEGATIVE));
	}
	public List<Map<String,Object>> getUrlPatternList(){
		return getCommonConstList(WXConstant.URL_PATTERN,getObjVal(WXConstant.URL_PATTERN));
	}
	public List<Map<String,Object>> getImgPatternList(){
		return getCommonConstList(WXConstant.URL_PATTERN,getObjVal(WXConstant.URL_PATTERN));
	}
	public List<Map<String,Object>> getHeaderTypeList(){
		return getCommonConstList(WXConstant.HEADER_TYPE,getObjVal(WXConstant.HEADER_TYPE));
	}
	
	
	private List<Map<String,Object>> getCommonConstList(String constType,Object[] obj){
		
		return service.getCommonConstList(constType,obj);
	}

}
