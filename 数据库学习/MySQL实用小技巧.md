## MySQL实用小技巧 ##

* 避免重复插入
```
INSERT IGNORE INTO user(id, name) VALUES (1,'xiaoming')
ps:必须有唯一约束。相对INSERT INTO,出现唯一约束的字段重复时，执行插入语句时返回0，而不会报错。
```
* ON DUPLICATE KEY UPDATE

```
//如果在INSERT语句末尾指定了ON DUPLICATE KEY UPDATE，并且插入行后会导致在一个UNIQUE索引或PRIMARY //KEY中出现重复值，则在出现重复值的行执行UPDATE；如果不会导致唯一值列重复的问题，则插入新行。
```

