<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="//ajax.googleapis.com/ajax/libs/jqueryui/1.9.0/themes/base/jquery-ui.css" />
<link rel="icon" type="image/gif" href="${pageContext.request.contextPath}/images/favicon.ico" />
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.1/jquery-ui.min.js"></script>
<script type="text/javascript" src="${ pageContext.request.contextPath }/js/jquery.zclip.min.js" ></script>
<title>${pageTitle} | University of Wisconsin-Madison</title>

<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/main_no_top_nav.css" type="text/css" media="all" />
<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/site.css" type="text/css" media="all" />
<!--[if IE 6]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie6.css" type="text/css" media="screen" />
  <![endif]-->
<!--[if IE 7]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie7.css" type="text/css" media="screen" />
  <![endif]-->
<!--[if IE 8]>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ie8.css" type="text/css" media="screen" />
  <![endif]-->

</head>
<body>
	<div class="wrap">
		<div id="home">
			
			<div id="shell">
				<div id="sidebar" class="col">

					<ul id="secondary-nav">
						<li>
							<core:url value="/apps/login" var="LoginURL" />
							<a href="${LoginURL}">Login</a>
						</li>
						<li>
						    <core:url value="/apps/create" var="HomeTokenUrl" />
							<a href="${HomeTokenUrl}">Create Service Key</a>
						</li>
						<li>
						<hr class="sidebar" />
						</li>
					</ul>
				</div>
				<div id="content" class="main col">
				    <core:if test="${not empty errorMessage}">
					   	<div class="error">
					   		Error: <spring:message code="${errorMessage}" arguments="${zero}" />
					   	</div>
					</core:if>
				    <jsp:doBody />
				</div>
			</div>
		</div>

		<div id="footer">
			<p>Written by Tim Levett</p>
			<p>
				<a href="http://nocableneeded.blogspot.com">Contact Me</a>
			</p>
		</div>

	</div>
</body>
</html>