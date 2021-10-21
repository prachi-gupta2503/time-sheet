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
import com.adjecti.timesheet.service.base.ProjectLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.adjecti.timesheet.service.ProjectLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.adjecti.timesheet.model.Project",
	service = AopService.class
)
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.adjecti.timesheet.service.ProjectLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.timesheet.service.ProjectLocalServiceUtil</code>.
	 */
	
	public Project findByProjectId(long projectId) {
		Project findByProjectId=null;
		try {
			 findByProjectId = projectPersistence.findByProjectId(projectId);
		} catch (NoSuchProjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return findByProjectId;
	}
}