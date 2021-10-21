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
import com.adjecti.timesheet.service.base.TaskLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.timesheet.service.TaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.timesheet.model.Task",
	service = AopService.class
)
public class TaskLocalServiceImpl extends TaskLocalServiceBaseImpl {

	
	 public List<Task> findByProjectId(long projectId) {
		 return taskPersistence.findByProjectId(projectId);
	 }
	
	 
	
	/*
	 * public List<TaskCategoryDTO> findTaskAndCategory(long projectId){
	 * List<TaskCategoryDTO> list1=new LinkedList<TaskCategoryDTO>();
	 * 
	 * List<Task> findByProjectId = taskPersistence.findByProjectId(projectId);
	 * for(Task task: findByProjectId) { TaskCategoryDTO taskCategoryDTO=new
	 * TaskCategoryDTO();
	 * 
	 * List<TaskCategory> taskCategory=
	 * taskCategoryPersistence.findByTaskCategoryId(task.getTaskCategoryId());
	 * taskCategoryDTO.setTaskName(task.getTaskName()); for(TaskCategory
	 * t:taskCategory) taskCategoryDTO.setTaskCategoryName(t.getType());
	 * 
	 * list1.add(taskCategoryDTO); }
	 * 
	 * return list1; }
	 */
	 public List<Object> find(Long projectId){
		List<Object>object=new ArrayList<>();
			List<Task>tasklist=taskPersistence.findByProjectId(projectId);
			object.add(0, tasklist);
			
			List<TaskCategory>taskcategorylist = new ArrayList<>();
			
			for(Task task:tasklist) {
				System.out.println(task.getTaskName());
				taskcategorylist.add( taskCategoryPersistence.findByTaskCategoryId(task.getTaskCategoryId()).get(0));
			}
			object.add(1, taskcategorylist);
			System.out.println(object);
		
				return object;
			}
	
	
}