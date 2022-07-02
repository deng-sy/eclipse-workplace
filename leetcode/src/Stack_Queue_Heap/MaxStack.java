package Stack_Queue_Heap;
import java.util.*;

class MaxStack {
    Stack<Integer>stack;
    Stack<Integer>maxStack;
    public MaxStack(){
        stack=new Stack<>();
        maxStack=new Stack<>();
    }
    public void push(int x){

        if(maxStack.isEmpty()||maxStack.peek()<x)
            maxStack.push(x);
        stack.push(x);
    }
    public int pop(){
        int x=stack.pop();
        if(!maxStack.isEmpty()&&x==maxStack.peek())
            maxStack.pop();
        return x;
    }
    public int top(){
        return stack.peek();
    }
    public int peekMax(){
        return maxStack.peek();
    }
    public int popMax(){
        int max=peekMax();
        Stack<Integer>tmp=new Stack<>();
        while(top()!=max)
            tmp.push(pop());
        pop();
        while(!tmp.isEmpty())
            push(tmp.pop());
        return max;
    }

    public static void main(String[] args) {
        MaxStack maxStack=new MaxStack();
        maxStack.push(5);
        maxStack.push(1);
        maxStack.push(5);
        maxStack.top();
        maxStack.popMax();
        maxStack.top();
        maxStack.pop();
        maxStack.top();
        System.out.println(maxStack.stack);

    }


}
