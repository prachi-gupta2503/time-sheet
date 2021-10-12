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

import com.adjecti.timesheet.model.ResourceCategory;

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
 * The persistence utility for the resource category service. This utility wraps <code>com.adjecti.timesheet.service.persistence.impl.ResourceCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceCategoryPersistence
 * @generated
 */
public class ResourceCategoryUtil {

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
	public static void clearCache(ResourceCategory resourceCategory) {
		getPersistence().clearCache(resourceCategory);
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
	public static Map<Serializable, ResourceCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ResourceCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ResourceCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ResourceCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ResourceCategory update(ResourceCategory resourceCategory) {
		return getPersistence().update(resourceCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ResourceCategory update(
		ResourceCategory resourceCategory, ServiceContext serviceContext) {

		return getPersistence().update(resourceCategory, serviceContext);
	}

	/**
	 * Returns all the resource categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource categories
	 */
	public static List<ResourceCategory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the resource categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @return the range of matching resource categories
	 */
	public static List<ResourceCategory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the resource categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource categories
	 */
	public static List<ResourceCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource categories
	 */
	public static List<ResourceCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByUuid_First(
			String uuid, OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByUuid_First(
		String uuid, OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByUuid_Last(
			String uuid, OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByUuid_Last(
		String uuid, OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the resource categories before and after the current resource category in the ordered set where uuid = &#63;.
	 *
	 * @param resourceCategoryId the primary key of the current resource category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public static ResourceCategory[] findByUuid_PrevAndNext(
			long resourceCategoryId, String uuid,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUuid_PrevAndNext(
			resourceCategoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the resource categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of resource categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource categories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByUUID_G(String uuid, long groupId)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the resource category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource category that was removed
	 */
	public static ResourceCategory removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of resource categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource categories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource categories
	 */
	public static List<ResourceCategory> findByUuid_C(
		String uuid, long companyId) {

		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @return the range of matching resource categories
	 */
	public static List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource categories
	 */
	public static List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource categories
	 */
	public static List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the resource categories before and after the current resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param resourceCategoryId the primary key of the current resource category
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public static ResourceCategory[] findByUuid_C_PrevAndNext(
			long resourceCategoryId, String uuid, long companyId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			resourceCategoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the resource categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource categories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the resource categories where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @return the matching resource categories
	 */
	public static List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId) {

		return getPersistence().findByResourceCategoryId(resourceCategoryId);
	}

	/**
	 * Returns a range of all the resource categories where resourceCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @return the range of matching resource categories
	 */
	public static List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end) {

		return getPersistence().findByResourceCategoryId(
			resourceCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the resource categories where resourceCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching resource categories
	 */
	public static List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().findByResourceCategoryId(
			resourceCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource categories where resourceCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching resource categories
	 */
	public static List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByResourceCategoryId(
			resourceCategoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByResourceCategoryId_First(
			long resourceCategoryId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByResourceCategoryId_First(
			resourceCategoryId, orderByComparator);
	}

	/**
	 * Returns the first resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByResourceCategoryId_First(
		long resourceCategoryId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().fetchByResourceCategoryId_First(
			resourceCategoryId, orderByComparator);
	}

	/**
	 * Returns the last resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public static ResourceCategory findByResourceCategoryId_Last(
			long resourceCategoryId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByResourceCategoryId_Last(
			resourceCategoryId, orderByComparator);
	}

	/**
	 * Returns the last resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public static ResourceCategory fetchByResourceCategoryId_Last(
		long resourceCategoryId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().fetchByResourceCategoryId_Last(
			resourceCategoryId, orderByComparator);
	}

	/**
	 * Removes all the resource categories where resourceCategoryId = &#63; from the database.
	 *
	 * @param resourceCategoryId the resource category ID
	 */
	public static void removeByResourceCategoryId(long resourceCategoryId) {
		getPersistence().removeByResourceCategoryId(resourceCategoryId);
	}

	/**
	 * Returns the number of resource categories where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @return the number of matching resource categories
	 */
	public static int countByResourceCategoryId(long resourceCategoryId) {
		return getPersistence().countByResourceCategoryId(resourceCategoryId);
	}

	/**
	 * Caches the resource category in the entity cache if it is enabled.
	 *
	 * @param resourceCategory the resource category
	 */
	public static void cacheResult(ResourceCategory resourceCategory) {
		getPersistence().cacheResult(resourceCategory);
	}

	/**
	 * Caches the resource categories in the entity cache if it is enabled.
	 *
	 * @param resourceCategories the resource categories
	 */
	public static void cacheResult(List<ResourceCategory> resourceCategories) {
		getPersistence().cacheResult(resourceCategories);
	}

	/**
	 * Creates a new resource category with the primary key. Does not add the resource category to the database.
	 *
	 * @param resourceCategoryId the primary key for the new resource category
	 * @return the new resource category
	 */
	public static ResourceCategory create(long resourceCategoryId) {
		return getPersistence().create(resourceCategoryId);
	}

	/**
	 * Removes the resource category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category that was removed
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public static ResourceCategory remove(long resourceCategoryId)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().remove(resourceCategoryId);
	}

	public static ResourceCategory updateImpl(
		ResourceCategory resourceCategory) {

		return getPersistence().updateImpl(resourceCategory);
	}

	/**
	 * Returns the resource category with the primary key or throws a <code>NoSuchResourceCategoryException</code> if it could not be found.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public static ResourceCategory findByPrimaryKey(long resourceCategoryId)
		throws com.adjecti.timesheet.exception.NoSuchResourceCategoryException {

		return getPersistence().findByPrimaryKey(resourceCategoryId);
	}

	/**
	 * Returns the resource category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category, or <code>null</code> if a resource category with the primary key could not be found
	 */
	public static ResourceCategory fetchByPrimaryKey(long resourceCategoryId) {
		return getPersistence().fetchByPrimaryKey(resourceCategoryId);
	}

	/**
	 * Returns all the resource categories.
	 *
	 * @return the resource categories
	 */
	public static List<ResourceCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the resource categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @return the range of resource categories
	 */
	public static List<ResourceCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the resource categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of resource categories
	 */
	public static List<ResourceCategory> findAll(
		int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the resource categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of resource categories
	 */
	public static List<ResourceCategory> findAll(
		int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the resource categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of resource categories.
	 *
	 * @return the number of resource categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ResourceCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ResourceCategoryPersistence, ResourceCategoryPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ResourceCategoryPersistence.class);

		ServiceTracker<ResourceCategoryPersistence, ResourceCategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<ResourceCategoryPersistence, ResourceCategoryPersistence>(
						bundle.getBundleContext(),
						ResourceCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}