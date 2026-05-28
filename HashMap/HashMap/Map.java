package HashMap;

import java.util.ArrayList;

public class Map<K, V> {
  ArrayList<MapNode<K,V>> buckets;
  int count;
  int numBuckets;

  public Map(){
    buckets = new ArrayList<>();
    numBuckets = 20;
    for(int i = 0; i < numBuckets; i++){
      buckets.add(null);
    }
  }

  private int hashCode(K key){
    int hc = key.hashCode();
    int index = hc%numBuckets;
    return index;
  }
  public void insert(K key, V value){
      int bucketIndex = hashCode(key);
      MapNode<K, V> head = buckets.get(bucketIndex);
      while(head != null){
        if(head.key.equals(key)){
          head.value = value;
          return;
        }
        head = head.next;
      }
      head = buckets.get(bucketIndex);
      MapNode<K, V> newHead = new MapNode<>(key, value);
      newHead.next = head;
      buckets.set(bucketIndex, newHead);
      count++;
      double loadFactor = (1.0*count)/numBuckets;
      if(loadFactor > 0.7) reHash();
  }

  private void reHash() {
    ArrayList<MapNode<K,V>> temp = buckets;
    buckets = new ArrayList<>();
    count = 0;
    numBuckets = 2 * numBuckets;
    for(int i = 0; i < numBuckets; i++){
      buckets.add(null);
    }
    for(int i = 0; i < temp.size(); i++){
      MapNode<K,V> head = temp.get(i);
      while (head != null) {
        insert(head.key, head.value);
        head = head.next;
      }
    }
  }

  public int size(){
    return count;
  }

  public V get(K key) {
    int bucketIndex = hashCode(key);
    MapNode<K, V> head = buckets.get(bucketIndex);
    while (head != null) {
      if (head.key.equals(key)) {
        return head.value;
      }
      head = head.next;
    }
    return null;
  }

  public V remove(K key) {
    int bucketIndex = hashCode(key);
    MapNode<K, V> head = buckets.get(bucketIndex);
    MapNode<K, V> prev = null;
    while (head != null) {
      if (head.key.equals(key)) {
        if (prev != null) {
          prev.next = head.next;
        } else {
          buckets.set(bucketIndex, head.next);
        }
        count--;
        return head.value;
      }
      prev = head;
      head = head.next;
    }
    return null;
  }

  public double loadFactor(){
   return (1.0*count)/numBuckets; 
  }

  public void put(int i, int j) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'put'");
  }
}
