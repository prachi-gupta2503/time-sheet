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

import com.adjecti.timesheet.exception.NoSuchTaskCategoryException;
import com.adjecti.timesheet.model.TaskCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the task category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskCategoryUtil
 * @generated
 */
@ProviderType
public interface TaskCategoryPersistence extends BasePersistence<TaskCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskCategoryUtil} to access the task category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the task categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task categories
	 */
	public java.util.List<TaskCategory> findByUuid(String uuid);

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
	public java.util.List<TaskCategory> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<TaskCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

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
	public java.util.List<TaskCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the first task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

	/**
	 * Returns the last task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the last task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

	/**
	 * Returns the task categories before and after the current task category in the ordered set where uuid = &#63;.
	 *
	 * @param taskCategoryId the primary key of the current task category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public TaskCategory[] findByUuid_PrevAndNext(
			long taskCategoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Removes all the task categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of task categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task categories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByUUID_G(String uuid, long groupId)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the task category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task category that was removed
	 */
	public TaskCategory removeByUUID_G(String uuid, long groupId)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the number of task categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching task categories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching task categories
	 */
	public java.util.List<TaskCategory> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

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
	public java.util.List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the first task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

	/**
	 * Returns the last task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the last task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

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
	public TaskCategory[] findByUuid_C_PrevAndNext(
			long taskCategoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Removes all the task categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching task categories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the task categories where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @return the matching task categories
	 */
	public java.util.List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId);

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
	public java.util.List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end);

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
	public java.util.List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

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
	public java.util.List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByTaskCategoryId_First(
			long taskCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the first task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByTaskCategoryId_First(
		long taskCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

	/**
	 * Returns the last task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	public TaskCategory findByTaskCategoryId_Last(
			long taskCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
				orderByComparator)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the last task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	public TaskCategory fetchByTaskCategoryId_Last(
		long taskCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

	/**
	 * Removes all the task categories where taskCategoryId = &#63; from the database.
	 *
	 * @param taskCategoryId the task category ID
	 */
	public void removeByTaskCategoryId(long taskCategoryId);

	/**
	 * Returns the number of task categories where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @return the number of matching task categories
	 */
	public int countByTaskCategoryId(long taskCategoryId);

	/**
	 * Caches the task category in the entity cache if it is enabled.
	 *
	 * @param taskCategory the task category
	 */
	public void cacheResult(TaskCategory taskCategory);

	/**
	 * Caches the task categories in the entity cache if it is enabled.
	 *
	 * @param taskCategories the task categories
	 */
	public void cacheResult(java.util.List<TaskCategory> taskCategories);

	/**
	 * Creates a new task category with the primary key. Does not add the task category to the database.
	 *
	 * @param taskCategoryId the primary key for the new task category
	 * @return the new task category
	 */
	public TaskCategory create(long taskCategoryId);

	/**
	 * Removes the task category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category that was removed
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public TaskCategory remove(long taskCategoryId)
		throws NoSuchTaskCategoryException;

	public TaskCategory updateImpl(TaskCategory taskCategory);

	/**
	 * Returns the task category with the primary key or throws a <code>NoSuchTaskCategoryException</code> if it could not be found.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	public TaskCategory findByPrimaryKey(long taskCategoryId)
		throws NoSuchTaskCategoryException;

	/**
	 * Returns the task category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category, or <code>null</code> if a task category with the primary key could not be found
	 */
	public TaskCategory fetchByPrimaryKey(long taskCategoryId);

	/**
	 * Returns all the task categories.
	 *
	 * @return the task categories
	 */
	public java.util.List<TaskCategory> findAll();

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
	public java.util.List<TaskCategory> findAll(int start, int end);

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
	public java.util.List<TaskCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator);

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
	public java.util.List<TaskCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<TaskCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the task categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of task categories.
	 *
	 * @return the number of task categories
	 */
	public int countAll();

}