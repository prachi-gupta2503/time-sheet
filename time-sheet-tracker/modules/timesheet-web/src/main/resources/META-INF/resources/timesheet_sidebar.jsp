<%@ include file="/init.jsp" %>

<!doctype html>
<html lang="en">
  <head>
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

   
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <title>Hello, world!</title>
    <style>
       .side-navbar{
          background:black;
         
       }
       a{
           text-decoration:none;
            color:white;
          font-size:16px;
          font-weight:20px;
       }
    </style>
  </head>
  <body>
    

 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<!-- side bar  -->
	
	<liferay-portlet:renderURL var="resourceCategoryUrl">
        <portlet:param name="mvcPath" value="/resource_category_list.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="projectUrl">
        <portlet:param name="mvcPath" value="/project_list.jsp" />
</liferay-portlet:renderURL>
<liferay-portlet:renderURL var="taskCategoryUrl">
        <portlet:param name="mvcPath" value="/task_category_list.jsp" />
</liferay-portlet:renderURL>
<div class="side-navbar active-nav d-flex justify-content-between flex-wrap flex-column" id="sidebar">
  <ul class="nav flex-column text-white w-100">
    <a href="#" class="nav-link h3 text-white my-2">
     Time Tracker
    </a>
    <li href="#" class="nav-link">
      <a href="${resourceCategoryUrl}" >ResourceCategory</a>
    </li>
    <li href="#" class="nav-link">
     <a href="${projectUrl}" > Project</a>
    </li>
    <li href="#" class="nav-link">
      <a href="${taskCategoryUrl}" >TaskCategory</a>
    </li>
  </ul>
</div>
    
  </body>
</html>