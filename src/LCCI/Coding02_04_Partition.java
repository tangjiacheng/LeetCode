package LCCI;

import com.utils.BuildNode;
import com.utils.ListNode;

/**
 * @Author: TJC
 * @Date: 2020/7/9 21:26
 * @description:
 * 编写程序以 x 为基准分割链表，使得所有小于 x 的节点排在大于或等于 x 的节点之前。如果链表中包含 x，x 只需出现在小于 x
 * 的元素之后(如下所示)。分割元素 x 只需处于“右半部分”即可，其不需要被置于左右两部分之间。
 *
 * 示例:
 *
 * 输入: head = 3->5->8->5->10->2->1, x = 5
 * 输出: 3->1->2->10->5->5->8
 */
public class Coding02_04_Partition {
    public ListNode partition(ListNode head, int x) {
        ListNode root = new ListNode(0);
        root.next = head;
        while (head != null && head.next != null) {
            if (head.next.val < x) {
                ListNode tmp = head.next;
                head.next = tmp.next;
                tmp.next = root.next;
                root.next = tmp;
            } else {
                head = head.next;
            }
        }
        return root.next;
    }

    public static void main(String[] args) {
        String s = "[1,4,3,2,5,2]";
        ListNode head = BuildNode.buildListNode(s);
        Coding02_04_Partition partition = new Coding02_04_Partition();
        ListNode node = partition.partition(head, 3);
    }
}
