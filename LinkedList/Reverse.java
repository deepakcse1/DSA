package LinkedList;

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Reverse {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode second = new ListNode(2);
    ListNode third = new ListNode(3);
    head.next = second;
    second.next = third;
  
    System.out.println(head.toString().split("@")[1]);
    System.out.println(second.toString().split("@")[1]);
    ListNode temp = head;
    System.out.println(temp.toString().split("@")[1]);

  }
  // Iterative approach
  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode prev = head;
    ListNode curr = head.next;
    while (curr != null) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    head.next = null;
    return prev;
  }

    // Recursive approach
    public ListNode reverseList_Recursive(ListNode head) {
      if (head == null || head.next == null) return head;
      ListNode newHead = reverseList_Recursive(head.next);
      head.next.next = head;
      head.next = null;
      return newHead;
    }
}
