
<%@ include file="/WEB-INF/views/taglibs.jsp"%>
<z:layout pageTitle="View Activites">
	
	<div class="panel panel-default">
	  <!-- Default panel contents -->
	  <div class="panel-heading">Recent Activities</div>
	  <div class="panel-body">
	    <p>This is where you can review and export your recent Nike+ activities.</p>
	  </div>
	
	  <!-- Table -->
	  <table class="table">
	  	<thead>
	  		<tr>
		  		<th>Activity ID</th>
		  		<th>Activity Type</th>
		  		<th>Start Time</th>
		  		<th>Export</th>
	  		</tr>
	  	</thead>
	  	<tbody>
	  		<core:if test="${empty activities }">
	  			<th><td colspan="4">No Activities found with that ID</td></th>
	  		</core:if>
	  		<core:forEach var="activity" items="${activities}" >
	  			<tr>
	  				<td>
	  					${activity.activityId }
	  				</td>
	  				<td>
	  					${activity.activityType }
	  				</td>
	  				<td>
	  					${activity.startTime }
	  				</td>
	  				<td>
	  					<core:url value="/apps/export" var="exportURL">
	  						<core:param name="activityId" value="${activity.activityId }" />
	  					</core:url>
	  					<a href="${exportURL }">export</a>
	  				</td>
	  			</tr>
	  		</core:forEach>
	  	</tbody>  
	  </table>
	</div>
	
</z:layout>