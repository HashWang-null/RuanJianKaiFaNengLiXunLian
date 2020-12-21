package stack;

//链表栈
public class LinkedListStack<T> {
    Node tail;
    Node head;

    LinkedListStack() {
        tail = new Node(null,null);
        head = tail;
    }
    public void push(T data) {
        tail = new Node(data, tail);
    }
    public T pop() {
        if(tail == head) {
            throw new RuntimeException("Null");
        }
        T t = tail.data;
        tail = tail.past;
        return t;
    }

    //打印栈，顺序：栈顶到栈底（反的)
    public void print() {
        Node node = tail;
        while(node != head) {
            System.out.println(node.data.toString());
            node = node.past;
        }
    }
    private class Node {
        T data;
        Node past;
        Node(T data, Node past) {
            this.data = data;
            this.past = past;
        }
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(8);
        stack.push(6);
        stack.push(4);
        stack.push(2);
        stack.print();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(4);
        stack.pop();
        stack.print();
    }
}
