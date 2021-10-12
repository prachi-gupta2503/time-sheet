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
 * Provides the local service utility for ProjectResource. This utility wraps
 * <code>com.adjecti.timesheet.service.impl.ProjectResourceLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ProjectResourceLocalService
 * @generated
 */
public class ProjectResourceLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.adjecti.timesheet.service.impl.ProjectResourceLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the project resource to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectResource the project resource
	 * @return the project resource that was added
	 */
	public static com.adjecti.timesheet.model.ProjectResource
		addProjectResource(
			com.adjecti.timesheet.model.ProjectResource projectResource) {

		return getService().addProjectResource(projectResource);
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
	 * Creates a new project resource with the primary key. Does not add the project resource to the database.
	 *
	 * @param projectResourceId the primary key for the new project resource
	 * @return the new project resource
	 */
	public static com.adjecti.timesheet.model.ProjectResource
		createProjectResource(long projectResourceId) {

		return getService().createProjectResource(projectResourceId);
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
	 * Deletes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws PortalException if a project resource with the primary key could not be found
	 */
	public static com.adjecti.timesheet.model.ProjectResource
			deleteProjectResource(long projectResourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteProjectResource(projectResourceId);
	}

	/**
	 * Deletes the project resource from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectResource the project resource
	 * @return the project resource that was removed
	 */
	public static com.adjecti.timesheet.model.ProjectResource
		deleteProjectResource(
			com.adjecti.timesheet.model.ProjectResource projectResource) {

		return getService().deleteProjectResource(projectResource);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ProjectResourceModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ProjectResourceModelImpl</code>.
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

	public static com.adjecti.timesheet.model.ProjectResource
		fetchProjectResource(long projectResourceId) {

		return getService().fetchProjectResource(projectResourceId);
	}

	/**
	 * Returns the project resource matching the UUID and group.
	 *
	 * @param uuid the project resource's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static com.adjecti.timesheet.model.ProjectResource
		fetchProjectResourceByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchProjectResourceByUuidAndGroupId(uuid, groupId);
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
	 * Returns the project resource with the primary key.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource
	 * @throws PortalException if a project resource with the primary key could not be found
	 */
	public static com.adjecti.timesheet.model.ProjectResource
			getProjectResource(long projectResourceId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProjectResource(projectResourceId);
	}

	/**
	 * Returns the project resource matching the UUID and group.
	 *
	 * @param uuid the project resource's UUID
	 * @param groupId the primary key of the group
	 * @return the matching project resource
	 * @throws PortalException if a matching project resource could not be found
	 */
	public static com.adjecti.timesheet.model.ProjectResource
			getProjectResourceByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProjectResourceByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the project resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @return the range of project resources
	 */
	public static java.util.List<com.adjecti.timesheet.model.ProjectResource>
		getProjectResources(int start, int end) {

		return getService().getProjectResources(start, end);
	}

	/**
	 * Returns all the project resources matching the UUID and company.
	 *
	 * @param uuid the UUID of the project resources
	 * @param companyId the primary key of the company
	 * @return the matching project resources, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.timesheet.model.ProjectResource>
		getProjectResourcesByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getProjectResourcesByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of project resources matching the UUID and company.
	 *
	 * @param uuid the UUID of the project resources
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching project resources, or an empty list if no matches were found
	 */
	public static java.util.List<com.adjecti.timesheet.model.ProjectResource>
		getProjectResourcesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.adjecti.timesheet.model.ProjectResource>
					orderByComparator) {

		return getService().getProjectResourcesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of project resources.
	 *
	 * @return the number of project resources
	 */
	public static int getProjectResourcesCount() {
		return getService().getProjectResourcesCount();
	}

	/**
	 * Updates the project resource in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ProjectResourceLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param projectResource the project resource
	 * @return the project resource that was updated
	 */
	public static com.adjecti.timesheet.model.ProjectResource
		updateProjectResource(
			com.adjecti.timesheet.model.ProjectResource projectResource) {

		return getService().updateProjectResource(projectResource);
	}

	public static ProjectResourceLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProjectResourceLocalService, ProjectResourceLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProjectResourceLocalService.class);

		ServiceTracker<ProjectResourceLocalService, ProjectResourceLocalService>
			serviceTracker =
				new ServiceTracker
					<ProjectResourceLocalService, ProjectResourceLocalService>(
						bundle.getBundleContext(),
						ProjectResourceLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}