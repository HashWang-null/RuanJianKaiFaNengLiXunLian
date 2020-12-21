package mylist;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class MyList<T> implements List<T>, Iterable<T> {

    private static final int DEFAULT_SIZE = 10;
    private static final int MAX_SIZE = Integer.MAX_VALUE - 8;
    private static final Object[] InitElement = {};
    private int size = 0;
    private int account = 0;
    private Object[] elements;

    public MyList() {
        elements = InitElement;
    }

    @Override
    public void add(T data) {
        if(size == 0) {
            size = DEFAULT_SIZE;
            elements = new Object[size];
            elements[account++] = data;
        }else if(account == size) {
            size = size + DEFAULT_SIZE;
            if(size > MAX_SIZE) {
                System.err.println("超出最大限制!");
                System.exit(-1);
            }
            elements = Arrays.copyOf(elements, size);
            elements[account++] = data;
        }else {
            elements[account++] = data;
        }
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= account) {
            System.err.println("索引超出限制! account = " + account + "  index = " + index);
            System.exit(-1);
        }
        Object[] new_elements;
        if(account == size - 9) {
            new_elements = Arrays.copyOf(elements, size - DEFAULT_SIZE);
        }else {
            new_elements = Arrays.copyOf(elements, size);
        }
        for(int i = 0; i < index; i++) {
            new_elements[i] = elements[i];
        }
        for(int i = index+1; i < account; i++) {
            new_elements[i-1] = elements[i];
        }
        account--;
        elements = new_elements;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int index) {
        if(index < 0 || index >= account) {
            System.err.println("索引超出限制! account = " + account + "  index = " + index);
            System.exit(-1);
        }
        return (T)elements[index];
    }

    @Override
    public void print() {
        for(int i = 0; i < account; i++) {
            System.out.print(elements[i].toString() + " ");
        }
        System.out.println();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        class Itr implements Iterator<T>{
            private int cursor;

            @Override
            public boolean hasNext() {
                return cursor < account;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                return (T) elements[cursor++];
            }
        }
        return new Itr();
    }

    @Override
    public void set(int index, T data) {
        if(index < 0 || index >= account) {
            System.err.println("索引超出限制! account = " + account + "  index = " + index);
            System.exit(-1);
        }
        elements[index] = data;
    }

    public String toString() {
        String result = "";
        for(int i = 0; i < account; i++) {
            result = result.concat(elements[i].toString() + " ") ;
        }
        return result.concat("\n");
    }
}