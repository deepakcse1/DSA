package LinkedList;

public class ReverseLinkedListTwo {
  public ListNode reverseBetween(ListNode head, int left, int right) {
    if (head == null || left == right) return head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode prev = dummy;

    // Move prev to node before left
    for (int i = 1; i < left; i++) {
      prev = prev.next;
    }
    ListNode curr = prev.next;
    // Mode each next node to the front
    for (int i = 0; i < right - left; i++) {
      ListNode next = curr.next;
      curr.next = next.next;
      next.next = prev.next;
      prev.next = next;
    }
    return dummy.next;
  }

  // public ListNode reverseBetween(ListNode head, int left, int right) {
    //     if(head == null || head.next == null || left == right) return head;
    //     ListNode temp = head;
    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = head;
    //     ListNode prev = dummy;
    //     ListNode nextNode = null;
    //     ListNode leftNode = null;
    //     // while(temp != null){
    //     int count = 1;
    //     while(count != right){
    //         if(count < left)  prev = temp;
    //         if(count == left) leftNode = temp;
    //         temp = temp.next;
    //         count++;
    //     }
    //     nextNode = temp.next;
    //     temp.next = null;
    //     ListNode reverseNode = reverse(leftNode);
    //     prev.next = reverseNode;
    //     leftNode.next = nextNode;
    //     // }
    //     return dummy.next;
    // }
    // private ListNode reverse(ListNode head){
    //     ListNode curr = head;
    //     ListNode prev = null;
    //     while(curr != null){
    //         ListNode nextNode = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = nextNode;
    //     }
    //     return prev;
    // }
}
