package edu.ucla.pls.baseline;

public class NotADeadlock extends Thread {
  static Object
    l1 = new Object(),
    l2 = new Object();

  public static void main (String [] args) throws InterruptedException {
    Thread t1 = new NotADeadlock(), t2 = new NotADeadlock();
    t1.start(); t2.start();
    t1.join(); t2.join();
  }

  static synchronized void swap () {
    Object tmp = l1;
    l1 = l2;
    l2 = tmp;
  }

  public void run () {
    synchronized (l1) {
      synchronized (l2) {
      }
    }
    swap();
  }

}
