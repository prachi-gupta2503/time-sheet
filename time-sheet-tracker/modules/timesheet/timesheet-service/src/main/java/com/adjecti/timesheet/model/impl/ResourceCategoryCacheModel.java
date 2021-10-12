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

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ResourceCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ResourceCategoryCacheModel
	implements CacheModel<ResourceCategory>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ResourceCategoryCacheModel)) {
			return false;
		}

		ResourceCategoryCacheModel resourceCategoryCacheModel =
			(ResourceCategoryCacheModel)object;

		if (resourceCategoryId ==
				resourceCategoryCacheModel.resourceCategoryId) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, resourceCategoryId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", resourceCategoryId=");
		sb.append(resourceCategoryId);
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
	public ResourceCategory toEntityModel() {
		ResourceCategoryImpl resourceCategoryImpl = new ResourceCategoryImpl();

		if (uuid == null) {
			resourceCategoryImpl.setUuid("");
		}
		else {
			resourceCategoryImpl.setUuid(uuid);
		}

		resourceCategoryImpl.setResourceCategoryId(resourceCategoryId);
		resourceCategoryImpl.setGroupId(groupId);
		resourceCategoryImpl.setCompanyId(companyId);
		resourceCategoryImpl.setUserId(userId);

		if (userName == null) {
			resourceCategoryImpl.setUserName("");
		}
		else {
			resourceCategoryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			resourceCategoryImpl.setCreateDate(null);
		}
		else {
			resourceCategoryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			resourceCategoryImpl.setModifiedDate(null);
		}
		else {
			resourceCategoryImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			resourceCategoryImpl.setType("");
		}
		else {
			resourceCategoryImpl.setType(type);
		}

		resourceCategoryImpl.resetOriginalValues();

		return resourceCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		resourceCategoryId = objectInput.readLong();

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

		objectOutput.writeLong(resourceCategoryId);

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
	public long resourceCategoryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;

}