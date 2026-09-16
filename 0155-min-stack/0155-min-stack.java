import java.util.Deque;
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;
    public MinStack() {
        minStack = new ArrayDeque<Integer>();
        stack = new ArrayDeque<Integer>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty())
            minStack.push(value);
        else
            minStack.push(Integer.min(value, minStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        if(!stack.isEmpty())
            return stack.peek();
        return -1;
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */