package LinkedList;

public class IntersectionOfTwoLinkedList {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode temp1 = headA;
    ListNode temp2 = headB;
    // either both meet at intersection point
    // or both became null - so loop break
    while (temp1 != temp2) {
      temp1 = (temp1 == null) ? headB : temp1.next;
      temp2 = (temp2 == null) ? headA : temp2.next;
    }
    return temp1;
  }
  // public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //     Set<ListNode> set = new HashSet<>();
    //     ListNode temp1 = headA;
    //     while(temp1 != null){
    //         set.add(temp1);
    //         temp1 = temp1.next;
    //     }
    //     ListNode temp2 = headB;
    //     while(temp2 != null){
    //         if(set.contains(temp2)){
    //             return temp2;
    //         }
    //         temp2 = temp2.next;
    //     }
    //     return null;
    // }
}
