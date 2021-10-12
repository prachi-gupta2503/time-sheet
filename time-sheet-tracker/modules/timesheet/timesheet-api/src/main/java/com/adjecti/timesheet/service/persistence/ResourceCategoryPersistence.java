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

import com.adjecti.timesheet.exception.NoSuchResourceCategoryException;
import com.adjecti.timesheet.model.ResourceCategory;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the resource category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceCategoryUtil
 * @generated
 */
@ProviderType
public interface ResourceCategoryPersistence
	extends BasePersistence<ResourceCategory> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ResourceCategoryUtil} to access the resource category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the resource categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource categories
	 */
	public java.util.List<ResourceCategory> findByUuid(String uuid);

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
	public java.util.List<ResourceCategory> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ResourceCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

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
	public java.util.List<ResourceCategory> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

	/**
	 * Returns the resource categories before and after the current resource category in the ordered set where uuid = &#63;.
	 *
	 * @param resourceCategoryId the primary key of the current resource category
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public ResourceCategory[] findByUuid_PrevAndNext(
			long resourceCategoryId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Removes all the resource categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of resource categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource categories
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByUUID_G(String uuid, long groupId)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the resource category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource category that was removed
	 */
	public ResourceCategory removeByUUID_G(String uuid, long groupId)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the number of resource categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource categories
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource categories
	 */
	public java.util.List<ResourceCategory> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

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
	public java.util.List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

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
	public ResourceCategory[] findByUuid_C_PrevAndNext(
			long resourceCategoryId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Removes all the resource categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource categories
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the resource categories where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @return the matching resource categories
	 */
	public java.util.List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId);

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
	public java.util.List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end);

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
	public java.util.List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

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
	public java.util.List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByResourceCategoryId_First(
			long resourceCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the first resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByResourceCategoryId_First(
		long resourceCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

	/**
	 * Returns the last resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	public ResourceCategory findByResourceCategoryId_Last(
			long resourceCategoryId,
			com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
				orderByComparator)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the last resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	public ResourceCategory fetchByResourceCategoryId_Last(
		long resourceCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

	/**
	 * Removes all the resource categories where resourceCategoryId = &#63; from the database.
	 *
	 * @param resourceCategoryId the resource category ID
	 */
	public void removeByResourceCategoryId(long resourceCategoryId);

	/**
	 * Returns the number of resource categories where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @return the number of matching resource categories
	 */
	public int countByResourceCategoryId(long resourceCategoryId);

	/**
	 * Caches the resource category in the entity cache if it is enabled.
	 *
	 * @param resourceCategory the resource category
	 */
	public void cacheResult(ResourceCategory resourceCategory);

	/**
	 * Caches the resource categories in the entity cache if it is enabled.
	 *
	 * @param resourceCategories the resource categories
	 */
	public void cacheResult(
		java.util.List<ResourceCategory> resourceCategories);

	/**
	 * Creates a new resource category with the primary key. Does not add the resource category to the database.
	 *
	 * @param resourceCategoryId the primary key for the new resource category
	 * @return the new resource category
	 */
	public ResourceCategory create(long resourceCategoryId);

	/**
	 * Removes the resource category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category that was removed
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public ResourceCategory remove(long resourceCategoryId)
		throws NoSuchResourceCategoryException;

	public ResourceCategory updateImpl(ResourceCategory resourceCategory);

	/**
	 * Returns the resource category with the primary key or throws a <code>NoSuchResourceCategoryException</code> if it could not be found.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	public ResourceCategory findByPrimaryKey(long resourceCategoryId)
		throws NoSuchResourceCategoryException;

	/**
	 * Returns the resource category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category, or <code>null</code> if a resource category with the primary key could not be found
	 */
	public ResourceCategory fetchByPrimaryKey(long resourceCategoryId);

	/**
	 * Returns all the resource categories.
	 *
	 * @return the resource categories
	 */
	public java.util.List<ResourceCategory> findAll();

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
	public java.util.List<ResourceCategory> findAll(int start, int end);

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
	public java.util.List<ResourceCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator);

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
	public java.util.List<ResourceCategory> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ResourceCategory>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the resource categories from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of resource categories.
	 *
	 * @return the number of resource categories
	 */
	public int countAll();

}