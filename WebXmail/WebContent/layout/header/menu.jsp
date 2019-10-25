<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page isELIgnored="false"%>
<style>
<!--
.navbar .navbar-toggle {
	text-decoration: none;
	color: #224396;
	margin-top: 25px;
	margin-right: 20px;
}

.navbar .navbar-toggle:before {
	content: 'menu';
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
	padding: 8px 25px;
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
</style>


<div class="col-xs-12 col-md-8">

	<div id="ddtopmenubar" class="mattblackmenu">
		<ul class="nav navbar-nav navbar-right">
			<s:iterator value="%{#session.MenuList}" var="menuList" status="stat">
				<li class="dropdown"><s:if
						test='%{PARENT_MENU==null && !"99999".equals(MENU_ID) && !"Parent".equals(MENU_NAME)}'>
						<li><b><a href="<s:property value="MENU_URL"/>" />
							<s:property value="MENU_NAME" /></a></b></li>
					</s:if> <s:elseif test='PARENT_MENU=="99999"'>
						<s:if test='PARENT_MENU=="99999" && MENU_ID=="379"'>
							<b><a href="<s:property value="MENU_URL"/>"
								class="dropdown-toggle" data-toggle="dropdown" role="button" />
							<s:property value="MENU_NAME" /> </a></b>
						</s:if>
						<s:else>
							<b><a href="<s:property value="MENU_URL"/>"
								class="dropdown-toggle" />
							<s:property value="MENU_NAME" /> </a></b>
						</s:else>
						<ul class="dropdowns"
							style="width: max-content; padding-left: 0px;">
							<s:iterator value="%{#session.MenuList}" var="menuSubList"
								status="stat">
								<s:if test="#menuSubList.PARENT_MENU == #menuList.MENU_ID">
									<li><b><a href="<s:property value="MENU_URL"/>" />
										<s:property value="MENU_NAME" /></a></b></li>
								</s:if>
							</s:iterator>
						</ul>
					</s:elseif> <s:elseif test='%{PARENT_MENU==null}'>
						<li><b><a href="<s:property value="MENU_URL"/>" />
							<s:property value="MENU_NAME" /></a></b></li>
					</s:elseif></li>
			</s:iterator>
		</ul>
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