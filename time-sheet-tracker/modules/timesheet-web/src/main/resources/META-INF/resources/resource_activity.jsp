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
	width: 80%; 
	height: 80%; 
	/*margin-left:400px;*/
	margin-top:30px;
	margin-left:10%
	
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

#dailyTask{

   display:none;
}

</style>
<div class="row">

<div class="col-10">

<% 

 long employeeId=(long)request.getAttribute("employee");
 
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
      <th scope="col">Status </th>
      <th scope="col" > </th>
    </tr>
  </thead>
  <tbody>
  <%TaskLocalService taskLocalService=(TaskLocalService)request.getAttribute("_taskLocalService");
  ProjectLocalService projectLocalService=(ProjectLocalService)request.getAttribute("_projectLocalService");
  ResourceTaskLocalService  resourceTaskLocalService =(ResourceTaskLocalService)request.getAttribute("_resourceTaskLocalService");
  ResourceTimeSheetLocalService  resourceTimeSheetLocalService =(ResourceTimeSheetLocalService)request.getAttribute("_resourceTimeSheetLocalService");
 
  List<ResourceTask>resourceTasks= resourceTaskLocalService.findTaskByEmployeeId(employeeId);
  for(ResourceTask resourceTask:resourceTasks){
	
	Task task=  taskLocalService.findByTaskId(resourceTask.getTaskId());
	 Project project=projectLocalService.findByProjectId(task.getProjectId());
 %>
   <tr>
    
 <td style="display:none;"><%=resourceTask.getResourceTaskId() %></td>
 <td><%=task.getTaskName() %></td>
 <td><%=project.getName() %></td>
  <td><%=resourceTask.getFromDate()%></td>
   <td><%=resourceTask.getToDate() %></td>
    <td><%=resourceTask.getHour()+" hour" %></td>
    <td><%=resourceTask.getStatus() %></td>
    <%if(resourceTask.getStatus().equalsIgnoreCase("completed")){ %>
     <td style="background-color:#e3f2fd"><%="Worked Hour: "+resourceTask.getWorkedHour()+" hour" %></td>
     
    <%}else { %>
    
    <td><button type="button"  class="btn btn-success mapping" id="<%=resourceTask.getResourceTaskId() %>" value="<%=resourceTask.getResourceTaskId() %>"><liferay-ui:icon image="edit" /> Update</button> </td>
    <%} %>
     </tr>
     
   <%--   
     <%for(ResourceTimeSheet resourceTimeSheet:resourceTimeSheets){ %>
     <tr>
     <td style="background-color:#e3f2fd"><%="Date : "+resourceTimeSheet.getDate().toString().substring(0, 10) %></td>
     <td style="background-color:#e3f2fd"><%="Hour : "+resourceTimeSheet.getHour()+" hour" %></td>
     <td style="background-color:#e3f2fd"></td>
     <td style="background-color:#e3f2fd"></td>
     <td style="background-color:#e3f2fd"></td>
     <td style="background-color:#e3f2fd"></td>
     <td style="background-color:#e3f2fd"></td>
     
     </tr>
     <%} %> --%>
 <%} %>
   
   
  </tbody>
</table>
 

       

</div>

        
</div> 


<div id="myModal" class="add_mapping">
	
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
					
					
					<div id="dates">
					</div>
				
					<aui:row>
					<aui:col width="50" >
					<aui:input name="description" type="textarea" rows="4" cols="50" />
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
		
		
		  
		const date1 = new Date(currentRow.find("td:eq(3)").text());
		console.log("date "+date1);
		const date2 = new Date(currentRow.find("td:eq(4)").text());
		const diffTime = Math.abs(date2 - date1);
		const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)); 
		var v = [];
		$("#dates").empty();
		//var date3=new Date(date1);
		var startDate = new Date(date1);
		console.log("startDate : "+startDate);
		for(var i=0;i<=diffDays;i++)
		{
			 var day = ("0" + startDate.getDate()).slice(-2);
			 var month = ("0" + (startDate.getMonth() + 1)).slice(-2);
			var today = startDate.getFullYear() + "-" + (month) + "-" + (day);			
			var row = $('<div/>').attr({class:'row mb-1'}).appendTo('#dates');
			var col1 = $('<div/>').attr({class:'col-md-4'}).appendTo(row);
			var col2 = $('<div/>').attr({class:'col-md-4'}).appendTo(row);
			var col3 = $('<div/>').attr({class:'col-md-4'}).appendTo(row);
			 var date = $('<input/>').attr({type:'date',class:"form-control"}).appendTo(col1);
			 date.val(today);
			 var text = $('<input/>').attr({type:'text',class:"form-control",placeholder:" Enter workedHour"}).appendTo(col2);
			 var status = $('<input/>').attr({type:'text',class:"form-control",placeholder:" Enter status"}).appendTo(col3);
			 //$("#dates").empty();
			var day = 60 * 60 * 24 * 1000;

           var endDate = new Date(startDate.getTime() + day);
           startDate = endDate;
           console.log("endDate : "+endDate);
		    //date3=date3.setDate(date3.getDate() + 1)
		}
		console.log("Printing the data array : "+v);
	    //$("#dates").append(v);
		 
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







 