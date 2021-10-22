<%@page import="com.adjecti.timesheet.model.Project" %>
<%@page import="java.util.*" %>
<%@ include file="/init.jsp" %>
<portlet:renderURL var="viewURL">



<portlet:param name="mvcPath" value="/project_list.jsp"></portlet:param>

</portlet:renderURL>

<portlet:actionURL name="addProject" var="addProjectURL"></portlet:actionURL>

 

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


#mapping-dialog{
  padding-left: 30%;
  
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
			
<aui:form action="${addProjectURL}" name="<portlet:namespace />fm">

<aui:model-context bean="${entry}" model="${Project.class}" />

    <aui:fieldset >
     
         <aui:col width="70">
        <aui:input name="name" />
        </aui:col>
         
        
         
          
        <aui:input name="projectId" type="hidden" />
        
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

