<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ page import="java.util.function.*" %>>
<%@ page import="java.util.stream.Collectors;" %>
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
   <p>Welcome  to liferay</p>
    <%int i=1; %>
    <%
  //  Set<Long>employeeList=new HashSet<Long>();
    //Employee employee=null;
   EmployeeLocalService employeeLocalService=(EmployeeLocalService)request.getAttribute("_employeeLocalService");
   // List<Employee>employees=employeeLocalService.getEmployees(0, employeeLocalService.getEmployeesCount());
    ProjectResourceLocalService projectResourceLocalService=(ProjectResourceLocalService)request.getAttribute("_projectResourceLocalService");
 //   ProjectLocalService projectLocalService=(ProjectLocalService)request.getAttribute("_projectLocalService");
   
List<ProjectResource>projectResources= projectResourceLocalService.getProjectResources(0, projectResourceLocalService.getProjectResourcesCount());
   
   
   List<Employee>emp=projectResources.stream()
		     						.map(p->p.getEmployeeId())
		     						.collect(Collectors.toSet())
		     						.stream()
		     						.map(employeeLocalService::findByEmployeeId)
		     						.collect(Collectors.toList());
  
 
   for(Employee employee:emp){
	
   String employeeId=String.valueOf(employee.getEmployeeId());
%>
    <tr>
      <td><%=i++ %></td>
      <td><%= employee.getFirstName()+"  "+employee.getLastName() %></td>
      <portlet:renderURL var="assignTaskUrl">

<portlet:param name="mvcPath" value="/assign_task.jsp"></portlet:param>
<portlet:param name="employeeId" value="<%=employeeId %>"></portlet:param>
</portlet:renderURL>
      <td><a href="${assignTaskUrl}" style="color:green">Assign Task</a></td>
      </tr>
  <%} %> 
</tbody>
</table>
</div>
</div>