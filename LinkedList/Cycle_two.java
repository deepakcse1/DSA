package LinkedList;

public class Cycle_two {
  public ListNode detectCycle(ListNode head) {
    ListNode slow = head;
    ListNode fast = slow;
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        fast = head;
        while (fast != slow) {
          fast = fast.next;
          slow = slow.next;
        }
        return fast;
      }
    }
    return null;
  }

  // brute force
  // public ListNode detectCycle(ListNode head) {
  // Set<ListNode> set = new HashSet<>();
  // ListNode temp = head;
  // while(temp != null){
  // if(set.contains(temp)) return temp;
  // set.add(temp);
  // temp = temp.next;
  // }
  // return null;
  // }
}
