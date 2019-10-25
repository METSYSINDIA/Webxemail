<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="s" uri="/struts-tags"%>  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Dashboard</title>

  <!-- Custom fonts for this template -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">


  <!-- Custom styles for this page -->
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
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
  float: right;
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
div.row{
line-height: 1.6;
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


</style>

<body id="page-top">

 
         <s:form name="mailInfo" id="mailInfo" theme="simple" action="">

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">Mailing Details</h1>
            <a href="#" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i class="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
          </div>
           
		       <div class="row">
				<div class="col-xs-12" align="right">
					<button type="button" class="btn btn-success" onclick="addNew();" ><i class="fa fa-plus"></i>&nbsp;&nbsp;Add New </button>&nbsp;
				</div>
			</div>
       <div class="row">
 <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Mailing Id</th>
                      <th>Source File</th>
                      <th>Email Subject</th>
                      <th>UEL Domain</th>
                      <th>WebX id</th>
                      <th>Test Mail Id</th>
                      <th>Edit</th>
                    
                   </tr>
                  </thead>
                  <tfoot>
                    <tr>
                      <th>Mailing Id</th>
                      <th>Source File</th>
                      <th>Email Subject</th>
                      <th>UEL Domain</th>
                      <th>WebX id</th>
                      <th>Test Mail Id</th>
                      <th>Edit</th>
                    </tr>
                  </tfoot>
                  <tbody>
                 		<s:iterator value="mailDetailsList" var="mailListDt" status="stat">
									<tr>
									<td><s:property value='%{#mailListDt.WX_MAILING_SID}' /></td>
										<td><s:property value='%{#mailListDt.SOURCE_FILE}' /></td>
										<td><s:property value='%{#mailListDt.EMAIL_SUBJECT}' /></td>
										<td><s:property value='%{#mailListDt.URL_DOMAIN}' /></td>
										<td><s:property value='%{#mailListDt.WEBX_ID}' /></td>
										<td><s:property value='%{#mailListDt.TEST_MAIL}' /></td>
											<td align="center">
												<button type="button" class="btn btn-sm btn-info" onclick="fnEdit('<s:property value='%{#mailListDt.WX_MAILING_SID}' />','edit');" >
													<i class="fa fa-edit"></i>
												</button>
											</td>
																				</tr>
									</s:iterator>

                  </tbody>
                </table>
              </div>
         
          </div>
         </div>
         <s:hidden name="wxMailingSid"></s:hidden>
         <s:hidden name="mode"></s:hidden>
         
</s:form>
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

  <!-- Custom scripts for all pages-->
  <script src="js/sb-admin-2.min.js"></script>

  <!-- Page level plugins -->
  <script src="vendor/datatables/jquery.dataTables.min.js"></script>
  <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

  <!-- Page level custom scripts -->
  <script src="js/demo/datatables-demo.js"></script>

<script type="text/javascript">


function addNew(){
	document.mailInfo.action='${pageContext.request.contextPath}/initWxmail.do';
	document.mailInfo.submit();
}
function fnEdit(wxMailingSid,mode){
		document.mailInfo.wxMailingSid.value=wxMailingSid;
		document.mailInfo.mode.value=mode;
		document.mailInfo.action='${pageContext.request.contextPath}/editWxmail.do';
		document.mailInfo.submit();
	}
	</script>
	

</html>
