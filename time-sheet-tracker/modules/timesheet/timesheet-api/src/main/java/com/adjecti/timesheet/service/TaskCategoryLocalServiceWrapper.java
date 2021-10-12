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
 * Provides a wrapper for {@link TaskCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TaskCategoryLocalService
 * @generated
 */
public class TaskCategoryLocalServiceWrapper
	implements ServiceWrapper<TaskCategoryLocalService>,
			   TaskCategoryLocalService {

	public TaskCategoryLocalServiceWrapper(
		TaskCategoryLocalService taskCategoryLocalService) {

		_taskCategoryLocalService = taskCategoryLocalService;
	}

	/**
	 * Adds the task category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskCategory the task category
	 * @return the task category that was added
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory addTaskCategory(
		com.adjecti.timesheet.model.TaskCategory taskCategory) {

		return _taskCategoryLocalService.addTaskCategory(taskCategory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskCategoryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new task category with the primary key. Does not add the task category to the database.
	 *
	 * @param taskCategoryId the primary key for the new task category
	 * @return the new task category
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory createTaskCategory(
		long taskCategoryId) {

		return _taskCategoryLocalService.createTaskCategory(taskCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskCategoryLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the task category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category that was removed
	 * @throws PortalException if a task category with the primary key could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory deleteTaskCategory(
			long taskCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskCategoryLocalService.deleteTaskCategory(taskCategoryId);
	}

	/**
	 * Deletes the task category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskCategory the task category
	 * @return the task category that was removed
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory deleteTaskCategory(
		com.adjecti.timesheet.model.TaskCategory taskCategory) {

		return _taskCategoryLocalService.deleteTaskCategory(taskCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _taskCategoryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _taskCategoryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _taskCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _taskCategoryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _taskCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.timesheet.model.TaskCategory fetchTaskCategory(
		long taskCategoryId) {

		return _taskCategoryLocalService.fetchTaskCategory(taskCategoryId);
	}

	/**
	 * Returns the task category matching the UUID and group.
	 *
	 * @param uuid the task category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory
		fetchTaskCategoryByUuidAndGroupId(String uuid, long groupId) {

		return _taskCategoryLocalService.fetchTaskCategoryByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _taskCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _taskCategoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _taskCategoryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _taskCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the task categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @return the range of task categories
	 */
	@Override
	public java.util.List<com.adjecti.timesheet.model.TaskCategory>
		getTaskCategories(int start, int end) {

		return _taskCategoryLocalService.getTaskCategories(start, end);
	}

	/**
	 * Returns all the task categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the task categories
	 * @param companyId the primary key of the company
	 * @return the matching task categories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.timesheet.model.TaskCategory>
		getTaskCategoriesByUuidAndCompanyId(String uuid, long companyId) {

		return _taskCategoryLocalService.getTaskCategoriesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of task categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the task categories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching task categories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.timesheet.model.TaskCategory>
		getTaskCategoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.timesheet.model.TaskCategory> orderByComparator) {

		return _taskCategoryLocalService.getTaskCategoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of task categories.
	 *
	 * @return the number of task categories
	 */
	@Override
	public int getTaskCategoriesCount() {
		return _taskCategoryLocalService.getTaskCategoriesCount();
	}

	/**
	 * Returns the task category with the primary key.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category
	 * @throws PortalException if a task category with the primary key could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory getTaskCategory(
			long taskCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskCategoryLocalService.getTaskCategory(taskCategoryId);
	}

	/**
	 * Returns the task category matching the UUID and group.
	 *
	 * @param uuid the task category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching task category
	 * @throws PortalException if a matching task category could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory
			getTaskCategoryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _taskCategoryLocalService.getTaskCategoryByUuidAndGroupId(
			uuid, groupId);
	}

	/**
	 * Updates the task category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect TaskCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param taskCategory the task category
	 * @return the task category that was updated
	 */
	@Override
	public com.adjecti.timesheet.model.TaskCategory updateTaskCategory(
		com.adjecti.timesheet.model.TaskCategory taskCategory) {

		return _taskCategoryLocalService.updateTaskCategory(taskCategory);
	}

	@Override
	public TaskCategoryLocalService getWrappedService() {
		return _taskCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		TaskCategoryLocalService taskCategoryLocalService) {

		_taskCategoryLocalService = taskCategoryLocalService;
	}

	private TaskCategoryLocalService _taskCategoryLocalService;

}