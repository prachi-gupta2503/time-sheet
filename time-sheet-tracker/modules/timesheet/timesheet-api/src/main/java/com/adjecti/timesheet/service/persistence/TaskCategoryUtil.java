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

import com.adjecti.timesheet.model.TaskCategory;

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
 * The persistence utility for the task category service. This utility wraps <code>com.adjecti.timesheet.service.persistence.impl.TaskCategoryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskCategoryPersistence
 * @generated
 */
public class TaskCategoryUtil {

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
	public static void clearCache(TaskCategory taskCategory) {
		getPersistence().clearCache(taskCategory);
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
	public static Map<Serializable, TaskCategory> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<TaskCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskCategory> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static TaskCategory update(TaskCategory taskCategory) {
		return getPersistence().update(taskCategory);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static TaskCategory update(
		TaskCategory taskCategory, ServiceContext serviceContext) {

		return getPersistence().update(taskCategory, serviceContext);
	}

	/**
	 * Returns all the task categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task categories
	 */
	public static List<TaskCategory> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the task categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @return the range of matching task categories
	 */
	public static List<TaskCategory> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the task categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task categories
	 */
	public static List<TaskCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task categories where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task categories
	 */
	public static List<TaskCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByUuid_First(
			String uuid, OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByUuid_First(
		String uuid, OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByUuid_Last(
			String uuid, OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByUuid_Last(
		String uuid, OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the task categories before and after the current task category in the ordered set where uuid = &#63;.
	 *
	 * @param taskCategoryId the primary key of the current task category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public static TaskCategory[] findByUuid_PrevAndNext(
			long taskCategoryId, String uuid,
			OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUuid_PrevAndNext(
			taskCategoryId, uuid, orderByComparator);
	}

	/**
	 * Removes all the task categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of task categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task categories
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByUUID_G(String uuid, long groupId)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the task category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task category that was removed
	 */
	public static TaskCategory removeByUUID_G(String uuid, long groupId)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of task categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching task categories
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching task categories
	 */
	public static List<TaskCategory> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @return the range of matching task categories
	 */
	public static List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task categories
	 */
	public static List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task categories
	 */
	public static List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the task categories before and after the current task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param taskCategoryId the primary key of the current task category
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public static TaskCategory[] findByUuid_C_PrevAndNext(
			long taskCategoryId, String uuid, long companyId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByUuid_C_PrevAndNext(
			taskCategoryId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the task categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching task categories
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the task categories where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @return the matching task categories
	 */
	public static List<TaskCategory> findByTaskCategoryId(long taskCategoryId) {
		return getPersistence().findByTaskCategoryId(taskCategoryId);
	}

	/**
	 * Returns a range of all the task categories where taskCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param taskCategoryId the task category ID
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @return the range of matching task categories
	 */
	public static List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end) {

		return getPersistence().findByTaskCategoryId(
			taskCategoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the task categories where taskCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param taskCategoryId the task category ID
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching task categories
	 */
	public static List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().findByTaskCategoryId(
			taskCategoryId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task categories where taskCategoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param taskCategoryId the task category ID
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching task categories
	 */
	public static List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByTaskCategoryId(
			taskCategoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByTaskCategoryId_First(
			long taskCategoryId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByTaskCategoryId_First(
			taskCategoryId, orderByComparator);
	}

	/**
	 * Returns the first task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByTaskCategoryId_First(
		long taskCategoryId,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().fetchByTaskCategoryId_First(
			taskCategoryId, orderByComparator);
	}

	/**
	 * Returns the last task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public static TaskCategory findByTaskCategoryId_Last(
			long taskCategoryId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByTaskCategoryId_Last(
			taskCategoryId, orderByComparator);
	}

	/**
	 * Returns the last task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public static TaskCategory fetchByTaskCategoryId_Last(
		long taskCategoryId,
		OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().fetchByTaskCategoryId_Last(
			taskCategoryId, orderByComparator);
	}

	/**
	 * Removes all the task categories where taskCategoryId = &#63; from the database.
	 *
	 * @param taskCategoryId the task category ID
	 */
	public static void removeByTaskCategoryId(long taskCategoryId) {
		getPersistence().removeByTaskCategoryId(taskCategoryId);
	}

	/**
	 * Returns the number of task categories where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @return the number of matching task categories
	 */
	public static int countByTaskCategoryId(long taskCategoryId) {
		return getPersistence().countByTaskCategoryId(taskCategoryId);
	}

	/**
	 * Caches the task category in the entity cache if it is enabled.
	 *
	 * @param taskCategory the task category
	 */
	public static void cacheResult(TaskCategory taskCategory) {
		getPersistence().cacheResult(taskCategory);
	}

	/**
	 * Caches the task categories in the entity cache if it is enabled.
	 *
	 * @param taskCategories the task categories
	 */
	public static void cacheResult(List<TaskCategory> taskCategories) {
		getPersistence().cacheResult(taskCategories);
	}

	/**
	 * Creates a new task category with the primary key. Does not add the task category to the database.
	 *
	 * @param taskCategoryId the primary key for the new task category
	 * @return the new task category
	 */
	public static TaskCategory create(long taskCategoryId) {
		return getPersistence().create(taskCategoryId);
	}

	/**
	 * Removes the task category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category that was removed
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public static TaskCategory remove(long taskCategoryId)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().remove(taskCategoryId);
	}

	public static TaskCategory updateImpl(TaskCategory taskCategory) {
		return getPersistence().updateImpl(taskCategory);
	}

	/**
	 * Returns the task category with the primary key or throws a <code>NoSuchTaskCategoryException</code> if it could not be found.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public static TaskCategory findByPrimaryKey(long taskCategoryId)
		throws com.adjecti.timesheet.exception.NoSuchTaskCategoryException {

		return getPersistence().findByPrimaryKey(taskCategoryId);
	}

	/**
	 * Returns the task category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category, or <code>null</code> if a task category with the primary key could not be found
	 */
	public static TaskCategory fetchByPrimaryKey(long taskCategoryId) {
		return getPersistence().fetchByPrimaryKey(taskCategoryId);
	}

	/**
	 * Returns all the task categories.
	 *
	 * @return the task categories
	 */
	public static List<TaskCategory> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the task categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @return the range of task categories
	 */
	public static List<TaskCategory> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the task categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of task categories
	 */
	public static List<TaskCategory> findAll(
		int start, int end, OrderByComparator<TaskCategory> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the task categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>TaskCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of task categories
	 * @param end the upper bound of the range of task categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of task categories
	 */
	public static List<TaskCategory> findAll(
		int start, int end, OrderByComparator<TaskCategory> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the task categories from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of task categories.
	 *
	 * @return the number of task categories
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static TaskCategoryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<TaskCategoryPersistence, TaskCategoryPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(TaskCategoryPersistence.class);

		ServiceTracker<TaskCategoryPersistence, TaskCategoryPersistence>
			serviceTracker =
				new ServiceTracker
					<TaskCategoryPersistence, TaskCategoryPersistence>(
						bundle.getBundleContext(),
						TaskCategoryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}