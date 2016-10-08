package com.example.ClassText.Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wenkui on 16/9/14.
 */
public class ListClass {

    public static void main(String[] args) {

        /** 创建数组元素 */
        String a = "A", b = "B", c = "C", d = "D", e = "E", a1 = "1", a2 = "2", a3 = "3";
        /** 创建LinkedList */
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
        System.out.println("LinkedList数组中的元素是:");
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println("");

        System.out.println("字母A第一次出现的位置是:" + linkedList.indexOf(a));
        System.out.println("字母A最后一次出现的位置是:" + linkedList.lastIndexOf(a));

        /** 创建ArrayList */
        List<String> arrayList = new ArrayList<String>();
        /** 添加元素 */
        arrayList.add(a);
        arrayList.add(a1);
        arrayList.add(a);
        arrayList.add(a2);
        arrayList.add(a3);
        arrayList.add(a);
        arrayList.add(b);
        arrayList.add(c);
        arrayList.add(a);
        arrayList.add(d);
        arrayList.add(e);
        arrayList.add(a);

        /** 创建数组迭代器 */
        Iterator<String> it1 = arrayList.iterator();
        System.out.println("ArrayList数组中的元素是:");
        while (it1.hasNext()) {
            System.out.print(it1.next() + " ");
        }

        System.out.println("字母A第一次出现的位置是:" + arrayList.indexOf(a));
        System.out.println("字母A最后一次出现的位置是:" + arrayList.lastIndexOf(a));

        /** 获取列表中的子列表 */
        List<String> array = arrayList.subList(1, 6);

    }

}
