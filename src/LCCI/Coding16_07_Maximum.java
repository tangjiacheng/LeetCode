package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 21:25
 * @description:
 * 编写一个方法，找出两个数字a和b中最大的那一个。不得使用if-else或其他比较运算符。
 *
 * 示例：
 *
 * 输入： a = 1, b = 2
 * 输出： 2
 */
public class Coding16_07_Maximum {
    public int maximum(int a, int b) {
        int temp = a ^ b;
        boolean flag = (a < b) && (temp = temp ^ a) == 0;
        flag = (b <= a) && (temp = temp ^ b) == 0;
        return temp;
    }

    public static void main(String[] args) {
        Coding16_07_Maximum maximum = new Coding16_07_Maximum();
        int a = 2147483647, b = -2147483648;
        System.out.println(maximum.maximum(a, b));
    }
}
