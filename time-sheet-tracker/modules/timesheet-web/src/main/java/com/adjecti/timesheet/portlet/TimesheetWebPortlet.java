package com.adjecti.timesheet.portlet;

import com.adjecti.timesheet.constants.TimesheetWebPortletKeys;
import com.adjecti.timesheet.model.Project;
import com.adjecti.timesheet.model.ResourceCategory;
import com.adjecti.timesheet.model.TaskCategory;
import com.adjecti.timesheet.service.ProjectLocalService;
import com.adjecti.timesheet.service.ProjectLocalServiceUtil;
import com.adjecti.timesheet.service.ResourceCategoryLocalServiceUtil;
import com.adjecti.timesheet.service.TaskCategoryLocalService;
import com.adjecti.timesheet.service.TaskCategoryLocalServiceUtil;
import com.adjecti.timesheet.service.TaskLocalService;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Adjecti-6
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=TimesheetWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + TimesheetWebPortletKeys.TIMESHEETWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class TimesheetWebPortlet extends MVCPortlet {
	@Reference
	private TaskLocalService _taskLocalService;
	@Reference
	private ProjectLocalService _projectLocalService;
	@Reference
	private TaskCategoryLocalService _taskCategoryLocalService;

	

	public void addProject(ActionRequest request, ActionResponse response) throws PortalException {

		String name = ParamUtil.getString(request, "name");
		

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Project project = ProjectLocalServiceUtil
				.createProject(CounterLocalServiceUtil.increment(Project.class.getName()));

		project.setGroupId(themeDisplay.getLayout().getGroupId());

		project.setName(name);
		

		ProjectLocalServiceUtil.updateProject(project);

	}

	public void addTaskCategory(ActionRequest request, ActionResponse response) throws PortalException {
	
		String category = ParamUtil.getString(request, "category");
		
		
		
		  ThemeDisplay themeDisplay = (ThemeDisplay)
		  request.getAttribute(WebKeys.THEME_DISPLAY);
		  
		  TaskCategory taskcategory = TaskCategoryLocalServiceUtil
		  .createTaskCategory(CounterLocalServiceUtil.increment(TaskCategory.class.
		  getName()));
		  
		  taskcategory.setGroupId(themeDisplay.getLayout().getGroupId());
		  
		  taskcategory.setType(category);;
		  
		  TaskCategoryLocalServiceUtil.updateTaskCategory(taskcategory);
		 
	}
	public void addResourceCategory(ActionRequest request, ActionResponse response) throws PortalException {
		
		String type = ParamUtil.getString(request, "type");
		
		
		
		  ThemeDisplay themeDisplay = (ThemeDisplay)
		  request.getAttribute(WebKeys.THEME_DISPLAY);
		  
		  ResourceCategory resourcecategory= ResourceCategoryLocalServiceUtil
		  .createResourceCategory(CounterLocalServiceUtil.increment(ResourceCategory.class.
		  getName()));
		  
		  resourcecategory.setGroupId(themeDisplay.getLayout().getGroupId());
		  
		  resourcecategory.setType(type);;
		  
		  ResourceCategoryLocalServiceUtil.updateResourceCategory(resourcecategory);
		 
	}
}