package LCCI;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/11 12:25
 * @description:
 * 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收养该收容所的动物时，收养人只能收养所有动物中
 * “最老”（由其进入收容所的时间长短而定）的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。
 * 换言之，收养人不能自由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，
 * 比如enqueue、dequeueAny、dequeueDog和dequeueCat。允许使用Java内置的LinkedList数据结构。
 * enqueue方法有一个animal参数，animal[0]代表动物编号，animal[1]代表动物种类，其中 0 代表猫，1 代表狗。
 * dequeue*方法返回一个列表[动物编号, 动物种类]，若没有可以收养的动物，则返回[-1,-1]。
 * 示例1:
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "dequeueCat", "dequeueDog", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [], [], []]
 *  输出：
 * [null,null,null,[0,0],[-1,-1],[1,0]]
 * 示例2:
 *  输入：
 * ["AnimalShelf", "enqueue", "enqueue", "enqueue", "dequeueDog", "dequeueCat", "dequeueAny"]
 * [[], [[0, 0]], [[1, 0]], [[2, 1]], [], [], []]
 *  输出：
 * [null,null,null,null,[2,1],[0,0],[1,0]]
 * 说明:
 * 收纳所的最大容量为20000
 */
public class Coding03_06_AnimalShelf {
    private final Deque<Integer> cat;
    private final Deque<Integer> dog;
    private final LinkedList<Integer> animal;

    public Coding03_06_AnimalShelf() {
        cat = new LinkedList<>();
        dog = new LinkedList<>();
        animal = new LinkedList<>();
    }

    public void enqueue(int[] animal) {
        this.animal.addLast(animal[1]);
        if (animal[1] == 0) {
            cat.addLast(animal[0]);
        } else {
            dog.addLast(animal[0]);
        }
    }

    public int[] dequeueAny() {
        if (animal.isEmpty())
            return new int[] {-1, -1};
        int type = animal.removeFirst();
        if (type == 1)
            return new int[] {dog.removeFirst(), 1};
        else
            return new int[] {cat.removeFirst(), 0};
    }

    public int[] dequeueDog() {
        if (dog.isEmpty())
            return new int[] {-1, -1};
        int index = 0;
        while (animal.get(index) != 1) {
            index++;
        }
        return new int[] {dog.removeFirst(), animal.remove(index)};
    }

    public int[] dequeueCat() {
        if (cat.isEmpty())
            return new int[] {-1, -1};
        int index = 0;
        while (animal.get(index) != 0) {
            index++;
        }
        return new int[] {cat.removeFirst(), animal.remove(index)};
    }
}
