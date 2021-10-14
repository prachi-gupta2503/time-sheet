<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addTask" var="addTaskURL"></portlet:actionURL>
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-6">

 

<aui:form action="${addTaskURL}" name="<portlet:namespace />fm">

<aui:model-context bean="${entry}" model="${Task.class}" />

    <aui:fieldset >
     <aui:col width="30">
    <aui:select label="Project " id="project" name="projectId">
     <aui:option value="" selected="true" disabled= "true">Please Select an Project</aui:option>
     <%
   
    ProjectLocalService projectlocalservice=(ProjectLocalService)request.getAttribute("_projectLocalService"); %>
    <%List<Project>projects=projectlocalservice.getProjects(0, projectlocalservice.getProjectsCount()); 
    for(Project project:projects){
        
    %>
   
    <aui:option value="<%=project.getProjectId() %>"><%=project.getName() %></aui:option>                       
        <%} %>
        </aui:select>
        
 
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

<div class="col-2">
<div class="float-right">
        <aui:button value="Add Task" class="btn btn-primary" id="addtask"></aui:button>
        </div>
        <div class="row">
        <table class="table table-striped" id="table1">
  <thead>
    <tr>
     
      <th scope="col">Task</th>
       
      
    </tr>
  </thead>
  <tbody>
  
  </tbody>
</table>
<table class="table table-striped" id="table2">
  <thead>
    <tr>
     
      
       <th scope="col">Type</th>
      
    </tr>
  </thead>
  <tbody>
  
  </tbody>
</table>
</div>
</div>
</div>
<script>

$("#<portlet:namespace/>taskname").hide();
$("#<portlet:namespace/>project").change(function(){
	 
	var projectId=$(this).val();
	var tab="";
	//var row=$("#table1 > tbody");
	var taskname="";
	var taskCategory="";
	
	var row=$("#table1 >tbody")
	var row1=$("#table2 >tbody")
	row.empty();
	row1.empty();
	Liferay.Service(
			  '/timesheet.task/find-by-project-id',
			  {
			    projectId: projectId
			  },
			  function(obj) {
			       for(var i=0;i<obj.length;i++){
			    row.append("<tr><td>"+obj[i].taskName+"</td><td>")
			  
			    Liferay.Service(
			    		  '/timesheet.taskcategory/find-by-task-category-id',
			    		  {
			    		    taskCategoryId: obj[i].taskCategoryId
			    		  },
			    		  function(taskcategory) {
			    			  taskCategory= taskcategory[0].type;
			    			  row1.append("<tr><td>"+taskCategory+"</td></tr>");
			    			
			    		  }
			    		);
			   
			    
			      
			    }
		  }
			);
	
/* 	console.log(tab) */
	
	/* $("table > tbody").append(tab); */
	 
});

$("#<portlet:namespace />addtask").click(function(){
	
	$("#<portlet:namespace/>taskname").show();
})

</script>
