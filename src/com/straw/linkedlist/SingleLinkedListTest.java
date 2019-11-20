package com.straw.linkedlist;

/**
 * @ Author : straw
 * @ Date   : 2019/11/20 22:10
 * @ Desc   : 测试单链表的操作
 */
public class SingleLinkedListTest {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertToTail(singleLinkedList.createNode(5));
        singleLinkedList.insertToHead(singleLinkedList.createNode(3));
        singleLinkedList.print();
        System.out.println(singleLinkedList.findByValue(3).getData());
        System.out.println(singleLinkedList.findByIndex(0).getData());
        singleLinkedList.insertBefore(singleLinkedList.findByIndex(0), singleLinkedList.createNode(1));
        singleLinkedList.insertBefore(singleLinkedList.findByIndex(1), singleLinkedList.createNode(2));
        singleLinkedList.insertBefore(singleLinkedList.findByIndex(3), singleLinkedList.createNode(4));
        singleLinkedList.insertBefore(singleLinkedList.findByIndex(7), singleLinkedList.createNode(4));
        singleLinkedList.print();
        singleLinkedList.insertAfter(singleLinkedList.findByIndex(0), singleLinkedList.createNode(4));
        singleLinkedList.insertAfter(singleLinkedList.findByValue(5), singleLinkedList.createNode(4));
        singleLinkedList.insertAfter(singleLinkedList.findByIndex(1), singleLinkedList.createNode(9));
        singleLinkedList.print();
        singleLinkedList.deleteByValue(2);
        System.out.println("删除1: " + singleLinkedList);
        singleLinkedList.deleteByValueAll(4);
        System.out.println("删除2: " + singleLinkedList);
        singleLinkedList.deleteByNode(singleLinkedList.findByIndex(0));
        singleLinkedList.deleteByNode(singleLinkedList.findByIndex(0));
        singleLinkedList.deleteByNode(singleLinkedList.findByIndex(0));
        singleLinkedList.deleteByValue(3);
        System.out.println("删除3: " + singleLinkedList);
        singleLinkedList.insertToTail(singleLinkedList.createNode(5));
        singleLinkedList.insertToTail(singleLinkedList.createNode(5));
        singleLinkedList.insertToTail(singleLinkedList.createNode(6));
        singleLinkedList.insertToTail(singleLinkedList.createNode(5));
        singleLinkedList.insertToTail(singleLinkedList.createNode(6));
        System.out.println(singleLinkedList);
        singleLinkedList.deleteByValueAll(5);
        System.out.println("删除4: " + singleLinkedList);
    }
}
