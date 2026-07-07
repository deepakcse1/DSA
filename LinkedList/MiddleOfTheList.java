package LinkedList;

public class MiddleOfTheList {
  public ListNode middleNode(ListNode head) {
    ListNode fast = head.next;
    ListNode slow = head;
    while (fast != null) {
      if (fast.next == null) {
        return slow.next;
      }
      fast = fast.next.next;
      slow = slow.next;
    }
    return slow;
  }
}
