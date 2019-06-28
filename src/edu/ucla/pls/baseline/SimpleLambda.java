package edu.ucla.pls.baseline;
// This class tries to test lambdas in static analyses.
class SimpleLambda {

  public static void main(String [] args) {
    Runnable runable = (() -> { new SimpleLambda().a(); });
    runable.run();
  }

  public void a() {
    System.out.println("A"); 
    Runnable runable = (() -> { this.b();});
    runable.run();
  }

  public void b() {
    System.out.println("B"); 
  }
}
