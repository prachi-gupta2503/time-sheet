<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/project_list.jsp"></portlet:param>

</portlet:renderURL>


<portlet:actionURL name="addProjectResource" var="addProjectResourceURL"></portlet:actionURL>
<style>
.myDiv {
 background-color: lightblue;
  color: black;
  padding: 20px;
  text-align: center;
}


.button-holder{
  margin-top: 0;
  margin-bottom: 0;
}
#form{

 
  display:none;
 
  }
</style>
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-6">

<% 
String projectid=request.getParameter("projectid");
  long projectId= Long.parseLong(projectid);
   ProjectLocalService projectLocalService=(ProjectLocalService)request.getAttribute("_projectLocalService");
 Project project= projectLocalService.getProject(projectId); 
 
 %>
 
<div class="myDiv">
 
     <h4><%=project.getName() %></h4>
 </div>
 
 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Resource</th>
      <th scope="col">Resource Category</th>
      
    </tr>
  </thead>
  <tbody>
  <%EmployeeLocalService employeeLocalService=(EmployeeLocalService)request.getAttribute("_employeeLocalService");
  ResourceCategoryLocalService resourceCategoryLocalService=(ResourceCategoryLocalService)request.getAttribute("_resourceCategoryLocalService");
  ProjectResourceLocalService projectResourceLocalService=(ProjectResourceLocalService)request.getAttribute("_projectResourceLocalService");
  List<ProjectResource>projectResources= projectResourceLocalService.findByProjectId(projectId);
 for(ProjectResource projectResource:projectResources){
	Employee employee= employeeLocalService.getEmployee(projectResource.getEmployeeId());
	 ResourceCategory resourceCategory=resourceCategoryLocalService.fetchResourceCategory(employee.getResourceCategoryId());
 %>
   <tr>
    
 <td><%=employee.getFirstName()+" "+employee.getLastName() %></td>
 <td><%=resourceCategory.getType() %></td>
 <%} %>
    </tr>
   
  </tbody>
</table>
<div >
        <aui:button value="Add Resource" class="btn btn-primary" id="addresource"></aui:button>
       </div>



 


 
<div id="form" class="mt-5">
<aui:form action="${addProjectResourceURL}" name="<portlet:namespace />fm" class="p-4">
	<!-- <aui:fieldset-group markupView="lexicon">
		<aui:fieldset label=""> -->
			<aui:row>
			<aui:input type="hidden" value="<%=projectId %>" name="projectId" />
			 <aui:input name="projectResourceId" type="hidden" />
				<aui:col width="100">
					<aui:select label="Employee " id="employee" name="employeeId">
     <aui:option value="" selected="true" disabled= "true">Please Select an Employee</aui:option>
     <%
   
     EmployeeLocalService employeelocalservice=(EmployeeLocalService)request.getAttribute("_employeeLocalService"); %>
    <%List<Employee>employees=employeelocalservice.getEmployees(0, employeelocalservice.getEmployeesCount()); 
    for(Employee employee:employees){
        
    %>
   
    <aui:option value="<%=employee.getEmployeeId() %>"><%=employee.getFirstName()+"  "+employee.getLastName() %></aui:option>                       
        <%} %>
        </aui:select>
				</aui:col>
				
			</aui:row>
			
		<!-- </aui:fieldset>
	</aui:fieldset-group> -->
	
	<aui:button-row>
		 <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="${viewURL.toString()}"></aui:button>
	</aui:button-row>
</aui:form>

<%-- <aui:form action="${addProjectResourceURL}" name="<portlet:namespace />fm">

<aui:model-context bean="${entry}" model="${ProjectResource.class}" />

    <aui:fieldset >
    <aui:row>
     <aui:col width="30">
    <aui:input type="hidden" value="<%=projectId %>" name="projectId" />
    
        
 
       </aui:col>
       
         
        
         <aui:col width="30">
    <aui:select label="Employee " id="employee" name="employeeId">
     <aui:option value="" selected="true" disabled= "true">Please Select an Employee</aui:option>
     <%
   
     EmployeeLocalService employeelocalservice=(EmployeeLocalService)request.getAttribute("_employeeLocalService"); %>
    <%List<Employee>employees=employeelocalservice.getEmployees(0, employeelocalservice.getEmployeesCount()); 
    for(Employee employee:employees){
        
    %>
   
    <aui:option value="<%=employee.getEmployeeId() %>"><%=employee.getFirstName()+"  "+employee.getLastName() %></aui:option>                       
        <%} %>
        </aui:select>
        
 
       </aui:col>
          
        <aui:input name="projectResourceId" type="hidden" />
        
    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="${viewURL.toString()}"></aui:button>

    </aui:button-row>
</aui:form> --%>
</div>

</div>

 </div>
 
<script>


$("#<portlet:namespace/>addresource").click(function(){
	 
	
	$("#form").css("display","block");
});

</script>
 