package edu.ucla.pls.baseline;
/** This class tests reachabilitiy analyses, on programs that
 * uses reflection.
 */
import java.lang.reflect.Method;
public class ReflectionReachability {
    public static void main(String[] args) throws Exception {
        Class<?> c = ReflectionReachability.class;
        Method m = c.getMethod("missed");
        m.invoke(null);
    }

    public static void missed() {
        System.out.println("reached \"missed\"");
    };

    public static void dead() {
        // This should not happen.
        System.out.println("reached \"dead\"");
    };
}
