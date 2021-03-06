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

package com.adjecti.timesheet.service.base;

import com.adjecti.timesheet.model.ResourceCategory;
import com.adjecti.timesheet.service.ResourceCategoryLocalService;
import com.adjecti.timesheet.service.persistence.EmployeePersistence;
import com.adjecti.timesheet.service.persistence.ProjectPersistence;
import com.adjecti.timesheet.service.persistence.ProjectResourcePersistence;
import com.adjecti.timesheet.service.persistence.ResourceCategoryPersistence;
import com.adjecti.timesheet.service.persistence.TaskCategoryPersistence;
import com.adjecti.timesheet.service.persistence.TaskPersistence;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the resource category local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.adjecti.timesheet.service.impl.ResourceCategoryLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.adjecti.timesheet.service.impl.ResourceCategoryLocalServiceImpl
 * @generated
 */
public abstract class ResourceCategoryLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ResourceCategoryLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ResourceCategoryLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.adjecti.timesheet.service.ResourceCategoryLocalServiceUtil</code>.
	 */

	/**
	 * Adds the resource category to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategory the resource category
	 * @return the resource category that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ResourceCategory addResourceCategory(
		ResourceCategory resourceCategory) {

		resourceCategory.setNew(true);

		return resourceCategoryPersistence.update(resourceCategory);
	}

	/**
	 * Creates a new resource category with the primary key. Does not add the resource category to the database.
	 *
	 * @param resourceCategoryId the primary key for the new resource category
	 * @return the new resource category
	 */
	@Override
	@Transactional(enabled = false)
	public ResourceCategory createResourceCategory(long resourceCategoryId) {
		return resourceCategoryPersistence.create(resourceCategoryId);
	}

	/**
	 * Deletes the resource category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category that was removed
	 * @throws PortalException if a resource category with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ResourceCategory deleteResourceCategory(long resourceCategoryId)
		throws PortalException {

		return resourceCategoryPersistence.remove(resourceCategoryId);
	}

	/**
	 * Deletes the resource category from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategory the resource category
	 * @return the resource category that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ResourceCategory deleteResourceCategory(
		ResourceCategory resourceCategory) {

		return resourceCategoryPersistence.remove(resourceCategory);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ResourceCategory.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return resourceCategoryPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return resourceCategoryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return resourceCategoryPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return resourceCategoryPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return resourceCategoryPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ResourceCategory fetchResourceCategory(long resourceCategoryId) {
		return resourceCategoryPersistence.fetchByPrimaryKey(
			resourceCategoryId);
	}

	/**
	 * Returns the resource category matching the UUID and group.
	 *
	 * @param uuid the resource category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource category, or <code>null</code> if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory fetchResourceCategoryByUuidAndGroupId(
		String uuid, long groupId) {

		return resourceCategoryPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the resource category with the primary key.
	 *
	 * @param resourceCategoryId the primary key of the resource category
	 * @return the resource category
	 * @throws PortalException if a resource category with the primary key could not be found
	 */
	@Override
	public ResourceCategory getResourceCategory(long resourceCategoryId)
		throws PortalException {

		return resourceCategoryPersistence.findByPrimaryKey(resourceCategoryId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			resourceCategoryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ResourceCategory.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("resourceCategoryId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			resourceCategoryLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ResourceCategory.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"resourceCategoryId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			resourceCategoryLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ResourceCategory.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("resourceCategoryId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ResourceCategory>() {

				@Override
				public void performAction(ResourceCategory resourceCategory)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, resourceCategory);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(ResourceCategory.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return resourceCategoryPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return resourceCategoryLocalService.deleteResourceCategory(
			(ResourceCategory)persistedModel);
	}

	public BasePersistence<ResourceCategory> getBasePersistence() {
		return resourceCategoryPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return resourceCategoryPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the resource categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource categories
	 * @param companyId the primary key of the company
	 * @return the matching resource categories, or an empty list if no matches were found
	 */
	@Override
	public List<ResourceCategory> getResourceCategoriesByUuidAndCompanyId(
		String uuid, long companyId) {

		return resourceCategoryPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of resource categories matching the UUID and company.
	 *
	 * @param uuid the UUID of the resource categories
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching resource categories, or an empty list if no matches were found
	 */
	@Override
	public List<ResourceCategory> getResourceCategoriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ResourceCategory> orderByComparator) {

		return resourceCategoryPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the resource category matching the UUID and group.
	 *
	 * @param uuid the resource category's UUID
	 * @param groupId the primary key of the group
	 * @return the matching resource category
	 * @throws PortalException if a matching resource category could not be found
	 */
	@Override
	public ResourceCategory getResourceCategoryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return resourceCategoryPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the resource categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.adjecti.timesheet.model.impl.ResourceCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of resource categories
	 * @param end the upper bound of the range of resource categories (not inclusive)
	 * @return the range of resource categories
	 */
	@Override
	public List<ResourceCategory> getResourceCategories(int start, int end) {
		return resourceCategoryPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of resource categories.
	 *
	 * @return the number of resource categories
	 */
	@Override
	public int getResourceCategoriesCount() {
		return resourceCategoryPersistence.countAll();
	}

	/**
	 * Updates the resource category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ResourceCategoryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param resourceCategory the resource category
	 * @return the resource category that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ResourceCategory updateResourceCategory(
		ResourceCategory resourceCategory) {

		return resourceCategoryPersistence.update(resourceCategory);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ResourceCategoryLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		resourceCategoryLocalService = (ResourceCategoryLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ResourceCategoryLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ResourceCategory.class;
	}

	protected String getModelClassName() {
		return ResourceCategory.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = resourceCategoryPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected EmployeePersistence employeePersistence;

	@Reference
	protected ProjectPersistence projectPersistence;

	@Reference
	protected ProjectResourcePersistence projectResourcePersistence;

	protected ResourceCategoryLocalService resourceCategoryLocalService;

	@Reference
	protected ResourceCategoryPersistence resourceCategoryPersistence;

	@Reference
	protected TaskPersistence taskPersistence;

	@Reference
	protected TaskCategoryPersistence taskCategoryPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@Reference
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

}