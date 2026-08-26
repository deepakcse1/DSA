package LinkedList;

public class RotateList {
  public static void main(String[] args) {

  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null) return head;
    int count = 1;
    ListNode tail = head;
    while (tail.next != null) {
      tail = tail.next;
      count++;
    }
    k = k % count;
    if (k == 0) return head;
    ListNode newTail = head;
    for (int i = 1; i < count - k; i++) {
      newTail = newTail.next;
    }
    ListNode newHead = newTail.next;
    newTail.next = null;
    tail.next = head;
    return newHead;
  }
}
