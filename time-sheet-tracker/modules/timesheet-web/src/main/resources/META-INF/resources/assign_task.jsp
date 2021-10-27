
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.function.*"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@page import="java.util.stream.Stream;" %>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">
<portlet:param name="mvcPath" value="/assign_task.jsp"></portlet:param>

</portlet:renderURL>
<portlet:actionURL name="assignTaskToResource" var="assignTaskToResourceURL"></portlet:actionURL>
<style>
.myDiv {
 background-color: lightblue;
  color: black;
  padding: 20px;
  text-align: center;
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
String employeeid=request.getParameter("employeeId");
  long employeeId= Long.parseLong(employeeid);
  ProjectResourceLocalService projectResourceLocalService=(ProjectResourceLocalService)request.getAttribute("_projectResourceLocalService");
  EmployeeLocalService employeeLocalService =(EmployeeLocalService)request.getAttribute("_employeeLocalService");
  ProjectLocalService projectLocalService =(ProjectLocalService)request.getAttribute("_projectLocalService");
  ResourceTaskLocalService resourceTaskLocalService=(ResourceTaskLocalService)request.getAttribute("_resourceTaskLocalService");
  TaskLocalService taskLocalService=(TaskLocalService)request.getAttribute("_taskLocalService");
  Employee employee=employeeLocalService.getEmployee(employeeId);
 List<ProjectResource> projectResources= projectResourceLocalService.findByEmployeeId(employeeId);

 Stream<Project> projects =projectResources.stream()
 .map(p->projectLocalService.findByProjectId(p.getProjectId()));
 
   List<String>projectNames=projectResources.stream()
		   .map(p->projectLocalService.findByProjectId(p.getProjectId()))
				 .map(project->project.getName())
				 .collect(Collectors.toList());
 
 %>
 
<div class="myDiv">
 
     <h4><%=employee.getFirstName().toUpperCase()+" "+employee.getLastName().toUpperCase() %></h4>
     <h4>Project:<%=projectNames %></h4>
 </div>
 
 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Task</th>
      <th scope="col">From Date</th>
      <th scope="col">To Date</th>
      <th scope="col">Hour</th>
      
    </tr>
  </thead>
  <tbody>
  <%List<ResourceTask>resourceTasks=resourceTaskLocalService.findTaskByEmployeeId(employee.getEmployeeId()); 
  for(ResourceTask resourceTask:resourceTasks){
  
  
  
  %>
   <tr>
 <% Task task=taskLocalService.findByTaskId(resourceTask.getTaskId()); %>   
 <td><%=task.getTaskName() %></td>
 <td><%=resourceTask.getFromDate().toString().substring(0, 10) %></td>
 <td><%=resourceTask.getToDate().toString().substring(0, 10) %></td>
 
 <td><%=resourceTask.getHour() %></td>
    </tr>
   <%} %>
  </tbody>
</table>
 
<div >
        <button type="button" class="btn btn-success" id="<portlet:namespace/>mappingBtn"><liferay-ui:icon image="add" /> Assign Task</button>

       </div>
       
       
 
</div>

        
</div> 


<div id="myModal" class=" add_mapping">
	
	<div class="modal-content">
		<div id="span">
			<span class="close">&times;</span>
		</div>
		<div id="mapping-dialog" title="Add Mapping">
			<aui:form action="${assignTaskToResourceURL}" name="<portlet:namespace />fm">

			  <aui:input type="hidden" value="<%=employee.getEmployeeId() %>" name="employeeId" /> 
			  <aui:input name="resourceTaskId" type="hidden" />
			 
				
					
					<aui:row>
				
				<aui:col width="80">
					<aui:select label=" Task" id="task" name="taskId">
     <aui:option value="" selected="true" disabled= "true">Please Select an Task</aui:option>
     
     
    <%
    Predicate<Task>predicate=t->
    						resourceTasks.stream().noneMatch(r->r.getTaskId()==t.getTaskId());
   
   List<Task>taskOfList= projects.map(project->taskLocalService.findByProjectId(project.getProjectId()))
		                         .flatMap(task->task.stream())
         						 .filter(predicate).collect(Collectors.toList());
            
   
    

    for(Task task:taskOfList){ 
  
    %>
   
    <aui:option value="<%=task.getTaskId() %>"><%=task.getTaskName() %></aui:option>                       
       <%
    	
    	} %>
        </aui:select>
				</aui:col>
			</aui:row>
			<aui:row>
				<aui:col width="80" id="fromDate">
					<aui:input name="fromDate" type="Date" />
					</aui:col>
					</aui:row>
					
				<aui:row>
				<aui:col width="80" id="toDate">
					<aui:input name="toDate" type="Date" />
					</aui:col>
					</aui:row>
					
					<aui:row>
				<aui:col width="80" id="hour">
					<aui:input name="hour"  />
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
 







 