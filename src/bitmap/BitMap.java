package bitmap;

import java.util.Random;
import java.util.StringTokenizer;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class BitMap {

    private byte[] bits;
    private final int MAX_BIT_LEN = 7;
    private final int MB = 10;
    private final int MAX_VALUE = MAX_BIT_LEN * MB;

    public BitMap() {
        bits = new byte[MB];
    }

    public void add(int n) {
        if(n >= MAX_VALUE) {
            throw new RuntimeException("超出范围");
        }
        int index = n / MAX_BIT_LEN;
        int pos = n % 7;
        int offset = (1 << pos);
        bits[index] |= offset;
    }

    public boolean contains(int n) {
        if(n >= MAX_VALUE) {
            throw new RuntimeException("超出范围");
        }
        int index = n / MAX_BIT_LEN;
        int pos = n % MAX_BIT_LEN;
        int offset = (1 << pos);
        return (bits[index] & offset) != 0;
    }

    public void clear(int n) {
        if(n >= MAX_VALUE) {
            throw new RuntimeException("超出范围");
        }
        int index = n / MAX_BIT_LEN;
        int pos = n % MAX_BIT_LEN;
        bits[index] &= (~(1<<pos));
    }

    public void show() {
        for(int i = 0; i < bits.length; i++) {
            System.out.println(i + ">> " + Integer.toBinaryString(bits[i]));
        }
    }

    public static void main(String[] args) {
        BitMap map = new BitMap();
        map.add(4);
        map.add(6);
        map.add(7);
        map.add(10);
        map.add(13);
        map.add(14);
        map.add(15);
        map.add(69);

        map.show();

    }
}
