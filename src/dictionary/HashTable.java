//package dictionary;
//
//
//import java.util.Objects;
//
///**
// * @姓名 王瀚霆
// * @学号 2019302841
// * @描述
// */
//public class HashTable<K, V> implements Map<K, V> {
//    private Object[] bukkets = new Object[11];
//    private int size;
//
//    @Override
//    public void put(K key, V value) {
//        Node<K, V> newNode = new Node<>();
//        Entry<K, V> e = new Entry<K, V>(key, value);
//        newNode.data = e;
//        int index = key.hashCode() % bukkets.length;
//
//        //0.75扩容
//
//        if(bukkets[index] == null) {
//            bukkets[index] = newNode;
//        }else {
//            Node tmp = (Node) bukkets[index];
//            while(tmp.next != null) {
//                tmp = tmp.next;
//            }
//            tmp.next = newNode;
//        }
//    }
//
//    @Override
//    public V get(K key) {
//        return null;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    class Entry<K, V> {
//        K key;
//        V value;
//        public Entry(K key, V value) {
//            this.key = key;
//            this.value = value;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            Entry<?, ?> entry = (Entry<?, ?>) o;
//            return Objects.equals(key, entry.key) &&
//                    Objects.equals(value, entry.value);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(key, value);
//        }
//    }
//
//    class Node<K, V> {
//        Entry<K, V> data;
//        Node<K, V> next;
//    }
//}
