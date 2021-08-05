## JVM常用参数

> 用法: 
>
> java [-options] class [args...] (执行类)
>    或  java [-options] -jar jarfile [args...] (执行 jar 文件)
>
> 示例：
>
> java -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError com/carrywei/understanding/jvm/outofmemory/HeapOOM arag1 arg2

1. -Xms20m  最小堆内存20Mb
2. -Xmx20m 最大堆内存20Mb
3. -XX:+HeapDumpOnOutOfMemoryError 出现oom时生成HeapDump文件