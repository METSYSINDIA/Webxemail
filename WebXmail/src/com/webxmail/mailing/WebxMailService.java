package com.webxmail.mailing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.webxmail.common.constant.Validation;
import com.webxmail.mailing.impl.WebxMailDAOImpl;

public class WebxMailService {
	WebxMailDAO DAO=new WebxMailDAOImpl();
	List<String> errorList=new ArrayList<String>();
	public List<Map<String, Object>> getCommonConstList(String constType, Object[] obj) {
		return DAO.getCommonConstList(constType, obj) ;
	}
	public List<String> validateData(WebxMailBean bean){
		errorList=new ArrayList<String>();

		/*
		 * if(StringUtils.isBlank(bean.getWxMailingSid ())) {
		 * addActionError("Please Enter "); }
		 */
		if(StringUtils.isBlank(bean.getSourceFile ())) {
			addActionError("Please Enter Source Name ");
		}
		/*
		 * if(StringUtils.isBlank(bean.getSourceTextCount ())) {}
		 */		
		if(StringUtils.isBlank(bean.getEmailSubject ())) {
			 addActionError("Please Enter Email Subject ");
		 }
		if(StringUtils.isBlank(bean.getEmailForm ())) {
			 addActionError("Please Enter Email From ");
		}
		if(StringUtils.isBlank(bean.getFromMail ())) {
			 addActionError("Please Enter From Email ");
		}else if(!Validation.isValidEmail(bean.getFromMail ())) {
			addActionError("Please Enter Valid From Email Id");
			
		}
		if(StringUtils.isBlank(bean.getUrlDomain ())) {
			 addActionError("Please Enter URL Domain ");
		}
		if(StringUtils.isBlank(bean.getWebxId ())) {
			 addActionError("Please Enter Webx ID");
		}
		if(StringUtils.isBlank(bean.getPowerMtaName ())) {
			 addActionError("Please Enter Power MTA Name");
		}
		if(StringUtils.isBlank(bean.getReturnPath ())) {
			 addActionError("Please Enter Return Path ");
		}
		if(StringUtils.isBlank(bean.getTestMail ())) {
			 addActionError("Please Enter Test Mail");
		}else if(!Validation.isValidEmail(bean.getTestMail ())) {
			addActionError("Please Enter Valid Test Email Id");
			
		}
	
		if(StringUtils.isBlank(bean.getCheckMode ())) {
			 addActionError("Please Choose Check Mode ");
		}
		if(StringUtils.isBlank(bean.getHeadType ())) {
			addActionError("Please Choose Header Type");
		}
		if(StringUtils.isBlank(bean.getCheckProcess ())) {
			addActionError("Please Choose Check Process ");
		}
		if(StringUtils.isBlank(bean.getCreateiveType ())) {
			addActionError("Please Choose Creative Type ");
		}
		if(StringUtils.isBlank(bean.getMailMode ())) {
			addActionError("Please Choose Mail Mode");
		}
		if(StringUtils.isBlank(bean.getMailProcess ())) {
			addActionError("Please Choose Mail Process");
		}
		if(StringUtils.isBlank(bean.getMta ())) {
			addActionError("Please Choose MTA");
		}
		if(StringUtils.isBlank(bean.getNegative ())) {
			addActionError("Please Choose Negative");
		}
		if(StringUtils.isBlank(bean.getCheckCount ())) {
			addActionError("Please Enter Check Count");
		}else if(!StringUtils.isNumeric(bean.getCheckCount ())) {
			addActionError("Please Enter Check Count");
		}
		if(StringUtils.isBlank(bean.getIpQueueLine ())) {
			addActionError("Please Enter Ip Queue Limit");
		}else if(!StringUtils.isNumeric(bean.getIpQueueLine ())) {
			addActionError("Please Enter Valid Ip Queue Limit");
		}
		if(StringUtils.isBlank(bean.getInstance ())) {
			addActionError("Please Enter Instance");
		}else if(!StringUtils.isNumeric(bean.getInstance ())) {
			addActionError("Please Enter Valid Instance");
		}
		if(StringUtils.isBlank(bean.getMailPermit ())) {
			addActionError("Please Enter Mail Per Min");
		}
		else if(!StringUtils.isNumeric(bean.getMailPermit ())){
			addActionError("Please Enter Valid Mail Per Min");

		}
		if(StringUtils.isBlank(bean.getUrlPattern ())) {
			addActionError("Please Select URL pattern");
		}
		if(StringUtils.isBlank(bean.getImagePattern ())) {
			addActionError("Please Select Image pattern");
		}
		if(StringUtils.isBlank(bean.getTextLimit ())) {
			addActionError("Please Enter Text Limit");
		}
		if(StringUtils.isBlank(bean.getImageFolder ())) {
			addActionError("Please Enter Image Folder");
		}
		if(StringUtils.isBlank(bean.getLandingPageImg ())) {
			addActionError("Please Enter Landing Page Image");
		}
		if(StringUtils.isBlank(bean.getOptoutPageImg ())) {
			addActionError("Please Enter OptOut Page Image");
		}
		if(StringUtils.isBlank(bean.getMailContent ())) {
			addActionError("Please Enter Mail Content");
		}
		/*if(StringUtils.isBlank(bean.getMailContent ())) {
			addActionError(MessageFormat.format(ErrorMSG.PLS_ENTER_ERR, new Object[] {"Mail Content"}));
		}*/



	
		return errorList;
	}
	private void addActionError(String actionError) {
		errorList.add(actionError);
		
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
