## MySQL实用小技巧 ##

* 避免重复插入
```
INSERT IGNORE INTO user(id, name) VALUES (1,'xiaoming')
ps:必须有唯一约束。相对INSERT INTO,出现唯一约束的字段重复时，执行插入语句时返回0，而不会报错。
```
* ​