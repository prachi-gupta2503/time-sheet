<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<%@ page import="java.util.function.*" %>
<%@ page import="java.util.stream.Collectors;" %>
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
  
 


.add_mapping {
	display: none; 
	position: fixed;
	z-index: 1; 
	padding-top: 100px; 
	left: 0;
	top: 0;
	width: 30%; 
	height: 40%; 
	margin-left:800px;
	margin-top:30px;
	
}


#mapping-dialog{
  padding-left: 30%;
  padding-bottom:10%;
  
}


/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
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
        <button value="Add Resource" class="btn btn-success" id="<portlet:namespace/>mappingBtn"><liferay-ui:icon image="add" />Resource </button>
       </div>
</div>
</div>



 


 



<div id="myModal" class=" add_mapping">
	
	<div class="modal-content">
		<div id="span">
			<span class="close">&times;</span>
		</div>
		<div id="mapping-dialog" title="Add Mapping">
			<aui:form action="${addProjectResourceURL}" name="<portlet:namespace />fm" class="p-4">
	
			<aui:row>
			<aui:input type="hidden" value="<%=projectId %>" name="projectId" />
			 <aui:input name="projectResourceId" type="hidden" />
				<aui:col width="80">
					<aui:select label="Employee " id="employee" name="employeeId">
     <aui:option value="" selected="true" disabled= "true">Please Select an Employee</aui:option>
     <%
   
     EmployeeLocalService employeelocalservice=(EmployeeLocalService)request.getAttribute("_employeeLocalService"); %>
    <%List<Employee>employees=employeelocalservice.getEmployees(0, employeelocalservice.getEmployeesCount()); 
   
   List<ProjectResource>projectResources1= projectResourceLocalService.findByProjectId(projectId);
   
   /* List<Long> projectresource=new ArrayList<>();
   
   for(ProjectResource resource:projectResources1){
	   projectresource.add(resource.getEmployeeId());
   } */
 
   Predicate<Employee> CheckEmployee=e->
	           projectResources1.stream().noneMatch(p->p.getEmployeeId()==e.getEmployeeId()) ; 
   
   List<Employee> employeeList=employees.stream().filter(CheckEmployee).collect(Collectors.toList());

    for(Employee employee:employeeList){
     
    %>
   
    <aui:option value="<%=employee.getEmployeeId() %>"><%=employee.getFirstName()+"  "+employee.getLastName() %></aui:option>                       
        <%
      
      }%>
        </aui:select>
				</aui:col>
				
			</aui:row>

        <aui:button-row>
       <button type="submit" class="btn btn-success"><liferay-ui:icon image="saved_in_database" /> Submit</button>
        <button type="button"class="btn btn-danger" onClick="${viewURL.toString()}" id="<portlet:namespace/>cancelBtn"><liferay-ui:icon image="close" />Close</button>

    </aui:button-row>
        </aui:form>
		</div>
	</div>
</div>


<script>
$(document).ready( function() {
   	var modal = document.getElementById("myModal");
	 var btn = document.getElementById("<portlet:namespace/>mappingBtn");
	var cancelBtn = document.getElementById("<portlet:namespace/>cancelBtn");
	var span = document.getElementsByClassName("close")[0]; 
	btn.onclick = function() {
		modal.style.display = "block";
	}
	span.onclick = function() {
		modal.style.display = "none";
	}
	cancelBtn.onclick = function() {
		modal.style.display = "none";
	}
	
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	}
	
} );

</script>    


 