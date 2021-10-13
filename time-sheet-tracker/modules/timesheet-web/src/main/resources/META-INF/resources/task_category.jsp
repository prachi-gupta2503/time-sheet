<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addTaskCategory" var="addTaskCategoryURL"></portlet:actionURL>

 

<aui:form action="${addTaskCategoryURL}" name="<portlet:namespace />fm">

<aui:model-context bean="${entry}" model="${TaskCategory.class}" />

    <aui:fieldset >
     
         <aui:col width="30">
        <aui:input name="category" />
        </aui:col>
         <aui:input name="taskcategoryId" type="hidden" />
        </aui:fieldset>
        <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="${viewURL.toString()}"></aui:button>

    </aui:button-row>
        </aui:form>