package dictionary;


import java.util.Arrays;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class MyHashTable<K,V> implements Map<K,V> {

    private final int initArrayLength;
    private int arrayLength;
    private int multiple;
    private int amount;
    private Node[] mapData;

    MyHashTable() {
        this.initArrayLength = 11;
        this.arrayLength = initArrayLength;
        this.multiple = 1;
        this.mapData = new Node[arrayLength];
        this.amount = 0;
    }

    MyHashTable(int initArrayLength) {
        this.initArrayLength = initArrayLength;
        this.arrayLength = initArrayLength;
        this.multiple = 1;
        this.mapData = new Node[arrayLength];
        this.amount = 0;
    }

    @Override
    public void put(K key, V value) {
        //判断是否有同样的key存在
        int pos = key.hashCode() % initArrayLength;
        for(int i = 0; i < multiple; i++) {
            int index = i * initArrayLength + pos;
            Node node = mapData[index];
            while(node != null) {
                if(node.data.key.equals(key)) {
                    throw new RuntimeException("重复！");
                }
                node = node.next;
            }
        }
        //增加节点
        amount ++;
        Node newNode = new Node<>();
        newNode.data = new Entry(key, value);
        int index = (multiple - 1) * initArrayLength + pos;
        if(mapData[index] == null) {
            mapData[index] = newNode;
        }else {
            Node node = mapData[index];
            while(node.next != null) {
                node = node.next;
            }
            node.next = newNode;
        }
        //增容

        if(amount > ((arrayLength >> 2) + (arrayLength >> 1))) {
            arrayLength = arrayLength << 1;
            multiple ++;
            mapData = Arrays.copyOf(mapData, arrayLength);
        }
    }

    @Override
    public V get(K key) {
        int pos = key.hashCode() % initArrayLength;
        for(int i = 0; i < multiple-1; i++) {
        Node node;
        node = mapData[pos];
        while(node != null) {
            if(node.data.key.equals(key)) {
                return (V)node.data.value;
            }
            node = node.next;
        }
        int index = (initArrayLength << i) + pos;
            node = mapData[index];
            while(node != null) {
                if(node.data.key.equals(key)) {
                    return (V)node.data.value;
                }
                node = node.next;
            }
        }
        throw new RuntimeException("没找到");
    }

    @Override
    public int size() {
        return amount;
    }

    //检查
    public void check() {
        for(int i = 0; i < arrayLength; i++) {
            if(mapData[i] == null) {
                System.out.println("index: " + i + " is Null");
            }else {
                Node node = mapData[i];
                System.out.print("index: " + i + " data:      ");
                while(node != null) {
                    System.out.print(node.data.value + " ");
                    node = node.next;
                }
                System.out.println();
            }
        }
        System.out.println("数量： " + amount);
    }

    private class Node<K,V> {
        Entry<K,V> data;
        Node<K,V> next;
    }

    private class Entry<K,V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashTable<Integer,String> map= new MyHashTable<>();
        map.put(1, "a");
        map.put(2, "b");
        map.put(15, "i");
        map.put(16, "j");
        map.put(17, "k");
        map.put(18, "l");
        map.put(19, "m");
        map.put(5, "c");
        map.put(4, "d");
        map.put(7, "e");
        map.put(8, "f");
        map.put(11, "g");
        map.put(119, "Hello world!");
        map.check();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        /////////////////////////////////////////////
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(15));
        System.out.println(map.get(16));
        System.out.println(map.get(17));
        System.out.println(map.get(18));
        System.out.println(map.get(19));
        System.out.println(map.get(5));
        System.out.println(map.get(4));
        System.out.println(map.get(7));
        System.out.println(map.get(8));
        System.out.println(map.get(11));

        System.out.println(map.get(119));

    }
}
