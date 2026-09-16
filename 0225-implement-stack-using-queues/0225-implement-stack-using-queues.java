import java.util.Queue;
import java.util.LinkedList;
class MyStack {

    Queue<Integer> queue;
    int size;
    public MyStack() {
        queue = new LinkedList<Integer>();
        size = 0;
    }
    
    public void push(int x) {
        size = queue.size();
        queue.offer(x);
        for(int i = 0;i < size; i++){
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        return queue.poll();
    }
    
    public int top() {
        return queue.peek();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */