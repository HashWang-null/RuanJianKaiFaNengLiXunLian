package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MySort {
    private boolean reserve = false;

    //升序排序
    public static void sort(Integer[] array) {
        for(int i = 0; i < array.length-1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] > array[j]) {
                    int t = array[i];
                    array[i] = array[j];
                    array[j] = t;
                }
            }
        }
    }

    //当reserve参数为true时降序排序，否则升序排序
    public static void sort(Integer[] array, boolean reserve) {
        if(reserve) {
            for(int i = 0; i < array.length-1; i++) {
                for(int j = i + 1; j < array.length; j++) {
                    if(array[i] < array[j]) {
                        int t = array[i];
                        array[i] = array[j];
                        array[j] = t;
                    }
                }
            }
        }else {
            MySort.sort(array);
        }
    }

    //寻找第几大的数
    public static int findNum(Integer[] inArray, int number) {
        Integer[] array = Arrays.copyOf(inArray, inArray.length);
        for(int j = 0; j < number; j++) {
            for(int i = 1; i < array.length-j; i++) {
                if(array[i-1] > array[i]) {
                    int t = array[i-1];
                    array[i-1] = array[i];
                    array[i] = t;
                }
            }
        }
        return array[array.length-number];
    }

    //hash去重，时间复杂度应该是2n
    public static List<Integer> hashSet(List<Integer> inList) {
        if(inList == null || inList.size() == 0) {
            return inList;
        }
        int max = inList.get(0);
        for(int i = 1; i < inList.size(); i++) {
            if(inList.get(i) > max) {
                max = inList.get(i);
            }
        }
        byte[] bytes = new byte[(max>>3)+1];
        List<Integer> list = new ArrayList<Integer>();
        for (Integer integer : inList) {
            int index = integer >> 3;
            int pos = integer - (index << 3);
            if ((bytes[index] & (1 << pos)) == 0) {
                bytes[index] |= (1 << pos);
                list.add(integer);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Integer[] ints = {1,23,4,6,4,17,2,8,3,1};
        System.out.println(hashSet(Arrays.asList(ints)));
        MySort.sort(ints);
        for (Integer anInt : ints) {
            System.out.print(anInt + " ");
        }
        System.out.println();
        System.out.println(MySort.findNum(ints, 1));  //打印第二大的数
    }

//    //寻找第几大的数，早期版本
//    public static int find(Integer[] inArray, int number) {
//        Integer[] array = Arrays.copyOf(inArray, inArray.length);
//        if(number < 1 || number > array.length) {
//            throw new RuntimeException("超出数组大小");
//        }
//        if(number == 1) { // 找最大的数时的优化
//            int max = array[0];
//            for(int i = 1; i < array.length; i++) {
//                if(array[i] > max) {
//                    max = array[i];
//                }
//            }
//            return max;
//        }
//        Integer[] copyArray = Arrays.copyOf(array, array.length);
//        MySort.sort(copyArray, true);
//        return copyArray[number-1];
//    }
}
