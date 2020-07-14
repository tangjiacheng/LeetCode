package LCCI;

import com.string.IsMatch;

import java.util.Arrays;

/**
 * @Author: TJC
 * @Date: 2020/7/13 17:44
 * @description:
 * 给定两条线段（表示为起点start = {X1, Y1}和终点end = {X2, Y2}），如果它们有交点，请计算其交点，没有交点则返回空值。
 *
 * 要求浮点型误差不超过10^-6。若有多个交点（线段重叠）则返回 X 值最小的点，X 坐标相同则返回 Y 值最小的点。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * line1 = {0, 0}, {1, 0}
 * line2 = {1, 1}, {0, -1}
 * 输出： {0.5, 0}
 * 示例 2：
 *
 * 输入：
 * line1 = {0, 0}, {3, 3}
 * line2 = {1, 1}, {2, 2}
 * 输出： {1, 1}
 * 示例 3：
 *
 * 输入：
 * line1 = {0, 0}, {1, 1}
 * line2 = {1, 0}, {2, 1}
 * 输出： {}，两条线段没有交点
 *  
 *
 * 提示：
 *
 * 坐标绝对值不会超过 2^7
 * 输入的坐标均是有效的二维坐标
 */
public class Coding16_03_Intersection {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int[][] line = new int[2][3];
        line[0][0] = end1[1] - start1[1];
        line[0][1] = start1[0] - end1[0];
        line[0][2] = end1[1] * start1[0] - end1[0] * start1[1];
        line[1][0] = end2[1] - start2[1];
        line[1][1] = start2[0] - end2[0];
        line[1][2] = end2[1] * start2[0] - end2[0] * start2[1];

        int temp = line[0][0] * line[1][1] - line[1][0] * line[0][1];
        if (temp == 0) {
            if (line[0][0] == 0 && line[1][0] == 0)
                return horizontalParallel(start1, end1, start2, end2);
            else if (line[0][1] == 0 && line[1][1] == 0)
                return verticalParallel(start1, end1, start2, end2);
            else
                return parallel(start1, end1, start2, end2, line);
        } else {
            double x = line[1][1] * line[0][2] - line[0][1] * line[1][2];
            double y = line[0][0] * line[1][2] - line[1][0] * line[0][2];
            x /= temp;
            y /= temp;
            if (isInLine(x, y, start1, end1) && isInLine(x, y, start2, end2))
                return new double[]{x, y};
            else
                return new double[0];
        }
    }

    private boolean isInLine(double x, double y, int[] start, int[] end) {
        return (x >= start[0] && x <= end[0]
                || x >= end[0] && x <= start[0])
                && (y >= start[1] && y <= end[1]
                || y >= end[1] && y <= start[1]);
    }

    private double[] parallel(int[] start1, int[] end1, int[] start2, int[] end2, int[][] line) {
        if (start1[0] * line[1][0] + start1[1] * line[1][1] != line[1][2])
            return new double[0];
        boolean flagStart1 = isInLine(start1[0], start1[1], start2, end2);
        boolean flagEnd1 = isInLine(end1[0], end1[1], start2, end2);
        boolean flagStart2 = isInLine(start2[0], start2[1], start1, end1);
        boolean flagEnd2 = isInLine(end2[0], end2[1], start1, end1);
        if (flagStart1 || flagStart2 || flagEnd1 || flagEnd2) {
            double minx = Double.MAX_VALUE;
            double miny = Double.MAX_VALUE;
            if (flagStart1) {
                minx = Math.min(minx, start1[0]);
                miny = Math.min(miny, start1[1]);
            }
            if (flagEnd1) {
                minx = Math.min(minx, end1[0]);
                miny = Math.min(miny, end1[1]);
            }
            if (flagStart2) {
                minx = Math.min(minx, start2[0]);
                miny = Math.min(miny, start2[1]);
            }
            if (flagEnd2) {
                minx = Math.min(minx, end2[0]);
                miny = Math.min(miny, end2[1]);
            }
            return new double[] {minx, miny};
        } else
            return new double[0];
    }

    private double[] horizontalParallel(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[1] != start2[1])
            return new double[0];
        double x1 = Math.min(start1[0], end1[0]);
        double y1 = start1[1];
        double x2 = Math.min(start2[0], end2[0]);
        double y2 = start2[1];
        boolean flag1 = isInLine(x1, y1, start2, end2);
        boolean flag2 = isInLine(x2, y2, start1, end1);
        if (flag1 && flag2) {
            return x1 < x2 ? new double[] {x1, y1} : new double[] {x2, y2};
        }
        else if (flag1)
            return new double[] {x1, y1};
        else if (flag2)
            return new double[] {x2, y2};
        else
        return new double[0];
    }

    private double[] verticalParallel(int[] start1, int[] end1, int[] start2, int[] end2) {
        if (start1[0] != start2[0])
            return new double[0];
        double x1 = start1[0];
        double y1 = Math.min(start1[1], end1[1]);
        double x2 = start2[0];
        double y2 = Math.min(start2[1], end2[1]);
        boolean flag1 = isInLine(x1, y1, start2, end2);
        boolean flag2 = isInLine(x2, y2, start1, end1);
        if (flag1 && flag2) {
            return x1 < x2 ? new double[] {x1, y1} : new double[] {x2, y2};
        }
        else if (flag1)
            return new double[] {x1, y1};
        else if (flag2)
            return new double[] {x2, y2};
        else
            return new double[0];
    }

    public static void main(String[] args) {
        Coding16_03_Intersection intersection = new Coding16_03_Intersection();
        int[] start1 = {1,0};
        int[] end1 = {1,3};
        int[] start2 = {2,1};
        int[] end2 = {2,2};
        double[] result = intersection.intersection(start1, end1, start2, end2);
        System.out.println(Arrays.toString(result));
    }

}
