<%@ attribute name="pageTitle" required="true" type="java.lang.String"%>
<%@ include file="/WEB-INF/views/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- Jquery -->
<link rel="icon" type="image/gif" href="${pageContext.request.contextPath}/images/favicon.ico" />
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<!-- Bootstrap -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap.min.css"></link>

<!-- Optional theme -->
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.2/css/bootstrap-theme.min.css"></link>

<!-- Latest compiled and minified JavaScript -->
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.2/js/bootstrap.min.js"></script>
<title>${pageTitle} | Nike Plus Data Mapper</title>

<link rel="stylesheet"	href="${pageContext.request.contextPath}/css/site.css" type="text/css" media="all" />

</head>
<body>

<core:url value="/" var="rootURL" />

<nav class="navbar navbar-default" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="${rootURL }">TimTim</a>
  </div>
  
  <!-- Links -->
  
  
  <core:url value="/apps/Login" var="LoginURL" />
  <core:url value="/apps/logout" var="LogoutURL" />
  <core:url value="/apps/List" var="viewListActivityURL" />
  <!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
    <ul class="nav navbar-nav">
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Quick Links <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="${LoginURL}">Login</a></li>
          <li><a href="${viewListActivityURL}">View List of Activities</a></li>
          <li class="divider"></li>
		  <li><a href="https://developer.nike.com/console" target="_blank">Nike+ Console Login</a></li>
        </ul>
      </li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <core:if test="${not empty sessionScope.TOKEN }">
      	<li><a href="">Hello ${sessionScope.USERNAME }</a></li>
      	<li><a href="${LogoutURL}">Logout</a></li>
      </core:if>
      <core:if test="${empty sessionScope.TOKEN }">
      	<li><a href="${LogoutURL}">Login</a></li>
      </core:if>
    </ul>
  </div><!-- /.navbar-collapse -->
</nav>

<div class="panel panel-default">
  <div class="panel-body">
    <core:if test="${not empty error}">
	   	<div class="alert alert-danger">
	   		<b>Error: </b><spring:message code="${error}" arguments="${zero}" />
	   	</div>
	</core:if>
    <jsp:doBody />
  </div>
  <div class="panel-footer">
  	<p>Written by Tim Levett</p>
	<p>
		<a href="http://nocableneeded.blogspot.com">Contact Me</a>
	</p>
</div>
</body>
</html>