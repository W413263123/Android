package com.example.ClassText.Collection;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by wenkui on 16/9/14.
 */
public class SetClass {
    public static void main(String[] args) {
        /** 创建List集合元素 */
        String a = "A", b = "B", c = "C", d = "D", e = "E", a1 = "1", a2 = "2", a3 = "3";
        /** 创建LinkedList集合对象 */
        List<String> linkedList = new LinkedList<String>();
        /** 添加元素 */
        linkedList.add(a);
        linkedList.add(b);
        linkedList.add(c);
        linkedList.add(a);
        linkedList.add(d);
        linkedList.add(e);
        linkedList.add(a);
        linkedList.add(a1);
        linkedList.add(a);
        linkedList.add(a2);
        linkedList.add(a);
        linkedList.add(a3);

        /** 创建数组迭代器 */
        Iterator<String> it = linkedList.iterator();
        System.out.println("去重之前的LinkedList数组中的元素是:");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");

        /** 创建Set集合对象 */
        Set<String> setClass = new LinkedHashSet<String>();
        /** 将list中的元素去重 */
        setClass.addAll(linkedList);
        Iterator<String> it1 = setClass.iterator();

        System.out.println("去重之后的LinkedList数组中的元素是:");
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }
        System.out.println("");
    }
}
