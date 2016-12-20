# Oracle 基本SQL语句

## 增加字段、删除字段
添加字段的语法：alter table tablename add (column datatype [default value][null/not null],….);

修改字段的语法：alter table tablename modify (column datatype [default value][null/not null],….);

删除字段的语法：alter table tablename drop (column);
添加、修改、删除多列的话，用逗号隔开。

重命名列名
alter table TABLE_NAME rename column FIELD_NAME to NEW_FIELD_NAME;

示例：
```
--增加字段
ALTER TABLE  OSM_FAULT_MESSAGE ADD (IBOSS_ORDER_ID INTEGER NULL)
--删除字段
ALTER TABLE  OSM_FAULT_MESSAGE DROP(IBOSS_ORDER_ID)
--修改字段
ALTER TABLE  OSM_FAULT_MESSAGE MODIFY (IBOSS_ORDER_ID DATE)
```
## 查看表名
```
--查看当前用户表名
SELECT TABLE_NAME FROM USER_TABLES;

--查看所有用户表名
SELECT TABLE_NAME FROM ALL_TABLES;

--查看所有表（包括系统表）
SELECT TABLE_NAME FROM DBA_TABLES;
```
## 查看表字段
```
--当前用户表字段，结果集：table_name,column_name,data_type,data_length,data_precision,data_scale,nullable,column_id等 
SELECT * FROM USER_TAB_COLUMNS WHERE TABLE_NAME = 'OSM_FAULT_MESSAGE';

--所有表字段，结果集：ower,table_name,column_name,data_type,data_length,data_precision,data_scale,nullable,column_id等 
SELECT * FROM ALL_TAB_COLUMNS WHERE TABLE_NAME = 'OSM_FAULT_MESSAGE';

--所有表字段（包括其他用户表及系统表），结果集：ower,table_name,column_name,data_type,data_length,data_precision,data_scale,nullable,column_id等
SELECT * FROM DBA_TAB_COLUMNS WHERE TABLE_NAME = 'OSM_FAULT_MESSAGE'
```
## 注释相关

```
--增加列注释
COMMENT ON COLUMN OSM_FAULT_MESSAGE.IBOSS_ORDER_ID IS '我是列注释'

--增加表注释
COMMENT ON TABLE OSM_FAULT_MESSAGE IS '我是表注释'

--获取表注释，结果集：TABLE_NAME	TABLE_TYPE	COMMENTS
SELECT * FROM USER_TAB_COMMENTS WHERE TABLE_NAME = 'OSM_FAULT_MESSAGE'

--获取字段注释 ，结果集：TABLE_NAME	COLUMN_NAME	COMMENTS
SELECT * FROM USER_COL_COMMENTS WHERE TABLE_NAME = 'OSM_FAULT_MESSAGE'
```
## 插入语句
```
 INSERT INTO OSM_EQUIPMENT_RUNNING(ID, EQUIPMENT_ID,END_TIME,END_DESCRIPTION)
 SELECT SEQ_OSM_EQUIPMENT_RUNNING.NEXTVAL,E.ID,SYSDATE,'设备停用'
 FROM OSM_EQUIPMENT E WHERE E.ID NOT IN (SELECT DISTINCT(OER.EQUIPMENT_ID) FROM  OSM_EQUIPMENT_RUNNING OER ) AND E.STATE = 0;
```


