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

import com.adjecti.timesheet.exception.NoSuchTaskCategoryException;
import com.adjecti.timesheet.model.TaskCategory;
import com.adjecti.timesheet.model.impl.TaskCategoryImpl;
import com.adjecti.timesheet.model.impl.TaskCategoryModelImpl;
import com.adjecti.timesheet.service.persistence.TaskCategoryPersistence;
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
 * The persistence implementation for the task category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = TaskCategoryPersistence.class)
public class TaskCategoryPersistenceImpl
	extends BasePersistenceImpl<TaskCategory>
	implements TaskCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>TaskCategoryUtil</code> to access the task category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		TaskCategoryImpl.class.getName();

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
	 * Returns all the task categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching task categories
	 */
	@Override
	public List<TaskCategory> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskCategory> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<TaskCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<TaskCategory> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator,
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

		List<TaskCategory> list = null;

		if (useFinderCache) {
			list = (List<TaskCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskCategory taskCategory : list) {
					if (!uuid.equals(taskCategory.getUuid())) {
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

			sb.append(_SQL_SELECT_TASKCATEGORY_WHERE);

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
				sb.append(TaskCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TaskCategory>)QueryUtil.list(
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
	 * Returns the first task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	@Override
	public TaskCategory findByUuid_First(
			String uuid, OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByUuid_First(uuid, orderByComparator);

		if (taskCategory != null) {
			return taskCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTaskCategoryException(sb.toString());
	}

	/**
	 * Returns the first task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByUuid_First(
		String uuid, OrderByComparator<TaskCategory> orderByComparator) {

		List<TaskCategory> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	@Override
	public TaskCategory findByUuid_Last(
			String uuid, OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByUuid_Last(uuid, orderByComparator);

		if (taskCategory != null) {
			return taskCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchTaskCategoryException(sb.toString());
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByUuid_Last(
		String uuid, OrderByComparator<TaskCategory> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<TaskCategory> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskCategory[] findByUuid_PrevAndNext(
			long taskCategoryId, String uuid,
			OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		uuid = Objects.toString(uuid, "");

		TaskCategory taskCategory = findByPrimaryKey(taskCategoryId);

		Session session = null;

		try {
			session = openSession();

			TaskCategory[] array = new TaskCategoryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, taskCategory, uuid, orderByComparator, true);

			array[1] = taskCategory;

			array[2] = getByUuid_PrevAndNext(
				session, taskCategory, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected TaskCategory getByUuid_PrevAndNext(
		Session session, TaskCategory taskCategory, String uuid,
		OrderByComparator<TaskCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_TASKCATEGORY_WHERE);

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
			sb.append(TaskCategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(taskCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task categories where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (TaskCategory taskCategory :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(taskCategory);
		}
	}

	/**
	 * Returns the number of task categories where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching task categories
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKCATEGORY_WHERE);

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
		"taskCategory.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(taskCategory.uuid IS NULL OR taskCategory.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchTaskCategoryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	@Override
	public TaskCategory findByUUID_G(String uuid, long groupId)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByUUID_G(uuid, groupId);

		if (taskCategory == null) {
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

			throw new NoSuchTaskCategoryException(sb.toString());
		}

		return taskCategory;
	}

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the task category where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByUUID_G(
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

		if (result instanceof TaskCategory) {
			TaskCategory taskCategory = (TaskCategory)result;

			if (!Objects.equals(uuid, taskCategory.getUuid()) ||
				(groupId != taskCategory.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_TASKCATEGORY_WHERE);

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

				List<TaskCategory> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					TaskCategory taskCategory = list.get(0);

					result = taskCategory;

					cacheResult(taskCategory);
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
			return (TaskCategory)result;
		}
	}

	/**
	 * Removes the task category where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the task category that was removed
	 */
	@Override
	public TaskCategory removeByUUID_G(String uuid, long groupId)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = findByUUID_G(uuid, groupId);

		return remove(taskCategory);
	}

	/**
	 * Returns the number of task categories where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching task categories
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKCATEGORY_WHERE);

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
		"taskCategory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(taskCategory.uuid IS NULL OR taskCategory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"taskCategory.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching task categories
	 */
	@Override
	public List<TaskCategory> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<TaskCategory> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator,
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

		List<TaskCategory> list = null;

		if (useFinderCache) {
			list = (List<TaskCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskCategory taskCategory : list) {
					if (!uuid.equals(taskCategory.getUuid()) ||
						(companyId != taskCategory.getCompanyId())) {

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

			sb.append(_SQL_SELECT_TASKCATEGORY_WHERE);

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
				sb.append(TaskCategoryModelImpl.ORDER_BY_JPQL);
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

				list = (List<TaskCategory>)QueryUtil.list(
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
	 * Returns the first task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	@Override
	public TaskCategory findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (taskCategory != null) {
			return taskCategory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTaskCategoryException(sb.toString());
	}

	/**
	 * Returns the first task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<TaskCategory> orderByComparator) {

		List<TaskCategory> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskCategory findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (taskCategory != null) {
			return taskCategory;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchTaskCategoryException(sb.toString());
	}

	/**
	 * Returns the last task category in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<TaskCategory> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<TaskCategory> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskCategory[] findByUuid_C_PrevAndNext(
			long taskCategoryId, String uuid, long companyId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		uuid = Objects.toString(uuid, "");

		TaskCategory taskCategory = findByPrimaryKey(taskCategoryId);

		Session session = null;

		try {
			session = openSession();

			TaskCategory[] array = new TaskCategoryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, taskCategory, uuid, companyId, orderByComparator,
				true);

			array[1] = taskCategory;

			array[2] = getByUuid_C_PrevAndNext(
				session, taskCategory, uuid, companyId, orderByComparator,
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

	protected TaskCategory getByUuid_C_PrevAndNext(
		Session session, TaskCategory taskCategory, String uuid, long companyId,
		OrderByComparator<TaskCategory> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_TASKCATEGORY_WHERE);

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
			sb.append(TaskCategoryModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(taskCategory)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<TaskCategory> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the task categories where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (TaskCategory taskCategory :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(taskCategory);
		}
	}

	/**
	 * Returns the number of task categories where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching task categories
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_TASKCATEGORY_WHERE);

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
		"taskCategory.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(taskCategory.uuid IS NULL OR taskCategory.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"taskCategory.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByTaskCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByTaskCategoryId;
	private FinderPath _finderPathCountByTaskCategoryId;

	/**
	 * Returns all the task categories where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @return the matching task categories
	 */
	@Override
	public List<TaskCategory> findByTaskCategoryId(long taskCategoryId) {
		return findByTaskCategoryId(
			taskCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end) {

		return findByTaskCategoryId(taskCategoryId, start, end, null);
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
	@Override
	public List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator) {

		return findByTaskCategoryId(
			taskCategoryId, start, end, orderByComparator, true);
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
	@Override
	public List<TaskCategory> findByTaskCategoryId(
		long taskCategoryId, int start, int end,
		OrderByComparator<TaskCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByTaskCategoryId;
				finderArgs = new Object[] {taskCategoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByTaskCategoryId;
			finderArgs = new Object[] {
				taskCategoryId, start, end, orderByComparator
			};
		}

		List<TaskCategory> list = null;

		if (useFinderCache) {
			list = (List<TaskCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (TaskCategory taskCategory : list) {
					if (taskCategoryId != taskCategory.getTaskCategoryId()) {
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

			sb.append(_SQL_SELECT_TASKCATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_TASKCATEGORYID_TASKCATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(TaskCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskCategoryId);

				list = (List<TaskCategory>)QueryUtil.list(
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
	 * Returns the first task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	@Override
	public TaskCategory findByTaskCategoryId_First(
			long taskCategoryId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByTaskCategoryId_First(
			taskCategoryId, orderByComparator);

		if (taskCategory != null) {
			return taskCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskCategoryId=");
		sb.append(taskCategoryId);

		sb.append("}");

		throw new NoSuchTaskCategoryException(sb.toString());
	}

	/**
	 * Returns the first task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByTaskCategoryId_First(
		long taskCategoryId,
		OrderByComparator<TaskCategory> orderByComparator) {

		List<TaskCategory> list = findByTaskCategoryId(
			taskCategoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category
	 * @throws NoSuchTaskCategoryException if a matching task category could not be found
	 */
	@Override
	public TaskCategory findByTaskCategoryId_Last(
			long taskCategoryId,
			OrderByComparator<TaskCategory> orderByComparator)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByTaskCategoryId_Last(
			taskCategoryId, orderByComparator);

		if (taskCategory != null) {
			return taskCategory;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("taskCategoryId=");
		sb.append(taskCategoryId);

		sb.append("}");

		throw new NoSuchTaskCategoryException(sb.toString());
	}

	/**
	 * Returns the last task category in the ordered set where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task category, or <code>null</code> if a matching task category could not be found
	 */
	@Override
	public TaskCategory fetchByTaskCategoryId_Last(
		long taskCategoryId,
		OrderByComparator<TaskCategory> orderByComparator) {

		int count = countByTaskCategoryId(taskCategoryId);

		if (count == 0) {
			return null;
		}

		List<TaskCategory> list = findByTaskCategoryId(
			taskCategoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the task categories where taskCategoryId = &#63; from the database.
	 *
	 * @param taskCategoryId the task category ID
	 */
	@Override
	public void removeByTaskCategoryId(long taskCategoryId) {
		for (TaskCategory taskCategory :
				findByTaskCategoryId(
					taskCategoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(taskCategory);
		}
	}

	/**
	 * Returns the number of task categories where taskCategoryId = &#63;.
	 *
	 * @param taskCategoryId the task category ID
	 * @return the number of matching task categories
	 */
	@Override
	public int countByTaskCategoryId(long taskCategoryId) {
		FinderPath finderPath = _finderPathCountByTaskCategoryId;

		Object[] finderArgs = new Object[] {taskCategoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_TASKCATEGORY_WHERE);

			sb.append(_FINDER_COLUMN_TASKCATEGORYID_TASKCATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(taskCategoryId);

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

	private static final String _FINDER_COLUMN_TASKCATEGORYID_TASKCATEGORYID_2 =
		"taskCategory.taskCategoryId = ?";

	public TaskCategoryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);

		setModelClass(TaskCategory.class);

		setModelImplClass(TaskCategoryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the task category in the entity cache if it is enabled.
	 *
	 * @param taskCategory the task category
	 */
	@Override
	public void cacheResult(TaskCategory taskCategory) {
		entityCache.putResult(
			TaskCategoryImpl.class, taskCategory.getPrimaryKey(), taskCategory);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {taskCategory.getUuid(), taskCategory.getGroupId()},
			taskCategory);

		taskCategory.resetOriginalValues();
	}

	/**
	 * Caches the task categories in the entity cache if it is enabled.
	 *
	 * @param taskCategories the task categories
	 */
	@Override
	public void cacheResult(List<TaskCategory> taskCategories) {
		for (TaskCategory taskCategory : taskCategories) {
			if (entityCache.getResult(
					TaskCategoryImpl.class, taskCategory.getPrimaryKey()) ==
						null) {

				cacheResult(taskCategory);
			}
			else {
				taskCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(TaskCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskCategory taskCategory) {
		entityCache.removeResult(
			TaskCategoryImpl.class, taskCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((TaskCategoryModelImpl)taskCategory, true);
	}

	@Override
	public void clearCache(List<TaskCategory> taskCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskCategory taskCategory : taskCategories) {
			entityCache.removeResult(
				TaskCategoryImpl.class, taskCategory.getPrimaryKey());

			clearUniqueFindersCache((TaskCategoryModelImpl)taskCategory, true);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(TaskCategoryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		TaskCategoryModelImpl taskCategoryModelImpl) {

		Object[] args = new Object[] {
			taskCategoryModelImpl.getUuid(), taskCategoryModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, taskCategoryModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		TaskCategoryModelImpl taskCategoryModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				taskCategoryModelImpl.getUuid(),
				taskCategoryModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((taskCategoryModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				taskCategoryModelImpl.getOriginalUuid(),
				taskCategoryModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new task category with the primary key. Does not add the task category to the database.
	 *
	 * @param taskCategoryId the primary key for the new task category
	 * @return the new task category
	 */
	@Override
	public TaskCategory create(long taskCategoryId) {
		TaskCategory taskCategory = new TaskCategoryImpl();

		taskCategory.setNew(true);
		taskCategory.setPrimaryKey(taskCategoryId);

		String uuid = PortalUUIDUtil.generate();

		taskCategory.setUuid(uuid);

		taskCategory.setCompanyId(CompanyThreadLocal.getCompanyId());

		return taskCategory;
	}

	/**
	 * Removes the task category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category that was removed
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	@Override
	public TaskCategory remove(long taskCategoryId)
		throws NoSuchTaskCategoryException {

		return remove((Serializable)taskCategoryId);
	}

	/**
	 * Removes the task category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task category
	 * @return the task category that was removed
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	@Override
	public TaskCategory remove(Serializable primaryKey)
		throws NoSuchTaskCategoryException {

		Session session = null;

		try {
			session = openSession();

			TaskCategory taskCategory = (TaskCategory)session.get(
				TaskCategoryImpl.class, primaryKey);

			if (taskCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(taskCategory);
		}
		catch (NoSuchTaskCategoryException noSuchEntityException) {
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
	protected TaskCategory removeImpl(TaskCategory taskCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskCategory)) {
				taskCategory = (TaskCategory)session.get(
					TaskCategoryImpl.class, taskCategory.getPrimaryKeyObj());
			}

			if (taskCategory != null) {
				session.delete(taskCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (taskCategory != null) {
			clearCache(taskCategory);
		}

		return taskCategory;
	}

	@Override
	public TaskCategory updateImpl(TaskCategory taskCategory) {
		boolean isNew = taskCategory.isNew();

		if (!(taskCategory instanceof TaskCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(taskCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					taskCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in taskCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom TaskCategory implementation " +
					taskCategory.getClass());
		}

		TaskCategoryModelImpl taskCategoryModelImpl =
			(TaskCategoryModelImpl)taskCategory;

		if (Validator.isNull(taskCategory.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			taskCategory.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (taskCategory.getCreateDate() == null)) {
			if (serviceContext == null) {
				taskCategory.setCreateDate(now);
			}
			else {
				taskCategory.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!taskCategoryModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				taskCategory.setModifiedDate(now);
			}
			else {
				taskCategory.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (taskCategory.isNew()) {
				session.save(taskCategory);

				taskCategory.setNew(false);
			}
			else {
				taskCategory = (TaskCategory)session.merge(taskCategory);
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
			Object[] args = new Object[] {taskCategoryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				taskCategoryModelImpl.getUuid(),
				taskCategoryModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {taskCategoryModelImpl.getTaskCategoryId()};

			finderCache.removeResult(_finderPathCountByTaskCategoryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByTaskCategoryId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((taskCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					taskCategoryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {taskCategoryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((taskCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					taskCategoryModelImpl.getOriginalUuid(),
					taskCategoryModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					taskCategoryModelImpl.getUuid(),
					taskCategoryModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((taskCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByTaskCategoryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					taskCategoryModelImpl.getOriginalTaskCategoryId()
				};

				finderCache.removeResult(
					_finderPathCountByTaskCategoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaskCategoryId, args);

				args = new Object[] {taskCategoryModelImpl.getTaskCategoryId()};

				finderCache.removeResult(
					_finderPathCountByTaskCategoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByTaskCategoryId, args);
			}
		}

		entityCache.putResult(
			TaskCategoryImpl.class, taskCategory.getPrimaryKey(), taskCategory,
			false);

		clearUniqueFindersCache(taskCategoryModelImpl, false);
		cacheUniqueFindersCache(taskCategoryModelImpl);

		taskCategory.resetOriginalValues();

		return taskCategory;
	}

	/**
	 * Returns the task category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task category
	 * @return the task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	@Override
	public TaskCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskCategoryException {

		TaskCategory taskCategory = fetchByPrimaryKey(primaryKey);

		if (taskCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return taskCategory;
	}

	/**
	 * Returns the task category with the primary key or throws a <code>NoSuchTaskCategoryException</code> if it could not be found.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category
	 * @throws NoSuchTaskCategoryException if a task category with the primary key could not be found
	 */
	@Override
	public TaskCategory findByPrimaryKey(long taskCategoryId)
		throws NoSuchTaskCategoryException {

		return findByPrimaryKey((Serializable)taskCategoryId);
	}

	/**
	 * Returns the task category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskCategoryId the primary key of the task category
	 * @return the task category, or <code>null</code> if a task category with the primary key could not be found
	 */
	@Override
	public TaskCategory fetchByPrimaryKey(long taskCategoryId) {
		return fetchByPrimaryKey((Serializable)taskCategoryId);
	}

	/**
	 * Returns all the task categories.
	 *
	 * @return the task categories
	 */
	@Override
	public List<TaskCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskCategory> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<TaskCategory> findAll(
		int start, int end, OrderByComparator<TaskCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<TaskCategory> findAll(
		int start, int end, OrderByComparator<TaskCategory> orderByComparator,
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

		List<TaskCategory> list = null;

		if (useFinderCache) {
			list = (List<TaskCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_TASKCATEGORY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_TASKCATEGORY;

				sql = sql.concat(TaskCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<TaskCategory>)QueryUtil.list(
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
	 * Removes all the task categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (TaskCategory taskCategory : findAll()) {
			remove(taskCategory);
		}
	}

	/**
	 * Returns the number of task categories.
	 *
	 * @return the number of task categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_TASKCATEGORY);

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
		return "taskCategoryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_TASKCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return TaskCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the task category persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			TaskCategoryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			TaskCategoryModelImpl.UUID_COLUMN_BITMASK |
			TaskCategoryModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			TaskCategoryModelImpl.UUID_COLUMN_BITMASK |
			TaskCategoryModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByTaskCategoryId = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTaskCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByTaskCategoryId = new FinderPath(
			TaskCategoryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTaskCategoryId", new String[] {Long.class.getName()},
			TaskCategoryModelImpl.TASKCATEGORYID_COLUMN_BITMASK);

		_finderPathCountByTaskCategoryId = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaskCategoryId", new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(TaskCategoryImpl.class.getName());
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

	private static final String _SQL_SELECT_TASKCATEGORY =
		"SELECT taskCategory FROM TaskCategory taskCategory";

	private static final String _SQL_SELECT_TASKCATEGORY_WHERE =
		"SELECT taskCategory FROM TaskCategory taskCategory WHERE ";

	private static final String _SQL_COUNT_TASKCATEGORY =
		"SELECT COUNT(taskCategory) FROM TaskCategory taskCategory";

	private static final String _SQL_COUNT_TASKCATEGORY_WHERE =
		"SELECT COUNT(taskCategory) FROM TaskCategory taskCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "taskCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No TaskCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No TaskCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		TaskCategoryPersistenceImpl.class);

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