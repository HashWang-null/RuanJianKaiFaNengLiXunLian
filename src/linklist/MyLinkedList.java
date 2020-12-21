package linklist;

import mylist.List;

import java.util.Iterator;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class MyLinkedList<T> implements List<T>, Iterable<T>{

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        this.head = new Node(null);
        this.tail = this.head;
        this.size = 0;
    }

    @Override
    public void add(T data) {
        Node newNode = new Node(data);
        tail.setNext(newNode);
        newNode.setPast(tail);
        tail = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index > size) {
            throw new RuntimeException("超出范围");
        }
        Node node = head.getNext();
        int i = 0;
        while(node != null) {
            if(i == index) {
                node.getPast().setNext(node.getNext());
                node.getNext().setPast(node.getPast());
                size --;
            }
            node = node.getNext();
            i++;
        }
    }

    public void remove(Object data) {
        Node node = head.getNext();
        while(node != null) {
            if(node.getData().equals(data)) {
                node.getPast().setNext(node.getNext());
                node.getNext().setPast(node.getPast());
                size --;
            }
            node = node.getNext();
        }
    }

    @Override
    public void set(int index, T data) {
        Node node = head.getNext();
        int i = 0;
        while(node != null) {
            if(i == index) {
                node.data = data;
            }
            node = node.getNext();
            i++;
        }
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size) {
            throw new RuntimeException("超出范围");
        }
        Node node = head.getNext();
        int i = 0;
        while(node != null) {
            if(i == index) {
                return (T)node.getData();
            }
            node = node.getNext();
            i++;
        }
        throw new RuntimeException("淦！");
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        Node node = head.getNext();
        while(node.getNext() != null) {
            System.out.println(sb.toString() + node.getData());
            sb.append("  ");
            System.out.println(sb.toString() + "\\");
            node = node.next;
        }
        System.out.println(sb.toString() + node.getData());
//        System.out.println();
    }

    public void display() {
        Node node = head.getNext();
        while(node != null) {
            System.out.print(node.getData() + " ");
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<T> iterator() {
        class Itr implements Iterator<T> {
            Node node;
            private Itr() {
                node = MyLinkedList.this.head;
            }
            @Override
            public boolean hasNext() {
                return node.getNext() != null;
            }

            @Override
            public T next() {
                node = node.getNext();
                return (T) node.getData();
            }
        }
        return new Itr();
    }

    private class Node {
        Object data;
        Node past;
        Node next;

        Node(Object data) {
            this.data = data;
            this.past = null;
            this.next = null;
        }

        Node getNext() {
            return next;
        }

        Node getPast() {
            return past;
        }

        Object getData() {
            return data;
        }

        void setNext(Node next) {
            this.next = next;
        }

        void setPast(Node past) {
            this.past = past;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(4);
        list.add(7);
        list.add(34);
        list.add(23);
        list.add(45);
        list.add(3); //
        list.add(2);
        list.add(6);

        Iterator itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}
