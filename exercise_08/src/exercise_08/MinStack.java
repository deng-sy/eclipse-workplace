package exercise_08;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();
    
    public MinStack() {}  
    
    public void push(int x) {
        s1.push(x);
        if (s2.isEmpty() || s2.peek() >= x)
        	s2.push(x);
    }
    
    public void pop() {
        int x = s1.pop();
        if (s2.peek() == x)
        	s2.pop();
    }   
    
    public int peak() {
        return s1.peek();
    }  
    
    public int getMin() {
        return s2.peek();
    }
    
    
    public static void main(String[] args) {
		MinStack minStack=new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.peak());
		System.out.println(minStack.getMin());
	}
}
