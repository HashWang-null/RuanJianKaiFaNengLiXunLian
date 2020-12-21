package mylist;

import java.util.Iterator;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public interface List<T> {
    void add(T data);
    void remove(int index);
    void set(int index, T data);
    T get(int index);
    void print();
    int size();
    Iterator<T> iterator();
}
