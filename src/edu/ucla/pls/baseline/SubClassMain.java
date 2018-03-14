package edu.ucla.pls.baseline;

public class SubClassMain {
    public static void main (String [] args) { 
        System.out.println("Main called");
    }
    public enum Main { 
        Test();

        public static void main (String [] args) { 
            System.out.println("Sub Main called");
        }
    }
}
