<%@ include file="/init.jsp" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ include file="/project.jsp" %>
<liferay-portlet:renderURL var="projecturl">
        <portlet:param name="mvcPath" value="/project.jsp" />
</liferay-portlet:renderURL>


<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">


<button type="button" class="btn btn-success" id="<portlet:namespace/>mappingBtn"><liferay-ui:icon image="add" /> Project</button>

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
      <%String id=String.valueOf(project.getProjectId()); %>
      <liferay-portlet:renderURL var="taskurl">
        <portlet:param name="mvcPath" value="/task.jsp" />
        <portlet:param name="projectid" value="<%=id %>" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="resourceurl">
        <portlet:param name="mvcPath" value="/project_resource.jsp" />
       <portlet:param name="projectid" value="<%=id %>" />
</liferay-portlet:renderURL>
      <td><a href="${taskurl }"style="color:green">Task</a></td>
      <td><a href="${resourceurl }"style="color:green">Resource</a></td>
      <%} %>
    </tr>
   
  </tbody>
</table>

</div>
</div>