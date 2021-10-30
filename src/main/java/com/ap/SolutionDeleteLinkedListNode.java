package com.ap;

public class SolutionDeleteLinkedListNode {

  public static void main(String[] args) {

    ListNode head = getTestData();

    deleteNode(head.getNext());

    print(head);

    System.gc();

  }

  public static void deleteNode(ListNode node) {
    while (node.getNext() != null) {
      node.setVal(node.getNext().getVal());
      node = node.getNext();
    }

    node = null;
  }

  private static ListNode getTestData() {

    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    head.setNext(second);

    ListNode third = new ListNode(3);
    second.setNext(third);

    ListNode fourth = new ListNode(4);
    third.setNext(fourth);

    return head;

  }

  private static void print(ListNode node) {

    while (node.getNext() != null) {
      System.out.println("Node value: " +node.getVal());
      node = node.getNext();
    }
  }

}
