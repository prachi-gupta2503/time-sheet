<%@ include file="/init.jsp" %>

<!doctype html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    
    <style>
     .side-navbar{
           background-color: #e3f2fd;;
         
         }
       
       
       a{
            text-decoration:none;
            color:black;
            font-size:16px;
            font-weight:20px;
         }
       h5{
            text-decoration: underline;
            margin-left:30px;
          }


    </style>
  </head>
  <body>
    

 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	
	
	<liferay-portlet:renderURL var="resourceCategoryUrl">
        <portlet:param name="mvcPath" value="/resource_category_list.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="projectUrl">
        <portlet:param name="mvcPath" value="/project_list.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="taskCategoryUrl">
        <portlet:param name="mvcPath" value="/task_category_list.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="tasksUrl">
        <portlet:param name="mvcPath" value="/task.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="projectResourceUrl">
        <portlet:param name="mvcPath" value="/project_resource_list.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL var="resourceUrl">
        <portlet:param name="mvcPath" value="/resource.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="ActivityUrl">
        <portlet:param name="mvcPath" value="/resource_activity.jsp" />
</liferay-portlet:renderURL>

<div class="side-navbar active-nav d-flex justify-content-between flex-wrap flex-column" id="sidebar">
  <ul class="nav flex-column text-white w-100">
    
   <a href="#" class="nav-link h3 text-info my-2" >
    <liferay-ui:icon image="time" id="time" />
     Time Tracker
    </a>
    <li href="#" class="nav-link">
    
      <a href="${resourceCategoryUrl}" ><liferay-ui:icon image="assign_user_roles" id="time" />Resource Category</a>
    </li>
    <li href="#" class="nav-link">
    
     <a href="${projectUrl}" ><liferay-ui:icon image="pages" id="time" /> Project</a>
    </li>
    <li href="#" class="nav-link">
   
      <a href="${taskCategoryUrl}" > <liferay-ui:icon image="team_icon" id="time" />Task Category</a>
      
    </li>
   
     <li href="#" class="nav-link">
   
      <a href="${resourceUrl}" > <liferay-ui:icon image="sitemap" id="time" />Resource</a>
      
    </li>
    <li href="#" class="nav-link">
   
      <a href="${ActivityUrl}" > <liferay-ui:icon image="sitemap" id="time" />Resource Activity</a>
      
    </li>
   
  </ul>
</div>
    
  </body>
</html>