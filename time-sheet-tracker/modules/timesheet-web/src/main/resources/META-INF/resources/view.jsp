<%-- <%@ include file="/init.jsp" %>

<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>

</div>
<div class="col-8">

</div>
</div>
 --%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<% 

List<Role>roles=(List<Role>)request.getAttribute("role");
System.out.println(roles);
for(Role role:roles)
{
	if(role.getName().equalsIgnoreCase("Project Manager")){
		
	%>
	<div class="row">
  <div class="col-4">
   <%@ include file="/timesheet_sidebar.jsp" %>

</div>
<div class="col-8">

</div>
</div>
<%} %>
	
	<% 	
	if(role.getName().equalsIgnoreCase("Project Resource")){
		//long employeeId=(Long)request.getAttribute("employee");
		//System.out.println("1"+employeeId);
		//request.setAttribute("employeeId",employeeId);
	%>
	 <%@ include file="/resource_activity.jsp" %>
	 
	<%
}}

%>
