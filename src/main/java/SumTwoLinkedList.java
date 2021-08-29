public class SumTwoLinkedList {

  public static void main(String[] args) {

    ListNode l1 = getLinkedList(new int[] {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1});
    ListNode l2 = getLinkedList(new int[] {5,6,4});

    printLList(addTwoNumbers(l1, l2));

  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {


    int carry = 0;

    ListNode returnNode = new ListNode();
    ListNode prev = returnNode;

    while (l1 != null || l2 != null) {

      int l1Val = l1 != null ? l1.val : 0;
      int l2Val = l2 != null ? l2.val : 0;

      int nodeVal = l1Val + l2Val + carry;

      carry = nodeVal / 10;

      ListNode newNode = new ListNode(nodeVal % 10);
      prev.next = newNode;
      prev = newNode;

      if (l1 != null) {
        l1 = l1.next;
      }

      if (l2 != null) {
        l2 = l2.next;
      }

    }

    if (carry != 0) {
      prev.next = new ListNode(carry);
    }

    return returnNode.next;
  }

  private static ListNode getLinkedList(int[] array) {

    ListNode head = new ListNode(array[0]);

    ListNode prev = head;

    for (int k=1; k< array.length; k++) {
      ListNode node = new ListNode(array[k]);
      prev.next = node;
      prev = node;
    }

    return head;

  }

  private static void printLList(ListNode node) {

    while (node != null) {
      System.out.print(node.val);
      node = node.next;
    }

  }

}
