package com.array;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/5/30 12:17
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
//        LargestRectangleArea lra = new LargestRectangleArea();
//        int[] heights = {2, 1, 5, 6, 2, 3};
//        System.out.println(lra.largestRectangleArea(heights));


//        ProductExceptSelf pes = new ProductExceptSelf();
//        int[] nums = {1, 2, 3, 4};
//        System.out.println(Arrays.toString(pes.productExceptSelf(nums)));

//        SpiralOrder so = new SpiralOrder();
//        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        System.out.println(Arrays.toString(so.spiralOrder(matrix)));

//        DailyTemperatures dt = new DailyTemperatures();
//        int[] T = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
//        int[] res = dt.dailyTemperatures(T);
//        System.out.println(Arrays.toString(res));

        /*RepeatNum repeatNum = new RepeatNum();
        int[] numbers = new int[] {2, 3, 1, 0, 2, 5, 3};
        System.out.println(repeatNum.repeatNum(numbers));*/

        /*int[] digits = {1, 2, 3};
        PlusOne one = new PlusOne();
        one.plusOne(digits);*/

        /*for (char i = 'A'; i <= 'z'; i++) {
            System.out.println(i + " = " + (int) i);
        }*/

        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        FindLength length = new FindLength();
        System.out.println(length.findLength(A, B));
    }
}
