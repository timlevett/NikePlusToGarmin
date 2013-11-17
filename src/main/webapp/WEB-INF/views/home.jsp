
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<z:layout pageTitle="Home">
	<h2 class="form-signin-heading">Welcome!</h2>
	<div class="alert alert-info">
		This should be the home page where we will put what you can do with this tool. 
	</div>
	<core:url var="viewActivityURL" value="/apps/List" />
	<a href="${viewActivityURL }">View List of Recent Activities</a>
</z:layout>