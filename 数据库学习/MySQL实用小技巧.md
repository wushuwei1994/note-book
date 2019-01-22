## MySQL实用小技巧 ##

* 避免重复插入
```
INSERT IGNORE INTO user(id, name) VALUES (1,'xiaoming')
ps:必须有唯一约束。相对INSERT INTO,出现唯一约束的字段重复时，执行插入语句时返回0，而不会报错。
```
* ON DUPLICATE KEY UPDATE

```
//如果在INSERT语句末尾指定了ON DUPLICATE KEY UPDATE，并且插入行后会导致在一个UNIQUE索引或PRIMARY //KEY中出现重复值，则在出现重复值的行执行UPDATE；如果不会导致唯一值列重复的问题，则插入新行。
// 示例
INSERT INTO hot_tag(tagName, useCount, ctime)
VALUES('自定义标签2', 1, NOW()) ON DUPLICATE KEY UPDATE useCount = useCount + 1
```

* 同库备份表数据

```
CREATE TABLE wx_gh_20180911 LIKE wx_gh; // 创建相同表结构表
INSERT INTO wx_gh_20180911 SELECT * FROM wx_gh; // 备份数据
```
