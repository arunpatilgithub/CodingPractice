package com.ap;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode n = head;

        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
        System.out.println("\n");

        ListNode node = removeNthFromEnd(head, 5);

        ListNode output = node;

        while (output != null) {
            System.out.print(output.val + " ");
            output = output.next;
        }

    }

    /**
     * We will use two pointers leader and follower.
     * We will keep gap between leader and follower such that when leader reaches end of the list, the follower
     * is pointer to the node to be removed.
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode leader = head;
        ListNode follower = head;

        int i = 0;

        while (i != n - 1) {
            i ++;
            leader = leader.next;
        }

        ListNode prevOfFollower = follower;

        while (leader . next != null) {
            leader = leader.next;
            prevOfFollower = follower;
            follower = follower.next;
        }

        if (follower == head) {
            head = head.next;
        } else {
            prevOfFollower.next = follower.next;
        }


        return head;
    }

    public static class ListNode {

        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }

}

