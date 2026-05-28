package threadsDemo;

// import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

class Account{
  int balance;
  // AtomicInteger balance;
  ReentrantLock lock = new ReentrantLock();
  Account(int balance){
    lock.lock();
    try{
      this.balance = balance;
    }finally{
      lock.unlock();
    }
  }
  public synchronized void decreament(){
    balance--;
  }
}

class Atm1 implements Runnable{
  Account account;
  public Atm1(Account account){
    this.account = account;
  }
  @Override
  public void run() {
    for(int i=0;i<1000;i++){
      account.decreament();
    }
  }  
}

class Atm2 implements Runnable{
  Account account;
  public Atm2(Account account){
    this.account = account;
  }
  @Override
  public void run() {
    for(int i=0;i<1000;i++){
      account.decreament();
    }
  }  
}
public class Bank {
  public static void main(String[] args) throws InterruptedException {
    System.out.println("Welcome to the Bank!");
    // Account account = new Account(new AtomicInteger(2000));
    Account account = new Account(2000);
    Thread atm1 = new Thread (new Atm1(account));
    Thread atm2 = new Thread (new Atm2(account));
    atm1.start();
    atm2.start();
    atm1.join();
    atm2.join();
    System.out.println("Final balance: " + account.balance);
  }
}
