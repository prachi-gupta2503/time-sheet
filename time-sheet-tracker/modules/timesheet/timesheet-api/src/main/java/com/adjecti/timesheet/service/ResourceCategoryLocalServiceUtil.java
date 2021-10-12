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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ResourceCategory. This utility wraps
 * <code>com.adjecti.timesheet.service.impl.ResourceCategoryLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ResourceCategoryLocalService
 * @generated
 */
public class ResourceCategoryLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.timesheet.service.impl.ResourceCategoryLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

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
	public static com.adjecti.timesheet.model.ResourceCategory
		addResourceCategory(
			com.adjecti.timesheet.model.ResourceCategory resourceCategory) {

		return getService().addResourceCategory(resourceCategory);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new resource category with the primary key. Does not add the resource category to the database.
	 *
	 * @param resourceCategoryId the primary key for the new resource category
	 * @return the new resource category
	 */
	public static com.adjecti.timesheet.model.ResourceCategory
		createResourceCategory(long resourceCategoryId) {

		return getService().createResourceCategory(resourceCategoryId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
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
	public static com.adjecti.timesheet.model.ResourceCategory
			deleteResourceCategory(long resourceCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteResourceCategory(resourceCategoryId);
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
	public static com.adjecti.timesheet.model.ResourceCategory
		deleteResourceCategory(
			com.adjecti.timesheet.model.ResourceCategory resourceCategory) {

		return getService().deleteResourceCategory(resourceCategory);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.adjecti.timesheet.model.ResourceCategory
		fetchResourceCategory(long resourceCategoryId) {

		return getService().fetchResourceCategory(resourceCategoryId);
	}

	/**
	 * Returns the resource category matching the UUID and group.
	 *
	 * @param uuid the resource category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static com.adjecti.timesheet.model.ResourceCategory
		fetchResourceCategoryByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchResourceCategoryByUuidAndGroupId(
			uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.adjecti.timesheet.model.ResourceCategory>
		getResourceCategories(int start, int end) {

		return getService().getResourceCategories(start, end);
	}

	/**
	 * Returns all the resource categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource categories
	 * @param companyId the primary key of the company
	 * @return the matching resource categories, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.timesheet.model.ResourceCategory>
		getResourceCategoriesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getResourceCategoriesByUuidAndCompanyId(
			uuid, companyId);
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
	public static java.util.List<com.adjecti.timesheet.model.ResourceCategory>
		getResourceCategoriesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.timesheet.model.ResourceCategory>
					orderByComparator) {

		return getService().getResourceCategoriesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of resource categories.
	 *
	 * @return the number of resource categories
	 */
	public static int getResourceCategoriesCount() {
		return getService().getResourceCategoriesCount();
	}

	/**
	 * Returns the resource category with the primary key.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category
	 * @throws PortalException if a resource category with the primary key could not be found
	 */
	public static com.adjecti.timesheet.model.ResourceCategory
			getResourceCategory(long resourceCategoryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getResourceCategory(resourceCategoryId);
	}

	/**
	 * Returns the resource category matching the UUID and group.
	 *
	 * @param uuid the resource category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource category
	 * @throws PortalException if a matching resource category could not be found
	 */
	public static com.adjecti.timesheet.model.ResourceCategory
			getResourceCategoryByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getResourceCategoryByUuidAndGroupId(uuid, groupId);
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
	public static com.adjecti.timesheet.model.ResourceCategory
		updateResourceCategory(
			com.adjecti.timesheet.model.ResourceCategory resourceCategory) {

		return getService().updateResourceCategory(resourceCategory);
	}

	public static ResourceCategoryLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ResourceCategoryLocalService, ResourceCategoryLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ResourceCategoryLocalService.class);

		ServiceTracker
			<ResourceCategoryLocalService, ResourceCategoryLocalService>
				serviceTracker =
					new ServiceTracker
						<ResourceCategoryLocalService,
						 ResourceCategoryLocalService>(
							 bundle.getBundleContext(),
							 ResourceCategoryLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}