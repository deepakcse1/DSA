package LinkedList;

public class ReorderList {
  public static void main(String[] args) {

  }

  // Find middle, ---------------------------- (1)
  // reverse second half, -------------------- (2)
  // merge two halves. ----------------------- (3)
  public static void reorderList(ListNode head) {
    if (head == null || head.next == null) return;
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode second = reverse(slow.next);
    slow.next = null;
    ListNode first = head;
    while (second != null) {
      ListNode temp1 = first.next;
      ListNode temp2 = second.next;
      first.next = second;
      second.next = temp1;
      first = temp1;
      second = temp2;
    }
  }
  
  public static ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode newHead = reverse(head.next);
    head.next.next = head;
    head.next = null;
    return newHead;
  }
}
