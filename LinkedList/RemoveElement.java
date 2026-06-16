package LinkedList;

public class RemoveElement {
  public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode temp = head;
    ListNode prev = dummy;
    while (temp != null) {
      if (temp.val == val) {
        prev.next = temp.next;
      } else {
        prev = temp;
      }
      temp = temp.next;
    }
    return dummy.next;
  }
    // public ListNode removeElements(ListNode head, int val) {
    //     ListNode temp = head;
    //     ListNode newHead = new ListNode(-1);
    //     ListNode temp2 = newHead;
    //     while(temp != null){
    //         if(temp.val == val){
    //             temp = temp.next;
    //             continue;
    //         }
    //         ListNode curr = new ListNode(temp.val);
    //         temp2.next = curr;
    //         temp2 = temp2.next;
    //         temp = temp.next; 
    //     }
    //     return newHead.next;
    // }
}
