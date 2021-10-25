<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/resource_activity.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="assignTaskToResource" var="addProjectResourceUrl"></portlet:actionURL>
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
	width: 40%; 
	height: 100%; 
	margin-left:400px;
	margin-top:30px;
	
}


#mapping-dialog{

  padding-left: 5%;
  padding-right:5%;
  
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

<div class="col-10">

<% 
/* String employeeid=request.getParameter("employeeid"); */
  long employeeId=3; /* Long.parseLong(employeeid); */
   EmployeeLocalService employeeLocalService=(EmployeeLocalService)request.getAttribute("_employeeLocalService");
 Employee employee= employeeLocalService.findByEmployeeId(employeeId); 
 
 %>
 
<div class="myDiv">
 
     <h4><%=employee.getFirstName().toUpperCase()+" "+employee.getLastName().toUpperCase() %></h4>
 </div>
 
 <table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Task</th>
      <th scope="col">Project</th>
      <th scope="col">From Date</th>
      <th scope="col">To Date</th>
      <th scope="col">Hour</th>
      <th scope="col"> </th>
      
    </tr>
  </thead>
  <tbody>
  <%TaskLocalService taskLocalService=(TaskLocalService)request.getAttribute("_taskLocalService");
  ProjectLocalService projectLocalService=(ProjectLocalService)request.getAttribute("_projectLocalService");
  ResourceTaskLocalService  resourceTaskLocalService =(ResourceTaskLocalService)request.getAttribute("_resourceTaskLocalService");
  
  List<ResourceTask>resourceTasks= resourceTaskLocalService.findTaskByEmployeeId(employeeId);
  for(ResourceTask resourceTask:resourceTasks){
	Task task=  taskLocalService.findByTaskId(resourceTask.getTaskId());
	 Project project=projectLocalService.findByProjectId(task.getProjectId());
 %>
   <tr>
    
 <td style="display:none;"><%=resourceTask.getResourceTaskId() %></td>
 <td><%=task.getTaskName() %></td>
 <td><%=project.getName() %></td>
  <td><%=resourceTask.getFromDate().toString().substring(0, 10) %></td>
   <td><%=resourceTask.getToDate().toString().substring(0, 10) %></td>
    <td><%=resourceTask.getHour()+" hour" %></td>
    <td><button type="button"  class="btn btn-success mapping" id="<%=resourceTask.getResourceTaskId() %>" value="<%=resourceTask.getResourceTaskId() %>"><liferay-ui:icon image="edit" /> Update</button> </td>
     </tr>
 <%} %>
   
   
  </tbody>
</table>
 

       

</div>

        
</div> 


<div id="myModal" class=" add_mapping">
	
	<div class="modal-content">
		<div id="span">
			<span class="close">&times;</span>
		</div>
		<div id="mapping-dialog" title="Add Mapping">
			<aui:form action="${addProjectResourceUrl}" name="<portlet:namespace />fm">
<aui:fieldset >
			 <aui:input type="hidden"  name="resourceTaskId" id="resourceTaskId" />
			
				<aui:row>
				<aui:col width="50" >
					<aui:input name="Task" id="taskName" type="text"  readOnly="true"/>
					</aui:col>
					
				<aui:col width="50" >
					<aui:input name="Project" id="project" type="text"  readOnly="true" />
					</aui:col>
					</aui:row>
					<aui:row>
				<aui:col width="50" >
					<aui:input name="fromDate"  id="fromDate" type="text"  readOnly="true" />
					</aui:col>
					
				<aui:col width="50" >
					<aui:input name="toDate"  id="toDate" type="text"  readOnly="true" />
					</aui:col>
					</aui:row>
					<aui:row>
				<aui:col width="50" >
					<aui:input name="Hour"  id="hour" type="text"  readOnly="true" />
					</aui:col>
					
					<aui:col width="50" >
					<aui:input name="workedHour"  />
					</aui:col>
					</aui:row>
					<aui:row>
					<aui:col width="50" >
					<aui:input name="description"  />
					</aui:col>
					
					<aui:col width="50" >
					<aui:input name="status"  />
					</aui:col>
					</aui:row>
				</aui:fieldset>
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
	
	jQuery(".mapping").click(function(event){
		var  id=this.value;
		
		var currentRow=$(this).closest("tr"); 
       
        document.getElementById("<portlet:namespace/>resourceTaskId").value = currentRow.find("td:eq(0)").text();
		  
		  document.getElementById("<portlet:namespace/>taskName").value = currentRow.find("td:eq(1)").text();
		  document.getElementById("<portlet:namespace/>project").value = currentRow.find("td:eq(2)").text();
		  document.getElementById("<portlet:namespace/>fromDate").value = currentRow.find("td:eq(3)").text();
		  document.getElementById("<portlet:namespace/>toDate").value =currentRow.find("td:eq(4)").text();
		  document.getElementById("<portlet:namespace/>hour").value = currentRow.find("td:eq(5)").text();
    
		 
	 var modal = document.getElementById("myModal");
	 modal.style.display = "block";
	var cancelBtn = document.getElementById("<portlet:namespace/>cancelBtn");
	var span = document.getElementsByClassName("close")[0]; 
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
	
	
	
	});
	
   	
	
	  
} );

</script>    







 