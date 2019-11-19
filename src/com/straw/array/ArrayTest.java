package com.straw.array;

/**
 * @ Author : straw
 * @ Date   : 2019/11/19 23:14
 * @ Desc   : 测试数组操作
 */
public class ArrayTest {

    public static void main(String[] args) {

        Array<String> array = new Array<>(2);
        System.out.println(array.isEmpty());
        array.addFirst("哈哈");
        array.addLast("拉拉");
        array.addLast("aa");
        array.add(3, "bb");
        System.out.println(array.isEmpty());
        System.out.println(array.getSize());
        System.out.println(array.getLenth());
        System.out.println(array.get(2));
        System.out.println(array);
        array.set(3, "cc");
        System.out.println(array);
        array.delete(0);
        array.deleteLast();
        array.deleteFirst();
        System.out.println(array);
        System.out.println(array.findIndex("aa"));
        System.out.println(array.contains("aa"));
        array.deleteElement("aa");
        System.out.println(array);
    }
}
