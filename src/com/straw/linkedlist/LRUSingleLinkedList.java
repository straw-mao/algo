package com.straw.linkedlist;

/**
 * @ Author : straw
 * @ Date   : 2019/11/23 17:48
 * @ Desc   : 基于链表实现LRU(最近最少使用)淘汰算法
 */
public class LRUSingleLinkedList<T> {

    private Node<T> head;

    /**
     *默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     *链表容量
     */
    private Integer capacity;

    /**
     *链表长度
     */
    private Integer length;

    public LRUSingleLinkedList() {
        this.head = null;
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUSingleLinkedList(Integer capacity) {
        this.head = null;
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * 1. 当数据在表中不存在，缓存没满，则直接插入到链表头
     * 2. 当数据在表中不存在，缓存满了，则删除尾节点再插入到链表头
     * 3. 当数据再表在存在，删除原来的这个节点，再将数据插入到链表头
     * @param data
     */
    public void add(T data) {
        Node node = findNodeByData(data);
        //如果表中不存在此数据
        if (node == null) {
            //缓存没满
            if (length < capacity) {
                insertHead(data);
            } else {
                deleteByEnd();
                insertHead(data);
            }
        } else {
            deleteNode(node);
            insertHead(data);
        }
    }

    //删除一个节点
    public void deleteNode(Node node) {
        if (node == null) {
            return;
        }
        if (node == head) {
            head = head.next;
            length--;
            return;
        }
        Node p = head;
        while (p != null && p.next != node) {
            p = p.next;
        }
        if (p == null) {
            return;
        }
        p.next = p.next.next;
        length--;
    }

    //删除尾节点
    public void deleteByEnd() {
        Node node = head;
        Node temp = null;
        if (head == null) {
            return;
        }
        while (node.next != null) {
            temp = node;
            node = node.next;
        }
        if (temp == null) {
            head = null;
            length--;
            return;
        }
         temp.next = null;
        length--;
    }

    //在链表头插入一个节点
    public void insertHead(T data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        length++;
    }

    //查找链表中是否存在值为data的节点
    public Node findNodeByData(T data) {
        Node node = head;
        while (node != null && !data.equals(node.getData())) {
            node = node.next;
        }
        return node;
    }

    public class Node<T> {

        private T data;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        public T getData() {
            return this.data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void print() {
        System.out.println("链表容量: " + capacity);
        System.out.println("链表长度: " + length);
        Node node = head;
        while (node != null) {
            System.out.print(node.data);
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }
}
