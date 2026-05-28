package threadsDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Order{
  private final int orderId;
  private final String foodName;
  public Order(int orderId, String foodName){
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

class Kitchen{
  private final List<Order> orders;
  Kitchen(List<Order> orders){
    this.orders = orders;
  }
  public void process(Order order){
    System.out.println("Order Received: "+order);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Order Processed: "+order);
  }
}

class Driver{
  private final List<Order> deliveries;
  Driver(List<Order> deliveries){
    this.deliveries = deliveries;
  }
  public void deliver(Order order){
    System.out.println("Finding delivery partner for :"+order);
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Order Delivered: "+order);
  }
}

public class FoodDeliverySystem {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    List<Order> kitchenOrders = new ArrayList<>();
    List<Order> deliveryOrder = new ArrayList<>();
    
    Kitchen kitchen = new Kitchen(kitchenOrders);
    Driver driver = new Driver(deliveryOrder);

    Random rand = new Random();
    String[] foodItems = {"Pizza", "Burger", "Sushi", "Pasta", "Salad"};
    for(int i = 1; i <= 10; i++){
      String foodName = foodItems[rand.nextInt(foodItems.length)];
      Order order = new Order(i, foodName);
      kitchenOrders.add(order);
      kitchen.process(order);

      System.out.println("New Order placed :"+order);

      deliveryOrder.add(order);
      driver.deliver(order);

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
