<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/view.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addResourceCategory" var="addResourceCategoryURL"></portlet:actionURL>

 
<div class="row">
<div class="col-4">
<%@ include file="/timesheet_sidebar.jsp" %>
</div>
<div class="col-8">

<aui:form action="${addResourceCategoryURL}" name="<portlet:namespace />fm">

<aui:model-context bean="${entry}" model="${ResourceCategory.class}" />

    <aui:fieldset >
     
         <aui:col width="30">
        <aui:input name="type" />
        </aui:col>
         <aui:input name="resourcecategoryId" type="hidden" />
        </aui:fieldset>
        <aui:button-row>

        <aui:button type="submit"></aui:button>
        <aui:button type="cancel" onClick="${viewURL.toString()}"></aui:button>

    </aui:button-row>
        </aui:form>
        
        </div>
        </div>