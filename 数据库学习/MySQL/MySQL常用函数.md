## MySQL常用函数

#### 时间相关

1.时间戳转时间格式

```
SELECT FROM_UNIXTIME(123) // 结果：1970-01-01 08:02:03
```

2.时间转时间戳

```
SELECT UNIX_TIMESTAMP(); // 当前时间戳，结果：1574323713
SELECT UNIX_TIMESTAMP(CURRENT_DATE); // 当天凌晨时间戳
```

3.查询日期

```
SELECT CURRENT_DATE;  //当天日期：2019-11-21
SELECT (CURRENT_DATE - INTERVAL 1 DAY); // 昨天日期：2019-11-20
-- 上月第一天
SELECT CURRENT_DATE - INTERVAL 1 MONTH - INTERVAL (DAY(NOW()) - 1) DAY;
-- 当月第一天
SELECT CURRENT_DATE - INTERVAL (DAY(NOW()) - 1) DAY;
-- 当天在当月的天数
SELECT DAY(NOW());
-- 当天在当年的月份数
SELECT MONTH(NOW());
```

4.计算时间天数差值

```
-- 结果为：2
SELECT DATEDIFF( FROM_UNIXTIME(1591260582720/1000), FROM_UNIXTIME(1591033782000/1000));
```

5.计算datetime类型差值 TIMESTAMPDIFF(unit,start,end)

> unit分类：
> 　　MINUTE：以分钟为单位
> 　　HOUR:小时为单位
> 　　DAY：天为单位
> 　　MONTH:月为单位

```
SELECT TIMESTAMPDIFF(DAY,'2020-05-01 18:27:16', '2020-05-01 10:20:01'); //结果：0
SELECT TIMESTAMPDIFF(HOUR,'2020-05-01 18:27:16', '2020-05-01 10:20:01'); // 结果 -8

```



#### 字符串相关

1. 字符串截取 substring(col_name, start, length)函数: col_name列名（必选），start从第几个开始（必选 为整数 从1开始），length截去长度（可选，为正整数）

```
SELECT SUBSTR('abc', 2);  // 结果：bc
SELECT SUBSTR('abc', 2, 1); // 结果：b
```



