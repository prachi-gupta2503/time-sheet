<%@ include file="/init.jsp" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ include file="/task_category.jsp"%>

<liferay-portlet:renderURL var="taskcategoryUrl">
        <portlet:param name="mvcPath" value="/task_category.jsp" />
</liferay-portlet:renderURL>
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">



<button type="button" class="btn btn-success" id="<portlet:namespace/>mappingBtn"><liferay-ui:icon image="add" /> TaskCategory</button>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">S.N.</th>
      <th scope="col">Task Category</th>
      
    </tr>
  </thead>
  <tbody>
   
    <%int i=1; %>
    <%
   
    TaskCategoryLocalService taskcategoryLocalService=(TaskCategoryLocalService)request.getAttribute("_taskCategoryLocalService"); %>
    <%List<TaskCategory>taskcategories=taskcategoryLocalService.getTaskCategories(0, taskcategoryLocalService.getTaskCategoriesCount());
   
    for(TaskCategory taskcategory:taskcategories){
    
   %>
    <tr>
      <td><%=i++ %></td>
      <td><%=taskcategory.getType() %></td>
      <%} %>
    </tr>
   
  </tbody>
</table>
</div>
</div>

