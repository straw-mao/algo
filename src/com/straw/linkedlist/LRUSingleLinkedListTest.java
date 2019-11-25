package com.straw.linkedlist;

/**
 * @ Author : straw
 * @ Date   : 2019/11/25 19:52
 * @ Desc   : 测试基于单链表实现的LRU淘汰算法
 */
public class LRUSingleLinkedListTest {

    public static void main(String[] args) {
        LRUSingleLinkedList<Integer> lru = new LRUSingleLinkedList<>();
        lru.print();
        lru.add(1);
        lru.add(2);
        lru.add(3);
        lru.add(4);
        lru.add(5);
        lru.add(6);
        lru.add(7);
        lru.add(8);
        lru.add(9);
        lru.add(10);
        lru.print();
        lru.add(1);
        lru.print();
        lru.add(3);
        lru.add(3);
        lru.print();

    }
}
