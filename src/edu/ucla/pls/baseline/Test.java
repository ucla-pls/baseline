package edu.ucla.pls.baseline;

public class Test {
  public static void main(String[] args) {
    I x = new C();
    x.test();
  }
}

interface I {
  public void test();
}

interface J extends I {}

class C implements J {
  public void test() {
    System.out.println("Test called");
  }
}
