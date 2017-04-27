package edu.ucla.pls.baseline;
/**
 * Infinite is a simple example of a non-terminating program.
 *
 * @author Christian Gram Kalhauge
 */
public class Infinite {
  public static void main (String[] args) {
    Infinite inf = new Infinite();
    synchronized (inf) {
      try {
        while (true) {
          inf.wait();
        }
      } catch (InterruptedException e) {
        System.out.println("Infinite loop interrupted.");
      }
    }
  }
}
