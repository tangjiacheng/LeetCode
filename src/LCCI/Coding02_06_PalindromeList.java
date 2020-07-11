package LCCI;

import com.utils.ListNode;

import java.util.LinkedList;

/**
 * @Author: TJC
 * @Date: 2020/7/10 17:23
 * @description:
 * 编写一个函数，检查输入的链表是否是回文的。
 *  
 * 示例 1：
 * 输入： 1->2
 * 输出： false
 * 示例 2：
 * 输入： 1->2->2->1
 * 输出： true
 *  
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Coding02_06_PalindromeList {
    public boolean isPalindrome(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head != null) {
            list.addLast(head.val);
            head = head.next;
        }
        while (list.size() > 1) {
            int last = list.removeLast();
            int first = list.removeFirst();
            if (last != first)
                return false;
        }
        return true;
    }
}
