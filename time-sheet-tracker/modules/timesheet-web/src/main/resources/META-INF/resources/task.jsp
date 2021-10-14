<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@page import=" com.liferay.portal.kernel.dao.orm.DynamicQuery" %>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addTask" var="addTaskURL"></portlet:actionURL>
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">

 

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
        <table class="table table-striped">
  <thead>
    <tr>
     
      <th scope="col">Name</th>
      
    </tr>
  </thead>
  <tbody>
  <%--  <%  TaskLocalService tasklocalservice=(TaskLocalService)request.getAttribute("_taskLocalService"); %>
    <%DynamicQuery query=tasklocalservice.dynamicQuery(); 
    query.add(PropertyFactoryUtil.forName("projectId").eq());
    for(Task task:tasks){
        
    %> --%>
      <tr>
      
      <td></td>
      
    </tr>
  
  </tbody>
</table>
       </aui:col>
         <aui:col width="30">
        <aui:input name="taskName" />
        </aui:col>
         <aui:col width="30">
    <aui:select label=" TaskCategory" id="taskcategory" name="taskcategoryId">
     <aui:option value="" selected="true" disabled= "true">Please Select an TaskCategory</aui:option>
     <%
   
    TaskCategoryLocalService taskcategoryLocalService=(TaskCategoryLocalService)request.getAttribute("_taskCategoryLocalService"); %>
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
</div>
