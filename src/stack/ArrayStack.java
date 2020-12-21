package stack;

import java.util.Arrays;

//数组栈
public class ArrayStack<T> {

    private final int initLength;  //初始数组大小
    private Object[] elements;     //数组
    private int amount;            //元素数量
    private int size;              //数组大小

    //默认初始数组大小为10
    public ArrayStack() {
        this.initLength = 10;
        this.elements = new Object[initLength];
        this.size = initLength;
//        amount = 0;
    }

    //指定初始数组大小
    public ArrayStack(int initLength) {
        this.initLength = initLength;
        this.elements = new Object[initLength];
        this.size = initLength;
//        amount = 0;
    }

    public void push(T element) {
        amount ++;
        if(amount >= size) {
            size += initLength;
            elements = Arrays.copyOf(elements, size);
            elements[amount-1] = element;
        }else {
            elements[amount-1] = element;
        }
    }

    public T pop() {
        T element = (T)elements[amount-1];
        elements[amount-1] = null; // 可以不写，为了释放空间
        amount --;
        if(amount <= size-initLength) {
            size -= initLength;
            elements = Arrays.copyOf(elements, size);
        }
        return element;
    }

    //打印栈 顺序为栈底到栈顶
    public void print() {
        for(int i = 0; i < amount; i++) {
            System.out.print(elements[i] + " ");
        }
        System.out.println();
    }

    //检查函数，打印整个数组和元素数量和数组大小
    public void check() {
        System.out.println("amouont: " + amount + "  size: " + size);
        String result = "";
        for(int i = 0; i < size; i++) {
            result = result + elements[i] + " ";
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        ArrayStack<String> stack = new ArrayStack<>(5);
        stack.push("a1");
        stack.push("a2");
        stack.push("a3");
        stack.push("a4");
        stack.push("a5");
        stack.push("a6");
        stack.print();
        System.out.println(stack.pop());
        stack.check();
        stack.push("b1");
        stack.push("b2");
        stack.print();
    }
}
