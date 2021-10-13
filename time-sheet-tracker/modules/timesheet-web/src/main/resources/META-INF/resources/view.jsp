<%@ include file="/init.jsp" %>

<liferay-portlet:renderURL var="resourceCategoryUrl">
        <portlet:param name="mvcPath" value="/resource_category.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="projectUrl">
        <portlet:param name="mvcPath" value="/project.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="taskCategoryUrl">
        <portlet:param name="mvcPath" value="/task_category.jsp" />
</liferay-portlet:renderURL>
<a href="${resourceCategoryUrl}" ><button type="button" class="btn btn-success">Add ResourceCategory</button></a>
<a href="${projectUrl}" ><button type="button" class="btn btn-success">Add Project</button></a>
<a href="${taskCategoryUrl}" ><button type="button" class="btn btn-success">Add TaskCategory</button></a>