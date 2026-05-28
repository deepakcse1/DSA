package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    head.next = second;
    System.out.println(hasCycle(head));
  }

  // Using Map to store node references as keys - O(N) time and O(N) space - extra space
  public static boolean hasCycle(ListNode head) {
    Map<String, Integer> map = new HashMap<>();
    while (head != null) {
      String key = head.toString().split("@")[1];
      if (map.containsKey(key)) return true;
      map.put(key, head.val);
      head = head.next;
    }
    return false;
  }

  // Slow and Fast pointer - O(N) time and O(1) space - optimized
  public boolean hasCycle_optimized(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }
}
