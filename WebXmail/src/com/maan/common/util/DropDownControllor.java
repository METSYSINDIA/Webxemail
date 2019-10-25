package com.maan.common.util;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import com.maan.common.db.DBConstants;
import com.maan.common.db.MyJdbcTemplate;

public class DropDownControllor extends MyJdbcTemplate {
	Logger logger = LogUtil.getLogger(DropDownControllor.class);
	
	public List<Map<String, Object>> getCountryDropDown(String branchCode) {
		
		List<Map<String, Object>> countryList=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_GETCOUNTRYLIST);
		    logger.info("Select Query==> " + query);
		    logger.info("Args[0]==> " + branchCode);
		    logger.info("Args[1]==> " + "Y");
		    countryList=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");		
		}
	    return countryList;
	}
	
	public  List<Map<String, Object>> getProfitCentreDropDown(String branchCode) {

		List<Map<String, Object>> profitCenterList=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_GETPROFITCENTERLIST);
		    logger.info("Select Query==> " + query);
		    logger.info("Args[0]==> " + branchCode);
		    logger.info("Args[1]==> " + "Y");
		    profitCenterList=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");	
		}
		
	    return profitCenterList;
	}

	public List<Map<String,Object>> getSubProfitCentreDropDown(String branchCode,String productCode){
	 	
	 	List<Map<String,Object>> subProfitCenterList=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_GETSUBPROFITCENTERLIST);
		    logger.info("Select Query=>"+query);
		    logger.info("Args[0]=>"+branchCode);
		    logger.info("Args[1]=>"+productCode);
		    logger.info("Args[2]=>"+"Y");
		    subProfitCenterList=this.mytemplate.queryForList(query,new Object[]{branchCode,productCode,"Y"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
	    
	    return subProfitCenterList;
	}	 
	 
	public List<Map<String,Object>> getProductDropDown(String branchCode){
		
		List<Map<String,Object>> productList=new ArrayList<Map<String,Object>>();
		try{
			String query=getQuery(DBConstants.COMMON_SELECT_GETPRODUCTLIST);
			logger.info("Select Query=>"+query);
			logger.info("Arg[0]=>"+branchCode);
			productList=this.mytemplate.queryForList(query, new Object[]{branchCode});
		}
		catch (Exception e) {
			logger.debug("Exception @ {" + e + "}");
		}
		
		return productList;
	}
	public List<Map<String,Object>> getUnderWritterDropDown(String branchCode) {
		
		List<Map<String,Object>> uwList=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_GETUWList);
		    logger.info("Select Query=>"+query);
		    logger.info("Args[0]=>"+branchCode);
		    logger.info("Args[1]=>"+"Y");
		    uwList=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
	    
	    return uwList;
	}
	
	public List<Map<String,Object>> getDepartmentDropDown(String branchCode,String productCode,String status){
		
		List<Map<String,Object>> department=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_DEPARTMENTLIST);
		    logger.info("Select Query=>"+query);
		    logger.info("Args[0]=>"+branchCode);
		    logger.info("Args[1]=>"+productCode);
		    logger.info("Args[2]=>"+status);
		    department=this.mytemplate.queryForList(query,new Object[]{branchCode,productCode,status});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");	
		}
	    
	    return department;
	
	}
	
    public List<Map<String,Object>> getPolicyBranchDropDown(String branchCode) {
			
			List<Map<String,Object>> policyBranch=new ArrayList<Map<String,Object>>();
			try{
			    String query=getQuery(DBConstants.COMMON_SELECT_POLICYBRANCHLIST);
			    logger.info("Select Query=>"+query);
			    logger.info("Args[0]=>"+branchCode);
			    logger.info("Args[1]=>"+"Y");
			    policyBranch=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
			}catch(Exception e){
				logger.debug("Exception @ {" + e + "}");	
			}
		    
		    return policyBranch;
		}
	    
	 
	 public List<Map<String,Object>> getPersonalInfoDropDown(String branchCode,String customerType) {
			
			List<Map<String,Object>> personalInfo=new ArrayList<Map<String,Object>>();
			try{
			    String query=getQuery(DBConstants.COMMON_SELECT_PERSONALINFOLIST);
			    logger.info("Select Query=>"+query);
			    logger.info("Args[0]=>"+branchCode);
			    logger.info("Args[1]=>"+customerType);
			    logger.info("Args[2]=>"+"Y");
			    personalInfo=this.mytemplate.queryForList(query,new Object[]{branchCode,customerType,"Y"});
			}catch(Exception e){
				logger.debug("Exception @ {" + e + "}");	
			}
		    
		    return personalInfo;
		}
	 //DEPARTMENT REPORT....
	 public List<Map<String,Object>> getDeptName(String branchCode) {
			
			List<Map<String,Object>> personalInfo=new ArrayList<Map<String,Object>>();
			try{
			    String query=getQuery(DBConstants.COMMON_SELECT_DEPTNAME);
			    logger.info("Select Query=>"+query);
			    logger.info("Branch Code==>Args[0]=>"+branchCode);
			   // logger.info("Product Code==>Args[1]=>"+productid);
			    //logger.info("Args[2]=>"+"H");
			    personalInfo=this.mytemplate.queryForList(query,new Object[]{branchCode});
			}catch(Exception e){
				logger.debug("Exception @ {" + e + "}");	
			}
		    
		    return personalInfo;
		}
	 
	 public  List<Map<String,Object>> getConstantDropDown(String categoryId) {
		 	
		 	List<Map<String,Object>> constantList=new ArrayList<Map<String,Object>>();
			try{
			    String query=getQuery(DBConstants.COMMON_SELECT_GETCONSTDET);
			    logger.info("Select Query=>"+query);
			    logger.info("Args[0]=>"+categoryId);
			    logger.info("Args[1]=>"+"Y");
			    constantList=this.mytemplate.queryForList(query,new Object[]{categoryId,"Y"});
			}catch(Exception e){
				logger.debug("Exception @ {" + e + "}");	
			}
		    
		    return constantList;
		}
	 
	 public List<Map<String,Object>> getCurrencyMasterDropDown(String branchCode,String countryId) {
		 	logger.info("DropDownControllor getCurrencyMasterDropDown() || Enter  branchCode=>"+branchCode+"countryId=>"+countryId);
		 	List<Map<String,Object>> personalInfo=new ArrayList<Map<String,Object>>();
			try{
			 	String query=getQuery(DBConstants.COMMON_SELECT_GETCURRENCYLIST);
			    logger.info("Select Query=>"+query);
			    logger.info("Args[0]=>"+branchCode);
			    logger.info("Args[1]=>"+countryId);
			    logger.info("Args[2]=>"+"Y");
			    personalInfo=this.mytemplate.queryForList(query,new Object[]{branchCode,countryId,"Y"});
			}catch(Exception e){
				logger.debug("Exception @ {" + e + "}");
			}
		    
		    return personalInfo;
	}
	 
	 public List<Map<String,Object>> getTerritoryDropDown(String branchCode) {
			 
			 List<Map<String,Object>> territorty=new ArrayList<Map<String,Object>>();
			 try{
				 String query=getQuery(DBConstants.COMMON_SELECT_GETTERRITORYLIST);
				 logger.info("Select Query=>"+query);
				 logger.info("Args[0]=>"+branchCode);
				 logger.info("Args[1]=>"+"Y");
				 territorty=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
			 }catch(Exception e){
				 logger.debug("Exception @ {" + e + "}"); 
			 }
			 
			 return territorty;
		}
	 								
	 public String GetExchangeRate(final String location,final String date,final String countryid,final String branchCode) {
		   String exRate="";
		   try{
			   String query=getQuery(DBConstants.COMMON_SELECT_STARTDTOFMONTH);
			   logger.info("Select Query=>"+query);
			   logger.info("Args[0]=>"+date);
			   String startDtOfMonth=(String)this.mytemplate.queryForObject(query,new Object[]{date},String.class);
			   logger.info("Result=>"+startDtOfMonth);
			   if(!"01/".equalsIgnoreCase(startDtOfMonth))
			   {
				   query=getQuery(DBConstants.COMMON_SELECT_EXRATE);
				   logger.info("Select Query=>"+query);
				   logger.info("Args[0]=>"+location);
				   logger.info("Args[1]=>"+countryid);
				   logger.info("Args[2]=>"+startDtOfMonth);
				   logger.info("Args[3]=>"+branchCode);
				   List<Map<String,Object>> list=this.mytemplate.queryForList(query,new Object[] {location,countryid,startDtOfMonth,branchCode});
				   logger.info("List Size=>"+list.size());
				   if(list!=null&&list.size()>0)
				   {
					   Map<String,Object> map=(Map<String,Object>)list.get(0);
					   exRate=map.get("EXCHANGE_RATE")==null?"":map.get("EXCHANGE_RATE").toString();
				   }
			   }
		   }catch(Exception e){
				 logger.debug("Exception @ {" + e + "}");	 
		  }
		  
		  return exRate;
	}
	
	 public static String formatter(final String value)
		{
			String output="0.00";
			if(StringUtils.isNotBlank(value))
			{
			double doublevalue=Double.parseDouble(value);
			DecimalFormat myFormatter = new DecimalFormat("###,###,###,###,##0.00");
		    output =myFormatter.format(doublevalue);
			}
		    return output;
		}

	public static String GetDesginationCountry(final String limitOrigCur,final String ExchangeRate) {
	    String valu="0";
	    if (StringUtils.isNotBlank(limitOrigCur)&& Double.parseDouble(limitOrigCur) != 0) {
	    	double originalCountry = Double.parseDouble(limitOrigCur)/ Double.parseDouble(ExchangeRate);
			DecimalFormat myFormatter = new DecimalFormat("###0.00");
		    final double dround = Math.round(originalCountry * 100.0) / 100.0;
			valu = myFormatter.format(dround);
		}
		return valu;
	}

	public int getMaxID(final String tableName,final String fieldName)
				 {
		String query;
		int maxId;
		query = "SELECT NVL(MAX(" + fieldName + "),0)+1 FROM " + tableName +" ";
		logger.info("query is"+query);
		maxId=this.mytemplate.queryForInt(query);
		logger.info("Max Id =>"+maxId);
		return maxId;
	}
	public Date stringToDate(final String dateStr)  {

		Date result=new Date();
		DateFormat formatter;
		if (dateStr.length() == 0) {
			result = new Date();
		} else {
			try {
				formatter = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
				result = (Date) formatter.parse(dateStr);
			} catch (Exception e) {
				logger.debug("Exception @ {" + e + "}");
			}
		}
		return result;
	}
		
	public String stringArrayToString(final String[] value,
			final String delimiter)  {
		final StringBuffer result=new StringBuffer();
		if (value == null) {
			result.append("");
		} else {
			result.append(value[0]);
			for (int i = 1; i < value.length; i++) {
				result.append(delimiter + value[i]);
			}
		}
		return result.toString();
	}
	public String[] stringToStringArray(final String value,
			final String delimiter)  {
		String[] result;
		if (value == null) {
			result = new String[0];
		} else {
			result = value.split(delimiter);
		}
		return result;
	}
	
	public List<Map<String,Object>> getRiskGradeDropDown(String branchCode)   {
		 
		 List<Map<String,Object>> riskGrade=new ArrayList<Map<String,Object>>();
		 try{
			 String query=getQuery(DBConstants.COMMON_SELECT_GETRISKGRADELIST);
			 logger.info("Select Query=>"+query);
			 logger.info("Args[0]=>"+branchCode);
			 logger.info("Args[1]=>"+"Y");
			 riskGrade=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		 }catch(Exception e){
				logger.debug("Exception @ {" + e + "}");	
		 }
		 
		 return riskGrade; 
	}
	
	public List<Map<String,Object>> getCategoryZoneDropDown(String branchCode)   {
		
		List<Map<String,Object>> categoryZone=new ArrayList<Map<String,Object>>();
		try{
			 String query=getQuery(DBConstants.COMMON_SELECT_GETCATEGORYZONELIST);
			 logger.info("Select Query=>"+query);
			 logger.info("Args[0]=>"+branchCode);
			 logger.info("Args[1]=>"+"Y");
			 categoryZone=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		 }catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		 }
		 
		 return categoryZone;
	}
	public List<Map<String,Object>> getBankMasterDropDown(String branchCode)   {
		
		List<Map<String,Object>> bankMaster=new ArrayList<Map<String,Object>>();
		try{
			String query=getQuery(DBConstants.COMMON_SELECT_BANKMASTERLIST);
			logger.info("Select Query=>"+query);
			logger.info("Args[0]=>"+branchCode);
			logger.info("Args[1]=>"+"Y");
			bankMaster=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
		return bankMaster;
	}

	public String getDepartmentName(String branchCode, String productCode,String deptCode)
	{
		
		String deptName="";
		try{
			String query=getQuery(DBConstants.COMMON_SELECT_GETDEPTNAME);
			logger.info("Select Query =>"+query);
			logger.info("Args[0]=>"+branchCode);
			logger.info("Args[1]=>"+productCode);
			logger.info("Args[2]=>"+deptCode);
			deptName=(String)this.mytemplate.queryForObject(query,new Object[]{branchCode,productCode,deptCode},String.class);
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");	
		}
		
		return deptName;
	}
	public String getCompanyName(String branchCode, String custId,String custType) 
	{
		
		String compName="";
		try{
			if(custId!=null && !"".equals(custId)&& !"0".equals(custId)){
			String query=getQuery(DBConstants.COMMON_SELECT_GETCOMPNAME);
			logger.info("Select Query =>"+query);
			logger.info("Args[0]=>"+branchCode);
			logger.info("Args[1]=>"+custId);
			logger.info("Args[2]=>"+custType);
			compName=(String)this.mytemplate.queryForObject(query,new Object[]{branchCode,custId,custType},String.class);
			}
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
		return compName;
	}
		
	public synchronized String getPolicyNo(String seqID,String productID,String branchCode){ 
		
		String policyNo="";
		try{
			/*For Oracle DataBase Policy Number generated based on Sequence by sathish on 09Mar13 || Start
			 */  
			String query=getQuery(DBConstants.COMMON_SELECT_SEQNAME);
			logger.info("Query=>"+query);
			logger.info("Sequenct ID=>"+seqID+" Product ID=>"+productID+" Branch Code=>"+branchCode+"Status=>Y");
			String seqName=(String)this.mytemplate.queryForObject(query,new Object[]{seqID,productID,branchCode,"Y"},String.class);
			logger.info("Result=>"+seqName);
			query=getQuery(DBConstants.COMMON_SELECT_POLICYNO1)+" "+seqName+getQuery(DBConstants.COMMON_SELECT_POLICYNO2);
			logger.info("Query=>"+query);
			policyNo=(String)this.mytemplate.queryForObject(query,String.class);
			logger.info("Result=>"+policyNo);
			/*For Oracle DataBase Policy Number generated based on Sequence by sathish on 09Mar13 || End
			For MySql DataBase Policy Number generated based on SequenceMaster maintain the maxVal of SeqNo by sathish on 09Mar13 || Start
			*/
			/*String query=getQuery(DBConstants.COMMON_SELECT_POLICYNO);
			logger.info("Query=>"+query);
			logger.info("Sequenct ID=>"+seqID+" Product ID=>"+productID+" Branch Code=>"+branchCode+"Status=>Y");
			policyNo=(String)this.mytemplate.queryForObject(query,new Object[]{seqID,productID,branchCode,"Y"},String.class);
			logger.info("Result=>"+policyNo);
			query=getQuery(DBConstants.COMMON_UPDATE_POLICYNO);
			logger.info("Query=>"+query);
			logger.info("Policy No=>"+policyNo+"Sequenct ID=>"+seqID+" Product ID=>"+productID+" Branch Code=>"+branchCode+"Status=>Y");
			int res=this.mytemplate.update(query,new Object[]{policyNo,seqID,productID,branchCode,"Y"});
			logger.info("Result=>"+res);*/
			//For MySql DataBase Policy Number generated based on SequenceMaster maintain the maxVal of SeqNo by sathish on 09Mar13 || End
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
		return policyNo;
	}
	
	public String getSysDate()
	{
		
		String sysDate="";
		try{
			String query=getQuery(DBConstants.COMMON_SELECT_GETSYSDATE);
			logger.info("Select Query =>"+query);
			sysDate=(String)this.mytemplate.queryForObject(query,String.class);
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
		return sysDate;
	}
	public String getUWLimmit(String loginId,String processId,String productId,String deptId)
	{
		
		String uwLimit=null;
		try{
				logger.info("Select Query====>"+getQuery(DBConstants.COMMON_SELECT_GETUWLIMIT));
				logger.info("Arg[0]=>"+loginId);
				logger.info("Arg[1]=>"+processId);
				logger.info("Arg[2]=>"+productId);
				logger.info("Arg[3]=>"+deptId);
				logger.info("Arg[4]=>"+"1");
				List<Map<String,Object>> uwList=null;
				uwList=this.mytemplate.queryForList(getQuery(DBConstants.COMMON_SELECT_GETUWLIMIT),new Object[]{loginId,processId,productId,deptId,"1"});
				if(uwList!=null && uwList.size()>0)
				{
					Map<String,Object> uwMap=(Map<String,Object>)uwList.get(0);
					uwLimit=uwMap.get("UWLIMIT")==null?"0":uwMap.get("UWLIMIT").toString();
				}else
					uwLimit ="0";
				logger.info("UW Limit==>"+uwLimit);
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");	
		}
		
		return uwLimit;
	}
	public  List<Map<String,Object>> getLoginIdDropDown(String branchCode,String userType)  {
		
		List<Map<String,Object>> loginIdList=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_LOGINIDLIST);
		    logger.info("Select Query=>"+query);
		    logger.info("Args[0]=>"+branchCode);
		    logger.info("Args[1]=>"+userType);
		    logger.info("Args[2]=>"+"1");
		    loginIdList=this.mytemplate.queryForList(query,new Object[]{branchCode,userType,"1"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
	    return loginIdList;
	}
	public List<Map<String,Object>> getModeOfTransportDropDown(String branchCode) {
		
		List<Map<String,Object>> countryList=new ArrayList<Map<String,Object>>();
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_MODEOFTRANSPORT);
		    logger.info("Select Query=>"+query);
		    logger.info("Args[0]=>"+branchCode);
		    logger.info("Args[1]=>"+"Y");
		    countryList=this.mytemplate.queryForList(query,new Object[]{branchCode,"Y"});
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");	
		}
		
	    return countryList;
	}
	public boolean getPLCLCountStatus(String contractNo,String layerNo) {
		
		boolean  status=false;
		try{
		    String query=getQuery(DBConstants.COMMON_SELECT_GETPRCLCOUNT);
		    logger.info("Select Query=>"+query);
		    logger.info("Args[0][2]=>"+contractNo);
		    logger.info("Args[1][3]=>"+layerNo);
		    int plclCount=this.mytemplate.queryForInt(query,new Object[]{contractNo,layerNo,contractNo,layerNo});
		    logger.info("Result=>"+plclCount);
		    if(plclCount>0)
		    	status=true;
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
	    return status;
	}
	public String getRenewalCopyQuote(final String productId,final String branchCode,final String poposalNo){
		
		String newPoposalNo="";
		try {
			String spName=getQuery(DBConstants.FAC_SP_RENEWALCOPYQUOTE);
	 		logger.info("SP Name=>"+spName);
	 		logger.info("Product Id=>"+productId);
	 		logger.info("Branch Code=>"+branchCode);
	 		logger.info("Proposal No=>"+poposalNo);
	 		 int cstmt=this.mytemplate.queryForInt(spName,new Object[]{productId,branchCode,poposalNo});
	 		 logger.info("Count==> " + cstmt);
		}catch(Exception e)
		{
			logger.debug("Exception @ {" + e + "}");
		}
		
		return 	newPoposalNo;
	}
	public String decimalFormat(final double number, final int nos) {
		
		String noFmt="0";
		try{
			String digit = "0.00";
			 noFmt= String.valueOf(number);
			switch (nos) {
			case 0:
				digit = "###,###";
				break;
			case 1:
				digit = "##,##0.0";
				break;
			case 2:
				digit = "##,##0.00";
				break;
			case 3:
				digit = "##,##0.000";
				break;
			case 4:
				digit = "##,##0.0000";
				break;
			case 5:
				digit = "##,##0.00000";
				break;
			case 6:
				digit = "##,##0.000000";
				break;
			default:
				digit = "0.00";
			}
			java.text.NumberFormat fmtNo;
			fmtNo = new java.text.DecimalFormat(digit);
			noFmt = fmtNo.format(number);
		}catch(Exception e){
			logger.debug("Exception @ {" + e + "}");
		}
		
		return noFmt;
	}
	public boolean getMode(final String proposalNo,final int instNo,final String endtNo,final int mode) {
		
		Object[] args=new Object[3];
		boolean flag=false;
		try {
			args[0] = proposalNo;
			args[1] = instNo+"";
			args[2] = endtNo;
			String query="";
			if(mode==1)
				query=getQuery(DBConstants.RISK_SELECT_GETINSTNO);
			else if(mode==2)
				query=getQuery(DBConstants.RISK_SELECT_GETRETROCNT);
			else if(mode==3)
				query=getQuery(DBConstants.RISK_SELECT_RETROCESSCNT);
			logger.info("Query=>"+query);
			logger.info("Args[]=>"+StringUtils.join(args,","));
			int count=this.mytemplate.queryForInt(query,args);
			logger.info("Result=>"+count);
			if (count==0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			logger.debug("Exception @ {" + e + "}");
		}
		
		return flag;
	}
	
	public String getRiskComMaxAmendId(final String proposalNo) {
		
		String result="";
		try{
			String selectQry = getQuery(DBConstants.RISK_SELECT_RISKCOMMAXAMENDID); 
			logger.info("Select Qry=>" + selectQry);
			logger.info("Args[0]=>" + proposalNo);
			result = this.mytemplate.queryForObject(selectQry,new String[]{proposalNo},String.class).toString();
		}catch(Exception e)
		{
			logger.debug("Exception @ {" + e + "}");
		}
		
		return result;
	}
	public Object[] getIncObjectArray(Object[] srcObj,Object[] descObj){
		final Object[] tempObj = new Object[srcObj.length];
		System.arraycopy(srcObj, 0, tempObj, 0, srcObj.length);
		srcObj=new Object[tempObj.length+descObj.length];
		System.arraycopy(tempObj, 0, srcObj, 0, tempObj.length);
		System.arraycopy(descObj, 0, srcObj, tempObj.length, descObj.length);
		return srcObj;
	}
}
