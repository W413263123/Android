package com.example.ClassText.Collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wenkui on 16/9/18.
 */
public class ListText {

    public static void main(String []args) {
//        TextOne();
//        TextTwo();
        TextThree();
    }

    /** 往集合中添加元素 */
    public static void TextOne() {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i < 101; i++) {
            /** 往集合中添加元素 */
            list.add(i);
        }
        Iterator<Integer> interator = list.iterator();
        while (interator.hasNext()) {
            System.out.print(interator.next());
        }
        System.out.println(" ");
        /** 移除内容 */
        list.remove(10);
        Iterator<Integer> interator1 = list.iterator();
        while (interator1.hasNext()) {
            System.out.print(interator1.next());
        }
        System.out.println(" ");
    }

    /** 测试set集合的去重性 */
    public static void TextTwo(){
        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet<String>();

        String[] array = {"A", "a", "c", "C", "a", "c"};

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
            set.add(array[i]);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println(" ");

        Iterator<String> iterator1 = set.iterator();
        while(iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println(" ");

    }

    /** 集合字典练习 */
    public static void TextThree() {
        class Person {
            Integer id;
            String name;
            public Person (Integer id, String name) {
                this.id = id;
                this.name = name;
            }
        }

        String[] nameArray = {"Jack", "Tom", "Jimmy", "Jim", "Ross", "Tommose"};

        /** 创建一个字典集合 */
        Map<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < nameArray.length; i++) {
            map.put(i+1, nameArray[i]);
        }
        /** 获取Map中的所有键值 */
        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(map.get(iterator.next()));
        }

        /** 根据KMap中的键值移除 */
        map.remove(5);

        Set<Integer> set2 = map.keySet();
        Iterator<Integer> iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            System.out.println(map.get(iterator2.next()));
        }

    }


}
