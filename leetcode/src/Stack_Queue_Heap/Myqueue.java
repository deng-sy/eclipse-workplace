package Stack_Queue_Heap;

import java.util.Stack;

class MyQueue {
    Stack<Integer>s1=new Stack<>();
    Stack<Integer>s2=new Stack<>();
    int front;

    public MyQueue() {

    }

    public void push(int x) {
        if(s1.isEmpty())
            front=x;
        while(!s1.isEmpty())
            s2.push(s1.pop());
        s2.push(x);
        while(!s2.isEmpty())
            s1.push(s2.pop());
    }

    public int pop() {
        int x=s1.pop();
        if(!s1.isEmpty())
            front=s1.peek();
        return x;
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}