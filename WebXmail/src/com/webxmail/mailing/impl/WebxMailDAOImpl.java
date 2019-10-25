package com.webxmail.mailing.impl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.maan.common.db.MyJdbcTemplate;
import com.webxmail.mailing.WebxMailBean;
import com.webxmail.mailing.WebxMailDAO;

public class WebxMailDAOImpl extends MyJdbcTemplate implements WebxMailDAO{

	@Override
	public List<Map<String, Object>> getCommonConstList(String constType, Object[] obj) {
		try {
			String query="select WX_CONSTANT_VAL,WX_CONSTANT_NAME "
					+ "from WX_CONSTANT_DETAILS where WX_CONSTANT_TYPE=?";//getQuery(DBConstants.EAPP_CONSTANT_101);
			List<Map<String, Object>> result =this.mytemplate.queryForList(query,new Object[]{constType});
			//if(count>0)
				return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<Map<String, Object>> ();
	}

	@Override
	public void insertMailData(WebxMailBean bean) {
	String query="";
	try {
		Object[] obj = null;
		if(StringUtils.isBlank(bean.getWxMailingSid())) {
		query="INSERT INTO  WX_MAILING_DETAILS(  WX_MAILING_SID,SOURCE_FILE,SOURCE_TEXT_COUNT,EMAIL_SUBJECT,"
				+ "EMAIL_FORM,FROM_MAIL,URL_DOMAIN,WEBX_ID,POWER_MTA_NAME,RETURN_PATH,TEST_MAIL,CHECK_MODE"
				+ ",HEAD_TYPE,CHECK_PROCESS,CREATEIVE_TYPE,MAIL_MODE,MAIL_PROCESS,MTA,NEGATIVE,CHECK_COUNT"
				+ ",IP_QUEUE_LINE,INSTANCE,MAIL_PERMIT,URL_PATTERN,IMAGE_PATTERN,TEXT_LIMIT,IMAGE_FOLDER"
				+ ",LANDING_PAGE_IMG,OPTOUT_PAGE_IMG,MAIL_CONTENT)"
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		bean.setWxMailingSid(getSeq());
		bean.setSourceTextCount("0");
			 obj =new Object[] { bean.getWxMailingSid(), bean.getSourceFile(), bean.getSourceTextCount(),
					bean.getEmailSubject(), bean.getEmailForm(), bean.getFromMail(), bean.getUrlDomain(),
					bean.getWebxId(), bean.getPowerMtaName(), bean.getReturnPath(), bean.getTestMail(),
					bean.getCheckMode(), bean.getHeadType(), bean.getCheckProcess(), bean.getCreateiveType(),
					bean.getMailMode(), bean.getMailProcess(), bean.getMta(), bean.getNegative(), bean.getCheckCount(),
					bean.getIpQueueLine(), bean.getInstance(), bean.getMailPermit(), bean.getUrlPattern(),
					bean.getImagePattern(), bean.getTextLimit(), bean.getImageFolder(), bean.getLandingPageImg(),
					bean.getOptoutPageImg(), bean.getMailContent()};
			removeNull(obj);
		}else {

			query="update  WX_MAILING_DETAILS set SOURCE_FILE=?,SOURCE_TEXT_COUNT=?,EMAIL_SUBJECT=?,"
					+ "EMAIL_FORM=?,FROM_MAIL=?,URL_DOMAIN=?,WEBX_ID=?,POWER_MTA_NAME=?,RETURN_PATH=?,TEST_MAIL=?,CHECK_MODE=?"
					+ ",HEAD_TYPE=?,CHECK_PROCESS=?,CREATEIVE_TYPE=?,MAIL_MODE=?,MAIL_PROCESS=?,MTA=?,NEGATIVE=?,CHECK_COUNT=?"
					+ ",IP_QUEUE_LINE=?,INSTANCE=?,MAIL_PERMIT=?,URL_PATTERN=?,IMAGE_PATTERN=?,TEXT_LIMIT=?,IMAGE_FOLDER=?"
					+ ",LANDING_PAGE_IMG=?,OPTOUT_PAGE_IMG=?,MAIL_CONTENT=? where WX_MAILING_SID=?";
			bean.setSourceTextCount("0");
				 obj =new Object[] { bean.getSourceFile(), bean.getSourceTextCount(),
							bean.getEmailSubject(), bean.getEmailForm(), bean.getFromMail(), bean.getUrlDomain(),
							bean.getWebxId(), bean.getPowerMtaName(), bean.getReturnPath(), bean.getTestMail(),
							bean.getCheckMode(), bean.getHeadType(), bean.getCheckProcess(), bean.getCreateiveType(),
							bean.getMailMode(), bean.getMailProcess(), bean.getMta(), bean.getNegative(), bean.getCheckCount(),
							bean.getIpQueueLine(), bean.getInstance(), bean.getMailPermit(), bean.getUrlPattern(),
							bean.getImagePattern(), bean.getTextLimit(), bean.getImageFolder(), bean.getLandingPageImg(),
							bean.getOptoutPageImg(), bean.getMailContent() ,bean.getWxMailingSid()};
				removeNull(obj);
			
		}
			System.out.println(queryFrammer(query, obj));
			
			this.mytemplate.update(query,obj);
			
	}catch (Exception e) {
		e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> getMailDetailsList() {
		try {
			String query="select * from WX_MAILING_DETAILS";//getQuery(DBConstants.EAPP_CONSTANT_101);
			List<Map<String, Object>> result =this.mytemplate.queryForList(query);
			//if(count>0)
				return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<Map<String, Object>> ();
	}

	@Override
	public List<Map<String, Object>> getMailDetailsEditList(WebxMailBean bean) {
		try {
			String query="select * from WX_MAILING_DETAILS where WX_MAILING_SID=?";//getQuery(DBConstants.EAPP_CONSTANT_101);
			List<Map<String, Object>> result =this.mytemplate.queryForList(query,new Object[] {bean.getWxMailingSid()});
			//if(count>0)
				return result;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return new ArrayList<Map<String, Object>> ();
	}
	private String getSeq() {
		String result ="";
		try {
			String query="SELECT seq(?) FROM DUAL";
			 result =this.mytemplate.queryForObject(query,new Object[] {"WX_MAILING_SID"},String.class);
			 return result;
			 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return "";
	}

}
