package LCCI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 10:30
 * @description: TODO
 */
public class Coding03_02_MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    public Coding03_02_MinStack() {
        stack = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        stack.addLast(x);
        if (min.isEmpty()) {
            min.addLast(x);
        } else {
            min.addLast(min.getLast() < x ? min.getLast() : x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.removeLast();
            min.removeLast();
        }
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        else
            return stack.getLast();
    }

    public int getMin() {
        if (min.isEmpty())
            return -1;
        else
            return min.getLast();
    }
}
