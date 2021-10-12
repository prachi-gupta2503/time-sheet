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

import com.adjecti.timesheet.exception.NoSuchProjectResourceException;
import com.adjecti.timesheet.model.ProjectResource;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the project resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectResourceUtil
 * @generated
 */
@ProviderType
public interface ProjectResourcePersistence
	extends BasePersistence<ProjectResource> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProjectResourceUtil} to access the project resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the project resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project resources
	 */
	public java.util.List<ProjectResource> findByUuid(String uuid);

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
	public java.util.List<ProjectResource> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<ProjectResource> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

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
	public java.util.List<ProjectResource> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

	/**
	 * Returns the project resources before and after the current project resource in the ordered set where uuid = &#63;.
	 *
	 * @param projectResourceId the primary key of the current project resource
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public ProjectResource[] findByUuid_PrevAndNext(
			long projectResourceId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Removes all the project resources where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of project resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project resources
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectResourceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the project resource where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project resource that was removed
	 */
	public ProjectResource removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the number of project resources where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project resources
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project resources
	 */
	public java.util.List<ProjectResource> findByUuid_C(
		String uuid, long companyId);

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
	public java.util.List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

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
	public java.util.List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

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
	public ProjectResource[] findByUuid_C_PrevAndNext(
			long projectResourceId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Removes all the project resources where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project resources
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the project resources where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @return the matching project resources
	 */
	public java.util.List<ProjectResource> findByProjectResourceId(
		long projectResourceId);

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
	public java.util.List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end);

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
	public java.util.List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

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
	public java.util.List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByProjectResourceId_First(
			long projectResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the first project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByProjectResourceId_First(
		long projectResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

	/**
	 * Returns the last project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	public ProjectResource findByProjectResourceId_Last(
			long projectResourceId,
			com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
				orderByComparator)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the last project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	public ProjectResource fetchByProjectResourceId_Last(
		long projectResourceId,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

	/**
	 * Removes all the project resources where projectResourceId = &#63; from the database.
	 *
	 * @param projectResourceId the project resource ID
	 */
	public void removeByProjectResourceId(long projectResourceId);

	/**
	 * Returns the number of project resources where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @return the number of matching project resources
	 */
	public int countByProjectResourceId(long projectResourceId);

	/**
	 * Caches the project resource in the entity cache if it is enabled.
	 *
	 * @param projectResource the project resource
	 */
	public void cacheResult(ProjectResource projectResource);

	/**
	 * Caches the project resources in the entity cache if it is enabled.
	 *
	 * @param projectResources the project resources
	 */
	public void cacheResult(java.util.List<ProjectResource> projectResources);

	/**
	 * Creates a new project resource with the primary key. Does not add the project resource to the database.
	 *
	 * @param projectResourceId the primary key for the new project resource
	 * @return the new project resource
	 */
	public ProjectResource create(long projectResourceId);

	/**
	 * Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public ProjectResource remove(long projectResourceId)
		throws NoSuchProjectResourceException;

	public ProjectResource updateImpl(ProjectResource projectResource);

	/**
	 * Returns the project resource with the primary key or throws a <code>NoSuchProjectResourceException</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	public ProjectResource findByPrimaryKey(long projectResourceId)
		throws NoSuchProjectResourceException;

	/**
	 * Returns the project resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource, or <code>null</code> if a project resource with the primary key could not be found
	 */
	public ProjectResource fetchByPrimaryKey(long projectResourceId);

	/**
	 * Returns all the project resources.
	 *
	 * @return the project resources
	 */
	public java.util.List<ProjectResource> findAll();

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
	public java.util.List<ProjectResource> findAll(int start, int end);

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
	public java.util.List<ProjectResource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator);

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
	public java.util.List<ProjectResource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProjectResource>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the project resources from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of project resources.
	 *
	 * @return the number of project resources
	 */
	public int countAll();

}