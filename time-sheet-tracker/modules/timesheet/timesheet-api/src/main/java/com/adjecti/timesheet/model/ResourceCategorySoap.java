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

package com.adjecti.timesheet.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.adjecti.timesheet.service.http.ResourceCategoryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ResourceCategorySoap implements Serializable {

	public static ResourceCategorySoap toSoapModel(ResourceCategory model) {
		ResourceCategorySoap soapModel = new ResourceCategorySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setResourceCategoryId(model.getResourceCategoryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());

		return soapModel;
	}

	public static ResourceCategorySoap[] toSoapModels(
		ResourceCategory[] models) {

		ResourceCategorySoap[] soapModels =
			new ResourceCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ResourceCategorySoap[][] toSoapModels(
		ResourceCategory[][] models) {

		ResourceCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ResourceCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ResourceCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ResourceCategorySoap[] toSoapModels(
		List<ResourceCategory> models) {

		List<ResourceCategorySoap> soapModels =
			new ArrayList<ResourceCategorySoap>(models.size());

		for (ResourceCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ResourceCategorySoap[soapModels.size()]);
	}

	public ResourceCategorySoap() {
	}

	public long getPrimaryKey() {
		return _resourceCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setResourceCategoryId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getResourceCategoryId() {
		return _resourceCategoryId;
	}

	public void setResourceCategoryId(long resourceCategoryId) {
		_resourceCategoryId = resourceCategoryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	private String _uuid;
	private long _resourceCategoryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;

}