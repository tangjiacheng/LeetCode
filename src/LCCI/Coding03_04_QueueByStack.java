package LCCI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 12:02
 * @description: TODO
 */
public class Coding03_04_QueueByStack {
    Deque<Integer> inStack;
    Deque<Integer> outStack;

    /** Initialize your data structure here. */
    public Coding03_04_QueueByStack() {
        inStack = new LinkedList<>();
        outStack = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!outStack.isEmpty())
            return outStack.pop();
        else {
            if (inStack.isEmpty())
                return -1;
            else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                return outStack.pop();
            }
        }
    }

    /** Get the front element. */
    public int peek() {
        if (!outStack.isEmpty())
            return outStack.peek();
        else {
            if (inStack.isEmpty())
                return -1;
            else {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
                return outStack.peek();
            }
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}
