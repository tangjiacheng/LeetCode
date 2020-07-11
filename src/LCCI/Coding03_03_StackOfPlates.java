package LCCI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 11:40
 * @description:
 * 堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。
 * 请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。
 * 此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。
 * 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
 * 当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.
 */
public class Coding03_03_StackOfPlates {
    private final LinkedList<Deque<Integer>> StackSet;
    private final int cap;

    public Coding03_03_StackOfPlates(int cap) {
        this.cap = cap;
        StackSet = new LinkedList<>();
    }

    public void push(int val) {
        if (cap <= 0)
            return;
        if (StackSet.isEmpty())
            StackSet.addLast(new LinkedList<>());
        if (StackSet.getLast().size() == cap) {
            StackSet.addLast(new LinkedList<>());
        }
        StackSet.getLast().addLast(val);
    }

    public int pop() {
        if (cap == 0 || StackSet.isEmpty() || StackSet.getLast().isEmpty())
            return -1;
        int plate = StackSet.getLast().removeLast();
        if (StackSet.getLast().size() == 0) {
            StackSet.removeLast();
        }
        return plate;
    }

    public int popAt(int index) {
        if (cap == 0 || StackSet.isEmpty() || StackSet.size() <= index)
            return -1;
        int plate = StackSet.get(index).removeLast();
        if (StackSet.get(index).isEmpty())
            StackSet.remove(index);
        return plate;
    }

    public static void main(String[] args) {
        Coding03_03_StackOfPlates plates = new Coding03_03_StackOfPlates(0);
        for (int i = 0; i < 5; i++) {
            plates.push(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(plates.pop());
        }
    }
}
