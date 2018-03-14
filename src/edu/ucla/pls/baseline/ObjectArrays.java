package edu.ucla.pls.baseline;
/** This class tests reachabilitiy analyses, on programs that
 * uses reflection.
 */

import java.util.ArrayList;
import java.util.Collection;
import java.lang.Runnable;

public class ObjectArrays {

    public static void main(String[] args) {
      new Test0().runTest();
      new Test1().runTest();
      new TestA().runTest();
      new TestB().runTest();
    }

  private static class Test0 {

    public void runTest() {
      // Does nothing
    }

    @Override
    public String toString() {
      return "Unreachable";
    }
  }

  private static class Test1 {

    public void runTest() {
      System.out.println(this.toString());
    }

    @Override
    public String toString() {
      return "Reachable";
    }
  }

  private static class TestA {

    public void runTest() {
      System.out.println(this);
    }

    @Override
    public String toString() {
      return "TestA";
    }
  }

  private static class TestB {

    public void runTest() {
      while (this.equals("TestB")) { 
      }
      System.out.println("TestB");
    }

    @Override
    public boolean equals(Object other) { 
      return false;
    }

    @Override
    public String toString() {
      return "TestB";
    }
  }
}
