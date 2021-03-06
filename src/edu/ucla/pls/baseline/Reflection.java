package edu.ucla.pls.baseline;
/**
 * From https://docs.oracle.com/javase/tutorial/reflect/index.html:
 * "Reflection is commonly used by programs which require the ability to
 * examine or modify the runtime behavior of applications running in the Java
 * virtual machine." Reflection can be problematic for analysis tools
 * that were not designed to support it.
 *
 * @author Colin Terndrup
 */
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.InvocationTargetException;

public class Reflection {
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("edu.ucla.pls.baseline.ReflectionTarget");
            Object o = c.newInstance();
            Method[] methods = c.getDeclaredMethods();
            // Set each method as accessible and invoke public methods
            for (Method m : methods) {
                System.out.format("Setting method %s accessible%n", m.getName());
                m.setAccessible(true);
                if (isPublic(m)) {
                    m.invoke(o, "Test with reflection");
                }
            }
        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        } catch (InstantiationException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (InvocationTargetException x) {
            x.printStackTrace();
        }
    }

    private static boolean isPublic(Method m) {
        return (m.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC;
    }
}

class ReflectionTarget {
    public ReflectionTarget() {
        methodB("Calling From ReflectionTarget constructor");
    }

    public void methodA(String a) {
        System.out.format("public methodA: %s%n", a);
        methodC(a);
    }

    private void methodB(String b) {
        System.out.format("private methodB: %s%n", b);
    }

    private void methodC(String c) {
        System.out.format("private methodC: %s%n", c);
    }
}
