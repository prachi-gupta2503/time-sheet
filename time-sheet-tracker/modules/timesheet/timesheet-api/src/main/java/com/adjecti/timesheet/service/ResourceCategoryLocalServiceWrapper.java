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
 * Provides a wrapper for {@link ResourceCategoryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceCategoryLocalService
 * @generated
 */
public class ResourceCategoryLocalServiceWrapper
	implements ResourceCategoryLocalService,
			   ServiceWrapper<ResourceCategoryLocalService> {

	public ResourceCategoryLocalServiceWrapper(
		ResourceCategoryLocalService resourceCategoryLocalService) {

		_resourceCategoryLocalService = resourceCategoryLocalService;
	}

	/**
	 * Adds the resource category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategory the resource category
	 * @return the resource category that was added
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory addResourceCategory(
		com.adjecti.timesheet.model.ResourceCategory resourceCategory) {

		return _resourceCategoryLocalService.addResourceCategory(
			resourceCategory);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceCategoryLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Creates a new resource category with the primary key. Does not add the resource category to the database.
	 *
	 * @param resourceCategoryId the primary key for the new resource category
	 * @return the new resource category
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory createResourceCategory(
		long resourceCategoryId) {

		return _resourceCategoryLocalService.createResourceCategory(
			resourceCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceCategoryLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the resource category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category that was removed
	 * @throws PortalException if a resource category with the primary key could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory deleteResourceCategory(
			long resourceCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceCategoryLocalService.deleteResourceCategory(
			resourceCategoryId);
	}

	/**
	 * Deletes the resource category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategory the resource category
	 * @return the resource category that was removed
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory deleteResourceCategory(
		com.adjecti.timesheet.model.ResourceCategory resourceCategory) {

		return _resourceCategoryLocalService.deleteResourceCategory(
			resourceCategory);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _resourceCategoryLocalService.dynamicQuery();
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

		return _resourceCategoryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl</code>.
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

		return _resourceCategoryLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl</code>.
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

		return _resourceCategoryLocalService.dynamicQuery(
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

		return _resourceCategoryLocalService.dynamicQueryCount(dynamicQuery);
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

		return _resourceCategoryLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.adjecti.timesheet.model.ResourceCategory fetchResourceCategory(
		long resourceCategoryId) {

		return _resourceCategoryLocalService.fetchResourceCategory(
			resourceCategoryId);
	}

	/**
	 * Returns the resource category matching the UUID and group.
	 *
	 * @param uuid the resource category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory
		fetchResourceCategoryByUuidAndGroupId(String uuid, long groupId) {

		return _resourceCategoryLocalService.
			fetchResourceCategoryByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _resourceCategoryLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _resourceCategoryLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _resourceCategoryLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _resourceCategoryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceCategoryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns a range of all the resource categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @return the range of resource categories
	 */
	@Override
	public java.util.List<com.adjecti.timesheet.model.ResourceCategory>
		getResourceCategories(int start, int end) {

		return _resourceCategoryLocalService.getResourceCategories(start, end);
	}

	/**
	 * Returns all the resource categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource categories
	 * @param companyId the primary key of the company
	 * @return the matching resource categories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.timesheet.model.ResourceCategory>
		getResourceCategoriesByUuidAndCompanyId(String uuid, long companyId) {

		return _resourceCategoryLocalService.
			getResourceCategoriesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of resource categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource categories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching resource categories, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.adjecti.timesheet.model.ResourceCategory>
		getResourceCategoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.timesheet.model.ResourceCategory>
					orderByComparator) {

		return _resourceCategoryLocalService.
			getResourceCategoriesByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of resource categories.
	 *
	 * @return the number of resource categories
	 */
	@Override
	public int getResourceCategoriesCount() {
		return _resourceCategoryLocalService.getResourceCategoriesCount();
	}

	/**
	 * Returns the resource category with the primary key.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category
	 * @throws PortalException if a resource category with the primary key could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory getResourceCategory(
			long resourceCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceCategoryLocalService.getResourceCategory(
			resourceCategoryId);
	}

	/**
	 * Returns the resource category matching the UUID and group.
	 *
	 * @param uuid the resource category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource category
	 * @throws PortalException if a matching resource category could not be found
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory
			getResourceCategoryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _resourceCategoryLocalService.
			getResourceCategoryByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Updates the resource category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategory the resource category
	 * @return the resource category that was updated
	 */
	@Override
	public com.adjecti.timesheet.model.ResourceCategory updateResourceCategory(
		com.adjecti.timesheet.model.ResourceCategory resourceCategory) {

		return _resourceCategoryLocalService.updateResourceCategory(
			resourceCategory);
	}

	@Override
	public ResourceCategoryLocalService getWrappedService() {
		return _resourceCategoryLocalService;
	}

	@Override
	public void setWrappedService(
		ResourceCategoryLocalService resourceCategoryLocalService) {

		_resourceCategoryLocalService = resourceCategoryLocalService;
	}

	private ResourceCategoryLocalService _resourceCategoryLocalService;

}