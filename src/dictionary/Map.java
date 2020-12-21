package dictionary;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public interface Map<K, V> {
    void put(K key, V value);
    V get(K key);
    int size();
}
