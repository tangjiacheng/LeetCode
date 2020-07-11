package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/10 20:38
 * @description:
 * 三合一。描述如何只用一个数组来实现三个栈。
 * 你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
 * 构造函数会传入一个stackSize参数，代表每个栈的大小。
 * 示例1:
 *  输入：
 * ["TripleInOne", "push", "push", "pop", "pop", "pop", "isEmpty"]
 * [[1], [0, 1], [0, 2], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, 1, -1, -1, true]
 * 说明：当栈为空时`pop, peek`返回-1，当栈满时`push`不压入元素。
 * 示例2:
 *  输入：
 * ["TripleInOne", "push", "push", "push", "pop", "pop", "pop", "peek"]
 * [[2], [0, 1], [0, 2], [0, 3], [0], [0], [0], [0]]
 *  输出：
 * [null, null, null, null, 2, 1, -1, -1]
 */
public class Coding02_09_TripleInOne {
    private final int[] stack;
    private final int[] index = new int[3];
    private final int stackSize;

    public Coding02_09_TripleInOne(int stackSize) {
        this.stackSize = stackSize;
        stack = new int[3 * stackSize];
        index[1] = stackSize;
        index[2] = 2 * stackSize;
    }

    public void push(int stackNum, int value) {
        if (index[stackNum] < (1 + stackNum) * stackSize) {
            stack[index[stackNum]++] = value;
        }
    }

    public int pop(int stackNum) {
        if (index[stackNum] > stackNum * stackSize) {
            index[stackNum]--;
            return stack[index[stackNum]];
        } else
            return -1;
    }

    public int peek(int stackNum) {
        if (index[stackNum] > stackNum * stackSize) {
            return stack[index[stackNum] - 1];
        } else
            return -1;
    }

    public boolean isEmpty(int stackNum) {
        return index[stackNum] <= stackNum * stackSize;
    }
}
