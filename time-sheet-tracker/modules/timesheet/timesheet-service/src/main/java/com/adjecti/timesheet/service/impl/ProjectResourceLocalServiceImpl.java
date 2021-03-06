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

import com.adjecti.timesheet.model.ProjectResource;
import com.adjecti.timesheet.service.base.ProjectResourceLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the project resource local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.timesheet.service.ProjectResourceLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectResourceLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.timesheet.model.ProjectResource",
	service = AopService.class
)
public class ProjectResourceLocalServiceImpl
	extends ProjectResourceLocalServiceBaseImpl {
	
	
public List<ProjectResource> findByProjectId(long projectId){
  return	projectResourcePersistence.findByProjectId(projectId);
}
public List<ProjectResource> findByEmployeeId(long employeeId){
	  return	projectResourcePersistence.findByEmployeeId(employeeId);
	}

}