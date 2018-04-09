package edu.ucla.pls.baseline;

// The example from PickLock
// Sorrentino, Francesco. "PickLock: A deadlock prediction approach under nested
// locking." Model Checking Software. Springer, Cham, 2015. 179-199.
public class PickLock {
  static Object
    l1 = new Object(),
    l2 = new Object(),
    l3 = new Object(),
    l4 = new Object();

  public static void main (String [] args) throws InterruptedException {
    Thread t1 = new T1(), t2 = new T2();
    t1.start(); t2.start();
    t1.join(); t2.join();
  }

  static class T1 extends Thread {
    public void run () {
      synchronized (l1) {
        synchronized (l2) {}
        synchronized (l3) {
          synchronized (l4) {}
        }
      }
    }
  }

  static class T2 extends Thread {
    public void run () {
      synchronized (l2) {
        synchronized (l1) {}
        synchronized (l4) {
          synchronized (l3) {}
        }
      }
    }
  }
}
