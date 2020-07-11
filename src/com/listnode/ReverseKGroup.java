package com.listnode;

import com.utils.ListNode;

public class ReverseKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1)
            return head;
        ListNode start = head;
        ListNode end = head;
        ListNode root = null;
        ListNode last = null;

        w: while (end != null) {
            for(int i = 0; i < k-1; i++) {
                end = end.next;
                if (end == null) {
                    break w;
                }
            }
            ListNode tmp = end.next;
            reverseK(start, end);
            if (root == null)
                root = end;
            if (last != null)
                last.next = end;
            last = start;

            start = tmp;
            end = tmp;
        }
        if (start != null)
            last.next = start;
        return root;
    }
    
    public void reverseK(ListNode start, ListNode end) {
        ListNode pre = start;
        ListNode next = start.next;
        while (!next.equals(end)) {
            ListNode tmp = next.next;
            next.next = pre;
            pre = next;
            next = tmp;
        }
        next.next = pre;
        start.next = null;
    }
}
