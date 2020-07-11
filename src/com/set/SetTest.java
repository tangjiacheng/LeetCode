package com.set;

/**
 * @Author: TJC
 * @Date: 2020/6/6 12:38
 * @description: TODO
 */
public class SetTest {
    public static void main(String[] args) {
//        LongestConsecutive longestConsecutive = new LongestConsecutive();
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        System.out.println(longestConsecutive.longestConsecutive(nums));

        EquationsPossible ep = new EquationsPossible();
        String[] equations = {"c==c","b==d","x!=z"};
        System.out.println(ep.equationsPossible(equations));
    }
}
