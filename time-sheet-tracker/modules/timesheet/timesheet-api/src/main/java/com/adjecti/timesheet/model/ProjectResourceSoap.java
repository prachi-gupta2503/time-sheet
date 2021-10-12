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
 * This class is used by SOAP remote services, specifically {@link com.adjecti.timesheet.service.http.ProjectResourceServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProjectResourceSoap implements Serializable {

	public static ProjectResourceSoap toSoapModel(ProjectResource model) {
		ProjectResourceSoap soapModel = new ProjectResourceSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setProjectResourceId(model.getProjectResourceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setProjectId(model.getProjectId());
		soapModel.setEmployeeId(model.getEmployeeId());

		return soapModel;
	}

	public static ProjectResourceSoap[] toSoapModels(ProjectResource[] models) {
		ProjectResourceSoap[] soapModels =
			new ProjectResourceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProjectResourceSoap[][] toSoapModels(
		ProjectResource[][] models) {

		ProjectResourceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProjectResourceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProjectResourceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProjectResourceSoap[] toSoapModels(
		List<ProjectResource> models) {

		List<ProjectResourceSoap> soapModels =
			new ArrayList<ProjectResourceSoap>(models.size());

		for (ProjectResource model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProjectResourceSoap[soapModels.size()]);
	}

	public ProjectResourceSoap() {
	}

	public long getPrimaryKey() {
		return _projectResourceId;
	}

	public void setPrimaryKey(long pk) {
		setProjectResourceId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getProjectResourceId() {
		return _projectResourceId;
	}

	public void setProjectResourceId(long projectResourceId) {
		_projectResourceId = projectResourceId;
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

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public long getProjectId() {
		return _projectId;
	}

	public void setProjectId(long projectId) {
		_projectId = projectId;
	}

	public long getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(long employeeId) {
		_employeeId = employeeId;
	}

	private String _uuid;
	private long _projectResourceId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _endDate;
	private Date _startDate;
	private long _projectId;
	private long _employeeId;

}