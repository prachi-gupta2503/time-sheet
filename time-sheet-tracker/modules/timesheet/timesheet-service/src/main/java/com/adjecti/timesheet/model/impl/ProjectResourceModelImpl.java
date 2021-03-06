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

import com.adjecti.timesheet.model.ProjectResource;
import com.adjecti.timesheet.model.ProjectResourceModel;
import com.adjecti.timesheet.model.ProjectResourceSoap;

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
 * The base model implementation for the ProjectResource service. Represents a row in the &quot;timesheet_ProjectResource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProjectResourceModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectResourceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProjectResourceImpl
 * @generated
 */
@JSON(strict = true)
public class ProjectResourceModelImpl
	extends BaseModelImpl<ProjectResource> implements ProjectResourceModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project resource model instance should use the <code>ProjectResource</code> interface instead.
	 */
	public static final String TABLE_NAME = "timesheet_ProjectResource";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"projectResourceId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"endDate", Types.TIMESTAMP}, {"startDate", Types.TIMESTAMP},
		{"projectId", Types.BIGINT}, {"employeeId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectResourceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("endDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("startDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("employeeId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table timesheet_ProjectResource (uuid_ VARCHAR(75) null,projectResourceId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,endDate DATE null,startDate DATE null,projectId LONG,employeeId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table timesheet_ProjectResource";

	public static final String ORDER_BY_JPQL =
		" ORDER BY projectResource.projectResourceId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY timesheet_ProjectResource.projectResourceId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long GROUPID_COLUMN_BITMASK = 2L;

	public static final long PROJECTRESOURCEID_COLUMN_BITMASK = 4L;

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
	public static ProjectResource toModel(ProjectResourceSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectResource model = new ProjectResourceImpl();

		model.setUuid(soapModel.getUuid());
		model.setProjectResourceId(soapModel.getProjectResourceId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setEndDate(soapModel.getEndDate());
		model.setStartDate(soapModel.getStartDate());
		model.setProjectId(soapModel.getProjectId());
		model.setEmployeeId(soapModel.getEmployeeId());

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
	public static List<ProjectResource> toModels(
		ProjectResourceSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ProjectResource> models = new ArrayList<ProjectResource>(
			soapModels.length);

		for (ProjectResourceSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public ProjectResourceModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectResourceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectResourceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectResourceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectResource.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectResource.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProjectResource, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProjectResource, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectResource, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProjectResource)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProjectResource, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProjectResource, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProjectResource)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProjectResource, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProjectResource, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProjectResource>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProjectResource.class.getClassLoader(), ProjectResource.class,
			ModelWrapper.class);

		try {
			Constructor<ProjectResource> constructor =
				(Constructor<ProjectResource>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ProjectResource, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProjectResource, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProjectResource, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ProjectResource, Object>>();
		Map<String, BiConsumer<ProjectResource, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ProjectResource, ?>>();

		attributeGetterFunctions.put("uuid", ProjectResource::getUuid);
		attributeSetterBiConsumers.put(
			"uuid",
			(BiConsumer<ProjectResource, String>)ProjectResource::setUuid);
		attributeGetterFunctions.put(
			"projectResourceId", ProjectResource::getProjectResourceId);
		attributeSetterBiConsumers.put(
			"projectResourceId",
			(BiConsumer<ProjectResource, Long>)
				ProjectResource::setProjectResourceId);
		attributeGetterFunctions.put("groupId", ProjectResource::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ProjectResource, Long>)ProjectResource::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ProjectResource::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ProjectResource, Long>)ProjectResource::setCompanyId);
		attributeGetterFunctions.put("userId", ProjectResource::getUserId);
		attributeSetterBiConsumers.put(
			"userId",
			(BiConsumer<ProjectResource, Long>)ProjectResource::setUserId);
		attributeGetterFunctions.put("userName", ProjectResource::getUserName);
		attributeSetterBiConsumers.put(
			"userName",
			(BiConsumer<ProjectResource, String>)ProjectResource::setUserName);
		attributeGetterFunctions.put(
			"createDate", ProjectResource::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ProjectResource, Date>)ProjectResource::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ProjectResource::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ProjectResource, Date>)
				ProjectResource::setModifiedDate);
		attributeGetterFunctions.put("endDate", ProjectResource::getEndDate);
		attributeSetterBiConsumers.put(
			"endDate",
			(BiConsumer<ProjectResource, Date>)ProjectResource::setEndDate);
		attributeGetterFunctions.put(
			"startDate", ProjectResource::getStartDate);
		attributeSetterBiConsumers.put(
			"startDate",
			(BiConsumer<ProjectResource, Date>)ProjectResource::setStartDate);
		attributeGetterFunctions.put(
			"projectId", ProjectResource::getProjectId);
		attributeSetterBiConsumers.put(
			"projectId",
			(BiConsumer<ProjectResource, Long>)ProjectResource::setProjectId);
		attributeGetterFunctions.put(
			"employeeId", ProjectResource::getEmployeeId);
		attributeSetterBiConsumers.put(
			"employeeId",
			(BiConsumer<ProjectResource, Long>)ProjectResource::setEmployeeId);

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
	public long getProjectResourceId() {
		return _projectResourceId;
	}

	@Override
	public void setProjectResourceId(long projectResourceId) {
		_columnBitmask = -1L;

		if (!_setOriginalProjectResourceId) {
			_setOriginalProjectResourceId = true;

			_originalProjectResourceId = _projectResourceId;
		}

		_projectResourceId = projectResourceId;
	}

	public long getOriginalProjectResourceId() {
		return _originalProjectResourceId;
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
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	@JSON
	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	@JSON
	@Override
	public long getEmployeeId() {
		return _employeeId;
	}

	@Override
	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(ProjectResource.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ProjectResource.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectResource toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProjectResource>
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
		ProjectResourceImpl projectResourceImpl = new ProjectResourceImpl();

		projectResourceImpl.setUuid(getUuid());
		projectResourceImpl.setProjectResourceId(getProjectResourceId());
		projectResourceImpl.setGroupId(getGroupId());
		projectResourceImpl.setCompanyId(getCompanyId());
		projectResourceImpl.setUserId(getUserId());
		projectResourceImpl.setUserName(getUserName());
		projectResourceImpl.setCreateDate(getCreateDate());
		projectResourceImpl.setModifiedDate(getModifiedDate());
		projectResourceImpl.setEndDate(getEndDate());
		projectResourceImpl.setStartDate(getStartDate());
		projectResourceImpl.setProjectId(getProjectId());
		projectResourceImpl.setEmployeeId(getEmployeeId());

		projectResourceImpl.resetOriginalValues();

		return projectResourceImpl;
	}

	@Override
	public int compareTo(ProjectResource projectResource) {
		int value = 0;

		if (getProjectResourceId() < projectResource.getProjectResourceId()) {
			value = -1;
		}
		else if (getProjectResourceId() >
					projectResource.getProjectResourceId()) {

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

		if (!(object instanceof ProjectResource)) {
			return false;
		}

		ProjectResource projectResource = (ProjectResource)object;

		long primaryKey = projectResource.getPrimaryKey();

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
		ProjectResourceModelImpl projectResourceModelImpl = this;

		projectResourceModelImpl._originalUuid = projectResourceModelImpl._uuid;

		projectResourceModelImpl._originalProjectResourceId =
			projectResourceModelImpl._projectResourceId;

		projectResourceModelImpl._setOriginalProjectResourceId = false;

		projectResourceModelImpl._originalGroupId =
			projectResourceModelImpl._groupId;

		projectResourceModelImpl._setOriginalGroupId = false;

		projectResourceModelImpl._originalCompanyId =
			projectResourceModelImpl._companyId;

		projectResourceModelImpl._setOriginalCompanyId = false;

		projectResourceModelImpl._setModifiedDate = false;

		projectResourceModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectResource> toCacheModel() {
		ProjectResourceCacheModel projectResourceCacheModel =
			new ProjectResourceCacheModel();

		projectResourceCacheModel.uuid = getUuid();

		String uuid = projectResourceCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			projectResourceCacheModel.uuid = null;
		}

		projectResourceCacheModel.projectResourceId = getProjectResourceId();

		projectResourceCacheModel.groupId = getGroupId();

		projectResourceCacheModel.companyId = getCompanyId();

		projectResourceCacheModel.userId = getUserId();

		projectResourceCacheModel.userName = getUserName();

		String userName = projectResourceCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			projectResourceCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			projectResourceCacheModel.createDate = createDate.getTime();
		}
		else {
			projectResourceCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			projectResourceCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			projectResourceCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		Date endDate = getEndDate();

		if (endDate != null) {
			projectResourceCacheModel.endDate = endDate.getTime();
		}
		else {
			projectResourceCacheModel.endDate = Long.MIN_VALUE;
		}

		Date startDate = getStartDate();

		if (startDate != null) {
			projectResourceCacheModel.startDate = startDate.getTime();
		}
		else {
			projectResourceCacheModel.startDate = Long.MIN_VALUE;
		}

		projectResourceCacheModel.projectId = getProjectId();

		projectResourceCacheModel.employeeId = getEmployeeId();

		return projectResourceCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProjectResource, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProjectResource, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectResource, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ProjectResource)this));
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
		Map<String, Function<ProjectResource, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProjectResource, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectResource, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ProjectResource)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProjectResource>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _projectResourceId;
	private long _originalProjectResourceId;
	private boolean _setOriginalProjectResourceId;
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
	private Date _endDate;
	private Date _startDate;
	private long _projectId;
	private long _employeeId;
	private long _columnBitmask;
	private ProjectResource _escapedModel;

}