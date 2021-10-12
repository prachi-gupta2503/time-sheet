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

package com.adjecti.timesheet.model.impl;

import com.adjecti.timesheet.model.TaskCategory;
import com.adjecti.timesheet.model.TaskCategoryModel;
import com.adjecti.timesheet.model.TaskCategorySoap;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the TaskCategory service. Represents a row in the &quot;timesheet_TaskCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>TaskCategoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskCategoryImpl
 * @generated
 */
@JSON(strict = true)
public class TaskCategoryModelImpl
	extends BaseModelImpl<TaskCategory> implements TaskCategoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task category model instance should use the <code>TaskCategory</code> interface instead.
	 */
	public static final String TABLE_NAME = "timesheet_TaskCategory";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"taskCategoryId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("taskCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table timesheet_TaskCategory (uuid_ VARCHAR(75) null,taskCategoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table timesheet_TaskCategory";

	public static final String ORDER_BY_JPQL =
		" ORDER BY taskCategory.taskCategoryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY timesheet_TaskCategory.taskCategoryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long TASKCATEGORYID_COLUMN_BITMASK = 4L;

	public static final long UUID_COLUMN_BITMASK = 8L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static TaskCategory toModel(TaskCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		TaskCategory model = new TaskCategoryImpl();

		model.setUuid(soapModel.getUuid());
		model.setTaskCategoryId(soapModel.getTaskCategoryId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setType(soapModel.getType());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static List<TaskCategory> toModels(TaskCategorySoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<TaskCategory> models = new ArrayList<TaskCategory>(
			soapModels.length);

		for (TaskCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public TaskCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _taskCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setTaskCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _taskCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return TaskCategory.class;
	}

	@Override
	public String getModelClassName() {
		return TaskCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<TaskCategory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<TaskCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TaskCategory, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((TaskCategory)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<TaskCategory, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<TaskCategory, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(TaskCategory)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<TaskCategory, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<TaskCategory, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, TaskCategory>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			TaskCategory.class.getClassLoader(), TaskCategory.class,
			ModelWrapper.class);

		try {
			Constructor<TaskCategory> constructor =
				(Constructor<TaskCategory>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<TaskCategory, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<TaskCategory, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<TaskCategory, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<TaskCategory, Object>>();
		Map<String, BiConsumer<TaskCategory, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<TaskCategory, ?>>();

		attributeGetterFunctions.put("uuid", TaskCategory::getUuid);
		attributeSetterBiConsumers.put(
			"uuid", (BiConsumer<TaskCategory, String>)TaskCategory::setUuid);
		attributeGetterFunctions.put(
			"taskCategoryId", TaskCategory::getTaskCategoryId);
		attributeSetterBiConsumers.put(
			"taskCategoryId",
			(BiConsumer<TaskCategory, Long>)TaskCategory::setTaskCategoryId);
		attributeGetterFunctions.put("groupId", TaskCategory::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<TaskCategory, Long>)TaskCategory::setGroupId);
		attributeGetterFunctions.put("companyId", TaskCategory::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<TaskCategory, Long>)TaskCategory::setCompanyId);
		attributeGetterFunctions.put("userId", TaskCategory::getUserId);
		attributeSetterBiConsumers.put(
			"userId", (BiConsumer<TaskCategory, Long>)TaskCategory::setUserId);
		attributeGetterFunctions.put("userName", TaskCategory::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<TaskCategory, String>)TaskCategory::setUserName);
		attributeGetterFunctions.put("createDate", TaskCategory::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<TaskCategory, Date>)TaskCategory::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", TaskCategory::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<TaskCategory, Date>)TaskCategory::setModifiedDate);
		attributeGetterFunctions.put("type", TaskCategory::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<TaskCategory, String>)TaskCategory::setType);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getTaskCategoryId() {
		return _taskCategoryId;
	}

	@Override
	public void setTaskCategoryId(long taskCategoryId) {
		_columnBitmask = -1L;

		if (!_setOriginalTaskCategoryId) {
			_setOriginalTaskCategoryId = true;

			_originalTaskCategoryId = _taskCategoryId;
		}

		_taskCategoryId = taskCategoryId;
	}

	public long getOriginalTaskCategoryId() {
		return _originalTaskCategoryId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException portalException) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(TaskCategory.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), TaskCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public TaskCategory toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, TaskCategory>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		TaskCategoryImpl taskCategoryImpl = new TaskCategoryImpl();

		taskCategoryImpl.setUuid(getUuid());
		taskCategoryImpl.setTaskCategoryId(getTaskCategoryId());
		taskCategoryImpl.setGroupId(getGroupId());
		taskCategoryImpl.setCompanyId(getCompanyId());
		taskCategoryImpl.setUserId(getUserId());
		taskCategoryImpl.setUserName(getUserName());
		taskCategoryImpl.setCreateDate(getCreateDate());
		taskCategoryImpl.setModifiedDate(getModifiedDate());
		taskCategoryImpl.setType(getType());

		taskCategoryImpl.resetOriginalValues();

		return taskCategoryImpl;
	}

	@Override
	public int compareTo(TaskCategory taskCategory) {
		int value = 0;

		if (getTaskCategoryId() < taskCategory.getTaskCategoryId()) {
			value = -1;
		}
		else if (getTaskCategoryId() > taskCategory.getTaskCategoryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskCategory)) {
			return false;
		}

		TaskCategory taskCategory = (TaskCategory)object;

		long primaryKey = taskCategory.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		TaskCategoryModelImpl taskCategoryModelImpl = this;

		taskCategoryModelImpl._originalUuid = taskCategoryModelImpl._uuid;

		taskCategoryModelImpl._originalTaskCategoryId =
			taskCategoryModelImpl._taskCategoryId;

		taskCategoryModelImpl._setOriginalTaskCategoryId = false;

		taskCategoryModelImpl._originalGroupId = taskCategoryModelImpl._groupId;

		taskCategoryModelImpl._setOriginalGroupId = false;

		taskCategoryModelImpl._originalCompanyId =
			taskCategoryModelImpl._companyId;

		taskCategoryModelImpl._setOriginalCompanyId = false;

		taskCategoryModelImpl._setModifiedDate = false;

		taskCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<TaskCategory> toCacheModel() {
		TaskCategoryCacheModel taskCategoryCacheModel =
			new TaskCategoryCacheModel();

		taskCategoryCacheModel.uuid = getUuid();

		String uuid = taskCategoryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			taskCategoryCacheModel.uuid = null;
		}

		taskCategoryCacheModel.taskCategoryId = getTaskCategoryId();

		taskCategoryCacheModel.groupId = getGroupId();

		taskCategoryCacheModel.companyId = getCompanyId();

		taskCategoryCacheModel.userId = getUserId();

		taskCategoryCacheModel.userName = getUserName();

		String userName = taskCategoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			taskCategoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			taskCategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			taskCategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			taskCategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			taskCategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		taskCategoryCacheModel.type = getType();

		String type = taskCategoryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			taskCategoryCacheModel.type = null;
		}

		return taskCategoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<TaskCategory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<TaskCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TaskCategory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((TaskCategory)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<TaskCategory, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<TaskCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<TaskCategory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((TaskCategory)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, TaskCategory>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _taskCategoryId;
	private long _originalTaskCategoryId;
	private boolean _setOriginalTaskCategoryId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _type;
	private long _columnBitmask;
	private TaskCategory _escapedModel;

}