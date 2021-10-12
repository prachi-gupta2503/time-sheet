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
 * Provides a wrapper for {@link TaskCategoryService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskCategoryService
 * @generated
 */
public class TaskCategoryServiceWrapper
	implements ServiceWrapper<TaskCategoryService>, TaskCategoryService {

	public TaskCategoryServiceWrapper(TaskCategoryService taskCategoryService) {
		_taskCategoryService = taskCategoryService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskCategoryService.getOSGiServiceIdentifier();
	}

	@Override
	public TaskCategoryService getWrappedService() {
		return _taskCategoryService;
	}

	@Override
	public void setWrappedService(TaskCategoryService taskCategoryService) {
		_taskCategoryService = taskCategoryService;
	}

	private TaskCategoryService _taskCategoryService;

}