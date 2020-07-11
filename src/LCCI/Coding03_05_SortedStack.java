package LCCI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 12:13
 * @description:
 * 栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，
 * 但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
 * 示例1:
 *  输入：
 * ["SortedStack", "push", "push", "peek", "pop", "peek"]
 * [[], [1], [2], [], [], []]
 *  输出：
 * [null,null,null,1,null,2]
 * 示例2:
 *  输入：
 * ["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
 * [[], [], [], [1], [], []]
 *  输出：
 * [null,null,null,null,null,true]
 * 说明:
 * 栈中的元素数目在[0, 5000]范围内。
 */
public class Coding03_05_SortedStack {
    private final Deque<Integer> stack;
    private final Deque<Integer> auxStack;

    public Coding03_05_SortedStack() {
        stack = new LinkedList<>();
        auxStack = new LinkedList<>();
    }

    public void push(int val) {
        while (!stack.isEmpty() && stack.peek() > val) {
            auxStack.push(stack.pop());
        }
        while (!auxStack.isEmpty() && auxStack.peek() < val) {
            stack.push(auxStack.pop());
        }
        stack.push(val);
    }

    public void pop() {
        while (!stack.isEmpty())
            auxStack.push(stack.pop());
        if (!auxStack.isEmpty())
            auxStack.pop();
    }

    public int peek() {
        while (!stack.isEmpty())
            auxStack.push(stack.pop());
        if (!auxStack.isEmpty())
            return auxStack.peek();
        else
            return -1;
    }

    public boolean isEmpty() {
        return stack.isEmpty() && auxStack.isEmpty();
    }
}
