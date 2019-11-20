package com.straw.linkedlist;

/**
 * @ Author : straw
 * @ Date   : 2019/11/20 19:15
 * @ Desc   : 单链表的插入、查找、删除操作
 */
public class SingleLinkedList {

    private Node head = null;

    public Node createNode(int data) {
        return new Node(data, null);
    }

    //表头插入一个节点
    public void insertToHead(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    //表尾插入一个节点
    public void insertToTail(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    //在链表中通过值查找
    public Node findByValue(int data) {
        Node node = head;
        while (node != null && data != node.getData()) {
            node = node.next;
        }
        return node;
    }

    //通过index查找
    public Node findByIndex(int index) {
        Node node = head;
        int num = 0;
        while (node != null && num != index) {
            node = node.next;
            num++;
        }
        return node;
    }

    //在一个节点之前插入
    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        if (head == p) {
            insertToHead(newNode);
            return;
        }
        Node node = head;
        while (node != null && node.next != p) {
            node = node.next;
        }
        if (node == null) {
            return;
        }
        node.next = newNode;
        newNode.next = p;
    }

    //在一个节点之后插入
    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    //通过一个节点删除此结点
    public void deleteByNode(Node p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            head = head.next;
            return;
        }
        Node node = head;
        if (node != null && node.next != p) {
            node = node.next;
        }
        if (node == null) {
            return;
        }
        node.next = node.next.next;
    }

    //通过一个值删除此节点，第一个为此值的节点
    public void deleteByValue(int data) {
        if (head == null) {
            return;
        }
        Node node = head;
        Node p = null;
        while (node != null && node.getData() != data) {
            p = node;
            node = node.next;
        }
        if (node == null) {
            return;
        }
        if (p == null) {
            head = head.next;
        } else {
            p.next = p.next.next;
        }
    }

    //删除所有此值的节点
    public void deleteByValueAll(int data) {
        while (head != null && head.getData() == data) {
            head = head.next;
        }
        if (head == null) {
            return;
        }
        Node node = head;
        while (node.next != null) {
            if (node.next.getData() == data) {
                node.next = node.next.next;
                continue;
            }
            node = node.next;
        }
    }

    //输出链表值
    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.getData());
            if (node.next != null) {
                System.out.print("->");
            }
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.getData());
            if (node.next != null) {
                stringBuilder.append("->");
            }
            node = node.next;
        }
        return stringBuilder.toString();
    }

    public class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

    }

}
