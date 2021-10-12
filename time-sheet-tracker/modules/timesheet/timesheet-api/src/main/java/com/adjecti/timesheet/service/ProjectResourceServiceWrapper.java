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

package com.adjecti.timesheet.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectResourceService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectResourceService
 * @generated
 */
public class ProjectResourceServiceWrapper
	implements ProjectResourceService, ServiceWrapper<ProjectResourceService> {

	public ProjectResourceServiceWrapper(
		ProjectResourceService projectResourceService) {

		_projectResourceService = projectResourceService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectResourceService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectResourceService getWrappedService() {
		return _projectResourceService;
	}

	@Override
	public void setWrappedService(
		ProjectResourceService projectResourceService) {

		_projectResourceService = projectResourceService;
	}

	private ProjectResourceService _projectResourceService;

}