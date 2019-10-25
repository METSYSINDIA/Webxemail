<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@page contentType="text/html" pageEncoding="UTF-8" isELIgnored="false"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>WebXmail</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  

</head>
<body class="search-page">
	<div class="page-loader-wrapper">
		<div class="loader">
			<div class="md-preloader pl-size-md">
				<svg viewbox="0 0 75 75">
                <circle cx="37.5" cy="37.5" r="33.5" class="pl-red"
						stroke-width="4" />
            </svg>
			</div>
			<p>Please wait...</p>
		</div>
	</div>
	<nav class="navbar">
		<div class="nav container-fluid">
			<tiles:insertAttribute name="header" />
		</div>
	</nav>
	<section class="content">
		<div class="container-fluid">
			<tiles:insertAttribute name="body" />
		</div>
	</section>
	<div class="legal">
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- Jquery Core Js -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery/jquery.min.js"></script>

	<!-- Bootstrap Core Js -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/bootstrap/js/bootstrap.js"></script>

	<!-- Waves Effect Plugin Js -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/node-waves/waves.js"></script>

	<!-- Validation Plugin Js -->
	<script
		src="<%=request.getContextPath()%>/assets/plugins/jquery-validation/jquery.validate.js"></script>

	<script src="<%=request.getContextPath()%>/assets/js/app-js.js"
		type="text/javascript"></script>
</body>
</html>

