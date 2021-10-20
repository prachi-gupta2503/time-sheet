/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.adjecti.timesheet.service.impl;

import com.adjecti.timesheet.model.Task;
import com.adjecti.timesheet.model.TaskCategory;
import com.adjecti.timesheet.model.TaskCategoryDTO;
import com.adjecti.timesheet.service.TaskCategoryLocalService;
import com.adjecti.timesheet.service.base.TaskServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.timesheet.service.TaskService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=timesheet",
		"json.web.service.context.path=Task"
	},
	service = AopService.class
)
public class TaskServiceImpl extends TaskServiceBaseImpl {

	@Reference
	TaskCategoryLocalService taskCategoryLocalService;
	
	 public List<Task> findByProjectId(long projectId) {
		 return taskLocalService.findByProjectId(projectId);
	 }
	public List<Object> find(long projectId){
		return taskLocalService.find(projectId);
	}
	 
	/*
	 * public List<TaskCategoryDTO> findTaskAndCategory(long projectId){
	 * List<TaskCategoryDTO> list1=new LinkedList<TaskCategoryDTO>();
	 * 
	 * List<Task> findByProjectId = taskLocalService.findByProjectId(projectId);
	 * for(Task task: findByProjectId) { TaskCategoryDTO taskCategoryDTO=new
	 * TaskCategoryDTO();
	 * 
	 * List<TaskCategory> taskCategory=
	 * taskCategoryLocalService.findByTaskCategoryId(task.getTaskCategoryId());
	 * taskCategoryDTO.setTaskName(task.getTaskName()); for(TaskCategory
	 * t:taskCategory) taskCategoryDTO.setTaskCategoryName(t.getType());
	 * 
	 * list1.add(taskCategoryDTO); }
	 * 
	 * return list1; }
	 */
	
}