package linklist;

//import mylist.List;

import dictionary.Map;

import java.util.Iterator;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class LinkedList<T> implements List<T>, Iterable<T> {
    private Node head;
    private Node tail;
    private int size;

    //构造器 【双链表】
    public LinkedList() {
        head = new Node(null);
        tail = head;
        size = 0;
    }

    //添加新节点
    @Override
    public void add(T data) {
        Node newNode = new Node(data);
        tail.next = newNode;
        newNode.past = tail;
        tail = newNode;
        size ++;
    }

    //删除指定位置的节点值
    @Override
    public void delete(int index) {
        if(index < 0 || index >= size) {
            throw new RuntimeException("超出限制");
        }
        int i = 0;
        Node node = head.next;
        while (node != null) {
            if (i == index) {
                node.past.next = node.next;
                if (node.next != null) {
                    node.next.past = node.past;
                }else {
                    tail = node.past;
                }
                size --;
                return;
            }
            node = node.next;
            i++;
        }
    }

    //设置指定位置的节点值
    @Override
    public void set(int index, T data) {
        if(index < 0 || index >= size) {
            throw new RuntimeException("超出限制");
        }
        int i = 0;
        Node node = head.next;
        while(node != null) {
            if(i == index) {
                node.data = data;
            }
            node = node.next;
            i ++;
        }
    }

    //打印
    @Override
    public void print() {
        Node node = head.next;
        while(node != null) {
            System.out.print(node.data.toString() + " ");
            node = node.next;
        }
        System.out.println();
    }

    //返回大小
    @Override
    public int size() {
        return size;
    }

    //判断是否为空
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new RuntimeException("超出限制");
        }
        int i = 0;
        Node node = head.next;
        while(node != null) {
            if(i == index) {
                return node.data;
            }
            node = node.next;
            i ++;
        }
        throw new RuntimeException("未知错误！");
    }

    @Override
    public boolean isExist(T data) {
        Node node = head.next;
        while(node != null) {
            if(node.data == data) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //闲的，为了能用for-each弄的
    @Override
    public Iterator<T> iterator() {
        class Itr implements Iterator<T> {
            Node node = head;
            @Override
            public boolean hasNext() {
                return node.next != null;
            }

            @Override
            public T next() {
                node = node.next;
                return node.data;
            }
        }
        return new Itr();
    }

    //闲的，删掉【所有】含有指定数据的节点
    public void remove(T data) {
        Node node = head.next;
        while(node != null) {
            if(node.data == data) {
                node.past.next = node.next;
                if(node.next != null) {
                    node.next.past = node.past;
                }else {
                    tail = node.past;
                }
                size --;
            }
            node = node.next;
        }
    }

    private class Node {
        T data;
        Node next;
        Node past;
        Node(T data) {
            this.data = data;
            this.next = null;
            this.past = null;
        }
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        System.out.println(list.isEmpty());
        list.add("H");
        list.add("b");
        list.add("e");
        list.add("l");
        list.add("l");
        list.add("b");
        list.add("o");
        list.add("b");
        list.add("!");
        list.add("b");
        list.delete(1);
        list.remove("b");
        list.print();
        System.out.println(list.size);
        System.out.println(list.isExist("H"));
        System.out.println(list.isExist("h"));
    }
}
