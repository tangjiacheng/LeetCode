package LCCI;

/**
 * @Author: TJC
 * @Date: 2020/7/13 15:36
 * @description:
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 * 示例2:
 *
 *  输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 *  输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 */
public class Coding10_05_SparseArraySearch {
    public int findString(String[] words, String s) {
        if (words == null || words.length == 0)
            return -1;
        int left = 0;
        int right = words.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1;
            if ("".equals(words[mid])) {
                int index = mid - 1;
                while (index >= left && "".equals(words[index]))
                    index--;
                if (index < left) {
                    index = mid + 1;
                    while (index <= right && "".equals(words[index]))
                        index++;
                    if (index > right || s.compareTo(words[index]) < 0)
                        return -1;
                }
                mid = index;
            }
            int compare = s.compareTo(words[mid]);
            if (compare == 0)
                return mid;
            if (compare < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (left < words.length && s.equals(words[left]))
            return left;
        return -1;
    }

    public static void main(String[] args) {
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String s = "ball";
        Coding10_05_SparseArraySearch search = new Coding10_05_SparseArraySearch();
        System.out.println(search.findString(words, s));
    }
}
