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

import com.adjecti.timesheet.exception.NoSuchProjectException;
import com.adjecti.timesheet.model.Project;
import com.adjecti.timesheet.model.ResourceTask;
import com.adjecti.timesheet.model.Task;
import com.adjecti.timesheet.service.base.ResourceTaskLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the resource task local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.timesheet.service.ResourceTaskLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceTaskLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.timesheet.model.ResourceTask",
	service = AopService.class
)
public class ResourceTaskLocalServiceImpl
	extends ResourceTaskLocalServiceBaseImpl {

	public List<ResourceTask> findTaskByEmployeeId(long employeeId){
		return resourceTaskPersistence.findByEmployeeId(employeeId);
	}
	public List<Object> findAllByResourceTask(long resourceTaskId) {
		List<Object>list=new ArrayList<>();
		ResourceTask resourceTask=resourceTaskPersistence.fetchByPrimaryKey(resourceTaskId);
		 Task task=taskPersistence.fetchByTaskId(resourceTask.getTaskId());
		 Project project=null;
		 try {
			 project=projectPersistence.findByProjectId(task.getProjectId());
		} catch (NoSuchProjectException e) {
			
			e.printStackTrace();
		}
		 list=Arrays.asList(task.getTaskName(),project.getName(),resourceTask.getFromDate(),resourceTask.getToDate(),resourceTask.getHour());
		
		return list;
	}
}