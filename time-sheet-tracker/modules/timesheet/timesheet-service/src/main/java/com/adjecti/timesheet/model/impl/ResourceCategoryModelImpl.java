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

import com.adjecti.timesheet.model.ResourceCategory;
import com.adjecti.timesheet.model.ResourceCategoryModel;
import com.adjecti.timesheet.model.ResourceCategorySoap;

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
 * The base model implementation for the ResourceCategory service. Represents a row in the &quot;timesheet_ResourceCategory&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ResourceCategoryModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ResourceCategoryImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ResourceCategoryImpl
 * @generated
 */
@JSON(strict = true)
public class ResourceCategoryModelImpl
	extends BaseModelImpl<ResourceCategory> implements ResourceCategoryModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a resource category model instance should use the <code>ResourceCategory</code> interface instead.
	 */
	public static final String TABLE_NAME = "timesheet_ResourceCategory";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"resourceCategoryId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"type_", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("resourceCategoryId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table timesheet_ResourceCategory (uuid_ VARCHAR(75) null,resourceCategoryId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,type_ VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table timesheet_ResourceCategory";

	public static final String ORDER_BY_JPQL =
		" ORDER BY resourceCategory.resourceCategoryId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY timesheet_ResourceCategory.resourceCategoryId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long RESOURCECATEGORYID_COLUMN_BITMASK = 4L;

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
	public static ResourceCategory toModel(ResourceCategorySoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ResourceCategory model = new ResourceCategoryImpl();

		model.setUuid(soapModel.getUuid());
		model.setResourceCategoryId(soapModel.getResourceCategoryId());
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
	public static List<ResourceCategory> toModels(
		ResourceCategorySoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ResourceCategory> models = new ArrayList<ResourceCategory>(
			soapModels.length);

		for (ResourceCategorySoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ResourceCategoryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _resourceCategoryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setResourceCategoryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _resourceCategoryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ResourceCategory.class;
	}

	@Override
	public String getModelClassName() {
		return ResourceCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ResourceCategory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ResourceCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ResourceCategory, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ResourceCategory)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ResourceCategory, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ResourceCategory, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ResourceCategory)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ResourceCategory, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ResourceCategory, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ResourceCategory>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ResourceCategory.class.getClassLoader(), ResourceCategory.class,
			ModelWrapper.class);

		try {
			Constructor<ResourceCategory> constructor =
				(Constructor<ResourceCategory>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ResourceCategory, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ResourceCategory, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ResourceCategory, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ResourceCategory, Object>>();
		Map<String, BiConsumer<ResourceCategory, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<ResourceCategory, ?>>();

		attributeGetterFunctions.put("uuid", ResourceCategory::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ResourceCategory, String>)ResourceCategory::setUuid);
		attributeGetterFunctions.put(
			"resourceCategoryId", ResourceCategory::getResourceCategoryId);
		attributeSetterBiConsumers.put(
			"resourceCategoryId",
			(BiConsumer<ResourceCategory, Long>)
				ResourceCategory::setResourceCategoryId);
		attributeGetterFunctions.put("groupId", ResourceCategory::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ResourceCategory, Long>)ResourceCategory::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ResourceCategory::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ResourceCategory, Long>)ResourceCategory::setCompanyId);
		attributeGetterFunctions.put("userId", ResourceCategory::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ResourceCategory, Long>)ResourceCategory::setUserId);
		attributeGetterFunctions.put("userName", ResourceCategory::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ResourceCategory, String>)
				ResourceCategory::setUserName);
		attributeGetterFunctions.put(
			"createDate", ResourceCategory::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ResourceCategory, Date>)
				ResourceCategory::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ResourceCategory::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ResourceCategory, Date>)
				ResourceCategory::setModifiedDate);
		attributeGetterFunctions.put("type", ResourceCategory::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<ResourceCategory, String>)ResourceCategory::setType);

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
	public long getResourceCategoryId() {
		return _resourceCategoryId;
	}

	@Override
	public void setResourceCategoryId(long resourceCategoryId) {
		_columnBitmask = -1L;

		if (!_setOriginalResourceCategoryId) {
			_setOriginalResourceCategoryId = true;

			_originalResourceCategoryId = _resourceCategoryId;
		}

		_resourceCategoryId = resourceCategoryId;
	}

	public long getOriginalResourceCategoryId() {
		return _originalResourceCategoryId;
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
			PortalUtil.getClassNameId(ResourceCategory.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ResourceCategory.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ResourceCategory toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ResourceCategory>
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
		ResourceCategoryImpl resourceCategoryImpl = new ResourceCategoryImpl();

		resourceCategoryImpl.setUuid(getUuid());
		resourceCategoryImpl.setResourceCategoryId(getResourceCategoryId());
		resourceCategoryImpl.setGroupId(getGroupId());
		resourceCategoryImpl.setCompanyId(getCompanyId());
		resourceCategoryImpl.setUserId(getUserId());
		resourceCategoryImpl.setUserName(getUserName());
		resourceCategoryImpl.setCreateDate(getCreateDate());
		resourceCategoryImpl.setModifiedDate(getModifiedDate());
		resourceCategoryImpl.setType(getType());

		resourceCategoryImpl.resetOriginalValues();

		return resourceCategoryImpl;
	}

	@Override
	public int compareTo(ResourceCategory resourceCategory) {
		int value = 0;

		if (getResourceCategoryId() <
				resourceCategory.getResourceCategoryId()) {

			value = -1;
		}
		else if (getResourceCategoryId() >
					resourceCategory.getResourceCategoryId()) {

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

		if (!(object instanceof ResourceCategory)) {
			return false;
		}

		ResourceCategory resourceCategory = (ResourceCategory)object;

		long primaryKey = resourceCategory.getPrimaryKey();

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
		ResourceCategoryModelImpl resourceCategoryModelImpl = this;

		resourceCategoryModelImpl._originalUuid =
			resourceCategoryModelImpl._uuid;

		resourceCategoryModelImpl._originalResourceCategoryId =
			resourceCategoryModelImpl._resourceCategoryId;

		resourceCategoryModelImpl._setOriginalResourceCategoryId = false;

		resourceCategoryModelImpl._originalGroupId =
			resourceCategoryModelImpl._groupId;

		resourceCategoryModelImpl._setOriginalGroupId = false;

		resourceCategoryModelImpl._originalCompanyId =
			resourceCategoryModelImpl._companyId;

		resourceCategoryModelImpl._setOriginalCompanyId = false;

		resourceCategoryModelImpl._setModifiedDate = false;

		resourceCategoryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ResourceCategory> toCacheModel() {
		ResourceCategoryCacheModel resourceCategoryCacheModel =
			new ResourceCategoryCacheModel();

		resourceCategoryCacheModel.uuid = getUuid();

		String uuid = resourceCategoryCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			resourceCategoryCacheModel.uuid = null;
		}

		resourceCategoryCacheModel.resourceCategoryId = getResourceCategoryId();

		resourceCategoryCacheModel.groupId = getGroupId();

		resourceCategoryCacheModel.companyId = getCompanyId();

		resourceCategoryCacheModel.userId = getUserId();

		resourceCategoryCacheModel.userName = getUserName();

		String userName = resourceCategoryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			resourceCategoryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			resourceCategoryCacheModel.createDate = createDate.getTime();
		}
		else {
			resourceCategoryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			resourceCategoryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			resourceCategoryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		resourceCategoryCacheModel.type = getType();

		String type = resourceCategoryCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			resourceCategoryCacheModel.type = null;
		}

		return resourceCategoryCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ResourceCategory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ResourceCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ResourceCategory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ResourceCategory)this));
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
		Map<String, Function<ResourceCategory, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ResourceCategory, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ResourceCategory, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ResourceCategory)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ResourceCategory>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _resourceCategoryId;
	private long _originalResourceCategoryId;
	private boolean _setOriginalResourceCategoryId;
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
	private ResourceCategory _escapedModel;

}