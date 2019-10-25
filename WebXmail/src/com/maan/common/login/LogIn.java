package com.maan.common.login;

import java.io.Serializable;

public class LogIn implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String txtuserName ;
	private String txtpassword ;
	private String entrydate ;
	//private String passwordold ;
	private String companyid ;
	
	
	public String getTxtuserName() {
		return txtuserName;
	}
	public void setTxtuserName(String txtuserName) {
		this.txtuserName = txtuserName;
	}
	public String getTxtpassword() {
		return txtpassword;
	}
	public void setTxtpassword(String txtpassword) {
		this.txtpassword = txtpassword;
	}
	public String getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}


	private Company company; 
	

}

class Company implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getCompanyid() {
		return companyid;
	}
	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	public String getEntrydate() {
		return entrydate;
	}
	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getFlex() {
		return flex;
	}
	public void setFlex(String flex) {
		this.flex = flex;
	}
	private String companyid ;
	private String companyname ;
	private String ownername ;
	private String mailid ;
	private String phonenumber ;
	private String contactnumber ;
	private String entrydate ;
	private String logo ;
	private String remarks ;
	private String flex ;
}
