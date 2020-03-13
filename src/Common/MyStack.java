package Common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author : Chad li
 * @Date : 2020/3/13 12:10
 * @Version 1.0
 */
public class MyStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private boolean isQueue1NotEmpty;
    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
        isQueue1NotEmpty= true;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(isQueue1NotEmpty){
            queue2.offer(x);
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            isQueue1NotEmpty = false;
        }else{
            queue1.offer(x);
            while(!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
            isQueue1NotEmpty = true;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return  isQueue1NotEmpty ? queue1.poll() : queue2.poll();
    }

    /** Get the top element. */
    public int top() {
        return isQueue1NotEmpty ? queue1.peek() : queue2.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return isQueue1NotEmpty ? queue1.isEmpty():queue2.isEmpty();
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
