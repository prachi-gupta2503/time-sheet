<%@page import="com.adjecti.timesheet.model.*" %>
<%@page import="java.util.*" %>
<%@ include file="/init.jsp" %>
 <%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<portlet:renderURL var="viewURL">

<portlet:param name="mvcPath" value="/task_category_list.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addTaskCategory" var="addTaskCategoryURL"></portlet:actionURL>

<style>


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

<div id="myModal" class=" add_mapping">
	
	<div class="modal-content">
		<div id="span">
			<span class="close">&times;</span>
		</div>
		<div id="mapping-dialog" title="Add Mapping">
			<aui:form action="${addTaskCategoryURL}" name="<portlet:namespace />fm">

              <aui:model-context bean="${entry}" model="${TaskCategory.class}" />

                 <aui:fieldset >
     
                   <aui:col width="50">
                  <aui:input name="category" />
                      </aui:col>
                     <aui:input name="taskcategoryId" type="hidden" />
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




