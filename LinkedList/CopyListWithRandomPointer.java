package LinkedList;

import java.util.HashMap;

import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {
    public static void main(String[] args) {

    }
    public Node copyRandomLis_iterative(Node head) {
        if(head == null) return head;
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.val);
            map.put(curr, newNode);
            curr = curr.next;
        }
        curr = head;
        while(curr != null){
            Node clone = map.get(curr);
            clone.next = map.get(curr.next);
            clone.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        return helper(head, map);
    }

    public Node helper(Node head, Map<Node, Node> map) {
        if (head == null) return null;
        Node clone = new Node(head.val);
        map.put(head, clone);
        clone.next = helper(head.next, map);
        clone.random = map.get(head.random);
        return clone;
    }
}
