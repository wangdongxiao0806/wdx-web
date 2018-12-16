package com.wdx.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * LinkedHashMap可以按照存入顺序保证遍历顺序
 * LinkedHashMap通过不同的构造方法可以保证遍历顺序和访问顺序一致，其中put、get、compute都算作访问
 * 使用LinkedHashMap的removeEldestEntry，可以实现自动删除非热点数据，
 */
public class LinkedHashMapTest {

    public static void main(String[] args){


        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap<String,String>();
        linkedHashMap.put("key1","value1");
        linkedHashMap.put("key2","value2");
        linkedHashMap.put("key3","value3");
        linkedHashMap.put("key4","value4");
//        linkedHashMap.forEach((k,v)->{
//            System.out.println("linkedHashMap的遍历顺序为;key:valye="+k+":"+v);
//        });


        /**
         * 设置accessOrder为true保证遍历顺序和访问顺序一直
         */
        LinkedHashMap<String,String> accessOrderedMap = new LinkedHashMap<String,String>(16,0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {

                System.out.println("当前LinkedHashMap中key的个数："+size());
                return size() >3;
            }
        };

        accessOrderedMap.put("key1","value1");
        accessOrderedMap.put("key2","value2");
        accessOrderedMap.put("key3","value3");
//        //此次遍历，返回3条数据，顺序就是key1,key2,key3
//        accessOrderedMap.forEach((k,v)->{
//            System.out.println("当前LinkedHashMap中的key：value="+v+":"+v);
//        });
//        accessOrderedMap.get("key1");
//        //此次遍历，返回3条数据，顺序就是key2,key3,key1
//        accessOrderedMap.forEach((k,v)->{
//            System.out.println("当前LinkedHashMap中的key：value="+v+":"+v);
//        });
//        accessOrderedMap.put("key4","value4");
//        //此次遍历，返回3条数据，顺序就是key3,key1,key4
//        accessOrderedMap.forEach((k,v)->{
//            System.out.println("当前LinkedHashMap中的key：value="+v+":"+v);
//        });

    }
}
