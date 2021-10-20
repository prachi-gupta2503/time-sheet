<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/task.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addTask" var="addTaskURL"></portlet:actionURL>
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
.model-content{
background-color: #e3f2fd;
}

#mapping-dialog{
background-color: #e3f2fd;
  padding-left: 30%;
  
}
#span{
background-color: #e3f2fd;
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
      <th scope="col">Task</th>
      <th scope="col">Type</th>
      
    </tr>
  </thead>
  <tbody>
  <%TaskLocalService taskLocalService=(TaskLocalService)request.getAttribute("_taskLocalService");
  TaskCategoryLocalService taskCategoryLocalService=(TaskCategoryLocalService)request.getAttribute("_taskCategoryLocalService");
  List<Task>tasklist=taskLocalService.findByProjectId(projectId);
 for(Task task:tasklist){
	TaskCategory taskCategory= taskCategoryLocalService.getTaskCategory(task.getTaskCategoryId());
 %>
   <tr>
    
 <td><%=task.getTaskName() %></td>
 <td><%=taskCategory.getType() %></td>
 <%} %>
    </tr>
   
  </tbody>
</table>
 
<div >
        <button type="button" class="btn btn-success" id="<portlet:namespace/>mappingBtn"><liferay-ui:icon image="add" /> AddTask</button>

       </div>
       
       
 <%-- <div id="form">     
 <div>
<aui:form action="${addTaskURL}" name="<portlet:namespace />fm">

			 <aui:input type="hidden" value="<%=projectId %>" name="projectId" />
			 <aui:input name="projectResourceId" type="hidden" />
			 <aui:input name="taskId" type="hidden" />
				<aui:row>
				<aui:col width="100" id="taskname">
					<aui:input name="taskName"  />
					</aui:col>
					</aui:row>
					<aui:row>
				
				<aui:col width="100">
					<aui:select label=" TaskCategory" id="taskcategory" name="taskCategoryId">
     <aui:option value="" selected="true" disabled= "true">Please Select an TaskCategory</aui:option>
     <% TaskCategoryLocalService taskcategoryLocalService=(TaskCategoryLocalService)request.getAttribute("_taskCategoryLocalService"); %>
    <%List<TaskCategory>taskCategory=taskcategoryLocalService.getTaskCategories(0, taskcategoryLocalService.getTaskCategoriesCount()); 
    for(TaskCategory taskcategory:taskCategory){ 
    %>
   
    <aui:option value="<%=taskcategory.getTaskCategoryId() %>"><%=taskcategory.getType() %></aui:option>                       
       <%} %>
        </aui:select>
				</aui:col>
			</aui:row>
				
			
			
	
	
	<aui:button-row>
		 <aui:button type="submit"></aui:button>
        <aui:button type="cancel"   onClick="${viewURL.toString()}"></aui:button>
	</aui:button-row>
	
</aui:form>

<aui:model-context bean="${entry}" model="${Task.class}" />

    <aui:fieldset >
     <aui:col width="30">
    <aui:input type="hidden" value="<%=projectId %>" name="projectId" />
    
        
 
       </aui:col>
         <aui:col width="30" id="taskname">
        <aui:input name="taskName"  />
        </aui:col>
         <aui:col width="30">
    <aui:select label=" TaskCategory" id="taskcategory" name="taskCategoryId">
     <aui:option value="" selected="true" disabled= "true">Please Select an TaskCategory</aui:option>
     <% TaskCategoryLocalService taskcategoryLocalService=(TaskCategoryLocalService)request.getAttribute("_taskCategoryLocalService"); %>
    <%List<TaskCategory>taskCategory=taskcategoryLocalService.getTaskCategories(0, taskcategoryLocalService.getTaskCategoriesCount()); 
    for(TaskCategory taskcategory:taskCategory){ 
    %>
   
    <aui:option value="<%=taskcategory.getTaskCategoryId() %>"><%=taskcategory.getType() %></aui:option>                       
       <%} %>
        </aui:select>
       </aui:col>
        
         
          
        <aui:input name="taskId" type="hidden" />
        
    </aui:fieldset>

    <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="${viewURL.toString()}"></aui:button>

    </aui:button-row>
</aui:form>
</div> 
</div> --%>
</div>

        
</div> 


<div id="myModal" class=" add_mapping">
	
	<div class="modal-content">
		<div id="span">
			<span class="close">&times;</span>
		</div>
		<div id="mapping-dialog" title="Add Mapping">
			<aui:form action="${addTaskURL}" name="<portlet:namespace />fm">

			 <aui:input type="hidden" value="<%=projectId %>" name="projectId" />
			 <aui:input name="projectResourceId" type="hidden" />
			 <aui:input name="taskId" type="hidden" />
				<aui:row>
				<aui:col width="50" id="taskname">
					<aui:input name="taskName"  />
					</aui:col>
					</aui:row>
					<aui:row>
				
				<aui:col width="50">
					<aui:select label=" TaskCategory" id="taskcategory" name="taskCategoryId">
     <aui:option value="" selected="true" disabled= "true">Please Select an TaskCategory</aui:option>
     
     <% TaskCategoryLocalService taskcategoryLocalService=(TaskCategoryLocalService)request.getAttribute("_taskCategoryLocalService"); %>
    <%List<TaskCategory>taskCategory=taskcategoryLocalService.getTaskCategories(0, taskcategoryLocalService.getTaskCategoriesCount()); 
    for(TaskCategory taskcategory:taskCategory){ 
    %>
   
    <aui:option value="<%=taskcategory.getTaskCategoryId() %>"><%=taskcategory.getType() %></aui:option>                       
       <%} %>
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







 