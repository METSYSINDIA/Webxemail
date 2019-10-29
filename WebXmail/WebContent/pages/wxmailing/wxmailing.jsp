<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

<style>
* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.columnleft {
  float: left;
  width: 15%;
  padding: 10px;
}

.columnright {
  float: left;
  width: 22%;
  padding: 10px;
}
label {
    /* Other styling... */
    text-align: right;
    clear: both;
    float:left;
    margin-right:1px;
}

.column {
  float: center;
  width: 62%;
  padding: 10px;
}

.break {
  flex-basis: 100%;
  height: 0;
}

.radio-inline,
.checkbox-inline {
  position: relative;
  display: inline-block;
  padding-left: 20px;
  margin-bottom: 0;
  font-weight: 400;
  vertical-align: middle;
  cursor: pointer;

  // These are used directly on <label>s
  &.disabled,
  fieldset[disabled] & {
    cursor: @cursor-disabled;
  }
}
.radio-inline + .radio-inline,
.checkbox-inline + .checkbox-inline {
  margin-top: 0;
  margin-left: 10px; // space out consecutive inline controls
}

.errorMessage {
  font-weight: bold;
  color: red;
}
</style>

<body id="page-top">

 

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Mailing Details</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
       <div class="row">
         <div class="columnleft">
         <br/>
         	 <div class="input-group">
         			<b><s:text name="IP set:"/></b>
       			 	 <s:select name="ipSet"  cssClass="nav-link dropdown-toggle"  list="#{'1':'Set1', '2':'Set2'}"/>
         	 </div>
         </div>
         <div class="column">
         <s:form name="mailInfo" id="mailInfo" theme="simple" action="">
         
          <s:if test="hasActionErrors()">
				<div class="row">
				</div>
			</s:if>	 
         <div class="row">
       		<div class="col-xs-12 col-md-12">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	               
	                  <label><b><s:text name="Source name:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	              `		 <s:fielderror fieldName="sourceFile"/>
	                    <s:textfield name="sourceFile" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-12">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	               
	                  <label><b><s:text name="Email Subject:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	                       <s:fielderror fieldName="emailSubject"/>
	                    <s:textfield name="emailSubject" cssErrorClass="emailSubject" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
			
			<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Email From:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	                	<s:fielderror fieldName="emailForm"/>
	                    <s:textfield name="emailForm" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="From Email:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="fromMail"/>
	                    <s:textfield name="fromMail" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
			
		<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="URL Domain:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	              		 <s:fielderror fieldName="urlDomain"/>
	                    <s:textfield name="urlDomain" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Webx ID:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="webxId"/>
	                    <s:textfield name="webxId" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="PowerMTA Name:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="powerMtaName"/>
	                    <s:textfield name="powerMtaName" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Return Path:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	              		 <s:fielderror fieldName="returnPath"/>
	                    <s:textfield name="returnPath" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
		<div class="row">
       		<div class="col-xs-12 col-md-12">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Test Mail:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	            	   <s:fielderror fieldName="testMail"/>
	                    <s:textfield name="testMail" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
			</div>
		</div>	
		<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Header Type:"/></b></label>
	               </div>
	               <div class="input-group">
	                <s:fielderror fieldName="headType"/>
 							 <s:radio name="headType" cssClass="radio" list="headTypeList" listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="headType" />	               
 					 </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Check Mode:"/></b></label>
	               </div>
	               <s:fielderror fieldName="checkMode"/>
 							 <s:radio  name="checkMode" list="checkModeList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="checkMode" />	               
	             </div>
	             </div>
			</div>
		<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Creative Type:"/></b></label>
	               </div>
	               <div class="input-group">
	               			<s:fielderror fieldName="createiveType"/>
 							 <s:radio name="createiveType" cssClass="radio" list="creativeTypeList" listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="createiveType" />	               
 					 </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Check Process:"/></b></label>
	               </div>
	               			<s:fielderror fieldName="checkProcess"/>
 							 <s:radio  name="checkProcess" list="checkProcessList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="checkProcess" />	               
	             </div>
	             </div>
			</div>		
			
			<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Mode:"/></b></label>
	               </div>
	               <div class="input-group">
	               			<s:fielderror fieldName="mailMode"/>
 							 <s:radio name="mailMode" cssClass="radio" list="wxModeList" listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="mailMode" />	               
 					 </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name=" Process:"/></b></label>
	               </div>
	               			<s:fielderror fieldName="mailProcess"/>	
 							 <s:radio  name="mailProcess" list="wxProcessList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="mailProcess" />	               
	             </div>
	             </div>
			</div>	
			<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="MTA:"/></b></label>
	               </div>
	               <div class="input-group">
	               			<s:fielderror fieldName="mta"/>	
 							 <s:radio name="mta" cssClass="radio" list="wxMtaList" listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="mta" />	               
 					 </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name=" Negative:"/></b></label>
	               </div>	
 							 <s:radio  name="negative" list="negativeList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" value="negative" />	               
	             </div>
	             </div>
			</div>	
		<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Check Count:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="mta"/>	
	                    <s:textfield name="checkCount" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="IP Queue Limit:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="ipQueueLine"/>	
	                    <s:textfield name="ipQueueLine" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
			
			<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Instance:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="instance"/>	
	                    <s:textfield name="instance" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Mail Per Min:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="mailPermit"/>	
	                    <s:textfield name="mailPermit" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
		<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="URL Pattern:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="urlPattern"/>	
	                    <s:select name="urlPattern" list="urlPatternList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" disabled="#disable" tooltip=""  cssClass="nav-link dropdown-toggle"  maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Image Pattern:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="imagePattern"/>	
	                    <s:select name="imagePattern" list="imgPatternList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" disabled="#disable" tooltip=""  cssClass="nav-link dropdown-toggle"  maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
			<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="TextLimit:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="textLimit"/>	
	                    <s:textfield name="textLimit" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Image Folder:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="imageFolder"/>	
	                    <s:textfield name="imageFolder" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
			<div class="row">
			<div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Landing Page Image:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		<s:fielderror fieldName="imageFolder"/>
	                    <s:textfield name="landingPageImg" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
	            <div class="col-xs-12 col-md-6">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	               
	                  <label><b><s:text name="OptOut page Image:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               <s:fielderror fieldName="optoutPageImg"/>
	                    <s:textfield name="optoutPageImg" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	                </div>
	             </div>
	             </div>
			</div>
		<div class="row">
       		<div class="col-xs-12 col-md-12">
			    <div class="input-group">
	               <div class="col-xs-12 col-md-4">
	                  <label><b><s:text name="Mail Content:"/></b></label>
	               </div>
	               <div class="col-xs-12 col-md-8">
	               		 <s:fielderror fieldName="mailContent"/>
						<s:textarea  name="mailContent" id="mailContent"  onkeyup="addFields()" onchange="addFields()" cols="40" rows="5"/>
						<a href="#" id="filldetails" onclick="addFields()">Fill Details</a>
	                </div>
	             </div>
			</div>
		</div>
		<div class="row">
		<div class="col-xs-12 col-md-12">
			    <div id="container"></div>
			</div>
			</div>
		<div class="row">
				<div class="col-xs-12 col-md-6" align="right">
					<input type="button" name="submitB" value="Submit" class="btn btn-sm btn-danger" onclick="fnSubmit()"/>
				</div>
				<div class="col-xs-12 col-md-6" align="right">
					<input type="button" name="submitc" value="Go To Process" class="btn btn-sm btn-success" onclick="fnSubmit()"/>
				</div>
		</div>
		 <s:hidden name="wxMailingSid"></s:hidden>
		</s:form>
         </div>
         <div class="columnright">
         <div class="row">
       		<div class="col-xs-12 col-md-12">
			    <div class="input-group">
	               
	               <div class="col-xs-12 col-md-12">
						<s:textarea label="Header" name="headerDesc" cols="40" rows="5"/>
	                </div>
	             </div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12 col-md-6">
			 
  						<s:select name="headerSelVal" list="headerTypeList"  listKey="WX_CONSTANT_VAL" listValue="WX_CONSTANT_NAME" disabled="#disable" tooltip="" cssClass="form-control dropdown-toggle" maxlength="100" />
	                	               
	             </div>
	            <div class="col-xs-12 col-md-6">
			  
	                    <s:textfield name="headerTxtVal" disabled="#disable" tooltip="" cssClass="form-control  charspaceOnly" maxlength="100" />
	               
	             </div>
			</div>
			<div class="row">
					<input type="button" name="submitB"  value="Update" class="btn btn-sm btn-danger" onclick="fnBack()"/>&nbsp;
					<input type="button" name="submitc" value="Save" class="btn btn-sm btn-success" onclick="fnSubmit()"/>
				<div class="col-xs-12 col-md-3" >
					<input type="button" name="submitB" value="Randomize" class="btn btn-sm btn-danger" onclick="fnBack()"/>
				</div>
				<div class="col-xs-12 col-md-3" >
					<input type="button" name="submitc" value="Refresh" class="btn btn-sm btn-success" onclick="fnSubmit()"/>
				</div>
		</div>
         </div>
        
          </div>
         </div>

        <!-- End of Main Content -->

      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span>Copyright &copy; Your Website 2019</span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->


  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>

  <!-- Logout Modal-->
  <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
          <button class="close" type="button" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">Ã</span>
          </button>
        </div>
        <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
        <div class="modal-footer">
          <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <a class="btn btn-primary" href="login.html">Logout</a>
        </div>
      </div>
    </div>
  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Page level plugins -->

<script type="text/javascript">
function fnSubmit(){
		document.mailInfo.action='${pageContext.request.contextPath}/saveWxmail.do';
		document.mailInfo.submit();
	}
function addFields(){
    // Number of inputs to create
   //  alert('number');
    var mailcont = document.getElementById("mailContent").value;
    document.getElementById("container").innerHTML = mailcont;

 //   var container = document.getElementById("container");
    }
	
	</script>
	

</html>
