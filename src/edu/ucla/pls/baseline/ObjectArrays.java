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
      new TestA().runTest();
      new TestB().runTest();
      new TestC().runTest();
      new TestD().runTest();
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
      ArrayList<Object> os = new ArrayList<Object>();
      os.add(this);
      System.out.println(os.get(0).toString());
    }

    @Override
    public String toString() {
      return "TestB";
    }
  }

  private static class TestC {

    public void runTest() {
      ArrayList<Object> os = new ArrayList<Object>();
      createIt(os, this);
      printIt(os);
    }

    public void createIt(Collection<Object> os, Object x) {
      os.add(x);
    }

    public void printIt(Collection<Object> os) {
      for (Object o: os) {
        System.out.println(o.toString());
      }
    }

    public String toString() {
      return "TestC";
    }
  }

  private static class TestD implements Runnable {

    public void runTest() {
      ArrayList<Runnable> os = new ArrayList<Runnable>();
      os.add(this);
      runAll(os);
    }

    public void runAll(Collection<Runnable> os) {
      for (Runnable r: os) {
        r.run();
      }
    }

    @Override
    public void run () {
      System.out.println("TestD");
    }
  }

}
