<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">


<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">S.N.</th>
      <th scope="col">Employee</th>
       <th scope="col">Action</th>
      
      
    </tr>
  </thead>
  <tbody>
   
    <%int i=1; %>
    <%
    Set<Long>employeeList=new HashSet<Long>();
    Employee employee=null;
   EmployeeLocalService employeeLocalService=(EmployeeLocalService)request.getAttribute("_employeeLocalService");
   // List<Employee>employees=employeeLocalService.getEmployees(0, employeeLocalService.getEmployeesCount());
    ProjectResourceLocalService projectResourceLocalService=(ProjectResourceLocalService)request.getAttribute("_projectResourceLocalService");
 //   ProjectLocalService projectLocalService=(ProjectLocalService)request.getAttribute("_projectLocalService");
   
List<ProjectResource>projectResources= projectResourceLocalService.getProjectResources(0, projectResourceLocalService.getProjectResourcesCount());
   for(ProjectResource projectResource:projectResources)
   {
	   System.out.println(projectResource.getEmployeeId());
	   employeeList.add(projectResource.getEmployeeId());
   }
   System.out.println("size"+employeeList.size());
   for(long empId:employeeList){
	  employee=employeeLocalService.findByEmployeeId(empId);
   
%>
    <tr>
      <td><%=i++ %></td>
      <td><%= employee.getFirstName()+"  "+employee.getLastName() %></td>
      <td><a href="#">Assign Task</a></td>
      </tr>
  <%} %> 
</tbody>
</table>
</div>
</div>