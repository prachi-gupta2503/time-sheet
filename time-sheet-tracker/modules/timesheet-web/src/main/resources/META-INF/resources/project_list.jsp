<%@ include file="/init.jsp" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<liferay-portlet:renderURL var="projecturl">
        <portlet:param name="mvcPath" value="/project.jsp" />
</liferay-portlet:renderURL>
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">


<a href="${projecturl}" ><button type="button" class="btn btn-success">Add Project</button></a>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">S.N.</th>
      <th scope="col">Name</th>
      
    </tr>
  </thead>
  <tbody>
   
    <%int i=1; %>
    <%
   
    ProjectLocalService projectlocalservice=(ProjectLocalService)request.getAttribute("_projectLocalService"); %>
    <%List<Project>projects=projectlocalservice.getProjects(0, projectlocalservice.getProjectsCount());
   
    for(Project project:projects){
    
   %>
      <tr>
      <td><%=i++ %></td>
      <td><%=project.getName() %></td>
      <%} %>
    </tr>
   
  </tbody>
</table>
</div>
</div>