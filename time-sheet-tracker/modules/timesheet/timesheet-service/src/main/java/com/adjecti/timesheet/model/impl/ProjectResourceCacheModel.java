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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectResource in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProjectResourceCacheModel
	implements CacheModel<ProjectResource>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectResourceCacheModel)) {
			return false;
		}

		ProjectResourceCacheModel projectResourceCacheModel =
			(ProjectResourceCacheModel)object;

		if (projectResourceId == projectResourceCacheModel.projectResourceId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectResourceId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", projectResourceId=");
		sb.append(projectResourceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectResource toEntityModel() {
		ProjectResourceImpl projectResourceImpl = new ProjectResourceImpl();

		if (uuid == null) {
			projectResourceImpl.setUuid("");
		}
		else {
			projectResourceImpl.setUuid(uuid);
		}

		projectResourceImpl.setProjectResourceId(projectResourceId);
		projectResourceImpl.setGroupId(groupId);
		projectResourceImpl.setCompanyId(companyId);
		projectResourceImpl.setUserId(userId);

		if (userName == null) {
			projectResourceImpl.setUserName("");
		}
		else {
			projectResourceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			projectResourceImpl.setCreateDate(null);
		}
		else {
			projectResourceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			projectResourceImpl.setModifiedDate(null);
		}
		else {
			projectResourceImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (endDate == Long.MIN_VALUE) {
			projectResourceImpl.setEndDate(null);
		}
		else {
			projectResourceImpl.setEndDate(new Date(endDate));
		}

		if (startDate == Long.MIN_VALUE) {
			projectResourceImpl.setStartDate(null);
		}
		else {
			projectResourceImpl.setStartDate(new Date(startDate));
		}

		projectResourceImpl.setProjectId(projectId);
		projectResourceImpl.setEmployeeId(employeeId);

		projectResourceImpl.resetOriginalValues();

		return projectResourceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		projectResourceId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		endDate = objectInput.readLong();
		startDate = objectInput.readLong();

		projectId = objectInput.readLong();

		employeeId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(projectResourceId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(startDate);

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(employeeId);
	}

	public String uuid;
	public long projectResourceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long endDate;
	public long startDate;
	public long projectId;
	public long employeeId;

}