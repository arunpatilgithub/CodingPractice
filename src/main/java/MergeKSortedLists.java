import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(3, new ListNode(3, new ListNode(4)));
        ListNode node3 = new ListNode(2, new ListNode(6));

        ListNode finalListNode = mergeKLists(new ListNode[] {node1, node2, node3});

        while (finalListNode != null) {
            System.out.println(finalListNode.val);
            finalListNode = finalListNode.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> priorityQueueOfNodes = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));;

        for (int i =0 ; i< lists.length; i++) {
            if (lists[i] != null) {
                priorityQueueOfNodes.add(lists[i]);
            }
        }

        ListNode head = null;
        ListNode prev = null;

        while (priorityQueueOfNodes.peek() != null) {

            ListNode node = priorityQueueOfNodes.poll();

            if (head == null) {
                head = node;
            } else {
                prev.next = node;
            }
            prev = node;

            if (node.next != null) {
                priorityQueueOfNodes.add(node.next);
            }

        }

        return head;
    }
}
