package LCCI;

import com.utils.ListNode;

/**
 * @Author: TJC
 * @Date: 2020/7/10 17:08
 * @description:
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 * 这些数位是反向存放的，也就是个位排在链表首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *  
 * 示例：
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 * 进阶：假设这些数位是正向存放的，请再做一遍。
 * 示例：
 * 输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
 * 输出：9 -> 1 -> 2，即912
 */
public class Coding02_05_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode ptr1 = l1;
        ListNode ptr2 = l2;
        ListNode root = new ListNode(0);
        ListNode cur = root;
        int carry = 0;
        while (ptr1 != null && ptr2 != null) {
            int val = ptr1.val + ptr2.val + carry;
            if (val > 9) {
                carry = 1;
                val -= 10;
            }else
                carry = 0;
            cur.next = new ListNode(val);
            cur = cur.next;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        while (ptr1 != null) {
            int val = ptr1.val + carry;
            if (val > 9) {
                carry = 1;
                val -= 10;
            }
            else
                carry = 0;
            cur.next = new ListNode(val);
            cur = cur.next;
            ptr1 = ptr1.next;
        }
        while (ptr2 != null) {
            int val = ptr2.val + carry;
            if (val > 9) {
                carry = 1;
                val -= 10;
            }
            else
                carry = 0;
            cur.next = new ListNode(val);
            cur = cur.next;
            ptr2 = ptr2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(1);
        }
        return root.next;
    }

    public ListNode addTwoNumbers_Rev(ListNode l1, ListNode l2) {
        return null;
    }
}
