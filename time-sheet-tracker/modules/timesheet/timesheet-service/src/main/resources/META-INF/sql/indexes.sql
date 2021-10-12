create index IX_C451D675 on timesheet_Employee (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_15D77637 on timesheet_Employee (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_6ABD6CA6 on timesheet_Project (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_89E4E4A8 on timesheet_Project (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_912E85D4 on timesheet_ProjectResource (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_52867156 on timesheet_ProjectResource (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_97F1DEF3 on timesheet_ResourceCategory (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_723B8635 on timesheet_ResourceCategory (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_B6D9A24C on timesheet_Task (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A6BE4BCE on timesheet_Task (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5E36D66A on timesheet_TaskCategory (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1D75EF6C on timesheet_TaskCategory (uuid_[$COLUMN_LENGTH:75$], groupId);