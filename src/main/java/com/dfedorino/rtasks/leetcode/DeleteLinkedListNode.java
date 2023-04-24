package com.dfedorino.rtasks.leetcode;

public class DeleteLinkedListNode {
    public void deleteNode(ListNode node) {
        ListNode currentNodeNext = node.next;
        if (currentNodeNext == null) {
            return;
        } else {
            node.val = currentNodeNext.val;
            node.next = currentNodeNext.next;
            deleteNode(currentNodeNext);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }
}
