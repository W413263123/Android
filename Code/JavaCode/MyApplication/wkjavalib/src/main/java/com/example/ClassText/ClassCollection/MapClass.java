package com.example.ClassText.Collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;

/**
 * Created by wenkui on 16/9/14.
 */
public class MapClass {
    public static void main(String[] args) {
        /** 创建Map集合对象 */
        Map<String , String> map = new HashMap<String, String>();
        map.put("1", "Apple");
        map.put("2", "Origin");
        map.put("3", "Banana");
        map.put("4", "Tomato");
        map.put("5", "PineApple");
        map.put("6", "Peach");
        map.put("7", "Lemon");
        map.put("8", "Litchi");
        map.put("9", "Mango");

        /** 获取所有的key */
        Set<String> set = map.keySet();
        List<String> list = (List<String>) map.values();

        Iterator<String> it = set.iterator();
        System.out.println("输出Map的所有的Key:");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        Iterator<String> it1 = list.iterator();
        System.out.println("输出Map的所有的Value:");
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println();
    }
}
