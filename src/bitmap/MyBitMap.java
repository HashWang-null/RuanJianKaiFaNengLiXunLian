package bitmap;

import javax.net.ssl.SSLContext;
import java.util.ArrayList;
import java.util.Vector;
import java.util.zip.Adler32;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述 重新实现BitMap
 */

public class MyBitMap {
    private byte[] bytes;
    private final int MAX_VALUE;
    private final int MAX_LENGTH; //bytes的长度

    //无参构造器 默认的存储数据最大值范围为Integer的最大值
    public MyBitMap() {
        this.MAX_LENGTH = Integer.MAX_VALUE/8+1;
        this.MAX_VALUE = Integer.MAX_VALUE;
        this.bytes = new byte[MAX_LENGTH];
    }

    //含参构造器 输入的值为存储数据最大值 【实际上能存储的范围要大，但添加时不允许添加超出设定的范围】
    public MyBitMap(int max_value) {
        this.MAX_LENGTH = max_value/8+1;
        this.MAX_VALUE = max_value;
        this.bytes = new byte[MAX_LENGTH];
    }

    //添加数据
    public void add(int n) {
        if(n >= MAX_VALUE || n < 0) {
            throw new RuntimeException("超出限制 " + toString() );
        }
        int index = n / 8;
        int pos = n % 8;
        if((bytes[index] & (1<<pos)) != 0) {
            throw new RuntimeException("重复存储 " + n);
        }
        bytes[index] |= (1<<pos);
    }

    //打印每个Byte各个位的值
    public void show() {
        for(int i = 0; i < MAX_LENGTH; i++) {
            System.out.print(i + " >> ");
            showNumBerBinary(bytes[i]);
        }
    }

    //获取范围
    public String toString() {
        return "存储范围：0-"+(MAX_VALUE - 1);
    }

    //删除指定数据
    public void remove(int n) {
        if(n >= MAX_VALUE || n < 0) {
            throw new RuntimeException("超出限制 " + toString() );
        }
        int index = n / 8;
        int pos = n % 8;
        bytes[index] &= (~(1<<pos));
    }

    //清空整个Bitmap
    public void clear() {
        for(int i = 0; i < MAX_LENGTH; i++) {
            bytes[i] = 0;
        }
    }

    //获取存储的所有数
    public Vector<Integer> getNumbers() {
        Vector<Integer> vector = new Vector<>();
        for(int i = 0; i < MAX_LENGTH; i++) {
            if(bytes[i] != 0) {
                for(int j = 0; j < 8; j++) {
                    if(((bytes[i]>>j)&1) == 1) {
                        vector.add(i*8 + j);
                    }
                }
            }
        }

        return vector;
    }

    //判断数据是否已经被存储
    public boolean isContain(int n) {
        int index = n / 8;
        int pos = n % 8;
        return ((bytes[index]>>pos)&1) == 1;
    }

    //打印byte的每一位信息，贼卡
    private static void showNumBerBinary(byte b) {
        for(int i = 7; i > -1; i--) {
            System.out.print(Integer.toBinaryString((b>>i)&1)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyBitMap myBitMap = new MyBitMap(100);
        System.out.println(myBitMap);
        myBitMap.add(4);
        myBitMap.add(14);
//        System.out.println(myBitMap.getNumbers());
//        myBitMap.clear();
        System.out.println(myBitMap.getNumbers());
        myBitMap.show();
    }
}
