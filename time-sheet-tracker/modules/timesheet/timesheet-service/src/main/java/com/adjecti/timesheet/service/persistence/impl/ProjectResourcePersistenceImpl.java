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

package com.adjecti.timesheet.service.persistence.impl;

import com.adjecti.timesheet.exception.NoSuchProjectResourceException;
import com.adjecti.timesheet.model.ProjectResource;
import com.adjecti.timesheet.model.impl.ProjectResourceImpl;
import com.adjecti.timesheet.model.impl.ProjectResourceModelImpl;
import com.adjecti.timesheet.service.persistence.ProjectResourcePersistence;
import com.adjecti.timesheet.service.persistence.impl.constants.timesheetPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the project resource service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProjectResourcePersistence.class)
public class ProjectResourcePersistenceImpl
	extends BasePersistenceImpl<ProjectResource>
	implements ProjectResourcePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProjectResourceUtil</code> to access the project resource persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProjectResourceImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the project resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching project resources
	 */
	@Override
	public List<ProjectResource> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectResource> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ProjectResource> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectResource> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ProjectResource> list = null;

		if (useFinderCache) {
			list = (List<ProjectResource>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectResource projectResource : list) {
					if (!uuid.equals(projectResource.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROJECTRESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ProjectResource>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	@Override
	public ProjectResource findByUuid_First(
			String uuid, OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByUuid_First(
			uuid, orderByComparator);

		if (projectResource != null) {
			return projectResource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectResourceException(sb.toString());
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByUuid_First(
		String uuid, OrderByComparator<ProjectResource> orderByComparator) {

		List<ProjectResource> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	@Override
	public ProjectResource findByUuid_Last(
			String uuid, OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByUuid_Last(
			uuid, orderByComparator);

		if (projectResource != null) {
			return projectResource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProjectResourceException(sb.toString());
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByUuid_Last(
		String uuid, OrderByComparator<ProjectResource> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProjectResource> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectResource[] findByUuid_PrevAndNext(
			long projectResourceId, String uuid,
			OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		uuid = Objects.toString(uuid, "");

		ProjectResource projectResource = findByPrimaryKey(projectResourceId);

		Session session = null;

		try {
			session = openSession();

			ProjectResource[] array = new ProjectResourceImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, projectResource, uuid, orderByComparator, true);

			array[1] = projectResource;

			array[2] = getByUuid_PrevAndNext(
				session, projectResource, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectResource getByUuid_PrevAndNext(
		Session session, ProjectResource projectResource, String uuid,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROJECTRESOURCE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProjectResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectResource)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectResource> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project resources where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProjectResource projectResource :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(projectResource);
		}
	}

	/**
	 * Returns the number of project resources where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching project resources
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTRESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"projectResource.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(projectResource.uuid IS NULL OR projectResource.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProjectResourceException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	@Override
	public ProjectResource findByUUID_G(String uuid, long groupId)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByUUID_G(uuid, groupId);

		if (projectResource == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProjectResourceException(sb.toString());
		}

		return projectResource;
	}

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the project resource where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof ProjectResource) {
			ProjectResource projectResource = (ProjectResource)result;

			if (!Objects.equals(uuid, projectResource.getUuid()) ||
				(groupId != projectResource.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROJECTRESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ProjectResource> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProjectResource projectResource = list.get(0);

					result = projectResource;

					cacheResult(projectResource);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ProjectResource)result;
		}
	}

	/**
	 * Removes the project resource where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the project resource that was removed
	 */
	@Override
	public ProjectResource removeByUUID_G(String uuid, long groupId)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = findByUUID_G(uuid, groupId);

		return remove(projectResource);
	}

	/**
	 * Returns the number of project resources where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching project resources
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTRESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"projectResource.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(projectResource.uuid IS NULL OR projectResource.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"projectResource.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching project resources
	 */
	@Override
	public List<ProjectResource> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectResource> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ProjectResource> list = null;

		if (useFinderCache) {
			list = (List<ProjectResource>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectResource projectResource : list) {
					if (!uuid.equals(projectResource.getUuid()) ||
						(companyId != projectResource.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROJECTRESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ProjectResource>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public ProjectResource findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (projectResource != null) {
			return projectResource;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectResourceException(sb.toString());
	}

	/**
	 * Returns the first project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProjectResource> orderByComparator) {

		List<ProjectResource> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectResource findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (projectResource != null) {
			return projectResource;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProjectResourceException(sb.toString());
	}

	/**
	 * Returns the last project resource in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProjectResource> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProjectResource> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ProjectResource[] findByUuid_C_PrevAndNext(
			long projectResourceId, String uuid, long companyId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		uuid = Objects.toString(uuid, "");

		ProjectResource projectResource = findByPrimaryKey(projectResourceId);

		Session session = null;

		try {
			session = openSession();

			ProjectResource[] array = new ProjectResourceImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, projectResource, uuid, companyId, orderByComparator,
				true);

			array[1] = projectResource;

			array[2] = getByUuid_C_PrevAndNext(
				session, projectResource, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProjectResource getByUuid_C_PrevAndNext(
		Session session, ProjectResource projectResource, String uuid,
		long companyId, OrderByComparator<ProjectResource> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROJECTRESOURCE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProjectResourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						projectResource)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProjectResource> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the project resources where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProjectResource projectResource :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectResource);
		}
	}

	/**
	 * Returns the number of project resources where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching project resources
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROJECTRESOURCE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"projectResource.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(projectResource.uuid IS NULL OR projectResource.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"projectResource.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProjectResourceId;
	private FinderPath _finderPathWithoutPaginationFindByProjectResourceId;
	private FinderPath _finderPathCountByProjectResourceId;

	/**
	 * Returns all the project resources where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @return the matching project resources
	 */
	@Override
	public List<ProjectResource> findByProjectResourceId(
		long projectResourceId) {

		return findByProjectResourceId(
			projectResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end) {

		return findByProjectResourceId(projectResourceId, start, end, null);
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
	@Override
	public List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return findByProjectResourceId(
			projectResourceId, start, end, orderByComparator, true);
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
	@Override
	public List<ProjectResource> findByProjectResourceId(
		long projectResourceId, int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProjectResourceId;
				finderArgs = new Object[] {projectResourceId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProjectResourceId;
			finderArgs = new Object[] {
				projectResourceId, start, end, orderByComparator
			};
		}

		List<ProjectResource> list = null;

		if (useFinderCache) {
			list = (List<ProjectResource>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProjectResource projectResource : list) {
					if (projectResourceId !=
							projectResource.getProjectResourceId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROJECTRESOURCE_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTRESOURCEID_PROJECTRESOURCEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProjectResourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectResourceId);

				list = (List<ProjectResource>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	@Override
	public ProjectResource findByProjectResourceId_First(
			long projectResourceId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByProjectResourceId_First(
			projectResourceId, orderByComparator);

		if (projectResource != null) {
			return projectResource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectResourceId=");
		sb.append(projectResourceId);

		sb.append("}");

		throw new NoSuchProjectResourceException(sb.toString());
	}

	/**
	 * Returns the first project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByProjectResourceId_First(
		long projectResourceId,
		OrderByComparator<ProjectResource> orderByComparator) {

		List<ProjectResource> list = findByProjectResourceId(
			projectResourceId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource
	 * @throws NoSuchProjectResourceException if a matching project resource could not be found
	 */
	@Override
	public ProjectResource findByProjectResourceId_Last(
			long projectResourceId,
			OrderByComparator<ProjectResource> orderByComparator)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByProjectResourceId_Last(
			projectResourceId, orderByComparator);

		if (projectResource != null) {
			return projectResource;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("projectResourceId=");
		sb.append(projectResourceId);

		sb.append("}");

		throw new NoSuchProjectResourceException(sb.toString());
	}

	/**
	 * Returns the last project resource in the ordered set where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching project resource, or <code>null</code> if a matching project resource could not be found
	 */
	@Override
	public ProjectResource fetchByProjectResourceId_Last(
		long projectResourceId,
		OrderByComparator<ProjectResource> orderByComparator) {

		int count = countByProjectResourceId(projectResourceId);

		if (count == 0) {
			return null;
		}

		List<ProjectResource> list = findByProjectResourceId(
			projectResourceId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the project resources where projectResourceId = &#63; from the database.
	 *
	 * @param projectResourceId the project resource ID
	 */
	@Override
	public void removeByProjectResourceId(long projectResourceId) {
		for (ProjectResource projectResource :
				findByProjectResourceId(
					projectResourceId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(projectResource);
		}
	}

	/**
	 * Returns the number of project resources where projectResourceId = &#63;.
	 *
	 * @param projectResourceId the project resource ID
	 * @return the number of matching project resources
	 */
	@Override
	public int countByProjectResourceId(long projectResourceId) {
		FinderPath finderPath = _finderPathCountByProjectResourceId;

		Object[] finderArgs = new Object[] {projectResourceId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROJECTRESOURCE_WHERE);

			sb.append(_FINDER_COLUMN_PROJECTRESOURCEID_PROJECTRESOURCEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(projectResourceId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_PROJECTRESOURCEID_PROJECTRESOURCEID_2 =
			"projectResource.projectResourceId = ?";

	public ProjectResourcePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProjectResource.class);

		setModelImplClass(ProjectResourceImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the project resource in the entity cache if it is enabled.
	 *
	 * @param projectResource the project resource
	 */
	@Override
	public void cacheResult(ProjectResource projectResource) {
		entityCache.putResult(
			ProjectResourceImpl.class, projectResource.getPrimaryKey(),
			projectResource);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				projectResource.getUuid(), projectResource.getGroupId()
			},
			projectResource);

		projectResource.resetOriginalValues();
	}

	/**
	 * Caches the project resources in the entity cache if it is enabled.
	 *
	 * @param projectResources the project resources
	 */
	@Override
	public void cacheResult(List<ProjectResource> projectResources) {
		for (ProjectResource projectResource : projectResources) {
			if (entityCache.getResult(
					ProjectResourceImpl.class,
					projectResource.getPrimaryKey()) == null) {

				cacheResult(projectResource);
			}
			else {
				projectResource.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all project resources.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProjectResourceImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the project resource.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProjectResource projectResource) {
		entityCache.removeResult(
			ProjectResourceImpl.class, projectResource.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ProjectResourceModelImpl)projectResource, true);
	}

	@Override
	public void clearCache(List<ProjectResource> projectResources) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ProjectResource projectResource : projectResources) {
			entityCache.removeResult(
				ProjectResourceImpl.class, projectResource.getPrimaryKey());

			clearUniqueFindersCache(
				(ProjectResourceModelImpl)projectResource, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProjectResourceImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProjectResourceModelImpl projectResourceModelImpl) {

		Object[] args = new Object[] {
			projectResourceModelImpl.getUuid(),
			projectResourceModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, projectResourceModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ProjectResourceModelImpl projectResourceModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				projectResourceModelImpl.getUuid(),
				projectResourceModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((projectResourceModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				projectResourceModelImpl.getOriginalUuid(),
				projectResourceModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new project resource with the primary key. Does not add the project resource to the database.
	 *
	 * @param projectResourceId the primary key for the new project resource
	 * @return the new project resource
	 */
	@Override
	public ProjectResource create(long projectResourceId) {
		ProjectResource projectResource = new ProjectResourceImpl();

		projectResource.setNew(true);
		projectResource.setPrimaryKey(projectResourceId);

		String uuid = PortalUUIDUtil.generate();

		projectResource.setUuid(uuid);

		projectResource.setCompanyId(CompanyThreadLocal.getCompanyId());

		return projectResource;
	}

	/**
	 * Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	@Override
	public ProjectResource remove(long projectResourceId)
		throws NoSuchProjectResourceException {

		return remove((Serializable)projectResourceId);
	}

	/**
	 * Removes the project resource with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the project resource
	 * @return the project resource that was removed
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	@Override
	public ProjectResource remove(Serializable primaryKey)
		throws NoSuchProjectResourceException {

		Session session = null;

		try {
			session = openSession();

			ProjectResource projectResource = (ProjectResource)session.get(
				ProjectResourceImpl.class, primaryKey);

			if (projectResource == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProjectResourceException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(projectResource);
		}
		catch (NoSuchProjectResourceException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProjectResource removeImpl(ProjectResource projectResource) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(projectResource)) {
				projectResource = (ProjectResource)session.get(
					ProjectResourceImpl.class,
					projectResource.getPrimaryKeyObj());
			}

			if (projectResource != null) {
				session.delete(projectResource);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (projectResource != null) {
			clearCache(projectResource);
		}

		return projectResource;
	}

	@Override
	public ProjectResource updateImpl(ProjectResource projectResource) {
		boolean isNew = projectResource.isNew();

		if (!(projectResource instanceof ProjectResourceModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(projectResource.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					projectResource);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in projectResource proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProjectResource implementation " +
					projectResource.getClass());
		}

		ProjectResourceModelImpl projectResourceModelImpl =
			(ProjectResourceModelImpl)projectResource;

		if (Validator.isNull(projectResource.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			projectResource.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (projectResource.getCreateDate() == null)) {
			if (serviceContext == null) {
				projectResource.setCreateDate(now);
			}
			else {
				projectResource.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!projectResourceModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				projectResource.setModifiedDate(now);
			}
			else {
				projectResource.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (projectResource.isNew()) {
				session.save(projectResource);

				projectResource.setNew(false);
			}
			else {
				projectResource = (ProjectResource)session.merge(
					projectResource);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			Object[] args = new Object[] {projectResourceModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				projectResourceModelImpl.getUuid(),
				projectResourceModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				projectResourceModelImpl.getProjectResourceId()
			};

			finderCache.removeResult(_finderPathCountByProjectResourceId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByProjectResourceId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((projectResourceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					projectResourceModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {projectResourceModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((projectResourceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					projectResourceModelImpl.getOriginalUuid(),
					projectResourceModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					projectResourceModelImpl.getUuid(),
					projectResourceModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((projectResourceModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByProjectResourceId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					projectResourceModelImpl.getOriginalProjectResourceId()
				};

				finderCache.removeResult(
					_finderPathCountByProjectResourceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProjectResourceId, args);

				args = new Object[] {
					projectResourceModelImpl.getProjectResourceId()
				};

				finderCache.removeResult(
					_finderPathCountByProjectResourceId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByProjectResourceId, args);
			}
		}

		entityCache.putResult(
			ProjectResourceImpl.class, projectResource.getPrimaryKey(),
			projectResource, false);

		clearUniqueFindersCache(projectResourceModelImpl, false);
		cacheUniqueFindersCache(projectResourceModelImpl);

		projectResource.resetOriginalValues();

		return projectResource;
	}

	/**
	 * Returns the project resource with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the project resource
	 * @return the project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	@Override
	public ProjectResource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProjectResourceException {

		ProjectResource projectResource = fetchByPrimaryKey(primaryKey);

		if (projectResource == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProjectResourceException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return projectResource;
	}

	/**
	 * Returns the project resource with the primary key or throws a <code>NoSuchProjectResourceException</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource
	 * @throws NoSuchProjectResourceException if a project resource with the primary key could not be found
	 */
	@Override
	public ProjectResource findByPrimaryKey(long projectResourceId)
		throws NoSuchProjectResourceException {

		return findByPrimaryKey((Serializable)projectResourceId);
	}

	/**
	 * Returns the project resource with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param projectResourceId the primary key of the project resource
	 * @return the project resource, or <code>null</code> if a project resource with the primary key could not be found
	 */
	@Override
	public ProjectResource fetchByPrimaryKey(long projectResourceId) {
		return fetchByPrimaryKey((Serializable)projectResourceId);
	}

	/**
	 * Returns all the project resources.
	 *
	 * @return the project resources
	 */
	@Override
	public List<ProjectResource> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ProjectResource> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ProjectResource> findAll(
		int start, int end,
		OrderByComparator<ProjectResource> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ProjectResource> findAll(
		int start, int end,
		OrderByComparator<ProjectResource> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ProjectResource> list = null;

		if (useFinderCache) {
			list = (List<ProjectResource>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROJECTRESOURCE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROJECTRESOURCE;

				sql = sql.concat(ProjectResourceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProjectResource>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the project resources from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProjectResource projectResource : findAll()) {
			remove(projectResource);
		}
	}

	/**
	 * Returns the number of project resources.
	 *
	 * @return the number of project resources
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PROJECTRESOURCE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "projectResourceId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROJECTRESOURCE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProjectResourceModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the project resource persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ProjectResourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ProjectResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ProjectResourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ProjectResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ProjectResourceModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			ProjectResourceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ProjectResourceModelImpl.UUID_COLUMN_BITMASK |
			ProjectResourceModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			ProjectResourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			ProjectResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			ProjectResourceModelImpl.UUID_COLUMN_BITMASK |
			ProjectResourceModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByProjectResourceId = new FinderPath(
			ProjectResourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProjectResourceId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByProjectResourceId = new FinderPath(
			ProjectResourceImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProjectResourceId", new String[] {Long.class.getName()},
			ProjectResourceModelImpl.PROJECTRESOURCEID_COLUMN_BITMASK);

		_finderPathCountByProjectResourceId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProjectResourceId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProjectResourceImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = timesheetPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = timesheetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = timesheetPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROJECTRESOURCE =
		"SELECT projectResource FROM ProjectResource projectResource";

	private static final String _SQL_SELECT_PROJECTRESOURCE_WHERE =
		"SELECT projectResource FROM ProjectResource projectResource WHERE ";

	private static final String _SQL_COUNT_PROJECTRESOURCE =
		"SELECT COUNT(projectResource) FROM ProjectResource projectResource";

	private static final String _SQL_COUNT_PROJECTRESOURCE_WHERE =
		"SELECT COUNT(projectResource) FROM ProjectResource projectResource WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "projectResource.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProjectResource exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProjectResource exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProjectResourcePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(timesheetPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}