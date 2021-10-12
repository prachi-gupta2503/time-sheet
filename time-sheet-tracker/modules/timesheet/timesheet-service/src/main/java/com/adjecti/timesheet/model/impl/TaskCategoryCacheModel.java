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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaskCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class TaskCategoryCacheModel
	implements CacheModel<TaskCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TaskCategoryCacheModel)) {
			return false;
		}

		TaskCategoryCacheModel taskCategoryCacheModel =
			(TaskCategoryCacheModel)object;

		if (taskCategoryId == taskCategoryCacheModel.taskCategoryId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, taskCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", taskCategoryId=");
		sb.append(taskCategoryId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaskCategory toEntityModel() {
		TaskCategoryImpl taskCategoryImpl = new TaskCategoryImpl();

		if (uuid == null) {
			taskCategoryImpl.setUuid("");
		}
		else {
			taskCategoryImpl.setUuid(uuid);
		}

		taskCategoryImpl.setTaskCategoryId(taskCategoryId);
		taskCategoryImpl.setGroupId(groupId);
		taskCategoryImpl.setCompanyId(companyId);
		taskCategoryImpl.setUserId(userId);

		if (userName == null) {
			taskCategoryImpl.setUserName("");
		}
		else {
			taskCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			taskCategoryImpl.setCreateDate(null);
		}
		else {
			taskCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			taskCategoryImpl.setModifiedDate(null);
		}
		else {
			taskCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			taskCategoryImpl.setType("");
		}
		else {
			taskCategoryImpl.setType(type);
		}

		taskCategoryImpl.resetOriginalValues();

		return taskCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		taskCategoryId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(taskCategoryId);

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

		if (type == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(type);
		}
	}

	public String uuid;
	public long taskCategoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;

}