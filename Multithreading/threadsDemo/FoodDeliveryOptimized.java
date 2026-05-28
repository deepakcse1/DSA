package threadsDemo;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

class Order_Optimized{
  private final int orderId;
  private final String foodName;
  public Order_Optimized(int orderId, String foodName){
    this.orderId = orderId;
    this.foodName = foodName;
  }
  public int getOrderId(){
    return orderId;
  }
  public String getFoodName(){
    return foodName;
  }
  @Override
  public String toString(){
    return "Order ID: " + orderId + ", Food Name: " + foodName;
  } 
}
class ProcessOrderAction extends RecursiveAction{
  private final List<Order_Optimized> orders;
  private final int start;
  private final int end;
  public ProcessOrderAction(List<Order_Optimized> orders, int start, int end){
    this.orders = orders;
    this.start = start;
    this.end = end;
  }

  @Override
  protected void compute(){
    for(int i = start; i < end; i++){
      processOrder(orders.get(i));
    }
  }

  private void processOrder(Order_Optimized order) {
    System.out.println("Preparing Order: " + order);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Order Prepared: " + order);
  }
}

class Kitchen_Optimized implements Runnable{
  private final List<Order_Optimized> orders;
  private final ForkJoinPool forkJoinPool;
  Kitchen_Optimized(List<Order_Optimized> orders){
    this.orders = orders;
    this.forkJoinPool = new ForkJoinPool();
  }
  public void run(){
    while(true){
      synchronized(orders){
        while(orders.isEmpty()){
          try {
            orders.wait();
          } catch (Exception e) {
            e.printStackTrace();
          }
        }
        List<Order_Optimized> ordersToProcess = new ArrayList<>(orders);
        orders.clear();
        forkJoinPool.execute(new ProcessOrderAction(ordersToProcess, 0, ordersToProcess.size()));
        // Order_Optimized order = orders.remove(0);
      }
    }
  }
}

class Driver_Optimized implements Runnable{
  private final List<Order_Optimized> deliveries;
  Driver_Optimized(List<Order_Optimized> deliveries){
    this.deliveries = deliveries;
  }
  public void run(){
    while(true){
      synchronized(deliveries){
        while(deliveries.isEmpty()){
          try {
            deliveries.wait();
          } catch (Exception e) {
             e.printStackTrace();
          }
        }
        Order_Optimized order = deliveries.remove(0);
        System.out.println("Finding delivery partner for :"+order);
        try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println("Order Delivered................: "+order);
      }
    }
  }
}

public class FoodDeliveryOptimized {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    List<Order_Optimized> kitchenOrders = new ArrayList<>();
    List<Order_Optimized> deliveryOrder = new ArrayList<>();
    
    Kitchen_Optimized kitchen = new Kitchen_Optimized(kitchenOrders);
    Driver_Optimized driver = new Driver_Optimized(deliveryOrder);

    Thread kitchenThread = new Thread(kitchen);
    kitchenThread.start();
    Thread driverThread = new Thread(driver);
    driverThread.start();
    Random rand = new Random();
    String[] foodItems = {"Pizza", "Burger", "Sushi", "Pasta", "Salad"};
    for(int i = 1; i <= 10; i++){
      String foodName = foodItems[rand.nextInt(foodItems.length)];
      Order_Optimized order = new Order_Optimized(i, foodName);
      synchronized(kitchenOrders){
        kitchenOrders.add(order);
        kitchenOrders.notify();
      }

      System.out.println("New Order placed :"+order);

      synchronized(deliveryOrder){
        deliveryOrder.add(order);
        deliveryOrder.notify();
      }

      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    long endTime = System.currentTimeMillis();
    System.out.println("Total Time take :"+ (endTime - startTime) + " ms");
  }
}
