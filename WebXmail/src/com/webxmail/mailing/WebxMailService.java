package com.webxmail.mailing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.webxmail.common.Util.FieldErrorUtil;
import com.webxmail.common.constant.Validation;
import com.webxmail.mailing.impl.WebxMailDAOImpl;

public class WebxMailService {
	WebxMailDAO DAO=new WebxMailDAOImpl();
	List<FieldErrorUtil> errorList=new ArrayList<FieldErrorUtil>();
	public List<Map<String, Object>> getCommonConstList(String constType, Object[] obj) {
		return DAO.getCommonConstList(constType, obj) ;
	}
	public List<FieldErrorUtil> validateData(WebxMailBean bean){
		errorList=new ArrayList<FieldErrorUtil>();

		/*
		 * if(StringUtils.isBlank(bean.getWxMailingSid ())) {
		 * addFieldError("","Please Enter "); }
		 */
		if(StringUtils.isBlank(bean.getSourceFile ())) {
			addFieldError("sourceFile","Please Enter Source Name ");
		}
		/*
		 * if(StringUtils.isBlank(bean.getSourceTextCount ())) {}
		 */		
		if(StringUtils.isBlank(bean.getEmailSubject ())) {
			 addFieldError("emailSubject","Please Enter Email Subject ");
		 }
		if(StringUtils.isBlank(bean.getEmailForm ())) {
			 addFieldError("emailForm","Please Enter Email From ");
		}
		if(StringUtils.isBlank(bean.getFromMail ())) {
			 addFieldError("fromMail","Please Enter From Email ");
		}else if(!Validation.isValidEmail(bean.getFromMail ())) {
			addFieldError("fromMail","Please Enter Valid From Email Id");
			
		}
		if(StringUtils.isBlank(bean.getUrlDomain ())) {
			 addFieldError("urlDomain","Please Enter URL Domain ");
		}
		if(StringUtils.isBlank(bean.getWebxId ())) {
			 addFieldError("webxId","Please Enter Webx ID");
		}
		if(StringUtils.isBlank(bean.getPowerMtaName ())) {
			 addFieldError("powerMtaName","Please Enter Power MTA Name");
		}
		if(StringUtils.isBlank(bean.getReturnPath ())) {
			 addFieldError("returnPath","Please Enter Return Path ");
		}
		if(StringUtils.isBlank(bean.getTestMail ())) {
			 addFieldError("testMail","Please Enter Test Mail");
		}else if(!Validation.isValidEmail(bean.getTestMail ())) {
			addFieldError("testMail","Please Enter Valid Test Email Id");
			
		}
	
		if(StringUtils.isBlank(bean.getCheckMode ())) {
			 addFieldError("checkMode","Please Choose Check Mode ");
		}
		if(StringUtils.isBlank(bean.getHeadType ())) {
			addFieldError("headType","Please Choose Header Type");
		}
		if(StringUtils.isBlank(bean.getCheckProcess ())) {
			addFieldError("checkProcess","Please Choose Check Process ");
		}
		if(StringUtils.isBlank(bean.getCreateiveType ())) {
			addFieldError("createiveType","Please Choose Creative Type ");
		}
		if(StringUtils.isBlank(bean.getMailMode ())) {
			addFieldError("mailMode","Please Choose Mail Mode");
		}
		if(StringUtils.isBlank(bean.getMailProcess ())) {
			addFieldError("mailProcess","Please Choose Mail Process");
		}
		if(StringUtils.isBlank(bean.getMta ())) {
			addFieldError("mta","Please Choose MTA");
		}
		if(StringUtils.isBlank(bean.getNegative ())) {
			addFieldError("negative","Please Choose Negative");
		}
		if(StringUtils.isBlank(bean.getCheckCount ())) {
			addFieldError("checkCount","Please Enter Check Count");
		}else if(!StringUtils.isNumeric(bean.getCheckCount ())) {
			addFieldError("checkCount","Please Enter Check Count");
		}
		if(StringUtils.isBlank(bean.getIpQueueLine ())) {
			addFieldError("ipQueueLine","Please Enter Ip Queue Limit");
		}else if(!StringUtils.isNumeric(bean.getIpQueueLine ())) {
			addFieldError("ipQueueLine","Please Enter Valid Ip Queue Limit");
		}
		if(StringUtils.isBlank(bean.getInstance ())) {
			addFieldError("instance","Please Enter Instance");
		}else if(!StringUtils.isNumeric(bean.getInstance ())) {
			addFieldError("instance","Please Enter Valid Instance");
		}
		if(StringUtils.isBlank(bean.getMailPermit ())) {
			addFieldError("mailPermit","Please Enter Mail Per Min");
		}
		else if(!StringUtils.isNumeric(bean.getMailPermit ())){
			addFieldError("mailPermit","Please Enter Valid Mail Per Min");

		}
		if(StringUtils.isBlank(bean.getUrlPattern ())) {
			addFieldError("urlPattern","Please Select URL pattern");
		}
		if(StringUtils.isBlank(bean.getImagePattern ())) {
			addFieldError("imagePattern","Please Select Image pattern");
		}
		if(StringUtils.isBlank(bean.getTextLimit ())) {
			addFieldError("textLimit","Please Enter Text Limit");
		}
		if(StringUtils.isBlank(bean.getImageFolder ())) {
			addFieldError("imageFolder","Please Enter Image Folder");
		}
		if(StringUtils.isBlank(bean.getLandingPageImg ())) {
			addFieldError("landingPageImg","Please Enter Landing Page Image");
		}
		if(StringUtils.isBlank(bean.getOptoutPageImg ())) {
			addFieldError("optoutPageImg","Please Enter OptOut Page Image");
		}
		if(StringUtils.isBlank(bean.getMailContent ())) {
			addFieldError("mailContent","Please Enter Mail Content");
		}
		/*if(StringUtils.isBlank(bean.getMailContent ())) {
			addFieldError("",MessageFormat.format(ErrorMSG.PLS_ENTER_ERR, new Object[] {"Mail Content"}));
		}*/



	
		return errorList;
	}
	private void addActionError(String actionError) {
		//errorList.add(actionError);
		
	}
	
	private void addFieldError(String fieldName,String errorMessage) {
		errorList.add(new FieldErrorUtil(fieldName,errorMessage));
		
	}
	public void insertMailData(WebxMailBean bean) {
		DAO.insertMailData(bean);
	}
	public List<Map<String, Object>> getMailDetailsList() {
		return DAO.getMailDetailsList();
	}
	public void editMailDetails(WebxMailBean bean) {
		try {
			List<Map<String, Object>>  list=DAO.getMailDetailsEditList(bean);
			Map<String, Object> resultMap;
			if(list.size()>0) {
				resultMap=new HashMap<String, Object>();
				resultMap=list.get(0);
				bean.setWxMailingSid(resultMap.get("WX_MAILING_SID")==null?"":resultMap.get("WX_MAILING_SID").toString());
				bean.setSourceFile(resultMap.get("SOURCE_FILE")==null?"":resultMap.get("SOURCE_FILE").toString());
				bean.setSourceTextCount(resultMap.get("SOURCE_TEXT_COUNT")==null?"":resultMap.get("SOURCE_TEXT_COUNT").toString());
				bean.setEmailSubject(resultMap.get("EMAIL_SUBJECT")==null?"":resultMap.get("EMAIL_SUBJECT").toString());
				bean.setEmailForm(resultMap.get("EMAIL_FORM")==null?"":resultMap.get("EMAIL_FORM").toString());
				bean.setFromMail(resultMap.get("FROM_MAIL")==null?"":resultMap.get("FROM_MAIL").toString());
				bean.setUrlDomain(resultMap.get("URL_DOMAIN")==null?"":resultMap.get("URL_DOMAIN").toString());
				bean.setWebxId(resultMap.get("WEBX_ID")==null?"":resultMap.get("WEBX_ID").toString());
				bean.setPowerMtaName(resultMap.get("POWER_MTA_NAME")==null?"":resultMap.get("POWER_MTA_NAME").toString());
				bean.setReturnPath(resultMap.get("RETURN_PATH")==null?"":resultMap.get("RETURN_PATH").toString());
				bean.setTestMail(resultMap.get("TEST_MAIL")==null?"":resultMap.get("TEST_MAIL").toString());
				bean.setCheckMode(resultMap.get("CHECK_MODE")==null?"":resultMap.get("CHECK_MODE").toString());
				bean.setHeadType(resultMap.get("HEAD_TYPE")==null?"":resultMap.get("HEAD_TYPE").toString());
				bean.setCheckProcess(resultMap.get("CHECK_PROCESS")==null?"":resultMap.get("CHECK_PROCESS").toString());
				bean.setCreateiveType(resultMap.get("CREATEIVE_TYPE")==null?"":resultMap.get("CREATEIVE_TYPE").toString());
				bean.setMailMode(resultMap.get("MAIL_MODE")==null?"":resultMap.get("MAIL_MODE").toString());
				bean.setMailProcess(resultMap.get("MAIL_PROCESS")==null?"":resultMap.get("MAIL_PROCESS").toString());
				bean.setMta(resultMap.get("MTA")==null?"":resultMap.get("MTA").toString());
				bean.setNegative(resultMap.get("NEGATIVE")==null?"":resultMap.get("NEGATIVE").toString());
				bean.setCheckCount(resultMap.get("CHECK_COUNT")==null?"":resultMap.get("CHECK_COUNT").toString());
				bean.setIpQueueLine(resultMap.get("IP_QUEUE_LINE")==null?"":resultMap.get("IP_QUEUE_LINE").toString());
				bean.setInstance(resultMap.get("INSTANCE")==null?"":resultMap.get("INSTANCE").toString());
				bean.setMailPermit(resultMap.get("MAIL_PERMIT")==null?"":resultMap.get("MAIL_PERMIT").toString());
				bean.setUrlPattern(resultMap.get("URL_PATTERN")==null?"":resultMap.get("URL_PATTERN").toString());
				bean.setImagePattern(resultMap.get("IMAGE_PATTERN")==null?"":resultMap.get("IMAGE_PATTERN").toString());
				bean.setTextLimit(resultMap.get("TEXT_LIMIT")==null?"":resultMap.get("TEXT_LIMIT").toString());
				bean.setImageFolder(resultMap.get("IMAGE_FOLDER")==null?"":resultMap.get("IMAGE_FOLDER").toString());
				bean.setLandingPageImg(resultMap.get("LANDING_PAGE_IMG")==null?"":resultMap.get("LANDING_PAGE_IMG").toString());
				bean.setOptoutPageImg(resultMap.get("OPTOUT_PAGE_IMG")==null?"":resultMap.get("OPTOUT_PAGE_IMG").toString());
				bean.setMailContent(resultMap.get("MAIL_CONTENT")==null?"":resultMap.get("MAIL_CONTENT").toString());

			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
