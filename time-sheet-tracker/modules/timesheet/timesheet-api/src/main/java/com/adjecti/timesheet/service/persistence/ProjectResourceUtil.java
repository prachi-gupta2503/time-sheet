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

package com.adjecti.timesheet.service.persistence;

import com.adjecti.timesheet.model.ProjectResource;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the project resource service. This utility wraps <code>com.adjecti.timesheet.service.persistence.impl.ProjectResourcePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectResourcePersistence
 * @generated
 */
public class ProjectResourceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ProjectResource projectResource) {
		getPersistence().clearCache(projectResource);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ProjectResource> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ProjectResource> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ProjectResource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ProjectResource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ProjectResource update(ProjectResource projectResource) {
		return getPersistence().update(projectResource);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ProjectResource update(
		ProjectResource projectResource, ServiceContext serviceContext) {

		return getPersistence().update(projectResource, serviceContext);
	}

	/**
	 * Returns all the project resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project resources
	 */
	public static List<ProjectResource> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the project resources where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @return the range of matching project resources
	 */
	public static List<ProjectResource> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the project resources where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project resources
	 */
	public static List<ProjectResource> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project resources where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project resources
	 */
	public static List<ProjectResource> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByUuid_First(
			String uuid, OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByUuid_First(
		String uuid, OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByUuid_Last(
			String uuid, OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the project resources before and after the current project resource in the ordered set where uuid = &#63;.
	 *
	 * @param projectResourceId the primary key of the current project resource
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public static ProjectResource[] findByUuid_PrevAndNext(
			long projectResourceId, String uuid,
			OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUuid_PrevAndNext(
			projectResourceId, uuid, orderByComparator);
	}

	/**
	 * Removes all the project resources where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of project resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project resources
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectResourceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByUUID_G(String uuid, long groupId)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the project resource where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project resource that was removed
	 */
	public static ProjectResource removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of project resources where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project resources
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project resources
	 */
	public static List<ProjectResource> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @return the range of matching project resources
	 */
	public static List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project resources
	 */
	public static List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project resources
	 */
	public static List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the project resources before and after the current project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param projectResourceId the primary key of the current project resource
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public static ProjectResource[] findByUuid_C_PrevAndNext(
			long projectResourceId, String uuid, long companyId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByUuid_C_PrevAndNext(
			projectResourceId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the project resources where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project resources
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the project resources where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @return the matching project resources
	 */
	public static List<ProjectResource> findByProjectResourceId(
		long projectResourceId) {

		return getPersistence().findByProjectResourceId(projectResourceId);
	}

	/**
	 * Returns a range of all the project resources where projectResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param projectResourceId the project resource ID
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @return the range of matching project resources
	 */
	public static List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end) {

		return getPersistence().findByProjectResourceId(
			projectResourceId, start, end);
	}

	/**
	 * Returns an ordered range of all the project resources where projectResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param projectResourceId the project resource ID
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching project resources
	 */
	public static List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().findByProjectResourceId(
			projectResourceId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project resources where projectResourceId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param projectResourceId the project resource ID
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching project resources
	 */
	public static List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByProjectResourceId(
			projectResourceId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByProjectResourceId_First(
			long projectResourceId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByProjectResourceId_First(
			projectResourceId, orderByComparator);
	}

	/**
	 * Returns the first project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByProjectResourceId_First(
		long projectResourceId,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().fetchByProjectResourceId_First(
			projectResourceId, orderByComparator);
	}

	/**
	 * Returns the last project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public static ProjectResource findByProjectResourceId_Last(
			long projectResourceId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByProjectResourceId_Last(
			projectResourceId, orderByComparator);
	}

	/**
	 * Returns the last project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public static ProjectResource fetchByProjectResourceId_Last(
		long projectResourceId,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().fetchByProjectResourceId_Last(
			projectResourceId, orderByComparator);
	}

	/**
	 * Removes all the project resources where projectResourceId = &#63; from the database.
	 *
	 * @param projectResourceId the project resource ID
	 */
	public static void removeByProjectResourceId(long projectResourceId) {
		getPersistence().removeByProjectResourceId(projectResourceId);
	}

	/**
	 * Returns the number of project resources where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @return the number of matching project resources
	 */
	public static int countByProjectResourceId(long projectResourceId) {
		return getPersistence().countByProjectResourceId(projectResourceId);
	}

	/**
	 * Caches the project resource in the entity cache if it is enabled.
	 *
	 * @param projectResource the project resource
	 */
	public static void cacheResult(ProjectResource projectResource) {
		getPersistence().cacheResult(projectResource);
	}

	/**
	 * Caches the project resources in the entity cache if it is enabled.
	 *
	 * @param projectResources the project resources
	 */
	public static void cacheResult(List<ProjectResource> projectResources) {
		getPersistence().cacheResult(projectResources);
	}

	/**
	 * Creates a new project resource with the primary key. Does not add the project resource to the database.
	 *
	 * @param projectResourceId the primary key for the new project resource
	 * @return the new project resource
	 */
	public static ProjectResource create(long projectResourceId) {
		return getPersistence().create(projectResourceId);
	}

	/**
	 * Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public static ProjectResource remove(long projectResourceId)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().remove(projectResourceId);
	}

	public static ProjectResource updateImpl(ProjectResource projectResource) {
		return getPersistence().updateImpl(projectResource);
	}

	/**
	 * Returns the project resource with the primary key or throws a <code>NoSuchProjectResourceException</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public static ProjectResource findByPrimaryKey(long projectResourceId)
		throws com.adjecti.timesheet.exception.NoSuchProjectResourceException {

		return getPersistence().findByPrimaryKey(projectResourceId);
	}

	/**
	 * Returns the project resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource, or <code>null</code> if a project resource with the primary key could not be found
	 */
	public static ProjectResource fetchByPrimaryKey(long projectResourceId) {
		return getPersistence().fetchByPrimaryKey(projectResourceId);
	}

	/**
	 * Returns all the project resources.
	 *
	 * @return the project resources
	 */
	public static List<ProjectResource> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the project resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @return the range of project resources
	 */
	public static List<ProjectResource> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the project resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of project resources
	 */
	public static List<ProjectResource> findAll(
		int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the project resources.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProjectResourceModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of project resources
	 * @param end the upper bound of the range of project resources (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of project resources
	 */
	public static List<ProjectResource> findAll(
		int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the project resources from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of project resources.
	 *
	 * @return the number of project resources
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ProjectResourcePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ProjectResourcePersistence, ProjectResourcePersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ProjectResourcePersistence.class);

		ServiceTracker<ProjectResourcePersistence, ProjectResourcePersistence>
			serviceTracker =
				new ServiceTracker
					<ProjectResourcePersistence, ProjectResourcePersistence>(
						bundle.getBundleContext(),
						ProjectResourcePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}