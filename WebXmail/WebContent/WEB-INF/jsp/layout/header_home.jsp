<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<style>
<!--
.navbar .navbar-toggle {
	text-decoration: none;
	color: #224396;
	margin-top: 25px;
	margin-right: 30px;
}

.navbar .navbar-toggle:before {
	background: url(<%= request.getContextPath ()%>/images/menu_icon.png)
		no-repeat;
	content: 'circle';
	font-size: 20px;
}
/* ul li{
        display: inline-block;
        position: relative;
        line-height: 21px;
        text-align: left;
    }*/
ul li a {
	display: block;
	padding: 8px 9px;
	color: #224396;
	text-decoration: none;
}

ul li a:hover {
	color: #00000;
	background: #f36f22;
}

ul li ul.dropdowns {
	min-width: 100%; /* Set width of the dropdown */
	background: #f2f2f2;
	display: none;
	position: absolute;
	z-index: 999;
	left: 0px;
}

ul li:hover ul.dropdowns {
	display: block; /* Display the dropdown */
}

ul li ul.dropdowns li {
	display: block;
}

.col-md-11 {
	width: 150.666667%;
}

.navbar .navbar-nav {
	margin-top: 0px;
}
</style>
<div class="navbar-header col-xs-12">
	<a href="javascript:void(0);" class="navbar-toggle collapsed"
		data-toggle="collapse" data-target="#navbar-collapse"
		aria-expanded="false"></a> <a class="navbar-brand" href="#"
		onclick="getHome('Loginwelcome.action','<s:property value="#session.UserId"/>');"
		style="padding: 5px 15px;"> <img alt="Bupa Logo"
		src="<%=request.getContextPath()%>/images/Vision-Ins-Logo.png" />
	</a>
	<h4 align="center" align="center" style="color: #f36f22;">
		<b style="color: #224396; font-size: 30px;"> <s:text
				name="EAPP FOR AUDIT"></s:text></b>
	</h4>
</div>

<div class="collapse navbar-collapse" id="navbar-collapse">
	<ul class="nav navbar-nav navbar-right">
		<s:if test="#session.UserId!='guest'">
			<a class="open-login-form"
				href="${pageContext.request.contextPath}/Loginwelcome.action"><span
				class="fa fa-home"></span>&nbsp;Home</a>|&nbsp;&nbsp;Login Id:&nbsp;&nbsp;<s:property
				value="#session.UserId" />&nbsp;&nbsp;|&nbsp;&nbsp;<a
				class="open-login-form"
				href="${pageContext.request.contextPath}/Loginout.do"><span
				class="fa fa-user">&nbsp;</span>Logout </a>&nbsp;&nbsp;&nbsp;&nbsp;
	       </s:if>
	</ul>

	<div class="col-xs-12 col-md-12 nav navbar-nav navbar-left">
		<!--<div class="col-xs-12 col-md-11" align="right" style="padding-right: 140px;">
			<h4 align="center"  style="color: #f36f22;">
				<b style="color: #224396;font-size: 30px;"><s:text name="VISIONPAY"></s:text> </b>
			</h4>
			<h4 align="center"  style="color: #f36f22;">
				<b style="font-size: 15px;"><s:text name="Online Debit / Credit card payments for Policies &amp; Claim Excess"></s:text> </b>
			</h4>
			</div><div class="col-xs-12 col-md-1" >
    		</div>
			-->
			<div id="ddtopmenubar" class="mattblackmenu">
	<ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
			<b>
				<a href="/loginCreationAdmin.action?mode=UC" class="dropdown-toggle">PENDING PROCESS</a>
			</b>
			<ul class="dropdowns" style="width: max-content;padding-left: 0px;"></ul>
		</li>
		<li class="dropdown">
			<b>
				<a href="/loginCreationAdmin.action?mode=AC" class="dropdown-toggle">COMPLETED PROCESS </a>
			</b>
			<ul class="dropdowns" style="width: max-content;padding-left: 0px;"></ul>
		</li>
		<li class="dropdown">
			<b>
				<a href="/loginCreationAdmin.action?mode=AC" class="dropdown-toggle">INPROGRASS PROCESS </a>
			</b>
			<ul class="dropdowns" style="width: max-content;padding-left: 0px;"></ul>
		</li>
		<li class="dropdown">
			<b>
				<a href="${pageContext.request.contextPath}/initClientMgt.do">CLIENT MANGEMENT</a>
			</b>
			<ul class="dropdowns" style="width: max-content;padding-left: 0px;"></ul>
		</li>
		<%-- <li class="dropdown">
			<b>
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button">CONSUULTING</a>
			</b>
			<ul class="dropdowns" style="width: max-content;padding-left: 0px;">
				<li>
					<b>
						<a href="${pageContext.request.contextPath}/incomeTaxConslt.do">INCOME TAX</a>
					</b>
				</li>
				<li>
					<b>
						<a href="${pageContext.request.contextPath}/reportPayment.action?menuType=S">NGO</a>
					</b>
				</li>
				<li>
					<b>
						<a href="/reportPayment.action?menuType=F">MSME</a>
					</b>
				</li>
			</ul>
		</li> --%>
		<li class="dropdown"></li>
	</ul>
</div>
			
</div>
</div>

<s:form name="homeMenu">
	<s:hidden name="mode" id="mode" />
</s:form>
<script type="text/javascript">
function getHome(page,user) {

if(user!='guest'){
	document.forms['homeMenu'].action = "${pageContext.request.contextPath}/"+page;
	document.forms['homeMenu'].submit();
}
}
function getHomeMode(page,mode) {
	document.forms['homeMenu'].action = "${pageContext.request.contextPath}/"+page;
	document.forms['homeMenu'].mode.value = mode;
	document.forms['homeMenu'].submit();
}
function UserManual() {
	var URL = "${pageContext.request.contextPath}/userManualReport.action";
	var windowName = "QuotatiionPrint";
	var width  = screen.availWidth;
	var height = screen.availHeight;
	var w = 900;
	var h =	500;
	var features =
		'width='          + w +
		',height='		  + h +
		',left='		  + ((width - w - 10) * .5)  +
		',top='			  + ((height - h - 30) * .5) +
		',directories=no' +
		',location=no'	  +
		',menubar=no'	  +
		',scrollbars=yes' +
		',status=no'	  +
		',toolbar=no'	  +
		',resizable=true';
	var strOpen = window.open (URL, windowName, features);
	strOpen.focus();
	return false;
	}
</script>