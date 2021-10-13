package com.adjecti.timesheet.portlet;

import com.adjecti.timesheet.constants.TimesheetWebPortletKeys;
import com.adjecti.timesheet.model.Project;
import com.adjecti.timesheet.model.ResourceCategory;
import com.adjecti.timesheet.model.TaskCategory;
import com.adjecti.timesheet.service.ProjectLocalService;
import com.adjecti.timesheet.service.ResourceCategoryLocalService;
import com.adjecti.timesheet.service.TaskCategoryLocalService;
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
    @Reference
    private ResourceCategoryLocalService _resourceCategoryLocalService;
	

	public void addProject(ActionRequest request, ActionResponse response) throws PortalException {

		String name = ParamUtil.getString(request, "name");
		
        System.out.println("name "+name);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		Project project = _projectLocalService.createProject(CounterLocalServiceUtil.increment(Project.class.getName()));
		System.out.println("project "+project);
		project.setGroupId(themeDisplay.getLayout().getGroupId());
        project.setUserName(themeDisplay.getLayout().getUserName());
        project.setCreateDate(themeDisplay.getLayout().getCreateDate());
        project.setModifiedDate(themeDisplay.getLayout().getModifiedDate());
		project.setName(name);
		

		_projectLocalService.updateProject(project);

	}

	public void addTaskCategory(ActionRequest request, ActionResponse response) throws PortalException {
	
		String category = ParamUtil.getString(request, "category");
		
		
		
		  ThemeDisplay themeDisplay = (ThemeDisplay)
		  request.getAttribute(WebKeys.THEME_DISPLAY);
		  
		  TaskCategory taskcategory = _taskCategoryLocalService
		  .createTaskCategory(CounterLocalServiceUtil.increment(TaskCategory.class.
		  getName()));
		  
		  taskcategory.setGroupId(themeDisplay.getLayout().getGroupId());
		  taskcategory.setUserName(themeDisplay.getLayout().getUserName());
		  taskcategory.setCreateDate(themeDisplay.getLayout().getCreateDate());
		  taskcategory.setModifiedDate(themeDisplay.getLayout().getModifiedDate());
		  taskcategory.setType(category);;
		  
		  _taskCategoryLocalService.updateTaskCategory(taskcategory);
		 
	}
	public void addResourceCategory(ActionRequest request, ActionResponse response) throws PortalException {
		
		String type = ParamUtil.getString(request, "type");
		
		
		
		  ThemeDisplay themeDisplay = (ThemeDisplay)
		  request.getAttribute(WebKeys.THEME_DISPLAY);
		  
		  ResourceCategory resourcecategory= _resourceCategoryLocalService
		  .createResourceCategory(CounterLocalServiceUtil.increment(ResourceCategory.class.
		  getName()));
		  
		  resourcecategory.setGroupId(themeDisplay.getLayout().getGroupId());
		  resourcecategory.setUserName(themeDisplay.getLayout().getUserName());
		  resourcecategory.setCreateDate(themeDisplay.getLayout().getCreateDate());
		  resourcecategory.setModifiedDate(themeDisplay.getLayout().getModifiedDate());
		  resourcecategory.setType(type);;
		  
		  _resourceCategoryLocalService.updateResourceCategory(resourcecategory);
		 
	}
}