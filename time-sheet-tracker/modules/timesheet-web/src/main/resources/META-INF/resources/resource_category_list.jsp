<%@ include file="/init.jsp" %>
<%@page import="com.adjecti.timesheet.service.*"%>
<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ include file="/resource_category.jsp"%>


<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">


 <button type="button" class="btn btn-success" id="<portlet:namespace/>mappingBtn"><liferay-ui:icon image="add" id="time" /> ResourceCategory</button>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">S.N.</th>
      <th scope="col">Resource Category</th>
      
    </tr>
  </thead>
  <tbody>
   
    <%int i=1; %>
    <%
   
   ResourceCategoryLocalService resourcecategoryLocalService=(ResourceCategoryLocalService)request.getAttribute("_resourceCategoryLocalService"); %>
    <%List<ResourceCategory>resourcecategories=resourcecategoryLocalService.getResourceCategories(0, resourcecategoryLocalService.getResourceCategoriesCount());
   
    for(ResourceCategory resourcecategory:resourcecategories){
    
   %>
     <tr>
      <td><%=i++ %></td>
      <td><%=resourcecategory.getType() %></td>
      <%} %>
    </tr>
   
  </tbody>
</table>
</div>
</div>