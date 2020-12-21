package linklist;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public interface List<T> {

    void add(T data);
    void delete(int index);
    void set(int index, T data);
    void print();
    int size();
    boolean isEmpty();
    T get(int index);
    boolean isExist(T data);
}
