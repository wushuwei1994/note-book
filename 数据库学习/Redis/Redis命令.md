## Redis命令

字符串string命令

```
set 设置存储在给定键中的值
get 获取存取在给定键中的值
del 删除存取在给定键中的值（适用于所有类型）
demo:
127.0.0.1:6379> set hello world
OK
127.0.0.1:6379> get hello
"world"
127.0.0.1:6379> del hello
(integer) 1
127.0.0.1:6379> get hello
(nil)
```

列表list命令：

```
rpush 将给定值推入列表的右端，该命令会返回列表当前的长度
lrange 获取列表在给定范围上的所有值。0 -1 取出列表所有元素
lindex 获取列表在给定位置上的单个元素（从0计数）
lpop 从列表的左端弹出一个值（即第一个值），并返回被弹出的值。被弹出的元素不再存在与列表中
demo:
127.0.0.1:6379> rpush list-key item1 item2
(integer) 2
127.0.0.1:6379> rpush list-key item2
(integer) 3
127.0.0.1:6379> del list-ket
(integer) 1
127.0.0.1:6379> lrange list-key 0 -1
1) "item1"
2) "item2"
3) "item2"
127.0.0.1:6379> lrange list-key 0 1
1) "item1"
2) "item2"
127.0.0.1:6379> lrange list-key 0 0
1) "item1"
127.0.0.1:6379> lindex list-key 0
"item1"
127.0.0.1:6379> lpop list-key
"item1"
127.0.0.1:6379> lrange list-key 0 -1
1) "item2"
2) "item2"

```

集合set命令

```
sadd 将元素添加到集合，命令返回元素添加成功数
srem 移除集合中的元素，命令返回被移除元素的数量
sismember 判断元素是否存在集合中，命令返回1表示存在，0表示不存在
smembers 获取集合中所有元素
demo:
127.0.0.1:6379> sadd set-key item0 item1 item2
(integer) 3
127.0.0.1:6379> sadd set-key item0 item4
(integer) 1
127.0.0.1:6379> smembers set-key
1) "item0"
2) "item1"
3) "item2"
4) "item4"
127.0.0.1:6379> sismember set-key item3
(integer) 0
127.0.0.1:6379> sismember set-key item4
(integer) 1
127.0.0.1:6379> srem set-key item4
(integer) 1
127.0.0.1:6379> smembers set-key
1) "item0"
2) "item1"
3) "item2"
```

散列hash命令

```
hset 在散列里面关联起给定的键值对，返回新增的键值对数量（已存在相应的键，返回0）
hget 获取指定散列的值
hgetall 获取散列包含的所有键值对
hdel 如果给定键存在于散列里面，那么移除这个键
demo:
127.0.0.1:6379> hset hash-set sub-key1 value1
(integer) 1
127.0.0.1:6379> hset hash-set sub-key2 value2
(integer) 1
127.0.0.1:6379> hset hash-set sub-key1 value1
(integer) 0
127.0.0.1:6379> hset hash-set sub-key1 subkey1value1
(integer) 0
127.0.0.1:6379> hget hash-set sub-key1
"subkey1value1"
127.0.0.1:6379> hgetall hash-set
1) "sub-key1"
2) "subkey1value1"
3) "sub-key2"
4) "value2"
127.0.0.1:6379> hdel hash-set sub-key1
(integer) 1
127.0.0.1:6379> hdel hash-set sub-key1
(integer) 0
127.0.0.1:6379> hgetall hash-set
1) "sub-key2"
2) "value2"
```

有序zset集合

```
zadd 将一个带有给定分值的成员添加到有序集合里面
zrange 根据元素在有序排列中所处的位置，从有序集合里面获取多个元素
zrangebyscore 获取有序集合在给定分值范围内的所有元素
zrem 如果给定成员存在与有序集合，那么移除这个成员
demo:
127.0.0.1:6379> zadd zset-key 728 member1
(integer) 1
127.0.0.1:6379> zadd zset-key 982 member2
(integer) 1
127.0.0.1:6379> zadd zset-key 982 member1
(integer) 0
127.0.0.1:6379> zrange zset-key 0 -1
1) "member1"
2) "member2"
127.0.0.1:6379> zrange zset-key 0 -1 withscores
1) "member1"
2) "982"
3) "member2"
4) "982"
127.0.0.1:6379> zadd zset-key 728 member1
(integer) 0
127.0.0.1:6379> zrange zset-key 0 -1 withscores
1) "member1"
2) "728"
3) "member2"
4) "982"
127.0.0.1:6379> zrangebyscore zset-key 0 800 withscores
1) "member1"
2) "728"
127.0.0.1:6379> zrem zset-key member1
(integer) 1
127.0.0.1:6379> zrange zset-key 0 -1
1) "member2"
```

