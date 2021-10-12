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

import com.adjecti.timesheet.exception.NoSuchResourceCategoryException;
import com.adjecti.timesheet.model.ResourceCategory;
import com.adjecti.timesheet.model.impl.ResourceCategoryImpl;
import com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl;
import com.adjecti.timesheet.service.persistence.ResourceCategoryPersistence;
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
 * The persistence implementation for the resource category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ResourceCategoryPersistence.class)
public class ResourceCategoryPersistenceImpl
	extends BasePersistenceImpl<ResourceCategory>
	implements ResourceCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ResourceCategoryUtil</code> to access the resource category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ResourceCategoryImpl.class.getName();

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
	 * Returns all the resource categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching resource categories
	 */
	@Override
	public List<ResourceCategory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ResourceCategory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<ResourceCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<ResourceCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
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

		List<ResourceCategory> list = null;

		if (useFinderCache) {
			list = (List<ResourceCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceCategory resourceCategory : list) {
					if (!uuid.equals(resourceCategory.getUuid())) {
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

			sb.append(_SQL_SELECT_RESOURCECATEGORY_WHERE);

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
				sb.append(ResourceCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceCategory>)QueryUtil.list(
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
	 * Returns the first resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory findByUuid_First(
			String uuid, OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByUuid_First(
			uuid, orderByComparator);

		if (resourceCategory != null) {
			return resourceCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchResourceCategoryException(sb.toString());
	}

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByUuid_First(
		String uuid, OrderByComparator<ResourceCategory> orderByComparator) {

		List<ResourceCategory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory findByUuid_Last(
			String uuid, OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByUuid_Last(
			uuid, orderByComparator);

		if (resourceCategory != null) {
			return resourceCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchResourceCategoryException(sb.toString());
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByUuid_Last(
		String uuid, OrderByComparator<ResourceCategory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ResourceCategory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ResourceCategory[] findByUuid_PrevAndNext(
			long resourceCategoryId, String uuid,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		uuid = Objects.toString(uuid, "");

		ResourceCategory resourceCategory = findByPrimaryKey(
			resourceCategoryId);

		Session session = null;

		try {
			session = openSession();

			ResourceCategory[] array = new ResourceCategoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, resourceCategory, uuid, orderByComparator, true);

			array[1] = resourceCategory;

			array[2] = getByUuid_PrevAndNext(
				session, resourceCategory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ResourceCategory getByUuid_PrevAndNext(
		Session session, ResourceCategory resourceCategory, String uuid,
		OrderByComparator<ResourceCategory> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCECATEGORY_WHERE);

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
			sb.append(ResourceCategoryModelImpl.ORDER_BY_JPQL);
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
						resourceCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ResourceCategory resourceCategory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(resourceCategory);
		}
	}

	/**
	 * Returns the number of resource categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching resource categories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCECATEGORY_WHERE);

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
		"resourceCategory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(resourceCategory.uuid IS NULL OR resourceCategory.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchResourceCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory findByUUID_G(String uuid, long groupId)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByUUID_G(uuid, groupId);

		if (resourceCategory == null) {
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

			throw new NoSuchResourceCategoryException(sb.toString());
		}

		return resourceCategory;
	}

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the resource category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByUUID_G(
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

		if (result instanceof ResourceCategory) {
			ResourceCategory resourceCategory = (ResourceCategory)result;

			if (!Objects.equals(uuid, resourceCategory.getUuid()) ||
				(groupId != resourceCategory.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_RESOURCECATEGORY_WHERE);

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

				List<ResourceCategory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ResourceCategory resourceCategory = list.get(0);

					result = resourceCategory;

					cacheResult(resourceCategory);
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
			return (ResourceCategory)result;
		}
	}

	/**
	 * Removes the resource category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the resource category that was removed
	 */
	@Override
	public ResourceCategory removeByUUID_G(String uuid, long groupId)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = findByUUID_G(uuid, groupId);

		return remove(resourceCategory);
	}

	/**
	 * Returns the number of resource categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching resource categories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCECATEGORY_WHERE);

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
		"resourceCategory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(resourceCategory.uuid IS NULL OR resourceCategory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"resourceCategory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching resource categories
	 */
	@Override
	public List<ResourceCategory> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<ResourceCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
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

		List<ResourceCategory> list = null;

		if (useFinderCache) {
			list = (List<ResourceCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceCategory resourceCategory : list) {
					if (!uuid.equals(resourceCategory.getUuid()) ||
						(companyId != resourceCategory.getCompanyId())) {

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

			sb.append(_SQL_SELECT_RESOURCECATEGORY_WHERE);

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
				sb.append(ResourceCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<ResourceCategory>)QueryUtil.list(
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
	 * Returns the first resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (resourceCategory != null) {
			return resourceCategory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchResourceCategoryException(sb.toString());
	}

	/**
	 * Returns the first resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		List<ResourceCategory> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ResourceCategory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (resourceCategory != null) {
			return resourceCategory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchResourceCategoryException(sb.toString());
	}

	/**
	 * Returns the last resource category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ResourceCategory> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public ResourceCategory[] findByUuid_C_PrevAndNext(
			long resourceCategoryId, String uuid, long companyId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		uuid = Objects.toString(uuid, "");

		ResourceCategory resourceCategory = findByPrimaryKey(
			resourceCategoryId);

		Session session = null;

		try {
			session = openSession();

			ResourceCategory[] array = new ResourceCategoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, resourceCategory, uuid, companyId, orderByComparator,
				true);

			array[1] = resourceCategory;

			array[2] = getByUuid_C_PrevAndNext(
				session, resourceCategory, uuid, companyId, orderByComparator,
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

	protected ResourceCategory getByUuid_C_PrevAndNext(
		Session session, ResourceCategory resourceCategory, String uuid,
		long companyId, OrderByComparator<ResourceCategory> orderByComparator,
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

		sb.append(_SQL_SELECT_RESOURCECATEGORY_WHERE);

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
			sb.append(ResourceCategoryModelImpl.ORDER_BY_JPQL);
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
						resourceCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ResourceCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the resource categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ResourceCategory resourceCategory :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceCategory);
		}
	}

	/**
	 * Returns the number of resource categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching resource categories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_RESOURCECATEGORY_WHERE);

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
		"resourceCategory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(resourceCategory.uuid IS NULL OR resourceCategory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"resourceCategory.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByResourceCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByResourceCategoryId;
	private FinderPath _finderPathCountByResourceCategoryId;

	/**
	 * Returns all the resource categories where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @return the matching resource categories
	 */
	@Override
	public List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId) {

		return findByResourceCategoryId(
			resourceCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end) {

		return findByResourceCategoryId(resourceCategoryId, start, end, null);
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
	@Override
	public List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return findByResourceCategoryId(
			resourceCategoryId, start, end, orderByComparator, true);
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
	@Override
	public List<ResourceCategory> findByResourceCategoryId(
		long resourceCategoryId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByResourceCategoryId;
				finderArgs = new Object[] {resourceCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByResourceCategoryId;
			finderArgs = new Object[] {
				resourceCategoryId, start, end, orderByComparator
			};
		}

		List<ResourceCategory> list = null;

		if (useFinderCache) {
			list = (List<ResourceCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ResourceCategory resourceCategory : list) {
					if (resourceCategoryId !=
							resourceCategory.getResourceCategoryId()) {

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

			sb.append(_SQL_SELECT_RESOURCECATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCECATEGORYID_RESOURCECATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ResourceCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceCategoryId);

				list = (List<ResourceCategory>)QueryUtil.list(
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
	 * Returns the first resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory findByResourceCategoryId_First(
			long resourceCategoryId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByResourceCategoryId_First(
			resourceCategoryId, orderByComparator);

		if (resourceCategory != null) {
			return resourceCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceCategoryId=");
		sb.append(resourceCategoryId);

		sb.append("}");

		throw new NoSuchResourceCategoryException(sb.toString());
	}

	/**
	 * Returns the first resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByResourceCategoryId_First(
		long resourceCategoryId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		List<ResourceCategory> list = findByResourceCategoryId(
			resourceCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category
	 * @throws NoSuchResourceCategoryException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory findByResourceCategoryId_Last(
			long resourceCategoryId,
			OrderByComparator<ResourceCategory> orderByComparator)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByResourceCategoryId_Last(
			resourceCategoryId, orderByComparator);

		if (resourceCategory != null) {
			return resourceCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("resourceCategoryId=");
		sb.append(resourceCategoryId);

		sb.append("}");

		throw new NoSuchResourceCategoryException(sb.toString());
	}

	/**
	 * Returns the last resource category in the ordered set where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchByResourceCategoryId_Last(
		long resourceCategoryId,
		OrderByComparator<ResourceCategory> orderByComparator) {

		int count = countByResourceCategoryId(resourceCategoryId);

		if (count == 0) {
			return null;
		}

		List<ResourceCategory> list = findByResourceCategoryId(
			resourceCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the resource categories where resourceCategoryId = &#63; from the database.
	 *
	 * @param resourceCategoryId the resource category ID
	 */
	@Override
	public void removeByResourceCategoryId(long resourceCategoryId) {
		for (ResourceCategory resourceCategory :
				findByResourceCategoryId(
					resourceCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(resourceCategory);
		}
	}

	/**
	 * Returns the number of resource categories where resourceCategoryId = &#63;.
	 *
	 * @param resourceCategoryId the resource category ID
	 * @return the number of matching resource categories
	 */
	@Override
	public int countByResourceCategoryId(long resourceCategoryId) {
		FinderPath finderPath = _finderPathCountByResourceCategoryId;

		Object[] finderArgs = new Object[] {resourceCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_RESOURCECATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_RESOURCECATEGORYID_RESOURCECATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(resourceCategoryId);

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
		_FINDER_COLUMN_RESOURCECATEGORYID_RESOURCECATEGORYID_2 =
			"resourceCategory.resourceCategoryId = ?";

	public ResourceCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(ResourceCategory.class);

		setModelImplClass(ResourceCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the resource category in the entity cache if it is enabled.
	 *
	 * @param resourceCategory the resource category
	 */
	@Override
	public void cacheResult(ResourceCategory resourceCategory) {
		entityCache.putResult(
			ResourceCategoryImpl.class, resourceCategory.getPrimaryKey(),
			resourceCategory);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				resourceCategory.getUuid(), resourceCategory.getGroupId()
			},
			resourceCategory);

		resourceCategory.resetOriginalValues();
	}

	/**
	 * Caches the resource categories in the entity cache if it is enabled.
	 *
	 * @param resourceCategories the resource categories
	 */
	@Override
	public void cacheResult(List<ResourceCategory> resourceCategories) {
		for (ResourceCategory resourceCategory : resourceCategories) {
			if (entityCache.getResult(
					ResourceCategoryImpl.class,
					resourceCategory.getPrimaryKey()) == null) {

				cacheResult(resourceCategory);
			}
			else {
				resourceCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all resource categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ResourceCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the resource category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ResourceCategory resourceCategory) {
		entityCache.removeResult(
			ResourceCategoryImpl.class, resourceCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(ResourceCategoryModelImpl)resourceCategory, true);
	}

	@Override
	public void clearCache(List<ResourceCategory> resourceCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ResourceCategory resourceCategory : resourceCategories) {
			entityCache.removeResult(
				ResourceCategoryImpl.class, resourceCategory.getPrimaryKey());

			clearUniqueFindersCache(
				(ResourceCategoryModelImpl)resourceCategory, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ResourceCategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ResourceCategoryModelImpl resourceCategoryModelImpl) {

		Object[] args = new Object[] {
			resourceCategoryModelImpl.getUuid(),
			resourceCategoryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, resourceCategoryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ResourceCategoryModelImpl resourceCategoryModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				resourceCategoryModelImpl.getUuid(),
				resourceCategoryModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((resourceCategoryModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				resourceCategoryModelImpl.getOriginalUuid(),
				resourceCategoryModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new resource category with the primary key. Does not add the resource category to the database.
	 *
	 * @param resourceCategoryId the primary key for the new resource category
	 * @return the new resource category
	 */
	@Override
	public ResourceCategory create(long resourceCategoryId) {
		ResourceCategory resourceCategory = new ResourceCategoryImpl();

		resourceCategory.setNew(true);
		resourceCategory.setPrimaryKey(resourceCategoryId);

		String uuid = PortalUUIDUtil.generate();

		resourceCategory.setUuid(uuid);

		resourceCategory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return resourceCategory;
	}

	/**
	 * Removes the resource category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category that was removed
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	@Override
	public ResourceCategory remove(long resourceCategoryId)
		throws NoSuchResourceCategoryException {

		return remove((Serializable)resourceCategoryId);
	}

	/**
	 * Removes the resource category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the resource category
	 * @return the resource category that was removed
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	@Override
	public ResourceCategory remove(Serializable primaryKey)
		throws NoSuchResourceCategoryException {

		Session session = null;

		try {
			session = openSession();

			ResourceCategory resourceCategory = (ResourceCategory)session.get(
				ResourceCategoryImpl.class, primaryKey);

			if (resourceCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchResourceCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(resourceCategory);
		}
		catch (NoSuchResourceCategoryException noSuchEntityException) {
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
	protected ResourceCategory removeImpl(ResourceCategory resourceCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(resourceCategory)) {
				resourceCategory = (ResourceCategory)session.get(
					ResourceCategoryImpl.class,
					resourceCategory.getPrimaryKeyObj());
			}

			if (resourceCategory != null) {
				session.delete(resourceCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (resourceCategory != null) {
			clearCache(resourceCategory);
		}

		return resourceCategory;
	}

	@Override
	public ResourceCategory updateImpl(ResourceCategory resourceCategory) {
		boolean isNew = resourceCategory.isNew();

		if (!(resourceCategory instanceof ResourceCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(resourceCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					resourceCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in resourceCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ResourceCategory implementation " +
					resourceCategory.getClass());
		}

		ResourceCategoryModelImpl resourceCategoryModelImpl =
			(ResourceCategoryModelImpl)resourceCategory;

		if (Validator.isNull(resourceCategory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			resourceCategory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (resourceCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				resourceCategory.setCreateDate(now);
			}
			else {
				resourceCategory.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!resourceCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				resourceCategory.setModifiedDate(now);
			}
			else {
				resourceCategory.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (resourceCategory.isNew()) {
				session.save(resourceCategory);

				resourceCategory.setNew(false);
			}
			else {
				resourceCategory = (ResourceCategory)session.merge(
					resourceCategory);
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
			Object[] args = new Object[] {resourceCategoryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				resourceCategoryModelImpl.getUuid(),
				resourceCategoryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				resourceCategoryModelImpl.getResourceCategoryId()
			};

			finderCache.removeResult(
				_finderPathCountByResourceCategoryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByResourceCategoryId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((resourceCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					resourceCategoryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {resourceCategoryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((resourceCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					resourceCategoryModelImpl.getOriginalUuid(),
					resourceCategoryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					resourceCategoryModelImpl.getUuid(),
					resourceCategoryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((resourceCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByResourceCategoryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					resourceCategoryModelImpl.getOriginalResourceCategoryId()
				};

				finderCache.removeResult(
					_finderPathCountByResourceCategoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResourceCategoryId, args);

				args = new Object[] {
					resourceCategoryModelImpl.getResourceCategoryId()
				};

				finderCache.removeResult(
					_finderPathCountByResourceCategoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByResourceCategoryId, args);
			}
		}

		entityCache.putResult(
			ResourceCategoryImpl.class, resourceCategory.getPrimaryKey(),
			resourceCategory, false);

		clearUniqueFindersCache(resourceCategoryModelImpl, false);
		cacheUniqueFindersCache(resourceCategoryModelImpl);

		resourceCategory.resetOriginalValues();

		return resourceCategory;
	}

	/**
	 * Returns the resource category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the resource category
	 * @return the resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	@Override
	public ResourceCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchResourceCategoryException {

		ResourceCategory resourceCategory = fetchByPrimaryKey(primaryKey);

		if (resourceCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchResourceCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return resourceCategory;
	}

	/**
	 * Returns the resource category with the primary key or throws a <code>NoSuchResourceCategoryException</code> if it could not be found.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category
	 * @throws NoSuchResourceCategoryException if a resource category with the primary key could not be found
	 */
	@Override
	public ResourceCategory findByPrimaryKey(long resourceCategoryId)
		throws NoSuchResourceCategoryException {

		return findByPrimaryKey((Serializable)resourceCategoryId);
	}

	/**
	 * Returns the resource category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category, or <code>null</code> if a resource category with the primary key could not be found
	 */
	@Override
	public ResourceCategory fetchByPrimaryKey(long resourceCategoryId) {
		return fetchByPrimaryKey((Serializable)resourceCategoryId);
	}

	/**
	 * Returns all the resource categories.
	 *
	 * @return the resource categories
	 */
	@Override
	public List<ResourceCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ResourceCategory> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ResourceCategory> findAll(
		int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ResourceCategory> findAll(
		int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator,
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

		List<ResourceCategory> list = null;

		if (useFinderCache) {
			list = (List<ResourceCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_RESOURCECATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_RESOURCECATEGORY;

				sql = sql.concat(ResourceCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ResourceCategory>)QueryUtil.list(
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
	 * Removes all the resource categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ResourceCategory resourceCategory : findAll()) {
			remove(resourceCategory);
		}
	}

	/**
	 * Returns the number of resource categories.
	 *
	 * @return the number of resource categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_RESOURCECATEGORY);

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
		return "resourceCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_RESOURCECATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ResourceCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the resource category persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			ResourceCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			ResourceCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			ResourceCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			ResourceCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			ResourceCategoryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			ResourceCategoryImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			ResourceCategoryModelImpl.UUID_COLUMN_BITMASK |
			ResourceCategoryModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			ResourceCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			ResourceCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			ResourceCategoryModelImpl.UUID_COLUMN_BITMASK |
			ResourceCategoryModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByResourceCategoryId = new FinderPath(
			ResourceCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByResourceCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByResourceCategoryId = new FinderPath(
			ResourceCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByResourceCategoryId", new String[] {Long.class.getName()},
			ResourceCategoryModelImpl.RESOURCECATEGORYID_COLUMN_BITMASK);

		_finderPathCountByResourceCategoryId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByResourceCategoryId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ResourceCategoryImpl.class.getName());
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

	private static final String _SQL_SELECT_RESOURCECATEGORY =
		"SELECT resourceCategory FROM ResourceCategory resourceCategory";

	private static final String _SQL_SELECT_RESOURCECATEGORY_WHERE =
		"SELECT resourceCategory FROM ResourceCategory resourceCategory WHERE ";

	private static final String _SQL_COUNT_RESOURCECATEGORY =
		"SELECT COUNT(resourceCategory) FROM ResourceCategory resourceCategory";

	private static final String _SQL_COUNT_RESOURCECATEGORY_WHERE =
		"SELECT COUNT(resourceCategory) FROM ResourceCategory resourceCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "resourceCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ResourceCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ResourceCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ResourceCategoryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	static {
		try {
			Class.forName(timesheetPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}