package com.carrywei.basiclearn.lang.collection;

import java.util.*;

/**
 * Created by wushuwei on 2020/7/26.
 * 描述：
 */
public class CollectionDemo {
    public static void main(String[] args) {

        if (true) {
            System.out.println("true1");
        } else if (true) {
            System.out.println("true2");
        } else {
            System.out.println("true3");
        }

        List<String> arrayList = new ArrayList<>();

        arrayList.add("aaa");
        arrayList.add("bbb");

        arrayList.remove("aaa");

//        for (String a : arrayList) {
//            System.out.println(a);
//            arrayList.add("1111");
//        }

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("abc");

        // hashSet 可以添加一个为null的元素
        hashSet.add(null);

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("abc");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("c");
        linkedList.add("b");
        linkedList.add("a");
        linkedList.remove(); // 移除头节点
        linkedList.remove("b");
        System.out.println(linkedList);

        SortedSet<String> treeSet = new TreeSet<>();
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("c");
        for (String a : treeSet) {
            System.out.println(a);
        }
        // treeSet不能添加为null的元素，将抛出空指针异常
//        treeSet.add(null);



        // 优先队列
        Queue<String> priorityQueue = new PriorityQueue();
        priorityQueue.offer("C");
        priorityQueue.offer("B");
        priorityQueue.offer("A");
        // 结果为 ABC
        for (String s : priorityQueue) {
            System.out.println(s);
        }

        // 结果为ABC
        String e = priorityQueue.poll();
        while (e != null) {
            System.out.println(e);
            e = priorityQueue.poll();
        }

        Map<String, Object> map = new TreeMap<>();
        map.put("CC", "CStr");
        map.put("BC", "BStr");
        map.put("AC", "AStr");
        System.out.println(map); // 输出：{AC=AStr, BC=BStr, CC=CStr}

//        map = new HashMap<>();
//        map.put("BC", "CStr");
//        map.put("CC", "BStr");
//        map.put("AC", "AStr");
//        System.out.println(map); // 输出{CC=BStr, BC=CStr, AC=AStr}

        // 遍历映射的相关方法
        // keySet()
        Set mapKey = map.keySet();
//        mapKey.add("ABC"); // 运行至此行语句，会抛出 UnsupportedOperationException
        System.out.println(mapKey);

        // values()
        Collection mapValue = map.values();
        System.out.println(mapValue);

        //entrySet() 之前遍历map最高效的形式
        Set<Map.Entry<String, Object>> mapEntries = map.entrySet();
        for (Map.Entry<String, Object> entry : mapEntries) {
            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
        }

        // jdk1.8，新增遍历方法
        map.forEach((key, value) ->{
            System.out.println("key = " + key + ", value = " + value);
        });

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("abc", "hello");
        hashMap.remove("abc");
    }
}
