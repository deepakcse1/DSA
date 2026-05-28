package HashMap;

public class MapImpl {
  public static void main(String[] args) {
    Map<String, Integer> map = new Map<>();
    for(int i = 0; i < 10; i++){
      map.insert("abc"+i, i+1);
      System.out.println(map.loadFactor());
    }
    System.out.println("----------------------");
    map.remove("abc2");
    for(int i = 0; i < 5 ; i++){
      System.out.println("abc"+i+" : "+map.get("abc"+i));
    }
  }
}
