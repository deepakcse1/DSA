package LinkedList;

import java.util.HashMap;

import java.util.Map;

public class LRU_Cache {

}

class ListNode {
  int key;
  int val;
  ListNode next;
  ListNode prev;

  public ListNode(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

class LRUCache {
  int capacity;
  Map<Integer, ListNode> map;
  ListNode head;
  ListNode tail;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap<>();
    head = new ListNode(-1, -1);
    tail = new ListNode(-1, -1);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    if (!map.containsKey(key)) return -1;
    ListNode node = map.get(key);
    remove(node);
    add(node);
    return node.val;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      ListNode oldNode = map.get(key);
      remove(oldNode);
    }
    ListNode node = new ListNode(key, value);
    map.put(key, node);
    add(node);
    if (map.size() > capacity) {
      ListNode nodeToDelete = head.next;
      remove(nodeToDelete);
      map.remove(nodeToDelete.key);
    }
  }

  public void add(ListNode node) {
    ListNode prevNode = tail.prev;
    prevNode.next = node;
    node.prev = prevNode;
    node.next = tail;
    tail.prev = node;
  }

  public void remove(ListNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}
