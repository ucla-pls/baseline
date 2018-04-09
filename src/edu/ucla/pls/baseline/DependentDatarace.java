package edu.ucla.pls.baseline;
/** This benchmark indicates a problem with the read-write dependency 
 * prediction. 
 */ 
public class DependentDatarace {
  static Object o;
  static int i = 0;

  public static void main (String [] args) throws InterruptedException {
    Thread t1 = new T1(), t2 = new T2();
    t1.start(); Thread.sleep(100); t2.start();
    t1.join(); t2.join();
  }

  static class T1 extends Thread {
    public void run () {
      i++;  // Data race 
      synchronized (DependentDatarace.class) { o = new Object(); }
    }
  }

  static class T2 extends Thread {
    public void run () {
      synchronized (DependentDatarace.class) { Object a = o; }
      i++; // Data race
    }
  }
}
