package com.straw.array;

/**
 * @ Author : straw
 * @ Date   : 2019/11/19 22:18
 * @ Desc   : 封装数组Array对象，实现插入、修改、删除数据，动态扩容
 */
public class Array<T> {

    private T[] data;
    //数组实际长度
    private int size = 0;

    //构造函数，根据传入传入大小构造数组
    public Array(int size) {
        data = (T[]) new Object[size];
    }

    //默认数组长度为10
    public Array() {
        this(10);
    }

    //获取数组长度
    public int getLenth() {
        return data.length;
    }

    //获取数组实际长度
    public int getSize() {
        return size;
    }

    //判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在index插入元素e
    public void add(int index, T e) {
        checkIndexForAdd(index);
        //自动扩容，如果长度不够则自动扩容为原长度的2倍
        if (size == data.length) {
            reLength(data.length * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //像数组头插入数据
    public void addFirst(T e) {
        add(0, e);
    }

    //像数组尾部添加数据
    public void addLast(T e) {
        add(size, e);
    }

    //获取index处的值
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    //修改index的值
    public void set(int index, T e) {
        checkIndex(index);
        data[index] = e;
    }

    //删除index位置的元素
    public T delete(int index) {
        checkIndex(index);
        T re = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        //缩容，当删除元素后长度过长，就进行缩容
        if (size == data.length / 4 && data.length / 2 != 0) {
            reLength(data.length / 2);
        }

        return re;
    }

    //删除第一个元素
    public T deleteFirst() {
        return delete(0);
    }

    //删除最后一个元素
    public T deleteLast() {
        return delete(size - 1);
    }

    //从数组中删除指定元素
    public void deleteElement(T e) {
        int index = findIndex(e);
        if (index != -1) {
            delete(index);
        }
    }

    //查看数组是否包含元素e
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    //获取对应元素的下标 未找到返回-1
    public int findIndex(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    //检查index是否在实际长度之间
    public void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    //检查index是否能保证像数组中添加数据的要求
    public void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
    }

    //扩容/缩容长度
    public void  reLength(int length) {
        T[] newArray = (T[]) new Object[length];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Array size = %d, length = %d \n", size, data.length));
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(data[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }
        builder.append(']');
        return builder.toString();
    }
}
