package mylist;

import java.util.Iterator;

/**
 * @姓名 王瀚霆
 * @学号 2019302841
 * @描述
 */
public class Test {


    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>();
        for(int i = 22; i < 33; i++) {
           list.add(i);
        }
        list.print();

        for(int i: list) {
            System.out.println(i);
        }

        System.out.println("++++");
        Iterator<Integer> itr = list.iterator();
        while(itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
