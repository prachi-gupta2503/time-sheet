<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>

<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/project_list.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addTask" var="addTaskURL"></portlet:actionURL>
<style>
.myDiv {
 background-color: lightblue;
  color: black;
  padding: 20px;
  text-align: center;
}
#form{

  color: black;
  padding: 40px;
  text-align: center;
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
        <aui:button value="Add Task" class="btn btn-primary" id="addtask"></aui:button>
       </div>
       
       
 <div id="form">     
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

<%-- <aui:model-context bean="${entry}" model="${Task.class}" />

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
</aui:form> --%>
</div> 
</div>
</div>

        
</div> 



  <script>

 $("#<portlet:namespace />addtask").click(function(){
	 //alert("hiii")
 	//console.log($("#form"));
 	$("#form").css("display","block");
 	
   
 });
/* $("#<portlet:namespace/>taskname").hide();
$("#<portlet:namespace/>project").change(function(){
	 
	var projectId=$(this).val();
	var tab="";
	//var row=$("#table1 > tbody");
	var taskname="";
	var taskCategory="";
	
	var row=$("#table >tbody")
	
	row.empty();
	
	Liferay.Service(
			  '/timesheet.task/find',
			  {
			    projectId: projectId
			  },
			  function(obj) {
				  for(var i=0;i<obj[0].length;i++){
					 
					 row.append("<tr><td>"+obj[0][i].taskName+"</td><td>"+obj[1][i].type+"</td></tr>")
				  }
					    
			  }
			);
	/* Liferay.Service(
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
			); */
	
/* 	console.log(tab) */
	
	/* $("table > tbody").append(tab); */
	 



</script> 
 -->