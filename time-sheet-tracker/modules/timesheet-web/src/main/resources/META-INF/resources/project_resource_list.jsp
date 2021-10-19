<%@ include file="/init.jsp" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<liferay-portlet:renderURL var="resourceUrl">
        <portlet:param name="mvcPath" value="/project_resource.jsp" />
</liferay-portlet:renderURL>

<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">


<a href="${resourceUrl}" ><button type="button" class="btn btn-success">Add  ProjectResource</button></a>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">S.N.</th>
      <th scope="col">Project</th>
      <th scope="col">Task</th>
      <th scope="col">Resource</th>
      
    </tr>
  </thead>
  <tbody>
   
    <%int i=1; %>
    <%
   
  ProjectResourceLocalService projectResourceLocalService=(ProjectResourceLocalService)request.getAttribute("_projectResourceLocalService"); %>
    <%List<ProjectResource>projectResources=projectResourceLocalService.getProjectResources(0, projectResourceLocalService.getProjectResourcesCount());
   
    for(ProjectResource projectResource:projectResources){
    
   %>
     <tr>
      <td><%=i++ %></td>
      <%
    ProjectLocalService projectlocalservice=(ProjectLocalService)request.getAttribute("_projectLocalService"); 
    Project project=projectlocalservice.getProject(projectResource.getProjectId());
    
   
    
    EmployeeLocalService employeeLocalService=(EmployeeLocalService)request.getAttribute("_employeeLocalService");
    Employee employee=employeeLocalService.getEmployee(projectResource.getEmployeeId());
   %>
      <td><%=project.getName() %></td>
    
      
      <td><%=employee.getFirstName() %></td>
      <%} %>
    </tr>
   
  </tbody>
</table>
</div>
</div>