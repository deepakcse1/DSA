package LinkedList;

public class RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    
  }
  
  // Two pass solution
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int count = 1;
    ListNode temp = head;
    while (temp.next != null) {
      count++;
      temp = temp.next;
    }
    int index = count - n - 1;
    if (index == -1) head = head.next;
    else {
      count = 0;
      temp = head;
      while (count != index) {
        count++;
        temp = temp.next;
      }
      temp.next = temp.next.next;
    }
    return head;
  }

  // One pass solution(slow and fast pointer)
  public ListNode removeNthFromEnd_Optimized(ListNode head, int n) {
    ListNode fast = head;
    for (int i = 0; i < n; i++) fast = fast.next;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    if (fast == null) return head.next;
    slow.next = slow.next.next;
    return head;
  }
}
