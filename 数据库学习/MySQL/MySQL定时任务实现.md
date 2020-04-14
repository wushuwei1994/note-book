## MySQL定时任务实现 ##

步骤：

1.查看服务器是否启动并开启事件计划

```
show variables like 'event_scheduler';  //ON表示开启，OFF表示关闭
set global event_scheduler=on;  //开启事件计划
```

2.新建计划任务

```
//新建test计划任务，立刻从2017-09-14 14:14:30开始每十秒执行一次mycall存储过程
CREATE DEFINER=`root`@`localhost` EVENT `test` ON SCHEDULE EVERY 10 SECOND STARTS '2017-09-14 14:14:30' ON COMPLETION PRESERVE ENABLE DO CALL mycall();
```

3.关闭定时任务

```
alter event test ON COMPLETION PRESERVE DISABLE;
```

4.开启定时任务

```
alter event test ON COMPLETION PRESERVE ENABLE;
```

