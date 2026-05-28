package LinkedList;

public class RotateList {
  public static void main(String[] args) {
    
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) return head;
    int size = 1;
    ListNode tail = head;
    while (tail.next != null) {
      size++;
      tail = tail.next;
    }
    if ((k % size) == 0) return head;
    int index = k % size;
    index = size - index - 1;
    int count = 0;
    ListNode prev = head;
    while (count != index) {
      count++;
      prev = prev.next;
    }
    ListNode newHead = prev.next;
    tail.next = head;
    prev.next = null;
    return newHead;

  }
}
